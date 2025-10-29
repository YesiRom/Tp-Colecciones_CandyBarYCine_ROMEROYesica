package ar.edu.unlam.pb2.tp.cine;


public class Asiento {
	private Cliente ocupante;
	private boolean estado;

	public boolean estaOcupado() {
		
		return estado;
	}
	
	public void ocuparAsiento(Cliente ocupante) {
		estado= true;
		this.ocupante= ocupante;
	}
	
	public void liberarAsiento() {
		estado = false;
		ocupante = null;
	}

	public Cliente getOcupante() {
		return ocupante;
	}
	
	

}
