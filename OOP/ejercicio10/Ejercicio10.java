// Daniel Bandala @ oct-2021
package ejercicio10;
import java.util.Scanner;

public class Ejercicio10 {
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
			if (isPalindrome(inputWord))
				System.out.println("La palabra u oración SI es palindroma");
			else
				System.out.println("La palabra u oración NO es palindroma");
		}
	}
	
	private static boolean isPalindrome(String inputString) {
		inputString = cleanString(inputString).toLowerCase();		
		boolean isPal = true;
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i)!=inputString.charAt(inputString.length()-1-i)) {
				isPal = false;
				break;
			}
		}
		return isPal;
	}
	private static String cleanString(String s) {
	    String withoutspaces = "";
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i)!=' ' && s.charAt(i)!=',' && s.charAt(i)!='.' && s.charAt(i)!=';')
	            withoutspaces += s.charAt(i);
	    }
	    return withoutspaces;
	}
}
