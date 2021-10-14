// Daniel Bandala @ oct-2021
package ejercicio12;
import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		int inputN = 0;
		boolean successRead = false;
		System.out.print("Ingrese un número entero: ");
		try(Scanner reader = new Scanner(System.in);){
			inputN = reader.nextInt();
			successRead = true;
		}catch(java.util.InputMismatchException exc) {
			System.out.printf("Debe ingresar un número entero \n",exc.getMessage());
		}catch(java.util.NoSuchElementException exc) {
			System.out.printf("Debe ingresar un número entero \n",exc.getMessage());
		}
		if (inputN>0) {
			SquareMatrix squareMatrix = new SquareMatrix(inputN);
			squareMatrix.showMatrix();
		}else if(successRead)
			System.out.println("Debe ingresar un número mayor a cero");
	}
}
