enum Mod_scriere{
	Color,
	AlbNegru
}
public class Imprimante extends Echipament {
	private int ppm;
	private String rezolutie;
	private int p_car;
	private Mod_scriere mod_scriere;
	public Imprimante(String denumire, int nr_inv, double pret,
			String zona_mag, Stare stare_produs,int ppm,String rezolutie,int p_car,Mod_scriere mod_scriere) {
		super(denumire, nr_inv, pret, zona_mag, stare_produs);
		// TODO Auto-generated constructor stub
		this.ppm=ppm;
		this.rezolutie=rezolutie;
		this.p_car=p_car;
		this.mod_scriere=mod_scriere;
	}
	@Override
	public String toString()
	{
		return super.toString() + " " + ppm + " " + rezolutie + " " + p_car + " " + mod_scriere;
	}
	public void setMod_scriere(Mod_scriere mod_scriere) {
		this.mod_scriere = mod_scriere;
	}
	
}

