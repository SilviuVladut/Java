/* Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul oronat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays*/

package Teme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pb3 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("D:\\Facultate\\LaboratorJava\\Lab3\\Lab3\\src\\judete.txt");
		Scanner sc = new Scanner(file);
		ArrayList<String> judete = new ArrayList<>();
		int i = 0;
		while(sc.hasNextLine()) //citeste din fisier toate liniile pana la final cand nu mai e nimic
		{
			//System.out.println(sc.nextLine());
			judete.add(sc.nextLine());
		}
		
		Collections.sort(judete); //sortam alfabetic
		System.out.println(judete);	
		System.out.println("Cauta judetul: ");
		Scanner keyboard = new Scanner(System.in);
		String jud = keyboard.nextLine();
		System.out.println("Judetul se afla la poz: "+ judete.indexOf(jud));
		
		
	}

}
