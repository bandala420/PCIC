// clase de cuenta bancaria
// Daniel Bandala @ sep-21
package bank;

public class Cuenta {
	private String name; // variable para el nombre
	private int id_number; // variable del numero de cuenta
	private float money; // variable para almacenar saldo disponible
	private static int autoincrement = 10100; // variable general para almacenar autoincrement
	
	// constructor de un parametro (nombre)
	public Cuenta(String name) {
		this(name,0);
	}
	// constructor de dos parametros (nombre,saldo)
	public Cuenta(String name, float money) {
		this.name = name; // inicializa campo de nombre
		this.money = money; // incializa variable de saldo
		this.id_number = autoincrement; // asigna el valor correspondiente de la cuenta
		autoincrement++; // incremente en una unidad el identificador de cuentas
	}
	// obtiene nombre de cliente
	public String getName() {
		return name;
	}
	// modifica nombre del cliente
	public void setName(String name) {
		this.name = name;
	}
	// obtiene el numero de cuenta
	public int getId() {
		return id_number;
	}
	// obtiene el saldo diseponible
	public float getMoney() {
		return money;
	}
	
	// metodo para transferir dinero de una cuenta a otra
	public boolean transferirDinero(Cuenta cuentaDestino,float importe) {
		boolean success = false;
		System.out.printf("Transfiriendo $%.2f de la cuenta de %s a la cuenta de %s \n",importe,name,cuentaDestino.getName());
		// compara que sea un objeto valido
		if (cuentaDestino!=null) {
			// comprueba que la cuenta origen cuente con saldo suficiente para la transferencia
			if (descontarSaldo(importe))
				success = cuentaDestino.ingresarSaldo(importe);
		}
		if (success)
			System.out.println("--Transferencia exitosa--");
		else
			System.out.println("--Error: Transferencia rechazada--");
		System.out.printf("%s tu saldo es: $ %.2f \n\n",name,money);
		return success;
	}
	// metodo para ingresar saldo en cuenta
	public boolean ingresarSaldo(float monto) {
		System.out.printf("Ingresando $%.2f a la cuenta de %s \n",monto,name);
		if (monto>0) {
			money = money + monto;
			return true;
		}
		System.out.println("Error: ha intentado ingresar un saldo negativo\n");
		return false;
	}
	// metodo para retirar saldo de cuenta
	public boolean descontarSaldo(float monto) {
		System.out.printf("Retiro por $%.2f de la cuenta de %s \n",monto,name);
		// comprueba que la cantidad sea positiva y se cuente con saldo suficiente
		if (monto<0)
			System.out.println("Error: ha intentado descontar un saldo negativo\n");
		else if (money<monto)
			System.out.printf("Error: no cuenta con saldo suficiente para esta operación ($ %.2f) \n\n",money);
		else {
			money = money - monto;
			return true;
		}
		return false;
	}
	// metodo para imprimir informacion de cuenta
	public void imprimeInformacion() {
		System.out.println("------------------------------------");
		System.out.println("Cliente: \t \t "+name);
		System.out.println("Numero de cuenta: \t "+id_number);
		System.out.println("Saldo disponible: \t $ "+money);
		System.out.println("------------------------------------\n");
	}
}
