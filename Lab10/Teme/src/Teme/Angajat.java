package Teme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Angajat {
	
	private String nume;
	private String post;
	private LocalDate dataAngajare;
	private float salariu;
	
	public Angajat (String nume, String post, LocalDate dataAngajare, float salariu)
	{
		this.nume = nume;
		this.post = post;
		this.dataAngajare = dataAngajare;
		this.salariu = salariu;
	}
	
	public void setNume(String nume)
	{
		this.nume = nume;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public void setPost(String post)
	{
		this.post = post;
	}
	
	public String getPost()
	{
		return this.post;
	}
	
	public void setDataAngajare(LocalDate dataAngajare)
	{
		this.dataAngajare = dataAngajare;
	}
	
	public LocalDate getDataAngajare()
	{
		return this.dataAngajare;
	}
	
	public void setSalariu(float salariu)
	{
		this.salariu = salariu;
	}
	
	public float getSalariu()
	{
		return this.salariu;
	}
	
	public String toString()
	{
		String output;
		output = nume + ", ";
		output += post + ", ";
		output += dataAngajare.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString() + ", ";
		output += salariu;
		return output;
	}
}
