
public class Copiatoare extends Echipament {
	private int ppm;
	private int p_ton;
	private String format_copiere;
	public Copiatoare(String denumire, int nr_inv, double pret,
			String zona_mag, Stare stare_produs,int ppm,int p_ton,String format_copiere) {
		super(denumire, nr_inv, pret, zona_mag, stare_produs);
		// TODO Auto-generated constructor stub
		this.ppm=ppm;
		this.p_ton=p_ton;
		this.format_copiere=format_copiere;
	}
	@Override
	public String toString()
	{
		return super.toString() + " " + ppm + " " + p_ton + " " + format_copiere;
	}
	public void setFormat_copiere(String format_copiere) {
		this.format_copiere = format_copiere;
	}
	
}
