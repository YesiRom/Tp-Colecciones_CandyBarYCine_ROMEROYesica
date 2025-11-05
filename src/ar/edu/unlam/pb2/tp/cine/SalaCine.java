package ar.edu.unlam.pb2.tp.cine;

import java.util.Map;
import java.util.TreeMap;

public class SalaCine {
	private Map<String, Asiento> butacas;
	private Pelicula pelicula;

	public SalaCine(int filas, int columnas) {
		this.butacas = new TreeMap<String, Asiento>();
		inicializarButacas(filas, columnas);
	}
	

	 private void inicializarButacas(int filas, int columnas) {
	        for (int i = 0; i < filas; i++) {
	            char letraFila = (char) ('A' + i); 
	            for (int numero = 1; numero <= columnas; numero++) {
	                String clave = letraFila + String.valueOf(numero);
	                butacas.put(clave, new Asiento());
	            }
	        }
	    }

	

	 public Map<String, Asiento> getButacas() {
		 return new TreeMap<>(butacas); 
	 }

	

	 public int contarAsientosOcupados() {
		 int contador = 0;
		 for (Asiento asiento : butacas.values()) {
			 if (asiento != null && asiento.estaOcupado()) {
				 contador++;
			 }
		 }
		 return contador;
	 }



	 public int getTotalAsientos() {
		 return butacas.size();
	 }


	 public boolean liberarAsiento(String clave) {
		 Asiento asiento = butacas.get(clave);
		 if (asiento != null && asiento.estaOcupado()) {
			 asiento.liberarAsiento();;
			 return true;
		 }
		 return false;
	 }


 //LOGICA CON PELICULA --> proyecta una pelicula, devuelve con get pelicula acual y titulo
	public void cambiarPelicula(Pelicula nuevaPelicula) {
		pelicula = nuevaPelicula;
		
	}
	public Pelicula getPeliculaActual() {
				
		return pelicula;
	}

		

	//LOGICA para vender boletos

	public boolean venderBoleto(String clave, Cliente cliente) {
		Asiento asiento = butacas.get(clave);
		if (asiento != null && !asiento.estaOcupado() && edadMinimaValida(cliente)) {
			asiento.ocuparAsiento(cliente);
			return true;
		}
		return false;
	}


	private boolean edadMinimaValida(Cliente cliente) {
		return pelicula.getEdadMinima() < cliente.getEdad();
	}

			

	private boolean existeButaca(String clave) {
		return butacas.containsKey(clave);
	}


	


	public void reiniciarSala() {
		for (Asiento asiento : butacas.values()) {
			if (asiento != null) {
				asiento.liberarAsiento();
			}
		}
		pelicula = null;
	}


	public String mostrarButacasDetalle() {
		StringBuilder detalle = new StringBuilder();

		for (Map.Entry<String, Asiento> entry : butacas.entrySet()) {
			Asiento asiento = entry.getValue();
			if (asiento != null && asiento.estaOcupado()) {
				detalle.append("\nCliente: ").append(asiento.getOcupante().getNombre())
                   .append("\nAsiento: ").append(entry.getKey())
                   .append("\nPelicula: ").append(getPeliculaActual().getTitulo())
                   .append("\n______________________________________________________________________________________\n");
			}
		}

		return detalle.toString();
	}




}
