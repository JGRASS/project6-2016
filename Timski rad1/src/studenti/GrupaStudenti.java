package studenti;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import studenti.gui.GUIKontroler;
import studenti.gui.PrikazStudenataGUI;
import studenti.sistemskeoperacije.SOUcitajIzFajlaDeserijalizacijom;
import studenti.sistemskeoperacije.SOUnesiStudenta;
import studenti.sistemskeoperacije.SOUpisiUFajlSerijalizacijom;
import studenti.sistemskeoperacije.SOVratiPretrazeneStudente;
import studenti.sistemskeoperacije.SOVratiSveStudente;
/**
 * Klasa koja se odnosi na grupu studenata
 * @author Andjela
 *
 */
public class GrupaStudenti {
	/**
	 * Lista koja ce sadrzati sve studente koje budemo unosili u bazu
	 */
	private LinkedList<Student> studenti = new LinkedList<>();
	/**
	 * Predstavlja formu koja ce sluziti za prikaz svih studenata
	 */
	private static PrikazStudenataGUI prikaz= new PrikazStudenataGUI();
	
	
	/**
	 * Metoda koja inicijalizuje listu studenti
	 * @param studenti Lista objekata tipa Student
	 */
	public void setStudenti(LinkedList<Student> studenti) {
		this.studenti = studenti;
	}
	/**
	 * Metoda koja unosi studenta u listu, istovremeno osvezava tabelu za prikaz i 
	 * upisuje novog studenta u fajl
	 * @param s Objekat tipa student
	 */
	public void unesiStudenta(Student s){
		SOUnesiStudenta.izvrsi(s, studenti);
	}
	/**
	 * Metoda koja upisuje u binarni fajl serijalizacijom listu objekata tipa Student
	 * 
	 */
	public void upisiUFajlSerijalizacijom(){
		SOUpisiUFajlSerijalizacijom.izvrsi(studenti);
		
	}
	/**
	 * Metoda koja ucitava iz binarnog fajla sve studente i upisuje ih u nasu listu studenti
	 * @throws java.lang.RuntimeException Ako dodje do greske prilikom ucitavanja podataka iz fajla
	 */
	public void ucitajIzFajlaDeserijalizacijom(){
		SOUcitajIzFajlaDeserijalizacijom.izvrsi(studenti);
	}
	/**
	 * Metoda vraca celu listu studenata
	 * @return Lista studenti
	 */
	public LinkedList<Student> vratiSveStudente(){
		return SOVratiSveStudente.izvrsi(studenti);
	}
	/**
	 * Metoda koja vraca koja prolazi kroz listu i trazi one studente kod kojih se u sklopu imena i prezimena ili br indeksa
	 * nalazi odgovarajuca rec, pravi listu i ubacuje odgovarajuce objekte u nju
	 * @param trazeno String koji neko zeli da pronadje
	 * @return Lista koja sadrzi objekte tipa student koji odgovaraju rezultatima pretrage
	 */
	public LinkedList<Student> vratiPretrazeneStudente(String trazeno) {
		return SOVratiPretrazeneStudente.izvrsi(trazeno, studenti);
	}
	
	
	
}
