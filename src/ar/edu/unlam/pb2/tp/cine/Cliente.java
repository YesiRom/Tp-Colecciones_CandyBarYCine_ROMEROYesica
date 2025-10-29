package ar.edu.unlam.pb2.tp.cine;

public class Cliente {
	private String nombre;
	private int edad;
	
	public Cliente(String nombre, int edad) {
		validarEdad(edad);
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
	public int getEdad() {
		return edad;
	}

	private void validarEdad(int edad) {
		if(edad <= 0 || edad > 110) {
			throw new IllegalArgumentException("Debe ingresar una edad valida. No puede ser negativa, ni mayor a 110.");
		}
	}

}
