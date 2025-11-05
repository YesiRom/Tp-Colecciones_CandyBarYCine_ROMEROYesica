package ar.edu.unlam.pb2.tp.candyBar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class CandyBarTest {

    private CandyBar candyBar;
    private Producto palomitas;
    private Producto refresco;

    // Se ejecuta antes de cada test para inicializar el objeto CandyBar
    @Before
    public void setUp() {
        candyBar = new CandyBar(); 
        palomitas = new Snack("Palomitas", 5.0, Tamano.MEDIANO, 20);
        refresco = new Bebida("Refresco", 3.0, Contenedor.VASO, 15);
    }

    @Test
    public void testAgregarProducto() throws ProductoDuplicadoException {
    	 	
    	assertTrue(candyBar.agregarProducto(palomitas));
        assertTrue(candyBar.agregarProducto(refresco));
        assertEquals(2, candyBar.obtenerInventario().size());

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidarProductoNoNulo() throws ProductoDuplicadoException{
    	Producto nuevo = null;
    	candyBar.agregarProducto(nuevo);
    	
    }
    
    @Test(expected = ProductoDuplicadoException.class)
    public void alAgregarProductosDuplicadosLanzaUnaProductoDuplicadoExeptionTest() throws ProductoDuplicadoException {
    	candyBar.agregarProducto(palomitas);
    	candyBar.agregarProducto(palomitas);
    }
    

    @Test
    public void testEliminarProductoExistente() throws ProductoNoEncontradoException, ProductoDuplicadoException {
        candyBar.agregarProducto(palomitas);
        candyBar.agregarProducto(refresco);

        assertEquals(2, candyBar.obtenerInventario().size());      
        assertTrue(candyBar.existeProducto(palomitas));
        
        candyBar.eliminarProducto(palomitas);
        assertEquals(1, candyBar.obtenerInventario().size());
        assertFalse(candyBar.existeProducto(palomitas));
    }
    
    

    @Test(expected = ProductoNoEncontradoException.class)
    public void testEliminarProductoNoExistente() throws ProductoDuplicadoException, ProductoNoEncontradoException {
        candyBar.agregarProducto(palomitas);

        assertEquals(1, candyBar.obtenerInventario().size());
        
        candyBar.eliminarProducto(refresco);
    }

    
    @Test
    public void inventarioVacioTest() {
       int inventario = candyBar.obtenerInventario().size();
       
       assertEquals(0, inventario);
    }

    @Test
    public void ordenarProductosPorStockTest() throws ProductoDuplicadoException {
    	candyBar.agregarProducto(palomitas);
    	candyBar.agregarProducto(refresco);
    	candyBar.agregarProducto(new Bebida("Manaos", 1600.0, Contenedor.BOTELLA, 12));
    	
    	List<Producto> inventario = new ArrayList<Producto>(candyBar.obtenerInventario());
    	 assertEquals(3, inventario.size());  
    	 assertEquals(12, inventario.get(0).getStock());  
    	 assertEquals(15, inventario.get(1).getStock());  
    	 assertEquals(20, inventario.get(2).getStock());  
    	
    }
    

    @Test
    public void obtenerBebidasOrdenadasPorPrecioTest() throws ProductoDuplicadoException {
    	candyBar.agregarProducto(new Bebida("Coca-Cola", 1500.0, Contenedor.BOTELLA, 10));
    	candyBar.agregarProducto(new Bebida("Manaos", 1200.0, Contenedor.BOTELLA, 8));
    	candyBar.agregarProducto(new Bebida("Pepsi", 1800.0, Contenedor.BOTELLA, 12));
    	candyBar.agregarProducto(palomitas); 
    	
    	 assertEquals(4, candyBar.obtenerInventario().size()); 

    	List<Bebida> bebidasOrdenadas = new ArrayList<Bebida>(candyBar.obtenerBebidasOrdenadasPorPrecio());

    	assertEquals(3, bebidasOrdenadas.size());
    	assertEquals("Manaos", bebidasOrdenadas.get(0).getNombre());
    	assertEquals("Coca-Cola", bebidasOrdenadas.get(1).getNombre());
    	assertEquals("Pepsi", bebidasOrdenadas.get(2).getNombre());
    }
    

    @Test
    public void obtenerSnacksOrdenadosPorNombreTest() throws ProductoDuplicadoException {
    	candyBar.agregarProducto(new Snack("Palitos salados", 500.0, Tamano.MEDIANO, 20));
    	candyBar.agregarProducto(new Snack("Nachos", 600.0, Tamano.GRANDE, 15));
    	candyBar.agregarProducto(new Snack("Chips", 400.0, Tamano.PEQUENO, 10));

    	List<Snack> snacksOrdenados = new ArrayList<Snack>(candyBar.obtenerSnacksOrdenadosPorNombre());

    	assertEquals(3, snacksOrdenados.size());
    	assertEquals("Chips", snacksOrdenados.get(0).getNombre());
    	assertEquals("Nachos", snacksOrdenados.get(1).getNombre());
    	assertEquals("Palitos salados", snacksOrdenados.get(2).getNombre());
}


}
