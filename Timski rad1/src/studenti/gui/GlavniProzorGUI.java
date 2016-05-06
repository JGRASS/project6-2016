package studenti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

	public class GlavniProzorGUI extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblusername;
	private JLabel lblPassword;
	private JTextField textField;
	private JButton btnPotvrdi;
	private JButton btnPretraziStudente;
	private JLabel lblDaBisteUnosili;
	private JLabel label;
	private JPasswordField passwordField;
	int ukupnoVreme = 9;

	/**
	 * Create the frame.
	 */
	public GlavniProzorGUI() {
		setTitle("BAZA STUDENATA");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getLblusername());
			panel.add(getLblPassword());
			panel.add(getTextField());
			panel.add(getBtnPotvrdi());
			panel.add(getBtnPretraziStudente());
			panel.add(getLblDaBisteUnosili());
			panel.add(getLabel());
			panel.add(getPasswordField());
			panel.add(getBtnVreme());
			
			JLabel lblUdjiKaoGost = new JLabel("Nastavi kao gost:");
			lblUdjiKaoGost.setForeground(new Color(102, 153, 51));
			lblUdjiKaoGost.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblUdjiKaoGost.setBounds(77, 127, 308, 25);
			panel.add(lblUdjiKaoGost);
		}
		return panel;
	}
	private JLabel getLblusername() {
		if (lblusername == null) {
			lblusername = new JLabel("Username:");
			lblusername.setIcon(new ImageIcon(GlavniProzorGUI.class.getResource("/slike/login.png")));
			lblusername.setBounds(72, 45, 89, 14);
		}
		return lblusername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setIcon(new ImageIcon(GlavniProzorGUI.class.getResource("/slike/stock_lock-open.png")));
			lblPassword.setBounds(72, 77, 89, 14);
		}
		return lblPassword;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(159, 42, 130, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.setIcon(new ImageIcon(GlavniProzorGUI.class.getResource("/slike/accept.png")));
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.proveriImeISifru(textField, passwordField, btnVreme, btnPotvrdi, taskPerformer);
					
				}
			});
			btnPotvrdi.setBounds(307, 56, 107, 25);
		}
		return btnPotvrdi;
	}
	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if(ukupnoVreme == -1) {
				btnVreme.setVisible(false);
				btnPotvrdi.setEnabled(true);
				textField.setEnabled(true);
				passwordField.setEnabled(true);
			}
			if (ukupnoVreme >= 0) {
				btnVreme.setText(ukupnoVreme + "");
				ukupnoVreme--;
			}
			
		}
	};
	private JButton btnVreme;


		private JButton getBtnPretraziStudente() {
			if (btnPretraziStudente == null) {
				btnPretraziStudente = new JButton("Pretrazi studente");
				btnPretraziStudente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						GUIKontroler.ucitajIzFajla();
						GUIKontroler.otvoriProzorZaPretragu();
					}
				});
				btnPretraziStudente.setIcon(new ImageIcon(GlavniProzorGUI.class.getResource("/slike/search.png")));
				btnPretraziStudente.setPreferredSize(new Dimension(120, 30));
				btnPretraziStudente.setMinimumSize(new Dimension(120, 30));
				btnPretraziStudente.setMaximumSize(new Dimension(120, 30));
				btnPretraziStudente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				btnPretraziStudente.setBackground(new Color(204, 255, 102));
				btnPretraziStudente.setBounds(10, 153, 404, 87);
			}
			return btnPretraziStudente;
		}
		private JLabel getLblDaBisteUnosili() {
			if (lblDaBisteUnosili == null) {
				lblDaBisteUnosili = new JLabel("Za administratore:");
				lblDaBisteUnosili.setForeground(new Color(102, 153, 51));
				lblDaBisteUnosili.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblDaBisteUnosili.setBounds(77, 11, 308, 14);
			}
			return lblDaBisteUnosili;
		}
		private JLabel getLabel() {
			if (label == null) {
				label = new JLabel(" ");
				label.setMinimumSize(new Dimension(64, 64));
				label.setMaximumSize(new Dimension(64, 64));
				label.setPreferredSize(new Dimension(64, 64));
				label.setIcon(new ImageIcon(GlavniProzorGUI.class.getResource("/slike/user_1.png")));
				label.setBounds(10, 36, 64, 64);
			}
			return label;
		}
		private JPasswordField getPasswordField() {
			if (passwordField == null) {
				passwordField = new JPasswordField();
				passwordField.setBounds(159, 74, 130, 20);
			}
			return passwordField;
		}
		private JButton getBtnVreme() {
			if (btnVreme == null) {
				btnVreme = new JButton("10");
				btnVreme.setVisible(false);
				btnVreme.setBounds(191, 105, 58, 23);
			}
			return btnVreme;
		}
}
