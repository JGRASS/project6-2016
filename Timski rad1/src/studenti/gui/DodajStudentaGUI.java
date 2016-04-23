package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import studenti.GrupaStudenti;
import studenti.Student;

import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DodajStudentaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField jtfImeIPrezime;
	private JTextField jtfProsek;
	private JTextField jtfBrIndeksa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajStudentaGUI frame = new DodajStudentaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DodajStudentaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		setMinimumSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(400, 400));
		setTitle("Dodaj studenta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Podaci o studentu: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 272, 329);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime i prezime:* ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 32, 91, 14);
		panel_1.add(lblNewLabel);
		
		jtfImeIPrezime = new JTextField();
		jtfImeIPrezime.setBackground(Color.WHITE);
		jtfImeIPrezime.setBounds(106, 29, 149, 20);
		panel_1.add(jtfImeIPrezime);
		jtfImeIPrezime.setColumns(10);
		
		JLabel lblProsek = new JLabel("Prosek:*");
		lblProsek.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblProsek.setBounds(10, 121, 86, 14);
		panel_1.add(lblProsek);
		
		jtfProsek = new JTextField();
		jtfProsek.setBackground(Color.WHITE);
		jtfProsek.setColumns(10);
		jtfProsek.setBounds(106, 118, 149, 20);
		panel_1.add(jtfProsek);
		
		JLabel lblBrojIndeksa = new JLabel("Broj indeksa:*");
		lblBrojIndeksa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblBrojIndeksa.setBounds(10, 78, 86, 14);
		panel_1.add(lblBrojIndeksa);
		
		jtfBrIndeksa = new JTextField();
		jtfBrIndeksa.setBackground(Color.WHITE);
		jtfBrIndeksa.setColumns(10);
		jtfBrIndeksa.setBounds(106, 75, 149, 20);
		panel_1.add(jtfBrIndeksa);
		
		JLabel lblDodatneAktivnosti = new JLabel("Dodatne aktivnosti:");
		lblDodatneAktivnosti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDodatneAktivnosti.setBounds(10, 157, 126, 14);
		panel_1.add(lblDodatneAktivnosti);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(20, 182, 233, 136);
		panel_1.add(textPane);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setIcon(new ImageIcon(DodajStudentaGUI.class.getResource("/slike/add.png")));
		btnDodaj.setBackground(new Color(255, 255, 224));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String brIndeksa = jtfBrIndeksa.getText();
				String imePrezime = jtfImeIPrezime.getText();
				String dodatneAktivnosti = textPane.getText();
				double prosek = 0;
				if(brIndeksa.isEmpty() || imePrezime.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Niste uneli sva obavezna polja", "Greska", JOptionPane.WARNING_MESSAGE);
					return;
				}
				try{
					prosek = Double.parseDouble(jtfProsek.getText());
				}catch(Exception e){
					JOptionPane.showMessageDialog(contentPane, "Greska pri unosu proseka", "Greska", JOptionPane.WARNING_MESSAGE);
					return;
				}
				LinkedList<Student> lista = GUIKontroler.vratiSveStudente();
				for (int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getBrojIndeksa().equals(brIndeksa)){
						JOptionPane.showMessageDialog(contentPane, "Student sa brojem indeksa "+brIndeksa+" vec postoji!!!", "Greska", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				GUIKontroler.unesiStudenta(imePrezime, dodatneAktivnosti, brIndeksa, prosek);
				GUIKontroler.sacuvajUFajl();
				dispose();
				
			}
		});
		btnDodaj.setBounds(292, 51, 122, 105);
		panel.add(btnDodaj);
		
		JButton btnPonisti = new JButton("O\u010Disti polja");
		btnPonisti.setIcon(new ImageIcon(DodajStudentaGUI.class.getResource("/slike/clear.png")));
		btnPonisti.setBackground(new Color(255, 255, 224));
		btnPonisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfBrIndeksa.setText(null);
				jtfImeIPrezime.setText(null);
				jtfProsek.setText(null);
				textPane.setText(null);
			}
		});
		btnPonisti.setBounds(292, 182, 122, 105);
		panel.add(btnPonisti);
	}
}
