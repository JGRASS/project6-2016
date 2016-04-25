package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import studenti.GrupaStudenti;
import studenti.Student;
import studenti.gui.models.StudentTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class PrikazStudenataGUI extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tfpretraga;
	private JLabel lblPretraga;
	private JLabel lblhelp;
	private JPanel panel_1;
	private JButton btnIzmeni;
	private JButton btnObrisi;

	/**
	 * Create the frame.
	 */
	public PrikazStudenataGUI() {
		setTitle("Prikaz studenata");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(255, 255, 204));
		scrollPane.setBounds(0, 0, 424, 197);
		panel.add(scrollPane);
		
		table = getTable();
		
		scrollPane.setViewportView(table);
		
		lblPretraga = new JLabel("Pretraga:");
		lblPretraga.setVisible(false);
		lblPretraga.setBounds(106, 208, 57, 14);
		panel.add(lblPretraga);
		
		tfpretraga = new JTextField();
		tfpretraga.setBackground(new Color(245, 245, 220));
		tfpretraga.setVisible(false);
		tfpretraga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				osveziPretrazenuTabelu();
			}
		});
		tfpretraga.setBounds(173, 205, 108, 20);
		panel.add(tfpretraga);
		tfpretraga.setColumns(10);
		
		lblhelp = new JLabel("(uneti ime i prezime ili broj indeksa)");
		lblhelp.setVisible(false);
		lblhelp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblhelp.setBounds(161, 226, 146, 14);
		panel.add(lblhelp);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 80));
		panel_1.setVisible(false);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzmeniGUI prozor = new IzmeniGUI();
				prozor.setVisible(true);
				int red = table.getSelectedRow();
				Student s = GUIKontroler.vratiSveStudente().get(red);
				prozor.podesiPolja(s, red);
			}
		});
		btnIzmeni.setIcon(new ImageIcon(PrikazStudenataGUI.class.getResource("/slike/group_edit.png")));
		btnIzmeni.setVisible(false);
		btnIzmeni.setPreferredSize(new Dimension(120, 40));
		panel_1.add(btnIzmeni);
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int red = table.getSelectedRow();
				GUIKontroler.obrisiRed(red);
			}
		});
		btnObrisi.setIcon(new ImageIcon(PrikazStudenataGUI.class.getResource("/slike/clear.png")));
		btnObrisi.setVisible(false);
		btnObrisi.setPreferredSize(new Dimension(120, 40));
		panel_1.add(btnObrisi);
	}
	
	public void osveziTabelu(){
		StudentTableModel model = (StudentTableModel) table.getModel();
		model.ucitajStudente(GUIKontroler.vratiSveStudente());
	}
	
	public void osveziPretrazenuTabelu(){
		StudentTableModel model = (StudentTableModel) table.getModel();
		model.ucitajStudente(GUIKontroler.vratiPretrazeneStudente(tfpretraga.getText()));
		
	}
	
	public JTable getTable() {
		if(table == null ){
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			table.setBackground(new Color(255, 255, 255));
			StudentTableModel model = new StudentTableModel(null);
			table.setModel(model);
		}
		return table;
	}

	public void vidljivaPretraga() {
		tfpretraga.setVisible(true);
		lblPretraga.setVisible(true);
		lblhelp.setVisible(true);
		
	}

	public void vidljivaIzmena() {
		// TODO Auto-generated method stub
		panel_1.setVisible(true);
		btnIzmeni.setVisible(true);
		btnObrisi.setVisible(true);
		
	}
}
