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

public class tablaEmpleados extends JFrame {

	private JPanel contentPane;
	private JTable tableEmpleado;
	private JTextField tfSSN;
	private JTextField tfCedula;
	private JTextField tfNombre;
	private JTextField tfPostal;
	private JTextField tfCiudad;
	private JTextField tfCalle;
	private JTextField tfPosicion;
	private JTextField tfTelefono;
	private JTextField tfSalario;
	private JTextField tfApellido;
	private JTextField tfSname;
	private static DefaultTableModel model;
	private static Object[] fila; 

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
		setBounds(100, 100, 1004, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPaneEmpleado = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblSSN = new JLabel("SSN");
		
		tfSSN = new JTextField();
		tfSSN.setColumns(10);
		
		tfCedula = new JTextField();
		tfCedula.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		
		tfSname = new JTextField();
		tfSname.setColumns(10);
		
		JLabel lblSname = new JLabel("Seguno Nombre");
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		
		JLabel lblCiudad = new JLabel("Ciudad");
		
		JLabel lblPostal = new JLabel("C\u00F3digo Postal");
		
		tfPostal = new JTextField();
		tfPostal.setColumns(10);
		
		tfCiudad = new JTextField();
		tfCiudad.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		
		tfPosicion = new JTextField();
		tfPosicion.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblPosicion = new JLabel("Posicion");
		
		JComboBox cbxProvincia = new JComboBox();
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ", "Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ", "Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ", "Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ", "S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ", "San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ", "Valverde "}));
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(tfCedula, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfPosicion, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfSSN, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCedula, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(tfNombre, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(lblPosicion, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSSN, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(88)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSname, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tfSalario, Alignment.LEADING)
							.addComponent(tfSname, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProvincia, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tfPostal, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addComponent(lblPostal, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addComponent(cbxProvincia, 0, 0, Short.MAX_VALUE)))
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCiudad, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(tfCalle, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCalle, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addGap(7))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(tfCiudad, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSSN)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfSSN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(lblSname)
								.addComponent(lblApellido)
								.addComponent(lblTelefono)
								.addComponent(lblCalle)
								.addComponent(lblProvincia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfSname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCedula)
									.addGap(12)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfPosicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(6))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPostal)
										.addComponent(lblCiudad))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(tfPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPosicion)
								.addComponent(lblSalario))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//model = new DefaultTableModel();
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "SSN", "Cedula", "Nombre", "S. Nombre", "Apellido", "Posicion", "C\u00F3digo Postal", "Ciudad", "Calle", "Tel\u00E9fono", "Salario"
				}
			);
		tableEmpleado = new JTable();
		/*tableEmpleado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "SSN", "Cedula", "Nombre", "S. Nombre", "Apellido", "Posicion", "C\u00F3digo Postal", "Provincia", "Ciudad", "Calle", "Tel\u00E9fono", "Salario"
			}
		));*/
		scrollPaneEmpleado.setViewportView(tableEmpleado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneEmpleado, GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPaneEmpleado, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JButton btnInsertarEmp = new JButton("REGISTRAR");
		btnInsertarEmp.setBackground(Color.LIGHT_GRAY);
		btnInsertarEmp.setBounds(659, 3, 107, 34);
		panel_1.add(btnInsertarEmp);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(774, 3, 96, 34);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnInsertarEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado emp1 = new Empleado(tfCedula.getText(), tfNombre.getText(), tfSname.getText(), tfApellido.getText(), tfCalle.getText(), tfCiudad.getText(), 
						tfTelefono.getText(), tfPostal.getText(), tfSSN.getText(), tfPosicion.getText(), Float.parseFloat(tfSalario.getText()), cbxProvincia.getSelectedItem().toString());
				try {
					Bike_Rental.getInstance().insertEmpleado(emp1);
					cargarEmpleados();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(gl_contentPane);
	}
	private void cargarEmpleados() throws Exception {
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
}
