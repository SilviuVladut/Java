
public class Sisteme_calcul extends Echipament {
	private String tip_mon;
	private double vit_proc;
	private int c_hdd;
	private String sistem_operare;
	public Sisteme_calcul(String denumire, int nr_inv, double pret,
			String zona_mag, Stare stare_produs,String tip_mon,double vit_proc,int c_hdd,String sistem_operare) {
		super(denumire, nr_inv, pret, zona_mag, stare_produs);
		// TODO Auto-generated constructor stub
		this.tip_mon=tip_mon;
		this.vit_proc=vit_proc;
		this.c_hdd=c_hdd;
		this.sistem_operare=sistem_operare;
	}
	@Override
	public String toString()
	{
		return super.toString() + " " + tip_mon + " " + vit_proc + " " + c_hdd + " " + sistem_operare;
	}
	public void setSistem_operare(String sistem_operare) {
		this.sistem_operare = sistem_operare;
	}
	
}
