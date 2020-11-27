package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logica.Bike_Rental;
import logica.Empleado;


import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.WindowStateListener;

public class ModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField tfSSN;
	private JTextField tfNombre;
	private JTextField tfCiudad;
	private JTextField tfCalle;
	private JTextField tfPosicion;
	private JTextField tfSalario;
	private JTextField tfApellido;
	private JTextField tfSname;
	private static DefaultTableModel model;
	private static Object[] fila; 
	private JFormattedTextField TelefonoJF;
	private JFormattedTextField cedulaJF;
	private JFormattedTextField CodPostJF;
	private boolean confirmar = false;
//	private JComboBox cbxProvincia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablaEmpleados frame = new tablaEmpleados();
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
	public ModificarEmpleado(Empleado emp) {
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfSSN.setText(emp.getSsn());
				TelefonoJF.setText(emp.getTel());
				cedulaJF.setText(emp.getCedula());
				CodPostJF.setText(emp.getPostalCode());
				tfNombre.setText(emp.getFname());
				tfSname.setText(emp.getSname());
				tfApellido.setText(emp.getLname());
				tfCalle.setText(emp.getCalle());
				tfCiudad.setText(emp.getCiudad());
				tfPosicion.setText(emp.getPosicion());
				//cbxProvincia.setSelectedItem(emp.getProvincia());
				tfSalario.setText(Float.toString(emp.getSalario()));
				confirmar = true;
			}
			@Override
			public void windowClosed(WindowEvent e) {
				confirmar = true;
			}
		});
		setTitle("Modificar Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 273);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblSSN = new JLabel("SSN");
		lblSSN.setBounds(16, 16, 42, 14);
		
		tfSSN = new JTextField();
		tfSSN.setBounds(16, 36, 111, 20);
		tfSSN.setColumns(10);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(16, 68, 42, 14);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(145, 36, 116, 20);
		tfNombre.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(145, 16, 63, 14);
		
		tfSname = new JTextField();
		tfSname.setBounds(279, 36, 116, 20);
		tfSname.setColumns(10);
		
		JLabel lblSname = new JLabel("Seguno Nombre");
		lblSname.setBounds(279, 16, 104, 14);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(413, 36, 116, 20);
		tfApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(413, 16, 84, 14);
		
		tfSalario = new JTextField();
		tfSalario.setBounds(279, 94, 116, 20);
		tfSalario.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(789, 68, 42, 14);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(789, 16, 42, 14);
		
		JLabel lblPostal = new JLabel("C\u00F3digo Postal");
		lblPostal.setBounds(603, 74, 111, 14);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(789, 94, 111, 20);
		tfCiudad.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(789, 36, 111, 20);
		tfCalle.setColumns(10);
		
		tfPosicion = new JTextField();
		tfPosicion.setBounds(145, 94, 116, 20);
		tfPosicion.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(279, 68, 42, 14);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(413, 68, 58, 14);
		
		JLabel lblPosicion = new JLabel("Posici\u00F3n");
		lblPosicion.setBounds(145, 69, 58, 14);
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(603, 36, 123, 20);
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ", "Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ", "Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ", "Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ", "S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ", "San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ", "Valverde "}));
		cbxProvincia.setSelectedItem(emp.getProvincia());
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(603, 16, 68, 14);
		lblProvincia.setHorizontalAlignment(SwingConstants.LEFT);
		MaskFormatter mascaraCedula;
		
		try {
			mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
		   
			cedulaJF = new JFormattedTextField(mascaraCedula);
			cedulaJF.setBounds(16, 94, 111, 20);
			cedulaJF.setEditable(false);
		
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		MaskFormatter mascaraCodigo;
		try {
			mascaraCodigo = new MaskFormatter("#####");
		
			CodPostJF = new JFormattedTextField(mascaraCodigo);
			CodPostJF.setBounds(603, 94, 111, 20);
			CodPostJF.setBackground(Color.WHITE);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		MaskFormatter mascaratel;
		try {
			mascaratel = new MaskFormatter("###-###-####");
			
			TelefonoJF = new JFormattedTextField(mascaratel);
			TelefonoJF.setBounds(413, 94, 111, 20);
			TelefonoJF.setBackground(Color.WHITE);
			TelefonoJF.setColumns(10);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//model = new DefaultTableModel();

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);
		panel.add(cedulaJF);
		panel.add(tfPosicion);
		panel.add(tfSSN);
		panel.add(lblCedula);
		panel.add(lblSSN);
		panel.add(lblName);
		panel.add(tfNombre);
		panel.add(lblPosicion);
		panel.add(tfSname);
		panel.add(lblSname);
		panel.add(tfSalario);
		panel.add(lblSalario);
		panel.add(lblTelefono);
		panel.add(TelefonoJF);
		panel.add(lblApellido);
		panel.add(tfApellido);
		panel.add(CodPostJF);
		panel.add(lblProvincia);
		panel.add(cbxProvincia);
		panel.add(lblCalle);
		panel.add(tfCiudad);
		panel.add(lblCiudad);
		panel.add(tfCalle);
		panel.add(lblPostal);
		panel_1.setLayout(null);
		
		JButton btnCerrar = new JButton("CANCELAR");
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBounds(876, 11, 96, 34);
		panel_1.add(btnCerrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Empleado auxEmp = new Empleado(cedulaJF.getText(), tfNombre.getText(), tfSname.getText(), tfApellido.getText(), tfCalle.getText(),
							tfCiudad.getText(), TelefonoJF.getText(), CodPostJF.getText(), tfSSN.getText(), tfPosicion.getText(), Float.parseFloat(tfSalario.getText()),
							cbxProvincia.getSelectedItem().toString());
					Bike_Rental.getInstance().updateEmpleado(auxEmp);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setBounds(772, 11, 96, 34);
		panel_1.add(btnModificar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 980, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public boolean confirmacion() {
		return confirmar;
	}
}
