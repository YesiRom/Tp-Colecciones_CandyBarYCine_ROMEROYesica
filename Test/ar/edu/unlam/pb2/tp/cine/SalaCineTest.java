package ar.edu.unlam.pb2.tp.cine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalaCineTest {
	
	    private SalaCine sala;
	    private Cliente cliente;
	    private Pelicula pelicula;

	    @Before
	    public void setUp() {
	        sala = new SalaCine(3, 3); 
	        cliente = new Cliente("Juan", 25);
	        pelicula = new PeliculaAccion("Rapido y Furioso", 120, 13);
	        sala.cambiarPelicula(pelicula);
	    }

	    @Test
	    public void testInicializacionButacas() {
	        assertEquals(9, sala.getTotalAsientos());
	    }

	    @Test
	    public void testVenderBoletoExitoso() {
	        boolean vendido = sala.venderBoleto("A1", cliente);
	        assertTrue(vendido);
	        assertEquals(1, sala.contarAsientosOcupados());
	    }

	    @Test
	    public void testVenderBoletoEdadInsuficiente() {
	        Cliente menor = new Cliente("Uriel", 9);
	        boolean vendido = sala.venderBoleto("A2", menor);
	        assertFalse(vendido);
	        assertEquals(0, sala.contarAsientosOcupados());
	    }

	    @Test
	    public void testLiberarAsiento() {
	        sala.venderBoleto("B2", cliente);
	        boolean liberado = sala.liberarAsiento("B2");
	        assertTrue(liberado);
	        assertEquals(0, sala.contarAsientosOcupados());
	    }

	    @Test
	    public void testCambiarPelicula() {
	    	Pelicula nueva = new PeliculaInfantil("La Sirenita", 90, 0);
	        sala.cambiarPelicula(nueva);
	        assertEquals("La Sirenita", sala.getPeliculaActual().getTitulo());
	    }

	    @Test
	    public void testReiniciarSala() {
	        sala.venderBoleto("C3", cliente);
	        sala.reiniciarSala();
	        assertEquals(0, sala.contarAsientosOcupados());
	        assertNull(sala.getPeliculaActual());
	    }

	    @Test
	    public void testMostrarButacasDetalle() {
	        sala.venderBoleto("A1", cliente);
	        String detalle = sala.mostrarButacasDetalle();
	        assertTrue(detalle.contains("Cliente: Juan"));
	        assertTrue(detalle.contains("Asiento: A1"));
	        assertTrue(detalle.contains("Pelicula: Rapido y Furioso"));
	    }
	}


