/* Să se scrie un program care citește un număr n natural de la tastatură și afișează toți
divizorii acestuia pe ecran. Dacă numărul este prim se va afișa un mesaj corespunzător. 
*/

package teme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pb3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("N= ");
		String x = in.readLine();
		int n = Integer.parseInt(x);
		int prim=0;
		
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				System.out.println("Divizor al lui: "+n+" este "+i);
				prim = prim+1;
			}
	
		}
		if(prim == 2)
		{
			System.out.println("Numarul "+n+" este prim!");
		}
		
	}

}
