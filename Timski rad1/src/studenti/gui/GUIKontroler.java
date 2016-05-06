package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import studenti.GrupaStudenti;
import studenti.Student;
import studenti.gui.models.StudentTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
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
	private static AdministratorGUI baza;
	/**
	 * Klasa GrupaStudenti
	 */
	private static GrupaStudenti grupa;
	/**
	 * Klasa koja se odnosi na prozor za prikaz
	 */
	private static PrikazStudenataGUI prikaz;
	private static GlavniProzorGUI glavniProzor;
	private JPanel contentPane;
	private static int brojPokusaja = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grupa = new GrupaStudenti();
					prikaz = new PrikazStudenataGUI();
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
					
					
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
		osveziTabelu(prikaz.getTable());
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
		osveziTabelu(prikaz.getTable());
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
		osveziTabelu(prikaz.getTable());
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
			osveziTabelu(prikaz.getTable());
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
	
	public static void dodajStudenta(JTextField jtfBrIndeksa, JTextField jtfImeIPrezime, JTextField jtfProsek, JTextPane textPane){
		String brIndeksa = jtfBrIndeksa.getText();
		String imePrezime = jtfImeIPrezime.getText();
		String dodatneAktivnosti = textPane.getText();
		double prosek = 0;
		if(brIndeksa.isEmpty() || imePrezime.isEmpty()){
			JOptionPane.showMessageDialog(null, "Niste uneli sva obavezna polja", "Greska", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try{
			prosek = Double.parseDouble(jtfProsek.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Greska pri unosu proseka", "Greska", JOptionPane.WARNING_MESSAGE);
			return;
		}
		LinkedList<Student> lista = GUIKontroler.vratiSveStudente();
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getBrojIndeksa().equals(brIndeksa)){
				JOptionPane.showMessageDialog(null, "Student sa brojem indeksa "+brIndeksa+" vec postoji!!!", "Greska", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		GUIKontroler.unesiStudenta(imePrezime, dodatneAktivnosti, brIndeksa, prosek);
		GUIKontroler.sacuvajUFajl();
	}
	/**
	 * Metoda koja ucitava podatke iz fajla i osvezva tabelu nakon toga
	 */
	public static void ucitajIzFajla(){
		try {
			grupa.ucitajIzFajlaDeserijalizacijom();
			osveziTabelu(prikaz.getTable());
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
		osveziTabelu(prikaz.getTable());
		grupa.upisiUFajlSerijalizacijom();
		

	}
	/**
	 * Metoda koja poziva metodu iz klase PrikazStudenataGUI i osvezava tabelu
	 */
	public static void osveziTabeluIzmena(){
		osveziTabelu(prikaz.getTable());
	}
	
	
	public static void proveriImeISifru(JTextField textField, JPasswordField passwordField, JButton btnVreme, JButton btnPotvrdi, ActionListener taskPerformer) {
		if(textField.getText().equals("admin") && passwordField.getText().equals("admin")){
			AdministratorGUI b = new AdministratorGUI();
			b.setVisible(true);
			b.setLocationRelativeTo(null);
			glavniProzor.setVisible(false);
		}else{
			JOptionPane.showMessageDialog(null, "Pogresan unos", "Greska", JOptionPane.ERROR_MESSAGE);
			brojPokusaja++;
		}
		if(brojPokusaja==3){
			brojPokusaja=0;
			textField.setEnabled(false);
			passwordField.setEnabled(false);
			btnPotvrdi.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Previse netacnih pokusaja. Probajte ponovo za 10 sekundi.");
			btnVreme.setVisible(true);
			Timer t = new Timer(1000, taskPerformer);
			t.start();
		}
		
	}
	public static void logOut() {
		// TODO Auto-generated method stub
		AdministratorGUI baza = new AdministratorGUI();
		baza.setVisible(false);
		GlavniProzorGUI glavniProzor = new GlavniProzorGUI();
		glavniProzor = new GlavniProzorGUI();
		glavniProzor.setVisible(true);
		glavniProzor.setLocationRelativeTo(null);
	}
	
	/**
	 * Metoda osvezava tabelu, ucitava sve studente
	 */
	public static void osveziTabelu(JTable table){
		StudentTableModel model = (StudentTableModel) table.getModel();
		model.ucitajStudente(GUIKontroler.vratiSveStudente());
	}
	/**
	 * Metoda osvezava pretrazenu tabelu, tako sto ucitava sve studente koji odgovaraju trazenom opisu
	 */
	public static void osveziPretrazenuTabelu(JTable table, JTextField tfpretraga){
		StudentTableModel model = (StudentTableModel) table.getModel();
		model.ucitajStudente(GUIKontroler.vratiPretrazeneStudente(tfpretraga.getText()));
		
	}
	
	/**
	 * Klikom na dugme izmeni na formi za prikazivanje studenata
	 * otvara se prozor za izmenu, preuzima se selektovani red i poziva se metoda kojom se popounjavaju polja u novoj formi 
	 * sa izabranim studentom 
	 */
	public static void podesavanjaZaIzmenu(JTable table){
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(false);
		IzmeniGUI prozor = new IzmeniGUI();
		prozor.setVisible(true);
		int red = table.getSelectedRow();
		Student s = GUIKontroler.vratiSveStudente().get(red);
		prozor.podesiPolja(s, red);
	}
	
}
