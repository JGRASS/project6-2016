package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import studenti.GrupaStudenti;
import studenti.Student;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

public class BazaStudenti extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	public BazaStudenti() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		setTitle("Baza studenti");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmIzadji = new JMenuItem("Izadji");
		mntmIzadji.setIcon(new ImageIcon(BazaStudenti.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmIzadji);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDodajStudenta = new JButton("Dodaj studenta");
		btnDodajStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.otvoriProzorZaDodavanjeStudenata();
			}
		});
		btnDodajStudenta.setBounds(48, 43, 133, 50);
		panel.add(btnDodajStudenta);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setBounds(253, 43, 133, 50);
		panel.add(btnIzmeni);
		
		JButton btnPretraziStudenta = new JButton("Pretrazi studenta");
		btnPretraziStudenta.setPreferredSize(new Dimension(120, 30));
		btnPretraziStudenta.setMinimumSize(new Dimension(120, 30));
		btnPretraziStudenta.setMaximumSize(new Dimension(120, 30));
		btnPretraziStudenta.setBounds(48, 141, 133, 50);
		panel.add(btnPretraziStudenta);
		
		JButton btnPrikaziStudente = new JButton("Prikazi studente");
		btnPrikaziStudente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.otvoriProzorZaPrikazStudenata();
				
			}
		});
		btnPrikaziStudente.setBounds(253, 141, 133, 50);
		panel.add(btnPrikaziStudente);
	
	
	}
	

	

	
}