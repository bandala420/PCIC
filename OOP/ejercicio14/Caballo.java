// Daniel Bandala @ oct-2021
package ejercicio14;

public class Caballo extends Animal implements Herbivoro{
	public void comunicar() {
		System.out.println("Relinchando ...");
	}
	public void comerHierba() {
		System.out.println("Caballo comiento hierba ...");
	}
}