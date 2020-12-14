package Teme;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
	
	private static LocalDate dateConverter(String data)
	{
		
		int zi, luna, an;
		String aux[] = data.split("\\.");
		
		zi = Integer.parseInt(aux[0].trim());
		luna = Integer.parseInt(aux[1].trim());
		an = Integer.parseInt(aux[2].trim());
		
		
		return LocalDate.of(an, luna, zi);
	}
	
	private static List<Angajat> citesteAngajatii()
	{
		List<Angajat> angajati = new LinkedList<Angajat>();
		
		Scanner my_scanner = null;
		
		try {
			my_scanner = new Scanner(new File("in.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Nu s-a putut deschide fisierul 'in.txt'");
			System.exit(0);
		}
		
		String input, aux[];
		
		while (my_scanner.hasNextLine())
		{
			input = my_scanner.nextLine();
			aux = input.split(",");
			
			if (aux.length != 4)
			{
				System.out.println("Informatiile din fisier nu sunt valide");
				System.exit(0);
			}
			
			
			angajati.add(new Angajat(aux[0].trim(), aux[1].trim(), dateConverter(aux[2]),
					Float.parseFloat(aux[3].trim())));
		}
		
		my_scanner.close();
		
		if (angajati.isEmpty())
		{
			System.out.println("Fisierul este gol");
			System.exit(0);
		}
		
		return angajati;
	}
	
	private static boolean isBoss(Angajat angajat)
	{
		String post = angajat.getPost().trim();
		if (post.equals("sef") || post.equals("director"))
			return true;
		
		return false;
	}

	private static boolean conditiiValide(Angajat angajat)
	{
		if (angajat.getDataAngajare().getMonth() != Month.APRIL)
			return false;
		if (angajat.getDataAngajare().getYear() != LocalDate.now().getYear())
			return false;
		
		return isBoss(angajat);
	}
	
	public static List<String> extrageNume(List<Angajat> angajati)
	{
		List<String> lista_nume = new LinkedList<String>();
		
		for (Angajat angajat : angajati)
		{
			lista_nume.add(angajat.getNume().toUpperCase());
		}
		
		return lista_nume;
	}
	
	public static List<Float> extrageSalarii(List<Angajat> angajati, Predicate<Angajat> conditie)
	{
		List<Float> lista_salarii = new LinkedList<Float>();
		
		for (Angajat angajat : angajati)
		{
			if (conditie.test(angajat))
				lista_salarii.add(angajat.getSalariu());
		}
		
		return lista_salarii;
	}
	
	public static void main(String[] args) 
	{
		List<Angajat> angajati = citesteAngajatii();
		System.out.println("S-au citit angajatii");
		System.out.println();
		
		System.out.println("Lista angajatiilor: ");
		System.out.println();
		angajati.stream().forEach((angajat) -> System.out.println(angajat.toString()));
		System.out.println();
		
		System.out.println("Angajatii cu salariu mai mare de 2500 roni: ");
		System.out.println();
		angajati.stream().filter(angajat -> angajat.getSalariu() > 2500).forEach((angajat) -> System.out.println(angajat.toString()));
		System.out.println();
		
		System.out.println("Lista sefi & manageri din aprilie: ");
		System.out.println();
		angajati.stream().filter(angajat -> conditiiValide(angajat)).collect(Collectors.toList())
			.stream().forEach((angajat) -> System.out.println(angajat.toString()));
		System.out.println();

		System.out.println("Lista angajati sortati ce nu sunt sefi sau manageri: ");
		System.out.println();
		angajati.stream().filter(angajat -> !isBoss(angajat)).sorted(new ComparatorSalarii()).collect(Collectors.toList())
			.stream().forEach((angajat) -> System.out.println(angajat.toString()));
		System.out.println();
		
		System.out.println("Numele fiecarui angajat cu majuscule: ");
		System.out.println();
		extrageNume(angajati).stream().forEach((nume) -> System.out.println(nume));
		System.out.println();
		
		System.out.println("Lista salarii mai mici de 3000 roni: ");
		System.out.println();
		extrageSalarii(angajati, (Angajat a) -> a.getSalariu() < 3000).stream().forEach((salar) -> System.out.println(salar));
		System.out.println();
	}

}
