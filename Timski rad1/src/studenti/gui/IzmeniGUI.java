package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import studenti.Student;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Klasa koja predstavlja prozor za izmenu odredjenog studenta
 * @author Andjela
 *
 */
public class IzmeniGUI extends JFrame {

	private JPanel contentPane;
	private  JTextField jtfImePrezime;
	private  JTextField jtfProsek;
	private  JTextField jtfBrIndeksa;
	private  JTextPane tPDodatne;
	private JTextField jtfIndeks;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzmeniGUI() {
		setTitle("Izmena podataka");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.otvoriProzorZaIzmenu();
			}
		});
		setMinimumSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Podaci o studentu: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(10, 11, 272, 329);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Ime i prezime:* ");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label.setBounds(10, 32, 91, 14);
		panel_1.add(label);
		
		jtfImePrezime = new JTextField();
		jtfImePrezime.setColumns(10);
		jtfImePrezime.setBackground(Color.WHITE);
		jtfImePrezime.setBounds(106, 29, 149, 20);
		panel_1.add(jtfImePrezime);
		
		JLabel label_1 = new JLabel("Prosek:*");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_1.setBounds(10, 121, 86, 14);
		panel_1.add(label_1);
		
		jtfProsek = new JTextField();
		jtfProsek.setColumns(10);
		jtfProsek.setBackground(Color.WHITE);
		jtfProsek.setBounds(106, 118, 149, 20);
		panel_1.add(jtfProsek);
		
		JLabel label_2 = new JLabel("Broj indeksa:*");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_2.setBounds(10, 78, 86, 14);
		panel_1.add(label_2);
		
		jtfBrIndeksa = new JTextField();
		jtfBrIndeksa.setEditable(false);
		jtfBrIndeksa.setColumns(10);
		jtfBrIndeksa.setBackground(Color.WHITE);
		jtfBrIndeksa.setBounds(106, 75, 149, 20);
		panel_1.add(jtfBrIndeksa);
		
		JLabel label_3 = new JLabel("Dodatne aktivnosti:");
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_3.setBounds(10, 157, 126, 14);
		panel_1.add(label_3);
		
		tPDodatne = new JTextPane();
		tPDodatne.setBackground(Color.WHITE);
		tPDodatne.setBounds(20, 182, 233, 136);
		panel_1.add(tPDodatne);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setIcon(new ImageIcon(IzmeniGUI.class.getResource("/slike/group_edit.png")));
		btnPotvrdi.addActionListener(new ActionListener() {
			/**
			 * Preuzima sve podatke iz odredjenih polja, pravi novi objekat klase student, brise studenta iz liste kog zelimo 
			 * da izmenimo i ubacuje novog studenta na kraj liste
			 */
			public void actionPerformed(ActionEvent e) {
				String imePrezime = jtfImePrezime.getText();
				String brIndeksa = jtfBrIndeksa.getText();
				String dodatneA = tPDodatne.getText();
				double prosek = Double.parseDouble(jtfProsek.getText());
				Student s = new Student(imePrezime, dodatneA, brIndeksa, prosek);
				int indeks = Integer.parseInt(jtfIndeks.getText());
				GUIKontroler.obrisiRed(indeks);
				GUIKontroler.unesiStudenta(imePrezime, dodatneA, brIndeksa, prosek);
				
				GUIKontroler.sacuvajUFajl();
				dispose();
				GUIKontroler.otvoriProzorZaIzmenu();
				
			}
		});
		btnPotvrdi.setBounds(306, 77, 108, 56);
		panel.add(btnPotvrdi);
		
		jtfIndeks = new JTextField();
		jtfIndeks.setVisible(false);
		jtfIndeks.setBounds(292, 22, 86, 20);
		panel.add(jtfIndeks);
		jtfIndeks.setColumns(10);
	}
	/**
	 * Metoda podesava polja sa podacima studenta koga smo izabrali kako bi mogli da neka polja samo modifikujemo
	 * bez potrebe da upisujemo novi tekst
	 * @param s Objekat klase student kog zelimo da izmenimo
	 * @param indeks Redni broj pod kojim se nalazi u tabeli
	 */
	public void podesiPolja(Student s, int indeks){
		jtfImePrezime.setText(s.getImeIPrezime());
		jtfBrIndeksa.setText(s.getBrojIndeksa());
		jtfProsek.setText(s.getProsek()+"");
		tPDodatne.setText(s.getDodatneAktivnosti());
		jtfIndeks.setText(indeks+"");
	}
	
}
