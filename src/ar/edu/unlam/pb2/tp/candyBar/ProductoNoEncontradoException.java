package ar.edu.unlam.pb2.tp.candyBar;

public class ProductoNoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MENSAJE = "El producto no se puede eliminar porque no se encuentra en el inventario.";
	
	public ProductoNoEncontradoException() {
		this(MENSAJE);
	}

	public ProductoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
	

}
