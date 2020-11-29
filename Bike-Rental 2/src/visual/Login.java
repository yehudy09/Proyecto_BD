package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Bike_Rental;
import logica.User;


import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	JLabel lblMin; 
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					Login frame = new Login();
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
	public Login() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icons/icons8-pie-chart-64.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		this.setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 450, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login BIKE-RENTAL");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(21, 11, 273, 29);
		panel.add(lblNewLabel);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblClose.setBounds(418, 11, 22, 29);
		panel.add(lblClose);
		
		lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		lblMin.setForeground(Color.WHITE);
		lblMin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMin.setBounds(386, 11, 10, 29);
		panel.add(lblMin);
		
		JLabel lblNewLabel_3 = new JLabel("STORE MANAGER");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(142, 41, 194, 14);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(44,62,80));
		panel_1.setBounds(0, 65, 450, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setForeground(SystemColor.text);
		lblUser.setBackground(new Color(236,240,241));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(23, 41, 75, 14);
		panel_1.add(lblUser);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPass.setForeground(SystemColor.text);
		lblPass.setBounds(23, 99, 129, 17);
		panel_1.add(lblPass);
		
		txtUser = new JTextField();
		txtUser.setBackground(new Color(108, 122, 137));
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setBounds(132, 37, 224, 22);
		panel_1.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Bike_Rental.getInstance().confirmLogin(txtUser.getText(),passwordField.getText())){
						Principal frame = new Principal();
						dispose();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null,
								"Bienvenido a BIKE-RENTAL, STORE MANAGER", "Información",
								JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						JOptionPane.showMessageDialog(null,
								"Usuario o contraseña incorrectos, inténtelo nuevamente.", "Error",
								JOptionPane.ERROR_MESSAGE, null);
						txtUser.setText("");
						passwordField.setText("");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		btnLogin.setBackground(new Color(34, 167, 240));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(258, 141, 98, 35);
		panel_1.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(108, 122, 137));
		passwordField.setBounds(132, 94, 224, 22);
		panel_1.add(passwordField);
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelButton.setBackground(new Color(255, 69, 0));
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBounds(133, 141, 98, 35);
		panel_1.add(cancelButton);
		
		JLabel lblPass_1 = new JLabel("Crear una nueva cuenta");
		lblPass_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuarios users = new Usuarios(); 
				users.setModal(true);
				users.setVisible(true);
			}
		});
		lblPass_1.setForeground(Color.WHITE);
		lblPass_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass_1.setBounds(165, 195, 175, 17);
		panel_1.add(lblPass_1);
		
	}
}
