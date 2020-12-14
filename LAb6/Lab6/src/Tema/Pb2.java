package Tema;

import java.io.IOException;
import java.util.Scanner;

class Except1 extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Except1() {
		
	}
	public String toString()
	{
		return "Nu putem imparti la 0!";
	}
}

class Except2 extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Except2() {
		
	}
	public String toString()
	{
		return "Caractere nepermise!";
	}
}



public class Pb2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String a,b;
		float c,nr1,nr2;
		boolean valid;
		do
		{
			valid = true;
			
			try {
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Primul nr: ");
				a = keyboard.nextLine();
				System.out.println("Al doilea nr: ");
				b = keyboard.nextLine();
				
				try 
				{
					nr1 = Float.parseFloat(a);
					nr2 = Float.parseFloat(b);				
				}
				catch (NumberFormatException e)
				{
					throw new Except2();
				}
				
				if (nr2 == 0)
					throw new Except1();
				
				c= nr1/nr2;
			    System.out.println("a/b="+ c);
			}
			catch (Exception e)
			{
				valid = false;
				System.out.println(e.toString());
			}
			
			
		}while (!valid);
	
	} 
}

