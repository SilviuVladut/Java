package Teme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pb1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("D:\\Facultate\\LaboratorJava\\Lab3\\Lab3\\src\\cantecin.txt");
		Scanner sc = new Scanner(file);
		Vers[] vrs = new Vers[50]; //facem un vector de tipul Clasei VERS
		int i =0;
		
		System.out.println("Alege o grupare de litere: ");
		Scanner keyboard = new Scanner(System.in);
		String lit = keyboard.nextLine();
		
	
		
		while(sc.hasNextLine())
		{
			//System.out.println(sc.nextLine());
			String s = sc.nextLine();
			vrs[i] = new Vers(s);
			i++;
		}
		
		try {
			FileWriter mywriter = new FileWriter("cantecout.txt");
			for(int k=0;k<i;k++)
			{
			if(vrs[k].grupare(lit))
			{
			if(vrs[k].random_nr()<0.1) {
					mywriter.write(vrs[k].afisare().toUpperCase()+" "+vrs[k].nr_cuv() + " " + vrs[k].nr_vocale()  + " *"+ "\n");
			}
			else 
			{
				mywriter.write(vrs[k].afisare()+" "+vrs[k].nr_cuv() + " " + vrs[k].nr_vocale()  + " *"+ "\n");
			}
			}
			else
			{
				if(vrs[k].random_nr()<0.1)
				 {mywriter.write(vrs[k].afisare().toUpperCase()+" "+vrs[k].nr_cuv() + " " + vrs[k].nr_vocale()  +  "\n");}
				else {mywriter.write(vrs[k].afisare()+" "+vrs[k].nr_cuv() + " " + vrs[k].nr_vocale()  +  "\n");}
			}
			
			}
			mywriter.close();
		} catch (IOException e) {
			System.out.println("Eroare la scriere fisier");  //daca se poate scrie in fisier se intra pe ramura TRY, iar daca scrierea nu a avut loc cu succes se afiseaza un mesaj
			e.printStackTrace();
		}
	}

}
