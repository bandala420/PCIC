package dog;

public class TestPerro {
	public static void main(String[] args) {
		Perro perro1 = new Perro();
		Perro perro2 = new Perro("Benito");
		Perro perro3 = new Perro("Ruffo","Maltes");
		Perro perro4 = new Perro("Rayo","pitbull",21.3f);
		
		perro1.imprimirCaracteristicas();
		perro2.imprimirCaracteristicas();
		perro3.imprimirCaracteristicas();
		perro4.imprimirCaracteristicas();
		
		System.out.println("---------------------------------------\n");
		
		perro1.setNombre("Edd");
		perro1.setRaza("Husky");
		perro1.setPeso(2.3f);
		perro2.setRaza("Poodle");
		perro2.setPeso(1.6f);
		perro3.setPeso(5.4f);
		
		perro2.ladrar();
		perro4.ladrar();
		
		System.out.println("Uno de mis perros se llama: "+perro2.getNombre());
		
		perro1.imprimirCaracteristicas();
		perro2.imprimirCaracteristicas();
		perro3.imprimirCaracteristicas();
		perro4.imprimirCaracteristicas();
	}

}
