package ar.edu.unlam.pb2.tp.cine;

import java.util.Objects;

public abstract class Pelicula {
	private String titulo, sinopsis;
	private int duracion, edadMinima;
	
	public Pelicula(String titulo, int duracion, int edadMin) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMin;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getEdadMinima() {
		
		return edadMinima;
	}

	public String mostrarSinopsis() {
		return sinopsis;
	}
	
	public void setSinopsis(String descripcion) {
		this.sinopsis = descripcion;
	}

	public String mostrarDetalleDePelicula() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Titulo: ").append(titulo);
		sb.append(System.lineSeparator());
		sb.append("Duracion: ").append(duracion);
		sb.append(System.lineSeparator());
		sb.append("Sinopsis: ").append(sinopsis);
		sb.append(System.lineSeparator());
		sb.append("Edad Minina: ").append(edadMinima);
		
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracion, edadMinima, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Pelicula p)) {
			return false;
		}
		return titulo.equals(p.titulo) && duracion == p.duracion && edadMinima == p.edadMinima;	
	}

}
