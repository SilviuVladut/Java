package Lab5;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



class Carte {
	private String titlu,autor,an;

	public Carte(String titlu, String autor, String an) {
		super();
		this.titlu = titlu;
		this.autor = autor;
		this.an = an;
	}

	@Override
	public String toString() {
		return "Carte [titlu=" + titlu + ", autor=" + autor + ", an=" + an + "]";
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}
	
	
}

public class Pb2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Map<String,Carte> mp = new HashMap<String,Carte>();
		File file = new File("D:\\Facultate\\LaboratorJava\\Lab5\\Lab5\\src\\in.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine())
		{
			int i=0;
			String part = sc.nextLine();
			String parts[] = part.split(";");
			mp.put(parts[0],new Carte(parts[1],parts[2],parts[3]));
			
			
		}
		
		Set s=mp.entrySet();
		Iterator it=s.iterator();
		while(it.hasNext())
		{
		Entry m =(Entry)it.next();
		String key=(String)m.getKey();
		Carte value=(Carte)m.getValue();
		System.out.println("Key :"+key+" Value :"+value.toString());
		
		}
		System.out.println(mp ); 
		
		List<Carte> carte = new ArrayList<Carte>();
		carte.addAll(mp.values());
		System.out.println("---------------------");
		System.out.println("Dimensiunea initiala a listei="+carte.size()+" elemente");
		System.out.println("----Afisare LIST---");
		for (int i=0;i<carte.size();i++)
			System.out.println(carte.get(i).toString() );
		System.out.println("---------------------");
		System.out.println("--Ordonare dupa titlu--");
		Collections.sort(carte, new ComparaTitlu());
		for (int i=0;i<carte.size();i++)
			System.out.println(carte.get(i).toString() );

		
	}

}

class ComparaTitlu implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
	return (((Carte)o1).getTitlu().compareTo(((Carte) o2).getTitlu()));
	}
	}
