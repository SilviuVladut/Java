package Lab5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Banca {
	private String denumire_banca;
	List<Client> clienti = new ArrayList<Client>();
	
	public Banca(String denumire_banca) {
		super();
		this.denumire_banca = denumire_banca;
	}
	
	public Client getClient(int index)
	{
		
			return clienti.get(index);
		
	}
	

	public String toString() {
		return denumire_banca;
	}
	
	public Client adaugaClient(String nume,String adresa)
	{
		Client c = new Client(nume,adresa);
		clienti.add(c);
		
		return c;
	}
	public Client adaugaClient(String nume,String adresa,Moneda moneda)
	{
		Client c = new Client(nume,adresa,moneda);
		clienti.add(c);
		
		return c;
	}
	
	public Client adaugaClient(Client c)
	{
		clienti.add(c);
		
		return c;
	}
	public void afisareClienti()
	{
		int i = 0;
		for (Client c : clienti)
		{
			System.out.println((i + 1) + ". " + c.toString());
			i++;
		}
	}
	
	public void afisareDate()
	{
		System.out.println(this.toString());
		for (Client c : clienti)
		{
			c.AfiareDate();
		}
	}
	
}
