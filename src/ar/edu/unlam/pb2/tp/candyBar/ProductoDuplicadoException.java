package ar.edu.unlam.pb2.tp.candyBar;

public class ProductoDuplicadoException extends Exception {
	
	private static final String MENSAJE = "Ya existe el producto que se intenta agregar.";
	

	public ProductoDuplicadoException() {
		this(MENSAJE);
	}
	
	public ProductoDuplicadoException(String mensaje) {
		super(mensaje);
	}

}
