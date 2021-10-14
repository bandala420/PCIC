// Daniel Bandala @ oct-2021
package ejercicio14;

public class Tigre extends Animal implements Carnivoro{
	public void comunicar() {
		System.out.println("Rugiendo ...");
	}
	public void comerCarne() {
		System.out.println("Tigre comiendo carne ...");
	}
}