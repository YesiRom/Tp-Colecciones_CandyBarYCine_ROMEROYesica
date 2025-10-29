package ar.edu.unlam.pb2.tp.candyBar;



public class Combo extends Producto {
	private Producto snack, bebida;
	private double descuento;
 public Combo(String nombre, Producto snack, Producto bebida, double desc, int stock) {
	    super(nombre, (snack.getPrecioBase() + bebida.getPrecioBase()), stock);
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = desc;
		
	}
 
 public double calcularPrecioFinal() {
	
	return (snack.calcularPrecioFinal() + bebida.calcularPrecioFinal()) * (1 - this.descuento);
 }

 
  

 
}
