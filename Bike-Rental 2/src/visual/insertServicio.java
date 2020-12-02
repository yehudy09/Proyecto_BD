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
import logica.Servicio;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class insertServicio extends JFrame {

	private JPanel contentPane;
	private JTable tableServicios;
	private JTextField tfTipo;
	private JTextField tfPrecio;
	private static DefaultTableModel model;
	private static Object[] fila; 
	private static JButton btnModificar;
	private static JButton btnEliminar;
	private static JComboBox cbxEmpleados;



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
	public insertServicio() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					cargarServicios();
					cargarEmpleados();
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					cbxEmpleados.setSelectedIndex(0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 399);
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
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Precio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (tfPrecio.getText().isEmpty()  || tfTipo.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
					}
					else {
						String[] fname = cbxEmpleados.getSelectedItem().toString().split(" ");
						String sql = "select ssn from Empleado where Fname = '"+fname[0]+"' and Sname = '"+fname[1]+"'";
						PreparedStatement ps  = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						String ssn;
						while (rs.next()) {
							ssn = rs.getString(1);
							
							 
							Servicio aux = new Servicio (Float.parseFloat(tfPrecio.getText()), ssn, tfTipo.getText());
							Bike_Rental.getInstance().insertServicio(aux);
							cargarServicios();
							JOptionPane
							.showMessageDialog(null,
									"Empleado Agregado Satisfactoriamente");
							cbxEmpleados.setSelectedIndex(0);
						}
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInsertar.setBackground(SystemColor.inactiveCaption);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaTable = tableServicios.getSelectedRow();
				String id = model.getValueAt(filaTable, 0).toString();
				String ssn = model.getValueAt(filaTable, 1).toString();
				String tipo = model.getValueAt(filaTable, 2).toString();
				Float precio = Float.parseFloat(model.getValueAt(filaTable, 3).toString());
				Servicio modify = new Servicio(precio, ssn, tipo);
				modificarServicio modi = new modificarServicio(modify, id);
				modi.setUndecorated(true);
				modi.setVisible(true);
				modi.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						try {
							cargarServicios();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});	
			}
		});
		btnModificar.setBackground(SystemColor.inactiveCaption);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sql = "delete from Servicio where idServicio = ?";
			int filaServ = tableServicios.getSelectedColumn();
			String id  = model.getValueAt(filaServ, 0).toString();
			try {
				PreparedStatement stmt = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				stmt.setString(1, id);
				stmt.execute();
				cargarServicios();
				JOptionPane
				.showMessageDialog(null,
						"Servicio Eliminado Satisfactoriamente");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnEliminar.setBackground(SystemColor.inactiveCaption);
		
		cbxEmpleados = new JComboBox();
		cbxEmpleados.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		GroupLayout gl_panelInsercion = new GroupLayout(panelInsercion);
		gl_panelInsercion.setHorizontalGroup(
			gl_panelInsercion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInsercion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInsercion.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelInsercion.createSequentialGroup()
							.addComponent(lblTipo, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(60))
						.addGroup(Alignment.TRAILING, gl_panelInsercion.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGap(60))
						.addGroup(Alignment.TRAILING, gl_panelInsercion.createSequentialGroup()
							.addGroup(gl_panelInsercion.createParallelGroup(Alignment.TRAILING)
								.addComponent(cbxEmpleados, Alignment.LEADING, 0, 152, Short.MAX_VALUE)
								.addComponent(tfPrecio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(btnEliminar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(btnModificar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(btnInsertar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(lblSsn, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panelInsercion.createSequentialGroup()
							.addComponent(tfTipo, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panelInsercion.setVerticalGroup(
			gl_panelInsercion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInsercion.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSsn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbxEmpleados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(lblTipo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tfTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(tfPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnInsertar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEliminar)
					.addContainerGap())
		);
		panelInsercion.setLayout(gl_panelInsercion);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(196, 10, 393, 342);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableServicios = new JTable();
		tableServicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "SSN", "Tipo", "Precio"
			}
		);
		tableServicios.setModel(model);
		scrollPane.setViewportView(tableServicios);
	}
	public void cargarServicios() throws Exception {
		model.setRowCount(0);
		tableServicios.setModel(model);
		String sql = "select * from Servicio order by idServicio";
		try {
			PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				fila = new Object[4];
				for (int i = 0; i<4; i++) {
					fila[i] = rs.getString(i+1);
				}
				model.addRow(fila);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void cargarEmpleados() throws Exception{
		String sql = "select * from Empleado";
		PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			cbxEmpleados.addItem(rs.getString(4) +" "+ rs.getString(5));
		}
		
	}
}
