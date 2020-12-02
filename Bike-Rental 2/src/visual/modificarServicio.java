package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import logica.Bike_Rental;
import logica.Cliente;
import logica.Servicio;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class modificarServicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfTipo;
	private JTextField tfPrecio;
	private static DefaultTableModel model;
	private static Object[] fila; 
	private static JButton btnModificar;
	private JButton btnCancelar;
	private JTextField tfSSN;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertServicio frame = new insertServicio();
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
	public modificarServicio(Servicio serv, String id) {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					tfSSN.setText(serv.getSsn());
					tfTipo.setText(serv.getTipo());
					tfPrecio.setText(Float.toString(serv.getPrecioServ()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 202, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelInsercion = new JPanel();
		panelInsercion.setBackground(SystemColor.inactiveCaptionBorder);
		panelInsercion.setBorder(new TitledBorder(null, "Servicio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInsercion.setBounds(8, 10, 180, 342);
		contentPane.add(panelInsercion);
		
		JLabel lblSsn = new JLabel("SSN (Empleado)");
		lblSsn.setBounds(14, 25, 119, 15);
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(14, 85, 100, 15);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Precio");
		lblNewLabel.setBounds(14, 155, 100, 15);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfTipo = new JTextField();
		tfTipo.setBounds(14, 110, 152, 19);
		tfTipo.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(14, 188, 152, 19);
		tfPrecio.setColumns(10);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(14, 274, 152, 21);
		btnModificar.setEnabled(true);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String ssn = tfSSN.getText();
					String tipo = tfTipo.getText();
					float precio = Float.parseFloat(tfPrecio.getText());
					Servicio nuevo = new Servicio(precio, tipo, ssn);
					try {
						updateServicio(id);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		});
		btnModificar.setBackground(SystemColor.inactiveCaption);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(14, 301, 152, 21);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		tfSSN = new JTextField();
		tfSSN.setBounds(14, 46, 152, 19);
		tfSSN.setEditable(false);
		tfSSN.setColumns(10);
		panelInsercion.setLayout(null);
		panelInsercion.add(lblTipo);
		panelInsercion.add(lblNewLabel);
		panelInsercion.add(btnCancelar);
		panelInsercion.add(tfPrecio);
		panelInsercion.add(btnModificar);
		panelInsercion.add(lblSsn);
		panelInsercion.add(tfSSN);
		panelInsercion.add(tfTipo);
		model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "SSN", "Tipo", "Precio"
			}
		);
	}
	public void updateServicio(String id) throws Exception {
		String sql = "update Servicio set tipo = ?, precio = ?" 
					 + " where ssn = ? and idServicio = ?";
			
		try {
			PreparedStatement stmt = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
			stmt.setString(1, tfTipo.getText());
			stmt.setFloat(2, Float.parseFloat(tfPrecio.getText()));
			stmt.setString(3, tfSSN.getText());
			stmt.setString(4, id);
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
}
