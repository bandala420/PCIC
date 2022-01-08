package fileManager;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import programUtilities.ProgramLog;

public class FileManager {
	private int cpus;
	public FileManager() {
		// obtiene el número de cpus disponibles para la JVM
		cpus = Runtime.getRuntime().availableProcessors();
	}
	public List<File> createChunksFiles(String filePath) {
		// valida si el archivo existe
		File fileHandler = new File(filePath);
		if (!fileHandler.exists())
			ProgramLog.terminateProgram("El archivo "+filePath+" no existe");
		List<File> filesToProcess = new ArrayList<File>();
		try {
			filesToProcess = splitFile(fileHandler,200);
		}catch(IOException exc) {
			ProgramLog.terminateProgram("Error al generar archivos temporales ("+exc.getMessage()+")");
		}
		return filesToProcess;
	}
	private List<File> splitFile(File file, int maxSize) throws IOException {
	    int counter = 1;
	    List<File> files = new ArrayList<File>();
	    long filesSizeAtLeast = Files.size(file.toPath())/(4*cpus);
	    long sizeOfChunk = Long.min(filesSizeAtLeast,1024*1024*maxSize);
	    String eof = System.lineSeparator();
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String name = file.getName();
	        String line = br.readLine();
	        while (line != null) {
	            File newFile = new File(file.getParent(), name + "."
	                    + String.format("%03d", counter++));
	            try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {
	                int fileSize = 0;
	                while (line != null) {
	                    byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
	                    if (fileSize + bytes.length > sizeOfChunk)
	                        break;
	                    out.write(bytes);
	                    fileSize += bytes.length;
	                    line = br.readLine();
	                }
	            }
	            files.add(newFile);
	        }
	    }
	    return files;
	}
}
