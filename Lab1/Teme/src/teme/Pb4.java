/*Să se determine cmmdc a două numere naturale, a căror valoare maximă este 30. Numerele
vor fi generate aleatoriu cu ajutorul unui obiect de tip Random și metodei nextInt(); */

package teme;

import java.util.Random;

public class Pb4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Random rand = new Random();
		int rand1 = rand.nextInt(31);
		int rand2 = rand.nextInt(31);
		
		System.out.println(rand1);
		System.out.println(rand2);
		
		while(rand1!=rand2)
		{
			if(rand1>rand2)
			{
				rand1=rand1-rand2;
			}
			else
			{
				rand2=rand2-rand1;
			}
		}
		
		System.out.println("CMMDC ul este: "+rand1);
	}

}
