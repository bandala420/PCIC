package programUtilities;
import java.util.Scanner;

public class ProgramLog {
	public static void terminateProgram(String errorMsn) {
		System.out.println("ERROR: "+errorMsn); // muestra error al usuario
		System.exit(0); // termina programa en JVM
	}
	public static void terminateProgram(String errorMsn, Scanner reader) {
		System.out.println("ERROR DE ENTRADA: "+errorMsn); // muestra error al usuario
		reader.close(); // cierra objeto para lectura de entradas
		System.exit(0); // termina programa en JVM
	}
}
