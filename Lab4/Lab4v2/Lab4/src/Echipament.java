enum Stare{
	achizitionat,
	expus,
	vandut
}
public class Echipament {
	private String denumire;
	private int nr_inv;
	private double pret;
	private String zona_mag;
	private Stare stare_produs;
	public Echipament(String denumire, int nr_inv, double pret,
			String zona_mag, Stare stare_produs) {
		super();
		this.denumire = denumire;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.stare_produs = stare_produs;
	}
	public String getDenumire() {
		return denumire;
	}
	@Override
	public String toString()
	{
		return denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + stare_produs;
	}
	public void setStare_produs(Stare stare_produs) {
		this.stare_produs = stare_produs;
	}
	public Stare getStare_produs() {
		return stare_produs;
	}
	
	
}
