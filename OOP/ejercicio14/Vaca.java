// Daniel Bandala @ oct-2021
package ejercicio14;

public class Vaca extends Animal implements Herbivoro{
	public void comunicar() {
		System.out.println("Mugiendo ...");
	}
	public void comerHierba() {
		System.out.println("Vaca comiento hierba ...");
	}
}