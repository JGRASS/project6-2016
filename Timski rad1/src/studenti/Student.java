package studenti;

import java.io.Serializable;
/**
 * Klasa o studentu
 * @author Andjela
 *
 */
public class Student implements Serializable{
	/**
	 * Ime i prezime studenta
	 */
	private String imeIPrezime;
	/**
	 * Neke dodatne aktivnosti ako ih ima
	 */
	private String dodatneAktivnosti;
	/**
	 * Broj indeksa
	 */
	private String brojIndeksa;
	/**
	 * Dosadasnji prosek na studijama 
	 */
	private double prosek;
	/**
	 * Konstruktor koji kreira objekat Student
	 * @param imeIPrezime Ime i prezime studenta
	 * @param dodatneAktivnosti Opis aktivnosti
	 * @param brojIndeksa Broj indeksa
	 * @param prosek Trenutni prosek
	 */
	public Student(String imeIPrezime, String dodatneAktivnosti, String brojIndeksa, double prosek) {
		super();
		this.imeIPrezime = imeIPrezime;
		this.dodatneAktivnosti = dodatneAktivnosti;
		this.brojIndeksa = brojIndeksa;
		this.prosek = prosek;	
	}
	/**
	 * Obican konstruktor
	 */
	public Student(){
	}
	/**
	 * Vraca ime i prezime studenta
	 * @return Ime i prezime
	 */
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	/**
	 * Postavlja vrednost imena i prezimena
	 * @param imeIPrezime Ime i prezime studenta
	 */
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	/**
	 * Vraca dodatne aktivnosti nekog studenta
	 * @return Opis aktivnosti
	 */
	public String getDodatneAktivnosti() {
		return dodatneAktivnosti;
	}
	/**
	 * Postavlja dodatne aktivnosti
	 * @param dodatneAktivnosti Opisuje koja znanja van fakulteta student poseduje
	 */
	public void setDodatneAktivnosti(String dodatneAktivnosti) {
		this.dodatneAktivnosti = dodatneAktivnosti;
	}
	/**
	 * Vraca broj indeksa
	 * @return Broj indeksa
	 */
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	/**
	 * Postavlja broj indeksa
	 * @param brojIndeksa
	 */
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	/**
	 * Vraca prosek studenta
	 * @return Prosek
	 */
	public double getProsek() {
		return prosek;
	}
	/**
	 * Postavlja prosek studenta
	 * @param prosek Trenutni prosek
	 */
	public void setProsek(double prosek) {
		this.prosek = prosek;
	}
	/**
	 * Metoda vraca sve informacije o studentu 
	 * @return Podaci u studentu u vidu stringa
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ime i prezime: "+imeIPrezime+" Br. indeksa: "+brojIndeksa+"Opis: "+dodatneAktivnosti+" Prosek: "+prosek;
	}
	
}
