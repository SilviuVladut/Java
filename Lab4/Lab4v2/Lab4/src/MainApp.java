import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class MainApp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		List<Echipament> echip = new ArrayList<Echipament>();
		String s = "echipamente.txt";
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new
				FileInputStream(s)));
		while((s=flux_in.readLine())!=null)
		{
			String[] parts = s.split(";");
			String part1 = parts[0];
			String part2 = parts[1];
			String part3 = parts[2];
			String part4 = parts[3];
			String part5= parts[4];
			String part6 = parts[5];
			String part7 = parts[6];
			String part8 = parts[7];
			String part9 = parts[8];

			int nr_inv=Integer.parseInt(part2);
			double pret=Double.parseDouble(part3);
			if(part6.equals("imprimanta"))
			{
				String part10 = parts[9];
				int ppm=Integer.parseInt(part7);
				int p_car=Integer.parseInt(part9);
				echip.add(new Imprimante(part1,nr_inv,pret,part4,Stare.valueOf(part5),ppm,part8,p_car,Mod_scriere.valueOf(part10)));
			}
			else if(part6.equals("copiator"))
			{
				int ppm=Integer.parseInt(part7);
				int p_ton=Integer.parseInt(part8);
				echip.add(new Copiatoare(part1,nr_inv,pret,part4,Stare.valueOf(part5),ppm,p_ton,part9));
			}
			else
			{
				String part10 = parts[9];
				double vit_proc=Double.parseDouble(part8);
				int c_hdd=Integer.parseInt(part9);
				echip.add(new Sisteme_calcul(part1,nr_inv,pret,part4,Stare.valueOf(part5),part7,vit_proc,c_hdd,part10));
			}
		}

		boolean ok=true;
		BufferedReader flux_in2 = new BufferedReader(new InputStreamReader (System.in));
		String opt;
		while(ok)
		{
			System.out.println("------MENIU-------");
			System.out.println("1.Afisarea imprimantelor");
			System.out.println("2.Afisarea copiatoarelor");
			System.out.println("3.Afisarea sistemelor de calcul");
			System.out.println("4.Modificarea starii in care se afla un echipament");
			System.out.println("5.Setarea unui anumit mod de scriere pentru o imprimanta");
			System.out.println("6.Setarea unui format de copiere pentru copiatoare");
			System.out.println("7.Instalarea unui anumit sistem de operare pe un sistem de calcul");
			System.out.println("8.Afisarea echipamentelor vandute");
			System.out.println("0.Iesire");
			System.out.println("Dati optiunea: ");
			opt=flux_in2.readLine();
			switch(opt)
			{
			case "1":for(Echipament e : echip)
			{
				if(e instanceof Imprimante)
					System.out.println(e);
			}
			break;
			case "2":for(Echipament e : echip)
			{
				if(e.getClass()==Copiatoare.class)
					System.out.println(e);
			}
			break;
			case "3":for(Echipament e : echip)
			{
				if(e.getClass().toString().contains("Sisteme_calcul"))
					System.out.println(e);
			}
			break;
			case "4":System.out.println("Dati starea dorita ");
			String stare=flux_in2.readLine();
			System.out.println("Dati denumirea echipamentului caruia doriti sa ii schimbati starea: ");
			String denum=flux_in2.readLine();
			for(Echipament e : echip)
			{
				if(e.getDenumire().equals(denum))
					e.setStare_produs(Stare.valueOf(stare));
			}
			break;
			case "5":System.out.println("Dati modul de scriere dorit ");
			String mod_scriere=flux_in2.readLine();
			System.out.println("Dati denumirea imprimantei careia doriti sa ii schimbati starea: ");
			String denum2=flux_in2.readLine();
			for(Echipament e : echip)
			{
				if(e.getDenumire().equals(denum2))
					((Imprimante) e).setMod_scriere(Mod_scriere.valueOf(mod_scriere));
			}
			break;
			case "6":System.out.println("Dati formatul de copiere dorit ");
			String format_copiere=flux_in2.readLine();
			System.out.println("Dati denumirea copiatorului caruia doriti sa ii schimbati starea: ");
			String denum3=flux_in2.readLine();
			for(Echipament e : echip)
			{
				if(e.getDenumire().equals(denum3))
					((Copiatoare) e).setFormat_copiere(format_copiere);
			}
			break;
			case "7":System.out.println("Dati sistemul de operare dorit ");
			String sistem_operare=flux_in2.readLine();
			System.out.println("Dati denumirea sistemului de calcul caruia doriti sa ii schimbati starea: ");
			String denum4=flux_in2.readLine();
			for(Echipament e : echip)
			{
				if(e.getDenumire().equals(denum4))
					((Sisteme_calcul) e).setSistem_operare(sistem_operare);
			}
			break;
			case "8":
				for(Echipament e : echip)
				{
					if(e.getStare_produs().equals(Stare.valueOf("vandut")))
						System.out.println(e);
				}
				break;
			case "0": ok=false;
			break;
			default: System.out.println("Optiune gresita!");

			}
		}
		System.out.println("Ati iesit din meniu");
	}
}
