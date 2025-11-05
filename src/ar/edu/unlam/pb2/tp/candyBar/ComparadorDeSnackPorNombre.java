package ar.edu.unlam.pb2.tp.candyBar;

import java.util.Comparator;

public class ComparadorDeSnackPorNombre implements Comparator<Snack> {

	@Override
	public int compare(Snack snack1, Snack snack2) {
		
		return snack1.getNombre().compareToIgnoreCase(snack2.getNombre());
	}

}
