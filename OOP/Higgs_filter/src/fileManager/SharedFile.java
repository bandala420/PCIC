package fileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SharedFile {
	private static File fileHandler;
	public static synchronized void writeToFile(String strToFile) throws IOException {
        try (FileWriter fw = new FileWriter(fileHandler.getAbsoluteFile(), true)){
        	fw.append(strToFile);
        }
    }
	public static void setFile(String sharedFile) {
		fileHandler = new File(sharedFile);
	}
}
