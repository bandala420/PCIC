// Daniel Bandala @ oct-2021
package ejercicio14;

public class Principal {
	public static void main(String[] args) {
		hablarConAnimal(new Caballo());
		hablarConAnimal(new Tigre());
		hablarConAnimal(new Vaca());
	}
	private static void hablarConAnimal(Animal animal) {
		animal.comunicar();
	}
}
