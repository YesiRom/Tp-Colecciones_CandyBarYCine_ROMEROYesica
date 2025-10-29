package ar.edu.unlam.pb2.tp.candyBar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandyBar {
	private List<Producto> productos;
	

	public CandyBar() {
		this.productos = new ArrayList<Producto>();
	}


	public boolean agregarProducto(Producto nuevoProd ) throws ProductoDuplicadoException {
		validarProductoNoNulo(nuevoProd);
		validarProductoNoDuplicado(nuevoProd);
		return productos.add(nuevoProd);
	}
		


	private void validarProductoNoDuplicado(Producto nuevoProd) throws ProductoDuplicadoException {
		for(Producto p: productos) {
			if(p.getNombre().equals(nuevoProd.getNombre())) {
				throw new ProductoDuplicadoException("El producto es nulo");
			}
		}
		
		
	}


	private void validarProductoNoNulo(Producto nuevoProd) {
		if(nuevoProd == null) {
			throw new IllegalArgumentException("El producto es nulo");
		}
		
	}


	public List<Producto> obtenerInventario() {
		List<Producto> inventario = new ArrayList<Producto>();
		
		inventario.addAll(productos);
	
		return inventario;
	}


	public void eliminarProducto(Producto producto) throws ProductoNoEncontradoException {
		validarProductoNoNulo(producto);
		for(Producto p: productos) {
			if(p.equals(producto)){
				productos.remove(p);
				return;
			}
		}
		throw new ProductoNoEncontradoException();
	}
	
	public boolean existeProducto(Producto producto) {
		return productos.contains(producto);
	}


	public List<Producto> obtenerInventarioOrdenadoPorStock() {
		List<Producto> inventarioOrdenado = obtenerInventario();
		Collections.sort(inventarioOrdenado);
		return inventarioOrdenado;
	}
	

	public List<Bebida> obtenerBebidasOrdenadasPorPrecio() {
		List<Bebida> bebidas = new ArrayList<>();
    
		for (Producto p : productos) {
			if (p instanceof Bebida pB) {
				bebidas.add(pB);
			}
		}
    

		Collections.sort(bebidas, new Comparator<Bebida>() {
			@Override
			public int compare(Bebida b1, Bebida b2) {
				return Double.compare(b1.getPrecioBase(), b2.getPrecioBase());
			}
		});

		return bebidas;
	}
	

	public List<Snack> obtenerSnacksOrdenadosPorNombre() {
		List<Snack> snacks = new ArrayList<>();

		for (Producto p : productos) {
			if (p instanceof Snack pS) {
				snacks.add(pS);
			}
		}

       Collections.sort(snacks, new Comparator<Snack>() {
    	   @Override
    	   public int compare(Snack s1, Snack s2) {
    		   return s1.getNombre().compareToIgnoreCase(s2.getNombre());
    	   }
       });

       return snacks;
	}

	
}
