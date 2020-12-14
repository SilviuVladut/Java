package Teme;

public class Melodie {
	
	private String nume_mel;
	private String nume_artist;
	private int an_lansare;
	private int vizualizari;
	
	public Melodie(String nume_mel, String nume_artist, int an_lansare, int vizualizari) {
		super();
		this.nume_mel = nume_mel;
		this.nume_artist = nume_artist;
		this.an_lansare = an_lansare;
		this.vizualizari = vizualizari;
	}
	
	public String afisare()
	{
		return nume_mel + " " + nume_artist + " " + an_lansare + " " + vizualizari + "\n";
	}
	
	public String getNume_mel() {
		return nume_mel;
	}



	public String getNume_artist() {
		return nume_artist;
	}



	public int getAn_lansare() {
		return an_lansare;
	}



	public int getVizualizari() {
		return vizualizari;
	}
	


	
	
	
}
