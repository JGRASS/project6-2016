package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Podaci o studentu: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 288, 299);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ime i prezime:");
		lblNewLabel.setBounds(10, 32, 86, 14);
		panel_1.add(lblNewLabel);
		
		jtfImeIPrezime = new JTextField();
		jtfImeIPrezime.setBounds(106, 29, 86, 20);
		panel_1.add(jtfImeIPrezime);
		jtfImeIPrezime.setColumns(10);
		
		JLabel lblProsek = new JLabel("Prosek");
		lblProsek.setBounds(10, 121, 86, 14);
		panel_1.add(lblProsek);
		
		jtfProsek = new JTextField();
		jtfProsek.setColumns(10);
		jtfProsek.setBounds(106, 118, 86, 20);
		panel_1.add(jtfProsek);
		
		JLabel lblBrojIndeksa = new JLabel("Broj indeksa:");
		lblBrojIndeksa.setBounds(10, 78, 86, 14);
		panel_1.add(lblBrojIndeksa);
		
		jtfBrIndeksa = new JTextField();
		jtfBrIndeksa.setColumns(10);
		jtfBrIndeksa.setBounds(106, 75, 86, 20);
		panel_1.add(jtfBrIndeksa);
		
		JLabel lblDodatneAktivnosti = new JLabel("Dodatne aktivnosti:");
		lblDodatneAktivnosti.setBounds(10, 157, 103, 14);
		panel_1.add(lblDodatneAktivnosti);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 182, 233, 106);
		panel_1.add(textPane);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String brIndeksa = jtfBrIndeksa.getText();
				String imePrezime = jtfImeIPrezime.getText();
				String dodatneAktivnosti = textPane.getText();
				Double prosek = Double.parseDouble(jtfProsek.getText());
				GUIKontroler.unesiStudenta(imePrezime, dodatneAktivnosti, brIndeksa, prosek);
			
				GUIKontroler.sacuvajUFajl();
				dispose();
				
			}
		});
		btnDodaj.setBounds(308, 23, 89, 23);
		panel.add(btnDodaj);
		
		JButton btnPonisti = new JButton("Ponisti");
		btnPonisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtfBrIndeksa.setText(null);
				jtfImeIPrezime.setText(null);
				jtfProsek.setText(null);
				textPane.setText(null);
			}
		});
		btnPonisti.setBounds(308, 74, 89, 23);
		panel.add(btnPonisti);
	}
}
