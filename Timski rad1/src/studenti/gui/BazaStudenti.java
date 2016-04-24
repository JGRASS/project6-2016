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
import java.awt.Color;
import java.awt.Font;

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
		mntmIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmIzadji.setIcon(new ImageIcon(BazaStudenti.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmIzadji);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDodajStudenta = new JButton("Dodaj studenta");
		btnDodajStudenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnDodajStudenta.setBackground(new Color(204, 255, 153));
		btnDodajStudenta.setIcon(new ImageIcon(BazaStudenti.class.getResource("/slike/add.png")));
		btnDodajStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.otvoriProzorZaDodavanjeStudenata();
			}
		});
		btnDodajStudenta.setBounds(10, 11, 188, 87);
		panel.add(btnDodajStudenta);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnIzmeni.setBackground(new Color(204, 255, 153));
		btnIzmeni.setIcon(new ImageIcon(BazaStudenti.class.getResource("/slike/group_edit.png")));
		btnIzmeni.setBounds(236, 11, 178, 87);
		panel.add(btnIzmeni);
		
		JButton btnPretraziStudenta = new JButton("Pretrazi studenta");
		btnPretraziStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.otvoriProzorZaPretragu();
				
			}
		});
		btnPretraziStudenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnPretraziStudenta.setBackground(new Color(204, 255, 153));
		btnPretraziStudenta.setIcon(new ImageIcon(BazaStudenti.class.getResource("/slike/search.png")));
		btnPretraziStudenta.setPreferredSize(new Dimension(120, 30));
		btnPretraziStudenta.setMinimumSize(new Dimension(120, 30));
		btnPretraziStudenta.setMaximumSize(new Dimension(120, 30));
		btnPretraziStudenta.setBounds(10, 132, 188, 87);
		panel.add(btnPretraziStudenta);
		
		JButton btnPrikaziStudente = new JButton("Prikazi studente");
		btnPrikaziStudente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnPrikaziStudente.setBackground(new Color(204, 255, 153));
		btnPrikaziStudente.setIcon(new ImageIcon(BazaStudenti.class.getResource("/slike/Show.png")));
		btnPrikaziStudente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.otvoriProzorZaPrikazStudenata();
				
			}
		});
		btnPrikaziStudente.setBounds(236, 132, 178, 87);
		panel.add(btnPrikaziStudente);
	
	
	}
	

	

	
}
