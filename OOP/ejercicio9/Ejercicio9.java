// Daniel Bandala @ oct-2021
package ejercicio9;
import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		int amount; float sum = 0;
		Scanner reader = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de números: ");
		try{
			amount = reader.nextInt();
		}catch(java.util.InputMismatchException exc) {
			System.out.printf("Debe ingresar un número entero válido (%s) \n",exc.getMessage());
			reader.close();
			return;
		}catch(java.util.NoSuchElementException exc) {
			System.out.printf("Debe ingresar un número entero válido (%s) \n",exc.getMessage());
			reader.close();
			return;
		}
		if (amount>0) {
			for (int i=0; i<amount ;i++){
				boolean flag = true;
				float inputNumber = 0;
				while(flag) {
					System.out.printf("Ingrese el valor %d: ",(i+1));
					try{
						inputNumber = reader.nextFloat();
						flag = false;
					}catch(java.util.InputMismatchException exc) {
						System.out.printf("Debe ingresar un número decimal válido (%s) \n",exc.getMessage());
						reader.next();
					}catch(java.util.NoSuchElementException exc) {
						System.out.printf("Debe ingresar un número decimal válido (%s) \n",exc.getMessage());
						reader.next();
					}
				}
				sum = sum+inputNumber;
			}
			System.out.printf("\nEl promedio de los %d números que ha ingresado es %.2f \n",amount,sum/amount);
		}else
			System.out.println("Debe ingresar una cantidad mayor a 0");
		reader.close();
	}
}
