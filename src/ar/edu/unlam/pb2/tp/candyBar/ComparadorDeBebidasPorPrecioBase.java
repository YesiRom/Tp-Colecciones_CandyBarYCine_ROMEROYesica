package ar.edu.unlam.pb2.tp.candyBar;

import java.util.Comparator;

public class ComparadorDeBebidasPorPrecioBase implements Comparator<Bebida> {

	@Override
	public int compare(Bebida bebida1, Bebida bebida2) {
		
		return Double.compare(bebida1.getPrecioBase(), bebida2.getPrecioBase());
	}

}
