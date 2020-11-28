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
import javax.swing.border.LineBorder;

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
					frame.setUndecorated(true);
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
		setBounds(100, 100, 1004, 246);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 980, 157);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblSSN = new JLabel("SSN");
		lblSSN.setBounds(18, 29, 42, 14);
		
		tfSSN = new JTextField();
		tfSSN.setBounds(18, 49, 111, 20);
		tfSSN.setColumns(10);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(18, 81, 42, 14);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(147, 49, 116, 20);
		tfNombre.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(147, 29, 63, 14);
		
		tfSname = new JTextField();
		tfSname.setBounds(281, 49, 116, 20);
		tfSname.setColumns(10);
		
		JLabel lblSname = new JLabel("Seguno Nombre");
		lblSname.setBounds(281, 29, 104, 14);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(415, 49, 116, 20);
		tfApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(415, 29, 84, 14);
		
		tfSalario = new JTextField();
		tfSalario.setBounds(281, 107, 116, 20);
		tfSalario.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(830, 81, 42, 14);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(830, 29, 42, 14);
		
		JLabel lblPostal = new JLabel("C\u00F3digo Postal");
		lblPostal.setBounds(644, 87, 111, 14);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(830, 107, 111, 20);
		tfCiudad.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(830, 49, 111, 20);
		tfCalle.setColumns(10);
		
		tfPosicion = new JTextField();
		tfPosicion.setBounds(147, 107, 116, 20);
		tfPosicion.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(281, 81, 42, 14);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(415, 81, 58, 14);
		
		JLabel lblPosicion = new JLabel("Posici\u00F3n");
		lblPosicion.setBounds(147, 82, 58, 14);
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(644, 49, 123, 20);
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ", "Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ", "Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ", "Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ", "S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ", "San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ", "Valverde "}));
		cbxProvincia.setSelectedItem(emp.getProvincia());
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(644, 29, 68, 14);
		lblProvincia.setHorizontalAlignment(SwingConstants.LEFT);
		MaskFormatter mascaraCedula;
		
		try {
			mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
		   
			cedulaJF = new JFormattedTextField(mascaraCedula);
			cedulaJF.setBounds(18, 107, 111, 20);
			cedulaJF.setEditable(false);
		
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		MaskFormatter mascaraCodigo;
		try {
			mascaraCodigo = new MaskFormatter("#####");
		
			CodPostJF = new JFormattedTextField(mascaraCodigo);
			CodPostJF.setBounds(644, 107, 111, 20);
			CodPostJF.setBackground(Color.WHITE);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		MaskFormatter mascaratel;
		try {
			mascaratel = new MaskFormatter("###-###-####");
			
			TelefonoJF = new JFormattedTextField(mascaratel);
			TelefonoJF.setBounds(415, 107, 111, 20);
			TelefonoJF.setBackground(Color.WHITE);
			TelefonoJF.setColumns(10);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//model = new DefaultTableModel();

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 168, 980, 48);
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
		btnCerrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBounds(854, 7, 118, 34);
		panel_1.add(btnCerrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(SystemColor.inactiveCaptionBorder);
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
		btnModificar.setBounds(738, 7, 108, 34);
		panel_1.add(btnModificar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(629, 10, 343, 137);
		panel.add(panel_2);
		contentPane.setLayout(null);
		contentPane.add(panel_1);
		contentPane.add(panel);
	}
	public boolean confirmacion() {
		return confirmar;
	}
}
