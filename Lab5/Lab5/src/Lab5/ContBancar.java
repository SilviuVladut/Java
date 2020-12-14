package Lab5;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

enum Moneda
{
	EURO,
	RON
}

public class ContBancar implements Operatiuni {
	private long conturi = 0;
	private String nrcont;
	private Moneda moneda;
	double suma;
	Calendar data_deschidere;
	Calendar data_ultop;
	public ContBancar(Moneda moneda) {
		super();
		this.nrcont = Long.toString(conturi);
		this.moneda = moneda;
		this.suma=0;
		this.data_deschidere = Calendar.getInstance();
		this.data_ultop = Calendar.getInstance();
		conturi++;
	}
	public ContBancar(double suma,Moneda moneda) {
		super();
		this.nrcont = Long.toString(conturi);
		this.moneda = moneda;
		this.suma=suma;
		this.data_deschidere = Calendar.getInstance();
		this.data_ultop = Calendar.getInstance();
		conturi++;
	}
	
	public Moneda getMoneda()
	{
		return moneda;
	}
	
	public String toString()
	{
		String output;
		output = "Contul numarul: " + nrcont + ", ";
		output += "Suma: " + suma + " (" + moneda.toString() + "), ";
		output += "Data deschiderii: " + data_deschidere.getTime().toString() + ", ";
		output += "Data ultimei operatiuni: " + data_ultop.getTime().toString();
		
		return output;
	}
	
	public void transferaCatre(ContBancar receiver, double suma)
	{
		if (suma > this.suma)
			System.out.println("Fonduri insuficiente!");
		else
		{
			this.extragere(suma);
			if (this.moneda == Moneda.EURO && receiver.moneda == Moneda.RON)
				suma = convertEuroToRon(suma);
			else if (this.moneda == Moneda.RON && receiver.moneda == Moneda.EURO)
				suma = convertRonToEuro(suma);
				
			receiver.depunere(suma);
			System.out.println("S-a transferat " + suma + " " + this.moneda.toString());
		}
	}
	public static double convertEuroToRon(double euro)
	{
		return (double) (euro * 4.88);
	}
	
	public static double convertRonToEuro(double ron)
	{
		return (double) (ron *0.21);
	}
	
	public double getSuma()
	{
		return suma;
	}

	@Override
	public double calculeaza_dobanda() {
		long today = Calendar.getInstance().getTimeInMillis();
		int days = (int)TimeUnit.MILLISECONDS.toDays(Math.abs(today - data_ultop.getTimeInMillis()));
		
		if (moneda == Moneda.EURO)
			return (float) (0.1 * days);
		else if (suma < 500)
				return (float) (0.3 * days);
			else
				return (float) (0.8*days);
	}

	@Override
	public double actualizare_suma() {
		double dobanda = calculeaza_dobanda();
		data_ultop = Calendar.getInstance();
		suma -= dobanda;
		return suma;
	}

	@Override
	public void depunere(double suma) {
		this.suma = actualizare_suma() + suma;
	}

	@Override
	public void extragere(double suma) {
		this.suma = actualizare_suma() - suma;
	}
	
}
