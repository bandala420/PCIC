package programUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public final class InputManager {
	public static String[] retrieveUserData() {
		String[] inputData = {"","",""};
		Scanner reader = new Scanner(System.in); // objeto para leer entrada de usuario
		// se solicita la ruta de archivo
		System.out.println("Ingresa la ruta del archivo csv:");
		inputData[0] = reader.nextLine();
		File fileHandler = new File(inputData[0]);
		if (inputData[0]==null || !inputData[0].toLowerCase().endsWith(".csv") || !fileHandler.exists())
			ProgramLog.terminateProgram("El archivo "+inputData[0]+" no existe o no es un archivo CSV válido",reader);
		
		// lee la primer linea del archivo
		int columnsNumber = 0;
		try (BufferedReader brTest = new BufferedReader(new FileReader(inputData[0]))){
			String firstLine = brTest .readLine();
			columnsNumber = firstLine.split(",").length;
			if (firstLine.length()>0)
				System.out.println("\n\nEl archivo contiene "+columnsNumber+" columnas \nUn ejemplo de una instancia de la base de datos es el siguiente \n"+firstLine.replace(",", " | ")+"\n");
			else
				ProgramLog.terminateProgram("El archivo no contiene ninguna columna",reader);
		}catch (IOException exc) {
			ProgramLog.terminateProgram("Error al leer las columnas del archivo CSV",reader);
		}
		
		// se solicita las columnas de interes
		System.out.println("Ingresa las columnas de interés:");
		inputData[1] = reader.nextLine();
		if (inputData[1]==null || inputData[1].length()<1)
			ProgramLog.terminateProgram("Ingresa al menos una columna de interés",reader);
		String[] columnsArray = inputData[1].split(",");
		for (String col : columnsArray) {
			int columnIndex = 0;
			try {
				columnIndex = Integer.parseInt(col);
			}catch (NumberFormatException e) {
				ProgramLog.terminateProgram("La columna "+col+" no se encuentra en la base de datos",reader);
			}
			if (columnIndex>columnsNumber)
				ProgramLog.terminateProgram("La columna "+col+" no se encuentra en la base de datos",reader);
		}
		// se solicita el criterio de filtrado
		System.out.println("\nIngresa el criterio de filtrado:");
		inputData[2] = reader.nextLine();
		if (inputData[2]==null || inputData[2].length()<1)
			ProgramLog.terminateProgram("Ingresa al menos un criterio de filtrado",reader);
		columnsArray = inputData[2].split(",");
		for (String qr : columnsArray) {
			String[] queryParts = qr.split("[=<>]");
			if (queryParts.length==2) {
				int columnQuery = 0;
				try {
					columnQuery = Integer.parseInt(queryParts[0]);
				}catch (NumberFormatException e) {
					ProgramLog.terminateProgram("La columna "+queryParts[0]+" no se encuentra en la base de datos",reader);
				}
				if (columnQuery>columnsNumber)
					ProgramLog.terminateProgram("La columna "+queryParts[0]+" no se encuentra en la base de datos",reader);
			}else
				ProgramLog.terminateProgram("El criterio de filtrado "+qr+" no es válido",reader);
		}
		return inputData;
	}
}
