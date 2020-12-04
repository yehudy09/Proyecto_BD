package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import logica.Bike_Rental;
import logica.Cliente;
import logica.Producto;
import logica.Proveedor;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class insertProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textMarca;
	private JTextField textTipo;
	private JTextField textPrecio;
	private JTextField IDProtxt;
	private JTextField textIDProv;
	private JTextField PrecioCtxt;
	private Producto producto = null;
	private Proveedor miprov = null;
	private JTextField textCant;
	private JButton btnGuardar;
	private JSpinner spnFecha =  new JSpinner(new SpinnerDateModel());
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			insertProducto dialog = new insertProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public insertProducto(String title, boolean modi, Producto mipro) {
		setTitle("Producto");
		setResizable(false);
		setBounds(100, 100, 497, 611);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		producto = mipro;
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setLayout(null);
		pnlInformacion.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInformacion.setBounds(20, 28, 436, 510);
		contentPanel.add(pnlInformacion);
		
		JLabel lblPrecioVentaUnd = new JLabel("Precio Venta Und.:");
		lblPrecioVentaUnd.setBounds(24, 288, 174, 14);
		pnlInformacion.add(lblPrecioVentaUnd);
		
		JLabel lblNombre = new JLabel("Nombre Producto:");
		lblNombre.setBounds(16, 142, 107, 14);
		pnlInformacion.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(24, 192, 55, 14);
		pnlInformacion.add(lblMarca);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBackground(Color.WHITE);
		textName.setBounds(151, 138, 174, 23);
		pnlInformacion.add(textName);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBackground(Color.WHITE);
		textMarca.setBounds(151, 192, 174, 23);
		pnlInformacion.add(textMarca);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(24, 235, 62, 14);
		pnlInformacion.add(lblCantidad);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(24, 341, 117, 14);
		pnlInformacion.add(lblDescripcion);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBackground(Color.WHITE);
		textTipo.setBounds(151, 337, 240, 23);
		pnlInformacion.add(textTipo);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textPrecio.setColumns(10);
		textPrecio.setBackground(Color.WHITE);
		textPrecio.setBounds(151, 284, 86, 23);
		pnlInformacion.add(textPrecio);
		
		JLabel lblIDProd = new JLabel("ID Producto:");
		lblIDProd.setBounds(24, 47, 107, 14);
		pnlInformacion.add(lblIDProd);
		
		IDProtxt = new JTextField();
		IDProtxt.setBounds(151, 44, 174, 20);
		pnlInformacion.add(IDProtxt);
		IDProtxt.setColumns(10);
		
		JButton btnSearchIDProd = new JButton("");
		btnSearchIDProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					producto = Bike_Rental.getInstance().searchProductoByID(IDProtxt.getText());
					miprov = Bike_Rental.getInstance().searchProveedorByID(textIDProv.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (producto != null ) {
					JOptionPane.showMessageDialog(null, "Verificado", null, JOptionPane.WARNING_MESSAGE);
					String aux;
					btnGuardar.setEnabled(true);
					btnGuardar.setVisible(true);
					
					aux = Float.toString(producto.getPrecioVenta());
					
					
					textName.setText(producto.getNameProducto());
					textMarca.setText(producto.getMarca());
					textIDProv.setText(miprov.getIdProveedor());
					textPrecio.setText(aux);
					textTipo.setText(producto.getTipo());
					
					textName.setEnabled(false);
					textMarca.setEnabled(false);
					textIDProv.setEnabled(false);
					textPrecio.setEnabled(false);
					textTipo.setEnabled(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "Producto Inexistente", null, JOptionPane.ERROR_MESSAGE);
					int option = JOptionPane.showConfirmDialog(null, "¿Desea Agregar este nuevo producto?", "CONFIRMACIÓN", JOptionPane.WARNING_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						
						JOptionPane.showMessageDialog(null, "Proveedor Inexistente", null, JOptionPane.ERROR_MESSAGE);
						option = JOptionPane.showConfirmDialog(null, "¿Desea Agregar este nuevo proveedor?", "CONFIRMACIÓN", JOptionPane.WARNING_MESSAGE);
						InsertProveedor insProv = new InsertProveedor("Insertar Proveedor", false, null);
						insProv.setVisible(true);
					}
				}
				
			}
		});
		btnSearchIDProd.setIcon(new ImageIcon(insertProducto.class.getResource("/icons/Search.png")));
		btnSearchIDProd.setBounds(347, 58, 55, 47);
		pnlInformacion.add(btnSearchIDProd);
		
		JLabel IDProvlbl = new JLabel("ID Proveedor: ");
		IDProvlbl.setBounds(16, 95, 92, 14);
		pnlInformacion.add(IDProvlbl);
		
		textIDProv = new JTextField();
		textIDProv.setBounds(151, 92, 174, 20);
		pnlInformacion.add(textIDProv);
		textIDProv.setColumns(10);
		
		JLabel PrecioClbl = new JLabel("Precio Compra:");
		PrecioClbl.setBounds(22, 399, 86, 14);
		pnlInformacion.add(PrecioClbl);
		
		PrecioCtxt = new JTextField();
		PrecioCtxt.setBounds(151, 396, 86, 20);
		pnlInformacion.add(PrecioCtxt);
		PrecioCtxt.setColumns(10);
		
		textCant = new JTextField();
		textCant.setBounds(151, 232, 86, 20);
		pnlInformacion.add(textCant);
		textCant.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(16, 455, 63, 14);
		pnlInformacion.add(lblFecha);
		
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy");
		spnFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		spnFecha = new JSpinner();
		spnFecha.setEnabled(false);
		spnFecha.setEditor(dateEditor);
		spnFecha.setBounds(151, 452, 86, 20);
		pnlInformacion.add(spnFecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(modi){
					btnRegistrar.setText("Salvar Modificaciones");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!modi) {
							
						String name = textName.getText();
						String tipo = textTipo.getText();
						float precio = Float.parseFloat(textPrecio.getText());
						int cantidad = Integer.valueOf(textCant.getText());
						String marca = textMarca.getText();	
						String idProducto = IDProtxt.getText();
						String idProveedor = textIDProv.getText();
						float precioCompra = Float.parseFloat(PrecioCtxt.getText());
						
						java.util.Date dt = new java.util.Date();
						java.text.SimpleDateFormat sdf = 
						        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

						String currentTime = sdf.format(dt);
						
				        Producto mipro = new Producto(tipo, name, precio, currentTime , marca, precioCompra, cantidad, idProveedor, idProducto);
						
						if (textName.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Se debe ingresar el nombre del producto a registrar","ATENCIÓN",
									JOptionPane.WARNING_MESSAGE, null);
							
							
						} else if (textTipo.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Se debe ingresar el tipo del producto a registrar","ATENCIÓN",
											JOptionPane.WARNING_MESSAGE, null);
							
							
						} else if (textPrecio.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Se debe ingresar el precio del producto a registrar", "ATENCIÓN",
											JOptionPane.WARNING_MESSAGE, null);
							
							
						} else if (textMarca.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Se debe ingresar la marca del producto a registrar", "ATENCIÓN",
											JOptionPane.WARNING_MESSAGE, null);
							
						} else if (IDProtxt.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Se debe ingresar el ID del producto a registrar", "ATENCIÓN",
									JOptionPane.WARNING_MESSAGE, null);
					
				} else {
						try {
							Bike_Rental.getInstance().insertProducto(mipro);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						IDProtxt.setText(null);
						textName.setText(null);
						textTipo.setText(null);
						textPrecio.setText(null);
						textCant.setText(null);
						textMarca.setText(null);
						textIDProv.setText(null);
						PrecioCtxt.setText(null);
						
						
						JOptionPane
						.showMessageDialog(null,
								"Producto Agregado Satisfactoriamente");
					}
						}
						
						else {
							String name = textName.getText();
							String tipo = textTipo.getText();
							float precio = Float.parseFloat(textPrecio.getText());
							int cantidad = Integer.valueOf(textCant.getText());
							String marca = textMarca.getText();	
							String idProducto = IDProtxt.getText();
							String idProveedor = textIDProv.getText();
							float precioCompra = Float.parseFloat(PrecioCtxt.getText());
							
							java.util.Date dt = new java.util.Date();
							java.text.SimpleDateFormat sdf = 
							        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

							String currentTime = sdf.format(dt);
							
					        Producto modiProd = new Producto(tipo, name, precio, currentTime , marca, precioCompra, cantidad, idProveedor, idProducto);
					        try {
								Bike_Rental.getInstance().updateStock(modiProd);
								JOptionPane.showMessageDialog(null, "Proveedor Modificado");
								dispose();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1,  "No se insertaron los datos correctos" + e1.getMessage(), JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
								
							}
						}
				}
				});
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Producto aux = null;
						int y = Integer.valueOf(textCant.getText());
					
						try {
							aux = Bike_Rental.getInstance().searchCantStock(IDProtxt.getText());
							Bike_Rental.getInstance().incrementProducto(IDProtxt.getText(), aux.getCantStock(), y);
							//Bike_Rental.getInstance().updateStock(mipro);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						IDProtxt.setText(null);
						textName.setText(null);
						textTipo.setText(null);
						textPrecio.setText(null);
						textCant.setText(null);
						textMarca.setText(null);
						textIDProv.setText(null);
						PrecioCtxt.setText(null);
						
						JOptionPane
						.showMessageDialog(null,
								"Producto Guardado Satisfactoriamente");
					}
				});
				btnGuardar.setEnabled(false);
				btnGuardar.setIcon(new ImageIcon(insertProducto.class.getResource("/icons/guardar.png")));
				buttonPane.add(btnGuardar);
				btnRegistrar.setIcon(new ImageIcon(Producto.class.getResource("/icons/add.png")));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setIcon(new ImageIcon(insertProducto.class.getResource("/icons/cancelar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		
		if(modi){
			loadProducto();
		}
		
		
	}
	
	private void loadProducto() {
		if (producto != null) {
			IDProtxt.setText(producto.getIdProducto());
			textIDProv.setText(producto.getIdProveedor());
			textName.setText(producto.getNameProducto());
			textMarca.setText(producto.getMarca());
			textCant.setText(Integer.toString(producto.getCantStock()));
			textPrecio.setText(Float.toString(producto.getPrecioVenta()));
			textTipo.setText(producto.getTipo());
			PrecioCtxt.setText(Float.toString(producto.getPrecioCompra()));
			
			
			
		}

	}
	
	
}
