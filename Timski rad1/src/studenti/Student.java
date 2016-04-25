package studenti;

import java.io.Serializable;

public class Student implements Serializable{
	private String imeIPrezime, dodatneAktivnosti, brojIndeksa;
	private double prosek;
	
	public Student(String imeIPrezime, String dodatneAktivnosti, String brojIndeksa, double prosek) {
		super();
		this.imeIPrezime = imeIPrezime;
		this.dodatneAktivnosti = dodatneAktivnosti;
		this.brojIndeksa = brojIndeksa;
		this.prosek = prosek;	
	}
	
	public Student(){
	}
	
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	public String getDodatneAktivnosti() {
		return dodatneAktivnosti;
	}
	public void setDodatneAktivnosti(String dodatneAktivnosti) {
		this.dodatneAktivnosti = dodatneAktivnosti;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public double getProsek() {
		return prosek;
	}
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ime i prezime: "+imeIPrezime+" Br. indeksa: "+brojIndeksa+"Opis: "+dodatneAktivnosti+" Prosek: "+prosek;
	}
	
}
