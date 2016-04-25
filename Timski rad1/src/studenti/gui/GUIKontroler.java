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

public class GUIKontroler {

	private static BazaStudenti baza;
	private static GrupaStudenti grupa;
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

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(null, "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		
		}
	}
	
	public static LinkedList<Student> vratiSveStudente() {
		return grupa.vratiSveStudente();
	}
	
	public static void otvoriProzorZaDodavanjeStudenata(){
		DodajStudentaGUI prozor = new DodajStudentaGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
		
	}
	
	public static void otvoriProzorZaPrikazStudenata(){
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.setTitle("Prikaz studenata");
	}	
	public static void otvoriProzorZaPretragu(){
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.vidljivaPretraga();
		prikaz.setTitle("Pretraga studenata");
	}
	
	public static void otvoriProzorZaIzmenu() {
		// TODO Auto-generated method stub
		PrikazStudenataGUI prikaz = new PrikazStudenataGUI();
		prikaz.setVisible(true);
		prikaz.setLocationRelativeTo(null);
		prikaz.osveziTabelu();
		prikaz.vidljivaIzmena();
		prikaz.setTitle("Izmena studenata");
		
	}
	
	public static void unesiStudenta(String imeIPrezime,String dodatneAktivnosti,String brojIndeksa, double prosek){
		try{
			Student s = new Student(imeIPrezime, dodatneAktivnosti, brojIndeksa, prosek);
			grupa.unesiStudenta(s);
			prikaz.osveziTabelu();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(baza.getContentPane(), "Proveri formu "+ e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static void sacuvajUFajl(){
		try {
			grupa.upisiUFajlSerijalizacijom();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void ucitajIzFajla(){
		try {
			grupa.ucitajIzFajlaDeserijalizacijom();
			prikaz.osveziTabelu();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static LinkedList<Student> vratiPretrazeneStudente(String trazeno) {
		return grupa.vratiPretrazeneStudente(trazeno);
	}

	
	public static void obrisiRed(int red) {
		// TODO Auto-generated method stub
		vratiSveStudente().remove(red);
		prikaz.osveziTabelu();
		grupa.upisiUFajlSerijalizacijom();
		

	}

	
}
