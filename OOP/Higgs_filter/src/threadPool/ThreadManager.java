package threadPool;
import java.util.concurrent.Executors;

import fileManager.SharedFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ThreadManager{
	private List<File> filesToProcess;  
	public ThreadManager() {
		this.filesToProcess = new ArrayList<File>();
	}
    public ThreadManager(List<File> files){  
        this.filesToProcess=files;
    }
    public String processFiles(String columnsName,String dataQuery) {
    	ThreadWorker.setColumnsName(columnsName);
    	ThreadWorker.setDataQuery(dataQuery);
    	String fileName = "none";
    	if (filesToProcess!=null) {
    		// define archivo de salida (este es el recurso compartido de todos los hilos)
    		File sharedFile = filesToProcess.get(0);
    		String resultFolder = "resultados";
    		String[] nameParts = sharedFile.getName().split("\\.");
    		String dateIdentifier = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
    		fileName = nameParts[0]+"_filtered"+dateIdentifier+".csv";
    		SharedFile.setFile(Paths.get(sharedFile.getParent(),resultFolder,fileName).toString());
    		// crea carpeta de resultados
    		new File(Paths.get(sharedFile.getParent(),resultFolder).toString()).mkdirs();
    		// genera el pool de hilos
	    	ExecutorService executor = Executors.newFixedThreadPool(filesToProcess.size());
	    	for (File file : filesToProcess) {
	    		// crea un hilo asociado con el archivo a procesar
	            Runnable worker = new ThreadWorker(file);
	            // ejecuta el hilo
	            executor.execute(worker); 
	        }
	    	// cierra y desecha la referencia al pool de hilos
	        executor.shutdown();
	        // espera a que termine de cerrar procesos
	        while (!executor.isTerminated()){ }
    	}
    	return fileName;
    }
}
