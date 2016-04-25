package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studenti.GrupaStudenti;
import studenti.Student;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Glavni prozor, koji sluzi za pokretanje svih ostalih prozora
 * @author Andjela
 *
 */
public class GUIKontroler {
	/**
	 * Klasa koja se odnosi na pocetni prozor nase aplikacije
	 */
	private static BazaStudenti baza;
	/**
	 * Klasa GrupaStudenti
	 */
	private static GrupaStudenti grupa;
	/**
	 * Klasa koja se odnosi na prozor za prikaz
	 */
	private static PrikazStudenataGUI prikaz;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baza = new BazaStudenti();
					prikaz = new PrikazStudenataGUI();
					prikaz.setVisible(true);
					prikaz.setLocationRelativeTo(null);
					grupa = new GrupaStudenti();
					baza.setVisible(true);
					baza.setLocationRelativeTo(null);
					prikaz.setVisible(false);
					ucitajIzFajla();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Metoda koja sluzi za pokretanje dijaloga za zatvaranje programa
	 */
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(null, "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		
		}
	}
	/**
	 * Metoda koja vraca sve studente iz liste studenti
	 * @return Lista objekata tipa Student
	 */
	public static LinkedList<Student> vratiSveStudente() {
		return grupa.vratiSveStudente();
	}
	/**
	 * Metoda koja postavlja vidljivost prozora za dodavanje na true i otvara ga na centar ekrana
	 */
	public static void otvoriProzorZaDodavanjeStudenata(){
		DodajStudentaGUI prozor = new DodajStudentaGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
		
	}
	/**
	 * Metoda koja postavlja vidljivost prozora za prikaz na true i otvara ga na centar ekrana i osvezava tabelu
	 */
	public static void otvoriProzorZaPrikazStudenata(){
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.setTitle("Prikaz studenata");
	}	
	/**
	 * Metoda koja postavlja vidljivost prikaz za dodavanje na true i otvara ga na centar ekrana, osvezava tabelu, 
	 * poziva metodu iz klase PrikazStudenataGUI koja obezbedjuje vidljivost neophodnih polja,
	 */
	public static void otvoriProzorZaPretragu(){
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.vidljivaPretraga();
		prikaz.setTitle("Pretraga studenata");
	}
	
	/**
	 * Metoda koja postavlja vidljivost prozora za prikaz na true i otvara ga na centar ekrana, osvezava tabelu,
	 * poziva metodu iz klase PrikazStudenataGUI koja obezbedjuje vidljivost neophodnih polja
	 */
	public static void otvoriProzorZaIzmenu() {
		// TODO Auto-generated method stub
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.vidljivaIzmena();
		prikaz.setTitle("Izmena studenata");
		
	}
	/**
	 * Metoda za unosenje studenta u listu
	 * @param imeIPrezime Ime i prezime studenta
	 * @param dodatneAktivnosti Opis aktivnosti
	 * @param brojIndeksa Broj indeksa
	 * @param prosek Trenutni prosek
	 */
	public static void unesiStudenta(String imeIPrezime,String dodatneAktivnosti,String brojIndeksa, double prosek){
		try{
			Student s = new Student(imeIPrezime, dodatneAktivnosti, brojIndeksa, prosek);
			grupa.unesiStudenta(s);
			prikaz.osveziTabelu();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(baza.getContentPane(), "Proveri formu "+ e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/**
	 * Metoda koja poziva metodu za upisivanje liste u binarni fajl
	 */
	public static void sacuvajUFajl(){
		try {
			grupa.upisiUFajlSerijalizacijom();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metoda koja ucitava podatke iz fajla i osvezva tabelu nakon toga
	 */
	public static void ucitajIzFajla(){
		try {
			grupa.ucitajIzFajlaDeserijalizacijom();
			prikaz.osveziTabelu();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metoda koja vraca pretrazene studente, poziva metodu koja vraca listu studenata koji odgovaraju rezultatima pretrage
	 * @param trazeno String reci koja se trazi
	 * @return Lista objekata tipa Student koji odgovaraju onome sto se trazi
	 */
	public static LinkedList<Student> vratiPretrazeneStudente(String trazeno) {
		return grupa.vratiPretrazeneStudente(trazeno);
	}

	/**
	 * Metoda brise red koji joj je prosledjen, nakon cega osvezava tabelu 
	 * i cuva izmene tako sto novu izmenjenu listu upisuje u fajl
	 * @param red Red ili redni broj u tabelu koji zelimo da obrisemo
	 */
	public static void obrisiRed(int red) {
		// TODO Auto-generated method stub
		vratiSveStudente().remove(red);
		prikaz.osveziTabelu();
		grupa.upisiUFajlSerijalizacijom();
		

	}
	/**
	 * Metoda koja poziva metodu iz klase PrikazStudenataGUI i osvezava tabelu
	 */
	public static void osveziTabeluIzmena(){
		prikaz.osveziTabelu();
	}
	
}
