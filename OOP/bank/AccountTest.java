//test de clase cuenta
//Daniel Bandala @ sep-21
package bank;
import java.util.Scanner;
import java.util.ArrayList;

public class AccountTest {
	public static void main(String[] args) {
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(); // lista para guardar cuentas de usuarios
		Scanner reader = new Scanner(System.in); // objeto para leer entrada de usuario
		System.out.println("CUENTA BANCARIA\n");

		System.out.println("Ingrese el nombre del primer cliente");
		System.out.print("Nombre: ");
		String inputName = reader.nextLine();
		listaCuentas.add(new Cuenta(inputName,500));
		listaCuentas.get(0).imprimeInformacion();
		 
		System.out.println("Ingrese el nombre del segundo cliente");
		System.out.print("Nombre: ");
		inputName = reader.nextLine();
		listaCuentas.add(new Cuenta(inputName));
		listaCuentas.get(1).imprimeInformacion();
		
		listaCuentas.get(0).transferirDinero(listaCuentas.get(1), 180);
		
		System.out.println("Desplegando información de ambas cuentas");
		listaCuentas.get(0).imprimeInformacion();
		listaCuentas.get(1).imprimeInformacion();
		
		listaCuentas.get(0).ingresarSaldo(60);
		listaCuentas.get(0).imprimeInformacion();
		listaCuentas.get(1).descontarSaldo(140);
		listaCuentas.get(1).imprimeInformacion();
			
		System.out.println("\nOPERACIONES NO PERMITIDAS\n");
		listaCuentas.get(0).transferirDinero(listaCuentas.get(1), 500);
		listaCuentas.get(1).descontarSaldo(400);
		listaCuentas.get(0).transferirDinero(listaCuentas.get(1), -500);
		listaCuentas.get(0).descontarSaldo(-100);
		listaCuentas.get(0).ingresarSaldo(-200);
		System.out.println("\n");
		
		System.out.println("Desplegando información de ambas cuentas");
		listaCuentas.get(0).imprimeInformacion();
		listaCuentas.get(1).imprimeInformacion();
		
		System.out.println("\nCuentas extas");
		listaCuentas.add(new Cuenta("JORGE"));
		listaCuentas.add(new Cuenta("HECTOR"));
		listaCuentas.add(new Cuenta("ADRIAN"));
		listaCuentas.get(2).imprimeInformacion();
		listaCuentas.get(3).imprimeInformacion();
		listaCuentas.get(4).imprimeInformacion();
		reader.close(); // cierra objeto para lectura de entradas
	}	
}
