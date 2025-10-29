package ar.edu.unlam.pb2.tp.candyBar;

public class Bebida extends Producto{
	private static final double RECARGO= 0.1;
	private Contenedor tipoContenedor;
	
	public Bebida(String nombre, double precio, Contenedor contenedor,int stock) {
		super(nombre, precio, stock);
		this.tipoContenedor = contenedor;
	}

	public double calcularPrecioFinal() {
		double preciofinal = super.getPrecioBase();
		if(this.tipoContenedor == Contenedor.BOTELLA ) {
			preciofinal *= (1+ RECARGO);
			return preciofinal;
		}
		
		return preciofinal;
	
	}

}
