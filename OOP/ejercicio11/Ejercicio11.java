// Daniel Bandala @ oct-2021
package ejercicio11;
import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		String inputWord = null;
		System.out.print("Ingrese una palabra u oración: ");
		try(Scanner reader = new Scanner(System.in);){
			inputWord = reader.nextLine();
		}catch(java.util.InputMismatchException exc) {
			System.out.printf("Debe ingresar una cadena de texto válida \n",exc.getMessage());
		}catch(java.util.NoSuchElementException exc) {
			System.out.printf("Debe ingresar una cadena de texto válida \n",exc.getMessage());
		}
		if (inputWord!=null) {
			System.out.println(transformString(inputWord));
		}
	}
	
	private static String transformString(String inputString) {
		boolean upperCase = true;
		final String upperCaseString = inputString.toUpperCase();
		final String lowerCaseString = inputString.toLowerCase();
		StringBuffer transformedString = new StringBuffer();
		for (int i = 0; i < inputString.length(); i++) {
			char actualChar = ((upperCase) ? upperCaseString.charAt(i) : lowerCaseString.charAt(i));
			transformedString.append(actualChar);
			upperCase = !upperCase;
			if (actualChar==' ')
				upperCase = true;
		}
		return transformedString.toString();
	}
}
