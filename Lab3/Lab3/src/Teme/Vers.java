package Teme;

import java.util.Random;

public class Vers {
		
	private String vers;
	
	public Vers(String vers)
	{
		this.vers = vers;
	}
	
	public String afisare()
	{
		return vers;
	}
	
	public String nr_cuv()
	{
		String[] cuv = vers.split(" ");
		return String.valueOf(cuv.length);
	}
	
	public String nr_vocale()
	{
		int contor = 0;
		
		for(int i = 0;i < this.vers.length(); i++) 
		{
			if(
					this.vers.charAt(i) == 'a' || 
					this.vers.charAt(i) == 'e' || 
					this.vers.charAt(i) == 'i' || 
					this.vers.charAt(i) == 'o' || 
					this.vers.charAt(i) == 'u' || 
					this.vers.charAt(i) == 'A' || 
					this.vers.charAt(i) == 'E' || 
					this.vers.charAt(i) == 'I' || 
					this.vers.charAt(i) == 'O' || 
					this.vers.charAt(i) == 'U' ) 
			{
				contor++;
			}
		}
		
		return String.valueOf(contor);
	}
	
	public boolean grupare(String lit)
	{
		boolean grup = vers.endsWith(lit);
		return grup;

	}
	
	public double random_nr()
	{
		Random rand = new Random();
		return rand.nextDouble();
	}


	
	
}
