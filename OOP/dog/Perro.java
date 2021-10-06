package dog;

public class Perro {
	private String nombre,raza;
	private float peso;
	
	public Perro() {}
	public Perro(String nombre) {
		this.nombre = nombre;
	}
	public Perro(String nombre, String raza) {
		this(nombre);
		this.raza = raza;
	}
	public Perro(String nombre, String raza, float peso) {
		this(nombre,raza);
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public void ladrar() {
		System.out.printf("Woof woof... (%s está ladrando) \n",nombre);
	}
	public void imprimirCaracteristicas() {
		System.out.printf("Nombre: %s \t raza: %s \t peso: %.2f \n",nombre,raza,peso);
	}
}