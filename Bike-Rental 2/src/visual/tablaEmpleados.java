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
import javax.swing.JOptionPane;
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
import java.awt.event.WindowStateListener;

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
import java.awt.Window.Type;
import javax.swing.border.LineBorder;

public class tablaEmpleados extends JFrame {

	private JPanel contentPane;
	private JTable tableEmpleado;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablaEmpleados frame = new tablaEmpleados();
					//frame.setLayout(absolute);
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
	public tablaEmpleados() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
					try {
					cargarEmpleados();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		setTitle("EMPLEADOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 566);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		JScrollPane scrollPaneEmpleado = new JScrollPane();
		scrollPaneEmpleado.setBounds(5, 184, 1066, 321);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1058, 161);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblSSN = new JLabel("SSN");
		lblSSN.setBounds(8, 42, 42, 14);
		
		tfSSN = new JTextField();
		tfSSN.setBounds(8, 66, 111, 20);
		tfSSN.setColumns(10);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(8, 96, 42, 14);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(153, 66, 111, 20);
		tfNombre.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(153, 42, 63, 14);
		
		tfSname = new JTextField();
		tfSname.setBounds(301, 66, 111, 20);
		tfSname.setColumns(10);
		
		JLabel lblSname = new JLabel("Seguno Nombre");
		lblSname.setBounds(308, 42, 104, 14);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(449, 66, 111, 20);
		tfApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(449, 42, 84, 14);
		
		tfSalario = new JTextField();
		tfSalario.setBounds(301, 120, 111, 20);
		tfSalario.setColumns(10);
		
		tfPosicion = new JTextField();
		tfPosicion.setBounds(153, 120, 111, 20);
		tfPosicion.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setBounds(301, 96, 42, 14);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(449, 96, 58, 14);
		
		JLabel lblPosicion = new JLabel("Posici\u00F3n");
		lblPosicion.setBounds(153, 96, 58, 14);
		MaskFormatter mascaraCedula;
		
		try {
			mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
		   
			cedulaJF = new JFormattedTextField(mascaraCedula);
			cedulaJF.setBounds(8, 120, 111, 20);
		
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		MaskFormatter mascaraCodigo = null;
		try {
			mascaraCodigo = new MaskFormatter("#####");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		MaskFormatter mascaratel;
		try {
			mascaratel = new MaskFormatter("###-###-####");
			
			TelefonoJF = new JFormattedTextField(mascaratel);
			TelefonoJF.setBounds(449, 120, 111, 20);
			TelefonoJF.setBackground(Color.WHITE);
			TelefonoJF.setColumns(10);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//model = new DefaultTableModel();
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "SSN", "Cedula", "Nombre", "S. Nombre", "Apellido", "Calle", "Ciudad", "C. Postal", "Telefono", "Posicion", "Salario", "Provincia"
				}
			);	
		tableEmpleado = new JTable();
		tableEmpleado.setModel(model);
	
		/*tableEmpleado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "SSN", "Cedula", "Nombre", "S. Nombre", "Apellido", "Posicion", "C\u00F3digo Postal", "Provincia", "Ciudad", "Calle", "Tel\u00E9fono", "Salario"
			}
		));*/
		scrollPaneEmpleado.setViewportView(tableEmpleado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 505, 1066, 55);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(621, 10, 429, 141);
		panel.add(panel_2);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(29, 23, 68, 14);
		lblProvincia.setHorizontalAlignment(SwingConstants.LEFT);
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(29, 50, 123, 20);
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ", "Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ", "Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ", "Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ", "S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ", "San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ", "Valverde "}));
		
		JLabel lblPostal = new JLabel("C\u00F3digo Postal");
		lblPostal.setBounds(29, 87, 111, 14);
		
			CodPostJF = new JFormattedTextField(mascaraCodigo);
			CodPostJF.setBounds(29, 111, 123, 20);
			CodPostJF.setBackground(Color.WHITE);
		
		tfCiudad = new JTextField();
		tfCiudad.setBounds(257, 111, 111, 20);
		tfCiudad.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(257, 87, 42, 14);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(257, 51, 111, 20);
		tfCalle.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(257, 23, 54, 14);
		panel_2.setLayout(null);
		panel_2.add(CodPostJF);
		panel_2.add(lblPostal);
		panel_2.add(cbxProvincia);
		panel_2.add(lblProvincia);
		panel_2.add(lblCalle);
		panel_2.add(tfCiudad);
		panel_2.add(tfCalle);
		panel_2.add(lblCiudad);
		panel_1.setLayout(null);
		
		JButton btnInsertarEmp = new JButton("REGISTRAR");
		btnInsertarEmp.setForeground(Color.BLACK);
		btnInsertarEmp.setBackground(SystemColor.inactiveCaptionBorder);
		btnInsertarEmp.setBounds(839, 10, 115, 34);
		panel_1.add(btnInsertarEmp);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBounds(962, 10, 96, 34);
		panel_1.add(btnCerrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(SystemColor.inactiveCaptionBorder);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaTable = tableEmpleado.getSelectedRow();
					if (filaTable == -1 ) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado!");
					}
					else {
						String id = model.getValueAt(filaTable, 0).toString(); //ID
						String ssn = model.getValueAt(filaTable, 1).toString(); 
						String cedula = model.getValueAt(filaTable, 2).toString();
						String nombre = model.getValueAt(filaTable, 3).toString();
						String sName = model.getValueAt(filaTable, 4).toString();
						String apellido = model.getValueAt(filaTable, 5).toString(); 
						String calle = model.getValueAt(filaTable, 6).toString();
						String ciudad = model.getValueAt(filaTable, 7).toString();
						String cPostal = model.getValueAt(filaTable, 8).toString();
						String telefono = model.getValueAt(filaTable, 9).toString();
						String posicion = model.getValueAt(filaTable, 10).toString();
						Float salario = Float.parseFloat(model.getValueAt(filaTable, 11).toString() ); 
						String provincia = model.getValueAt(filaTable, 12).toString();
						
						Empleado auxEm = new Empleado(cedula, nombre, sName, apellido, calle, ciudad, telefono, cPostal, ssn, posicion, salario, provincia);
						ModificarEmpleado modify = new ModificarEmpleado(auxEm);
						modify.setUndecorated(true);
						modify.setVisible(true);
						modify.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent e) {
								try {
									cargarEmpleados();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});						
					}


			}
		});
		btnModificar.setBounds(717, 10, 114, 34);
		panel_1.add(btnModificar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnInsertarEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					Empleado emp1 = new Empleado(cedulaJF.getText(), tfNombre.getText(), tfSname.getText(), tfApellido.getText(), tfCalle.getText(), tfCiudad.getText(), 
							TelefonoJF.getText(), CodPostJF.getText(), tfSSN.getText(), tfPosicion.getText(), Float.parseFloat(tfSalario.getText()), cbxProvincia.getSelectedItem().toString());
						try {
							Bike_Rental.getInstance().insertEmpleado(emp1);
							cargarEmpleados();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(scrollPaneEmpleado);
		contentPane.add(panel);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaTable = tableEmpleado.getSelectedRow();
				if(filaTable == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado!");
				}
				else  {
					try {
						String cedula = model.getValueAt(filaTable, 2).toString();
						String sql = "delete from empleado where cedula = '"+cedula+"'";
						PreparedStatement stmt = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
						stmt.execute();
						cargarEmpleados();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(594, 10, 114, 34);
		panel_1.add(btnNewButton);
	}
	public void cargarEmpleados() throws Exception {
		model.setRowCount(0);
		tableEmpleado.setModel(model);
		String sql = "select * from Empleado";
		try {
			PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//ResultSetMetaData  rsMd = rs.getMetaData();
			//int cantcolum = rsMd.getColumnCount();
			while (rs.next()) {
				fila = new Object[13];
				for (int i = 0; i<13; i++) {
					fila[i] = rs.getString(i+1);
				}
				model.addRow(fila);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public tablaEmpleados getInstance(){
		tablaEmpleados t1 = new tablaEmpleados();
		return t1;
	}
}
