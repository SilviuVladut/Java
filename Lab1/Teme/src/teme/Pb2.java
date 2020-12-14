/* Să se scrie un program care citește un set de numere din fișierul de intrare in.txt, care are
conținutul din figura 1.11. Programul va determină suma lor, media aritmetică, valoarea
minimă, valoarea maximă, va afișa aceste valori pe ecran și le va scrie în fișierul de ieșire
out.txt. Media aritmetică va fi afișată ca un număr real*/

package teme;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Pb2 {


	public static void main(String[] args) throws IOException  {
		
		File file = new File("D:\\Facultate\\LaboratorJava\\Lab1\\Teme\\src\\fis.txt");
		Scanner sc = new Scanner(file); //scaneaza fisierul pe care il dam
		int y = 0;
		int suma=0;
		// declarare vector de Int-uri
		Vector<Integer> vec = new Vector<>();
		while(sc.hasNextLine())
		{
			int x= sc.nextInt();
			//System.out.println(x);
			vec.add(x);
			y = y+1;
			
		}
		
		System.out.println("Sunt "+y+" nr in fisier");
		System.out.println("vec: "+vec);
		
		for(int i=0;i<y;i++)
		{
			suma = suma + vec.get(i);
			
			
		}
		
		System.out.println("suma elem: "+suma);
		float ma = (float) suma/y;
		System.out.println("media aritm: "+ma);
		System.out.println("Elem max: "+ Collections.max(vec));
		System.out.println("Elem min: "+ Collections.min(vec));
		
		
		
	
	}



}
