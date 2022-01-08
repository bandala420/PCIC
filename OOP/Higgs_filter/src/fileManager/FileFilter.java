package fileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import programUtilities.QueryData;

public class FileFilter {
	private File fileToFilter;
	public FileFilter(File fileToFilter) {
		this.fileToFilter = fileToFilter;
	}
	public void filterData(String columnsName,String dataQuery) throws IOException {
		// obtiene la posicion donde se encuentran las columnas seleccionadas
		List<Integer> columnsNum = new ArrayList<Integer>();
		for (String col : columnsName.split(","))
			columnsNum.add(Integer.parseInt(col));
		// obtiene las querys individuales para el filtro
		List<String> querys = new ArrayList<String>();
		for (String qr : dataQuery.split(","))
			querys.add(qr);
		// separador de linea
		String eof = System.lineSeparator();
		// lee cada linea para evitar saturación de la memoria
		try (FileInputStream inputStream = new FileInputStream(fileToFilter)){
			try (Scanner sc = new Scanner(inputStream, "UTF-8")) {
				while (sc.hasNextLine()) {
			        String line = sc.nextLine();
			        String[] lineElements = line.split(",");
			        // filtra informacion
			        boolean filterPass = true;
			        for (String qr : querys) {
			        	if (qr.contains("*")) {
			        		filterPass = true;
			        		break;
			        	}
			        	String[] queryParts = qr.split("[=<>]");
			        	if (queryParts.length==2) {
			        		queryParts[0] = queryParts[0].replace("!","");
			        		queryParts[1] = queryParts[1].replace("!","");
			        		String data1 = lineElements[Integer.parseInt(queryParts[0])-1];
			        		String data2 = queryParts[1];
			        		QueryData queryData1 = new QueryData(data1);
			        		QueryData queryData2 = new QueryData(data2);
			        		filterPass = filterPass && queryData1.compareTo(queryData2,qr);
			        	}else {
			        		filterPass = false;
			        		break;
			        	}
			        }
			        if (!filterPass)
			        	continue;
			        // selecciona las columnas
			        StringBuffer newLine= new StringBuffer();
			        if (columnsName.contains("*"))
			        	newLine.append(line);
			        else {
				        for (Integer index : columnsNum)
				        	newLine.append(lineElements[index-1] + ",");
				        newLine.deleteCharAt(newLine.length()-1);
				        newLine.append(eof);
			        }
			        // escribe en el archivo de salida
			        SharedFile.writeToFile(newLine.toString());
			    }
			    // comprueba estado del Scanner
			    if (sc.ioException() != null) {
			        throw sc.ioException();
			    }
			}
		}finally {
			// borra archivo temporal
			fileToFilter.deleteOnExit();
		}
	}
}
