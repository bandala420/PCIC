// Daniel Bandala @ oct-2021
package ejercicio13;
import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		int inputN=0,row=0,column=0,newValue=0;
		boolean successRead = false;
		System.out.print("Ingrese el tamaño de la matriz: ");
		try(Scanner reader = new Scanner(System.in);){
			inputN = reader.nextInt();
			System.out.println("Información del elemento que desea modificar");
			System.out.print("Fila: ");
			row = reader.nextInt();
			System.out.print("Columna: ");
			column = reader.nextInt();
			System.out.print("Nuevo valor: ");
			newValue = reader.nextInt();
			successRead = true;
		}catch(java.util.InputMismatchException exc) {
			System.out.printf("Únicamente puede ingresar números enteros \n",exc.getMessage());
		}catch(java.util.NoSuchElementException exc) {
			System.out.printf("Únicamente puede ingresar números enteros \n",exc.getMessage());
		}
		if (inputN>0 && row>0 && column>0) {
			ModSquareMatrix squareMatrix = new ModSquareMatrix(inputN);
			squareMatrix.substituteElement(new int[] {row,column}, newValue);
			squareMatrix.showMatrix();
		}else if(successRead)
			System.out.println("Debe ingresar un números mayores a cero");
	}
}
