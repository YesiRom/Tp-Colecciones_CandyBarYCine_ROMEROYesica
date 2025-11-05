package ar.edu.unlam.pb2.tp.candyBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CandyBar {
	private Set<Producto> productos;
	

	public CandyBar() {
		this.productos = new TreeSet<Producto>();
	}


	public boolean agregarProducto(Producto nuevoProd ) throws ProductoDuplicadoException {
		validarProductoNoNulo(nuevoProd);
		validarProductoNoDuplicado(nuevoProd);
		return productos.add(nuevoProd);
	}
		


	private void validarProductoNoDuplicado(Producto nuevoProd) throws ProductoDuplicadoException {
		for(Producto p: productos) {
			if(p.getNombre().equals(nuevoProd.getNombre())) {
				throw new ProductoDuplicadoException("El producto esta duplicado");
			}
		}
		
		
	}


	private void validarProductoNoNulo(Producto nuevoProd) {
		if(nuevoProd == null) {
			throw new IllegalArgumentException("El producto es nulo");
		}
		
	}


	public Set<Producto> obtenerInventario() {
		Set<Producto> inventario = new TreeSet<Producto>();
		
		inventario.addAll(productos);
	
		return inventario;
	}


	public void eliminarProducto(Producto producto) throws ProductoNoEncontradoException {
		validarProductoNoNulo(producto);
			
		if(existeProducto(producto)) {
			productos.remove(producto);
		}else {
			throw new ProductoNoEncontradoException();
		}
		
	}
	
	public boolean existeProducto(Producto producto) {
		return productos.contains(producto);
	}


	public Set<Bebida> obtenerBebidasOrdenadasPorPrecio() {
		
		Set<Bebida> bebidas = new TreeSet<Bebida>(new ComparadorDeBebidasPorPrecioBase());
    
		for (Producto p : productos) {
			if (p instanceof Bebida pB) {
				bebidas.add(pB);
			}
		}
    
		return bebidas;
	}
	

	public Set<Snack> obtenerSnacksOrdenadosPorNombre() {
		Set<Snack> snacks = new TreeSet<Snack>(new ComparadorDeSnackPorNombre());

		for (Producto p : productos) {
			if (p instanceof Snack pS) {
				snacks.add(pS);
			}
		}

       return snacks;
	}

	
}
