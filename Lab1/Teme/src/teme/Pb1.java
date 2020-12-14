/*Se cere să se scrie un program Java care să calculeze şi să afişeze perimetru şi aria unui
dreptunghi. Valorile pentru lungime şi lățime se citesc de la tastatura. Sa se adauge un break
point pe prima linie care citește valoarea unei laturi si din acel punct să se ruleze programul
linie cu linie urmărind valorile variabilelor în memorie.  */

package teme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pb1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		BufferedReader lung = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader lat = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		System.out.println("Lungime: ");
		String x = lung.readLine();
		System.out.println("Latime: ");
		String y = lat.readLine();
		// aici trecem string -> int
		int lg = Integer.parseInt(x);
		int lt = Integer.parseInt(y);
		System.out.println("Perimetrul este: "+2*(lg+lt));
		System.out.println("Aria este: "+(lg*lt));

		
	}

}
