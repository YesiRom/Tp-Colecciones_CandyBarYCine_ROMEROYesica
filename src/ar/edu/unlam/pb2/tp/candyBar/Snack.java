package ar.edu.unlam.pb2.tp.candyBar;

public class Snack extends Producto{
	private static final double RECARGO= 0.2;
	private static final double DESCUENTO = 0.15;
	private Tamano tipoTamano;
	
	public Snack(String nombre, double precio, Tamano tipo, int stock) {
		super(nombre, precio, stock );
		this.tipoTamano = tipo;
	}

	public double calcularPrecioFinal() {
		double preciofinal = super.getPrecioBase();
		if(this.tipoTamano == Tamano.GRANDE) {
			preciofinal *= (1+ RECARGO);
			return preciofinal;
		}
		
		if(this.tipoTamano == Tamano.PEQUENO) {
			preciofinal *= (1-DESCUENTO);
			return preciofinal;
		}
		return preciofinal;
	}

}
