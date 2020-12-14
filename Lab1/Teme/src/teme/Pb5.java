/* Să se scrie un program care generează aleatoriu un număr întreg cuprins între 0 și 20.
Progamul va determina dacă numărul aparține șirului lui Fobonacci. */

package teme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;

public class Pb5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int rand1 = rand.nextInt(21);
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Sa fie sirul lui fibonacci pana la cate elem: ");
		//String x = in.readLine();
		//int n = Integer.parseInt(x);
		System.out.println("Numarul random generat este:"+rand1);
		Vector<Integer> vec=new Vector<>();
		int nr0=0;
		int nr1=1;
		for(int i=3;i<=20;i++)
		{
			int nr2=nr0+nr1;
			nr0=nr1;
			nr1=nr2;
			//System.out.println(nr2);
			vec.add(nr2);
		}
		
		if(vec.contains(rand1))
		{
			System.out.println("Nr "+rand1+" este in sir.");
		}
		else
		{
			System.out.println("Nr "+rand1+" NU este in sir.");
		}
		
		System.out.println("Sirul fibonacci: "+vec);
	}

}
