package ar.edu.unlam.pb2.tp.candyBar;



public abstract class Producto implements Comparable<Producto>{
	private String nombre;
	private double precioBase;
	private int stock;
	public Producto(String nombre, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.precioBase = precio;
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	
	public int getStock() {
		return stock;
	}
	
	public abstract  double calcularPrecioFinal();
	
	@Override
	public int compareTo(Producto otro) {
		return Integer.compare(this.stock, otro.stock);
}

	
	
}
