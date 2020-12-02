package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerDateModel;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import logica.Bike_Rental;
import logica.Cliente;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollBar;

public class RegistroFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField ftxtCedula;
	private JLabel lblTotal;
	private JTextField txtF;
	private JRadioButton rdbtnProd; 
	private JRadioButton rdbtnServicio; 
	private JPanel pnlProducto;
	private JPanel pnlServ; 
	private JButton btnVerificar; 
	private JButton btnAgregar; 
	private Cliente cliente = null; 
	private JLabel lblCedula; 
	private JLabel lblTelefono; 
	private JLabel lblNombre; 
	private String cod; 
	private String cod2; 
	private DefaultTableModel modelProd;
	private static Object[] filaProd;
	private JTable tableProd;
	private JTable tableServ;
	private DefaultTableModel modelServ;
	private static Object[] filaServ;
	private JList<String> listCompras; 
	private DefaultListModel modeloCompra = new DefaultListModel();
	private JSpinner spnFecha =  new JSpinner(new SpinnerDateModel());
	private JSpinner spnCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroFactura dialog = new RegistroFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public RegistroFactura() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					loadProd();
					loadServ();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setTitle("Facturaci\u00F3n");
		setResizable(false);
		setBounds(100, 100, 887, 538);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlVenta = new JPanel();
		pnlVenta.setBackground(SystemColor.inactiveCaptionBorder);
		pnlVenta.setBorder(new TitledBorder(null, "Venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlVenta.setBounds(318, 263, 553, 176);
		contentPanel.add(pnlVenta);
		pnlVenta.setLayout(new BorderLayout(0, 0));
		
		JButton btnDevolver = new JButton("Eliminar");
		btnDevolver.setEnabled(false);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDevolver.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/borrar.png")));
		pnlVenta.add(btnDevolver, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		pnlVenta.add(panel, BorderLayout.NORTH);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblTotal);
		
		JLabel lbl$ = new JLabel("$");
		lbl$.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbl$);
		
		JLabel lblPrecio = new JLabel("0.0");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblPrecio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnlVenta.add(scrollPane_1, BorderLayout.CENTER);
		
		listCompras = new JList();
		scrollPane_1.setViewportView(listCompras);
		
		JPanel pnlGeneral = new JPanel();
		pnlGeneral.setBackground(SystemColor.inactiveCaptionBorder);
		pnlGeneral.setLayout(null);
		pnlGeneral.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGeneral.setBounds(10, 22, 276, 208);
		contentPanel.add(pnlGeneral);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula:");
		lblNewLabel.setBounds(10, 29, 46, 14);
		pnlGeneral.add(lblNewLabel);
		
		btnVerificar = new JButton("Check");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ftxtCedula.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						cliente = Bike_Rental.getInstance().searchClienteByCed(ftxtCedula.getText());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (cliente != null && cliente.getCedula().equalsIgnoreCase(ftxtCedula.getText())) {
						JOptionPane.showMessageDialog(null, "Verificado", null, JOptionPane.WARNING_MESSAGE);
						lblCedula.setText(cliente.getCedula());
						lblNombre.setText(cliente.getFname());
						lblTelefono.setText(cliente.getPostalCode());
					} else {
						JOptionPane.showMessageDialog(null, "Cliente Inexistente", null, JOptionPane.ERROR_MESSAGE);
						lblCedula.setText("**********************");
						lblNombre.setText("**********************");
						lblTelefono.setText("**********************");
						int option = JOptionPane.showConfirmDialog(null, "¿Desea Agregar un Cliente Nuevo?", "CONFIRMACIÓN", JOptionPane.WARNING_MESSAGE);
						if (option == JOptionPane.OK_OPTION) {
							InsertCliente agcliente = new InsertCliente("Insertar Cliente", false, null);
							agcliente.setLocationRelativeTo(null);
							agcliente.setVisible(true);
						}else {
							ftxtCedula.setText("");
						}
					}
				}
			}
		});
		btnVerificar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/Check.png")));
		btnVerificar.setBounds(171, 25, 94, 23);
		pnlGeneral.add(btnVerificar);
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInformacion.setBorder(new TitledBorder(null, "Informaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBounds(10, 66, 255, 135);
		pnlGeneral.add(pnlInformacion);
		pnlInformacion.setLayout(null);
		
		lblCedula = new JLabel("**********************");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCedula.setEnabled(false);
		lblCedula.setBounds(86, 23, 159, 14);
		pnlInformacion.add(lblCedula);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
		lblNewLabel_1.setBounds(10, 23, 53, 14);
		pnlInformacion.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 60, 53, 14);
		pnlInformacion.add(lblNewLabel_2);
		
		lblNombre = new JLabel("**********************");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setEnabled(false);
		lblNombre.setBounds(86, 60, 159, 14);
		pnlInformacion.add(lblNombre);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3.setBounds(10, 98, 53, 14);
		pnlInformacion.add(lblNewLabel_3);
		
		lblTelefono = new JLabel("**********************");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setEnabled(false);
		lblTelefono.setBounds(86, 98, 159, 14);
		pnlInformacion.add(lblTelefono);
		
		MaskFormatter aux2 = new MaskFormatter("###-#######-#");
		aux2.setPlaceholderCharacter(' ');
		ftxtCedula = new JFormattedTextField(aux2);
		ftxtCedula.setBounds(59, 26, 102, 20);
		pnlGeneral.add(ftxtCedula);

		JPanel pnlInventario = new JPanel();
		pnlInventario.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInventario.setBorder(new TitledBorder(null, "Inventario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInventario.setBounds(318, 22, 553, 171);
		contentPanel.add(pnlInventario);
		pnlInventario.setLayout(new CardLayout(0, 0));
		
		pnlProducto = new JPanel();
		pnlInventario.add(pnlProducto, "name_535546469129700");
		pnlProducto.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlProducto.add(scrollPane, BorderLayout.CENTER);
		
		tableProd = new JTable();
		tableProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = tableProd.getSelectedRow();
				
				if (aux > -1) {
					btnAgregar.setEnabled(true);
					cod = (String) tableProd.getModel().getValueAt(aux, 0);
				} else {
					btnAgregar.setEnabled(false);
					String cod = "";
				}
			}
		});
		scrollPane.setViewportView(tableProd);
		modelProd = new DefaultTableModel();
		String[] columneNames = {"Id", "Tipo", "Nombre", "Precio", "Marca", "En Stock"};
		modelProd.setColumnIdentifiers(columneNames);
		
		pnlServ = new JPanel();
		pnlInventario.add(pnlServ, "name_535633779652799");
		pnlServ.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnlServ.add(scrollPane_2, BorderLayout.CENTER);
		
		tableServ = new JTable();
		tableServ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = tableServ.getSelectedRow();
				
				if (aux > -1) {
					btnAgregar.setEnabled(true);
					cod2 = (String) tableServ.getModel().getValueAt(aux, 0);

				} else {
					btnAgregar.setEnabled(false);
					String cod2 = "";
				}
				
			}
		});
		scrollPane_2.setViewportView(tableServ);
		modelServ = new DefaultTableModel();
		String[] columneNames2 = {"Id", "Empleado", "Tipo", "Precio"};
		modelServ.setColumnIdentifiers(columneNames2);
		
		JPanel pnlFactura = new JPanel();
		pnlFactura.setBackground(SystemColor.inactiveCaptionBorder);
		pnlFactura.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlFactura.setBounds(10, 235, 276, 204);
		contentPanel.add(pnlFactura);
		pnlFactura.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		lblNewLabel_4.setBounds(10, 24, 46, 14);
		pnlFactura.add(lblNewLabel_4);
		
		txtF = new JTextField();
		txtF.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtF.setText("F - ");
		txtF.setEnabled(false);
		txtF.setColumns(10);
		txtF.setBounds(10, 93, 90, 20);
		pnlFactura.add(txtF);
		
		JLabel lblNewLabel_4_1 = new JLabel("Id Factura:");
		lblNewLabel_4_1.setBounds(10, 74, 60, 14);
		pnlFactura.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Comprobante de Factura:");
		lblNewLabel_5.setBounds(58, 127, 164, 14);
		pnlFactura.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton.setBounds(77, 148, 53, 23);
		pnlFactura.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton_1.setBounds(143, 148, 65, 23);
		pnlFactura.add(rdbtnNewRadioButton_1);
		
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy");
		spnFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		spnFecha.setEnabled(false);
		spnFecha.setEditor(dateEditor);
		spnFecha.setBounds(10, 43, 111, 20);
		pnlFactura.add(spnFecha);
		
		JPanel pnlControl = new JPanel();
		pnlControl.setBackground(SystemColor.inactiveCaptionBorder);
		pnlControl.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnlControl.setBounds(318, 192, 553, 38);
		contentPanel.add(pnlControl);
		
		rdbtnProd = new JRadioButton("Productos");
		rdbtnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnServicio.setSelected(false);
				rdbtnProd.setSelected(true);
				pnlServ.setVisible(false);
				pnlProducto.setVisible(true);
				spnCant.setEnabled(true);
			}
		});
		rdbtnProd.setSelected(true);
		rdbtnProd.setBackground(SystemColor.inactiveCaptionBorder);
		pnlControl.add(rdbtnProd);
		
		rdbtnServicio = new JRadioButton("Servicios");
		rdbtnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnServicio.setSelected(true);
				rdbtnProd.setSelected(false);
				pnlServ.setVisible(true);
				pnlProducto.setVisible(false);
				spnCant.setEnabled(false);
				spnCant.setValue(0);
			}
		});
		rdbtnServicio.setBackground(SystemColor.inactiveCaptionBorder);
		pnlControl.add(rdbtnServicio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = (int) spnCant.getValue(); 
				if(cod == "") {
					JOptionPane.showMessageDialog(null, "Seleccione un producto", null, JOptionPane.WARNING_MESSAGE);
				}else if (aux == 0 ) {
					JOptionPane.showMessageDialog(null, "Digite la cantidad de producto", null, JOptionPane.WARNING_MESSAGE);
				}
				
				//ArrayList<String>
			}
		});
		btnAgregar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/add.png")));
		pnlControl.add(btnAgregar);
		
		spnCant = new JSpinner();
		spnCant.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spnCant.setBounds(586, 232, 66, 20);
		contentPanel.add(spnCant);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad:");
		lblNewLabel_6.setBounds(517, 235, 79, 14);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnFacturar = new JButton("Facturar");
				btnFacturar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/modificar.png")));
				btnFacturar.setActionCommand("OK");
				buttonPane.add(btnFacturar);
				getRootPane().setDefaultButton(btnFacturar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void loadProd() throws Exception{
		modelProd.setRowCount(0);
		tableProd.setModel(modelProd);
		String sql = "select * from Producto"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int aux = modelProd.getColumnCount();
					filaProd = new Object[aux];
					for(int i = 0; i<aux; i++) {
						filaProd[i]=rs.getString(i+1);
					}
					modelProd.addRow(filaProd);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	
	private void loadServ() throws Exception{
		modelServ.setRowCount(0);
		tableServ.setModel(modelServ);
		String sql = "select * from Servicio"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int aux = modelServ.getColumnCount();
					filaServ = new Object[aux];
					for(int i = 0; i<aux; i++) {
						filaServ[i]=rs.getString(i+1);
					}
					modelServ.addRow(filaServ);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
}
