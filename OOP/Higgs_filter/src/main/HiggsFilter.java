package main;
import java.io.File;
import java.util.List;

import fileManager.FileManager;
import programUtilities.InputManager;
import threadPool.ThreadManager;

public class HiggsFilter {
	public static void main(String[] args) {
		// Obtiene los datos de entrada
		String[] inputData = InputManager.retrieveUserData();
		// inicia conteo para calcular el tiempo de ejecución
		long startTime = System.nanoTime();
		// Genera los archivos temporales
		FileManager fileManager = new FileManager();
		List<File> filesList = fileManager.createChunksFiles(inputData[0]);
		// Procesa cada archivo en el pool de hilos
		ThreadManager threadManager = new ThreadManager(filesList);
		String outputFile = threadManager.processFiles(inputData[1],inputData[2]);		
		// Proceso terminado
		System.out.println("\nProceso terminado, se ha generado el archivo "+outputFile);
		long totalTime = (System.nanoTime() - startTime)/(1000000);	// convert to miliseconds
		System.out.println("Tiempo de ejecución: "+(totalTime/1000)+" s");
	}
}