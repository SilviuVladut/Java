package Tema;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

enum CNPError
{
	format,
	length,
	S,
	LL,
	ZZ,
	JJ,
	NNN,
	C
}

class CNPException extends Exception{
	static final long serialVersionUID = 1L;
	
	private CNPError error;
	
	public CNPException(CNPError error) {
		this.error = error;
	}
	
	public String toString()
	{
		switch (error)
		{
		case format:
			return "CNP-ul poate contine doar numere (0 - 9)";
		case length:
			return "Lungimea CNP-ului nu este corecta (13 cifre)";
		case S:
			return "Cifra sexului invalida (1, 2, 5, 6)";
		case LL:
			return "Luna nu este corecta (1 - 12)";
		case ZZ:
			return "Ziua nu este corecta (1 - numar zile din luna)";
		case JJ:
			return "Codul judetului nu este corect (1 - 42)";
		case NNN:
			return "Numarul de ordine nu poate fi 000";
		case C:
			return "Cifra de control nu este valida";
			
		default:
			return null;
		}
		
	}
}


public class Pb3 {


	public static void main(String[] args) {
		Scanner my_scanner = new Scanner(System.in);
		boolean valid;
		LocalDate zi_nastere = null;
		String nume;
		do
		{
			valid = true;
			System.out.print("Nume: ");
			nume = my_scanner.next();
			System.out.print("Introdu CNP-ul: ");
			String CNP = my_scanner.next();
			my_scanner.nextLine();
			
			try
			{
				zi_nastere = getBirthdayFromCNP(CNP);
			}
			catch (CNPException e)
			{
				System.out.println(e.toString());
				valid = false;
			}
		}while (!valid);
		
		System.out.println("Nume: " + nume);
		System.out.println("Zi nastere: " + zi_nastere.toString());
		
		my_scanner.close();
	}
	
	public static LocalDate getBirthdayFromCNP(String cnp) throws CNPException
	{
		int zi, luna, an, cod_judet;
		LocalDate data_nasterii;
		
		if (cnp.length() != 13)
			throw new CNPException(CNPError.length);
		
		if (!hasOnlyDigits(cnp))
			throw new CNPException(CNPError.format);
		
		if (!"1256".contains(cnp.substring(0, 1)))
			throw new CNPException(CNPError.S);
		
		if ("12".contains(cnp.substring(0, 1)))
			an = 1900;
		else
			an = 2000;
		
		an += Integer.parseInt(cnp.substring(1, 3));
		
		luna = Integer.parseInt(cnp.substring(3, 5));
		
		if (luna < 1 || luna > 12)
			throw new CNPException(CNPError.LL);
		
		zi = Integer.parseInt(cnp.substring(5, 7));
		
		try 
		{
		data_nasterii = LocalDate.of(an, luna, zi);
		}
		catch (DateTimeException e)
		{
			throw new CNPException(CNPError.ZZ);
		}

		cod_judet = Integer.parseInt(cnp.substring(7, 9));
		
		if (cod_judet < 1 || cod_judet > 42)
			throw new CNPException(CNPError.JJ);
		
		if (cnp.substring(9, 12) == "000")
			throw new CNPException(CNPError.NNN);
		
		if (!validControlDigit(cnp))
			throw new CNPException(CNPError.C);
		
		return data_nasterii;
	}

	public static boolean hasOnlyDigits(String input)
	{
		for (char c : input.toCharArray())
		{
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	public static boolean validControlDigit(String CNP)
	{
		char C = CNP.charAt(12);
		CNP = CNP.substring(0, 12);
		
		int cnp[] = new int[43], i = 0, c = 0;
		String aux = "279146358279";
		
		for (char ch : CNP.toCharArray())
		{
			cnp[i] = Character.getNumericValue(ch);
			c += (cnp[i] * Character.getNumericValue(aux.charAt(i)));
			i++;
		}
		
		c = (c % 11);
		
		if (c == 10)
			c = 1;

		if (c == Character.getNumericValue(C))
			return true;
		return false;
	}
}


