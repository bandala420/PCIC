package threadPool;
import java.io.File;
import java.io.IOException;

import fileManager.FileFilter;
import programUtilities.ProgramLog;

public class ThreadWorker implements Runnable {
	private File fileToProcess;
	private static String columnsName,dataQuery;
	public ThreadWorker(File fileToProcess) {
		this.fileToProcess = fileToProcess;
	}
	public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) - "+fileToProcess.getAbsolutePath());  
        // crea objeto para filtrar archivo
        FileFilter fileFilter = new FileFilter(fileToProcess);
        // filtra informacion y la almacena en archivo compartido
        try {
        	fileFilter.filterData(columnsName, dataQuery);
        }catch(IOException exc) {
        	ProgramLog.terminateProgram("El archivo "+fileToProcess.getName()+" no se procesó correctamente ("+exc.getMessage()+")");
        }
    }
	public static void setColumnsName(String colsName) {
		// limpia los caracteres especiales no deseados
		columnsName = colsName.replaceAll("[^a-zA-Z0-9,_-]","");
	}
	public static void setDataQuery(String dtQuery) {
		// limpia los caracteres especiales no deseados
		dataQuery = dtQuery.replaceAll("[^a-zA-Z0-9,_\\-\\.=<>'\"]","");
	}
}
