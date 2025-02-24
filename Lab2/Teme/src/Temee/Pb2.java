package Temee;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class Produs {
	private String denumire;
	private double pret;
	private double cantitate;
	
	public Produs(String d,double p,double c)
	{
		denumire=d;
		pret=p;
		cantitate=c;
	}
	
	public String toString() //fctia care returneaza toate elementele clasei
	{
	    return denumire+";"+pret+";"+cantitate;
	}
	
	public double getPret()
	{
		return pret;
	}
	
	public double getCantitate()
	{
		return cantitate;
	}
}


public class Pb2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Produs produse1[] = new Produs[50];
		String fis ="fis.txt";
		String des ="rezultat.txt";
		String prod,aux;
		int i=0;
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(fis)));
		while((fis=flux_in.readLine())!=null)
		{
			prod = fis;
			String[] parti = fis.split(";");
			String part1 = parti[0];
			String part2 = parti[1];
			String part3 = parti[2];
			double pret = Double.parseDouble(parti[1]);
			double cant = Double.parseDouble(parti[2]);
			produse1[i]=new Produs(parti[0],pret,cant);
			i++;
		}
		//min/max prima val din tablou
		double min=produse1[0].getPret();
		double max=min;
		int a=0;
		int b=0;
		for(int j=0;j<i;j++)
		{
			if(produse1[j].getPret()<min)
			{
				min = produse1[j].getPret();
				a=j;
			}
			if(produse1[j].getPret()>max)
			{
				max=produse1[j].getPret();
				b=j;
			}
			
		}
		String valoare;
		BufferedReader flux_in2 = new BufferedReader(new InputStreamReader (System.in)); 
		System.out.println("Dati valoarea: ");
		valoare=flux_in2.readLine();
		double cantCitita=Double.parseDouble(valoare);
		System.out.println("Produsele pentru care cantitatea este mai mica decat valoarea citita de la tastatura sunt: ");
		for(int j=0;j<i;j++)
		{
			if(produse1[j].getCantitate()<cantCitita)
			{
				aux=produse1[j].toString();
				String[] parts5 = aux.split(";");
				String part51 = parts5[0];
				String part52 = parts5[1];
				String part53 = parts5[2];
				double pr4=Double.parseDouble(parts5[1]);
				double ca4=Double.parseDouble(parts5[2]);
				System.out.format("%10s %10s %20s",parts5[0],pr4,ca4);
				System.out.println();
			}
		}
				PrintStream flux_out = new PrintStream (des);
				flux_out.println("-----------------------------------------------------------------------------");
				flux_out.printf("%10s %10s %20s", "DENUMIRE PRODUS", "PRET", "CANTITATE");
				flux_out.println();
				flux_out.println("-----------------------------------------------------------------------------");
				for(int j=0;j<i;j++)
				{
					aux=produse1[j].toString();
					String[] parts2 = aux.split(";");
					String part21 = parts2[0];
					String part22 = parts2[1];
					String part23 = parts2[2];
					double pr1=Double.parseDouble(parts2[1]);
					double ca1=Double.parseDouble(parts2[2]);
					flux_out.format("%-20s %-15s %s",parts2[0],pr1,ca1);
					flux_out.println();
				}
				flux_out.println("-----------------------------------------------------------------------------");
				flux_out.println();
				flux_out.println("Produsul cu pretul minim este: ");
				aux=produse1[a].toString();
				String[] parts3 = aux.split(";");
				String part31 = parts3[0];
				String part32 = parts3[1];
				String part33 = parts3[2];
				double pr2=Double.parseDouble(parts3[1]);
				double ca2=Double.parseDouble(parts3[2]);
				flux_out.format("%10s %10s %20s",parts3[0],pr2,ca2);
				flux_out.println();
				flux_out.println("Produsul cu pretul maxim este: ");
				aux=produse1[b].toString();
				String[] parts4 = aux.split(";");
				String part41 = parts4[0];
				String part42 = parts4[1];
				String part43 = parts4[2];
				double pr3=Double.parseDouble(parts4[1]);
				double ca3=Double.parseDouble(parts4[2]);
				flux_out.format("%10s %10s %20s",parts4[0],pr3,ca3);
	}

}
