package Teme;

import java.util.Comparator;

public class ComparatorSalarii implements Comparator<Angajat>{

	public int compare(Angajat a1, Angajat a2) {

			return -Float.compare(a1.getSalariu(), a2.getSalariu());
	}

}