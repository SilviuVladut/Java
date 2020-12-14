package Lab5;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ClientiiBancilor {

	private Vector<Banca> banci;
	Scanner input;
	
	ClientiiBancilor()
	{
		input = new Scanner(System.in);
		banci = new Vector<Banca>();
	}
	
	public void menu() throws IOException {
		int o;
		
		do
		{
			System.out.println();
			System.out.println("1. Adaugare banca");
			System.out.println("2. Adaugare client");
			System.out.println("3. Adaugare cont");
			System.out.println("4. Afisare date introduse");
			System.out.println("5. Depunerea unei sume intr-un cont");
			System.out.println("6. Extragerea unei sume dintr-un cont");
			System.out.println("7. Transfer de bani intre doua conturi");
			System.out.println("0. Iesire");
			
			o = input.nextInt();
			input.nextLine();
			
			
			switch (o)
			{
			case 1:
				adaugareBanca();
				break;
			case 2:
				adaugareClient(selecteazaBanca(), true);
				break;
			case 3:
				adaugareContBancar(selecteazaClient(selecteazaBanca()));
				break;
			case 4:
				afisareDate();
				break;
			case 5:
				depuneInCont();
				break;
			case 6:
				extragereDinCont();
				break;
			case 7:
				transfer();
				break;
			default:
				System.out.println("Optiunea introdusa nu este valida!");
				break;
			case 0:
				break;
			}
			
			
		}while(o != 0);

		input.close();
	}
	
	public Banca adaugareBanca() throws IOException
	{
		Banca b;
		
		System.out.print("Numele bancii: ");
		
		while (!input.hasNext());
		
		b = new Banca(input.nextLine());
		banci.add(b);
		
		return b;
	}
	
	public ContBancar adaugareContBancar(Client c) throws IOException
	{
		
		ContBancar cb;
		int aux;
		float suma;
		
		System.out.println("Moneda contului: ");
		System.out.println("0. EURO \n1. RON");
		do
		{
			aux = input.nextInt();
			input.nextLine();
		}while (aux != 0 && aux != 1);
		
		System.out.print("Suma: ");
		do
		{
			suma = input.nextInt();
			input.nextLine();
		}while (suma < 0);
		
		cb = new ContBancar(suma, Moneda.values()[aux]);
		
		c.adaugaCont(cb);
		
		return cb;
	}
	
	public Banca selecteazaBanca() throws IOException
	{	
		Banca b;
		int index;
		
		this.afisareBanci();
		System.out.println("0. <Banca noua>");
		
		index = input.nextInt();
		input.nextLine();
		
		switch (index)
		{
		case 0:
			b = adaugareBanca();
			break;
		default:
			b = banci.get(index - 1);
			if (b == null)
			{
				do
				{
					index = input.nextInt();
					input.nextLine();
					b = banci.get(index - 1);
				}while (b != null);
			}
			break;
		}
		
		return b;
	}
	
	public Client selecteazaClient(Banca b) throws IOException
	{
		Client c;
		int index;
		
		b.afisareClienti();
		System.out.println("0. <Client nou>");
		
		index = input.nextInt();
		input.nextLine();
		
		switch (index)
		{
		case 0:
			c = adaugareClient(b, false);
			break;
		default:
			c = b.getClient(index - 1);
			if (c == null)
			{
				do
				{
					index = input.nextInt(); 
					input.nextLine();
					c = b.getClient(index - 1);
				}while (c != null);
			}
			break;
		}
		
		return c;
	}
	
	public Client adaugareClient(Banca b, boolean adaugaSiCont) throws IOException
	{
		Client c;
		String nume, adresa;
		int aux;
		
		System.out.print("Numele clientului: ");
		nume = input.nextLine();
		
		System.out.print("Adresa clientului: ");
		adresa = input.nextLine();
			
		if (adaugaSiCont)
		{
			System.out.println("Moneda contului: ");
			System.out.println("0. EURO \n1. RON");
			do
			{
				aux = input.nextInt();
				input.nextLine();
			}while (aux != 0 && aux != 1);
			
			c = new Client(nume, adresa, Moneda.values()[aux]);
		}
		else
			c = new Client(nume, adresa);
		
		return b.adaugaClient(c);
	}
	
	public void transfer()
	{
		System.out.println("Alegeti contul din care se transfera: ");
		ContBancar cb_1 = interogateUser();
		if (cb_1 == null)
			return;
		
		System.out.println("Alegeti contul in care se transfera: ");
		ContBancar cb_2 = interogateUser();
		if (cb_2 == null)
			return;
		
		float suma;
		
		System.out.println();
		
		do
		{
			System.out.print("Introduceti suma ce sa se depuna: ");
			suma = input.nextInt();
			input.nextLine();
		}while (suma < 0 || suma > cb_1.getSuma());
		
		cb_1.transferaCatre(cb_2, suma);
	}
	
	public void extragereDinCont()
	{
		System.out.println();
		
		ContBancar cb = interogateUser();
		if (cb != null)
		{
			System.out.println();
			
			float suma;
			
			System.out.println();
			
			do
			{
				System.out.print("Introduceti suma ce sa se extraga: ");
				suma = input.nextInt();
				input.nextLine();
			}while (suma < 0 || suma > cb.getSuma());
			
			cb.extragere(suma);
		}
	}
	
	public ContBancar interogateUser()
	{
		afisareBanci();
		
		System.out.println();
		
		Banca b;
		try
		{
			System.out.print("Alegeti banca clientului: ");
			b = banci.get(input.nextInt() - 1);
			input.nextLine();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Banca cu acest index nu exista!");
			return null;
		}
		
		System.out.println();
		
		b.afisareClienti();
		
		Client c;
		
		System.out.print("Alegeti clientul: ");
		c = b.getClient(input.nextInt() - 1);
		input.nextLine();
		
		if (c == null)
		{
			System.out.println("Clientul cu acest index nu exista!");
			return null;
		}
		
		System.out.println();
		
		c.afisareConturi();
		
		ContBancar cb;
		do
		{
			System.out.print("Alegeti contul: ");
			cb = c.getCont(input.nextInt() - 1);
			input.nextLine();
		}while (cb == null);
		
		return cb;
	}
	
	public void depuneInCont()
	{
		ContBancar cb = interogateUser();
		if (cb != null)
		{
			float suma;
			
			System.out.println();
			do
			{
				System.out.print("Introduceti suma ce sa se depuna: ");
				suma = input.nextInt();
				input.nextLine();
			}while (suma < 0);
			
			cb.depunere(suma);
		}
	}
	
	public void afisareBanci()
	{
		int i = 0;
		for (Banca b : banci)
		{
			System.out.println((i + 1) + ". " + b.toString());
			i++;
		}	
	}
	
	public void afisareDate()
	{
		for (Banca b : banci)
		{
			b.afisareDate();
		}
	}

}