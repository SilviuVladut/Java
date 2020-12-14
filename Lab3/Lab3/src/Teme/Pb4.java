package Teme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pb4 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Melodie[] mel = new Melodie[50]; //vector de tipul clasei MELODIE
		File file = new File("D:\\Facultate\\LaboratorJava\\Lab3\\Lab3\\src\\in.txt");
		Scanner sc = new Scanner(file);
		int i =0;
		while(sc.hasNextLine())
		{
			String sir = sc.nextLine();
			String[] cuv = sir.split(";");
			
			mel[i] = new Melodie(cuv[0],cuv[1], Integer.parseInt(cuv[2]), Integer.parseInt(cuv[3])); //adaugam in vector o noua clasa cu alte elemente
			i++;
		}
		
		for(int j=0;j<i;j++)
		{
			
		System.out.print(mel[j].afisare());
		
		}
		
		System.out.println("Melodiile sortate dupa vizualizare: ");
		for(int j=0;j<i;j++)
		{
			for(int k = j+1;k<i;k++)
			{
				if(mel[j].getVizualizari() <= mel[k].getVizualizari())
				{
					Melodie aux = mel[j];
					mel[j] = mel[k];
					mel[k] = aux;
				}
			}
			System.out.println(mel[j].afisare());
		}
		System.out.println("Nume artist: ");
		Scanner keyboard = new Scanner(System.in); //memoram de la tastatura
		String artist = keyboard.nextLine();
		for(int j=0;j<i;j++)
		{ //parcurgem toate melodiile si unde ne a gasit artistul nostru afisam
			if(mel[j].getNume_artist().contains(artist))
			{
				System.out.println(mel[j].afisare());
			}
		}
	
	}

}
