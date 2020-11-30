package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import logica.Bike_Rental;
import logica.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class insertProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textMarca;
	private JTextField textTipo;
	private JSpinner spnCantidad;
	private Producto miPro; 
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			insertProducto dialog = new insertProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public insertProducto() {
		setTitle("Productos");
		setResizable(false);
		setBounds(100, 100, 440, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setLayout(null);
		pnlInformacion.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInformacion.setBounds(25, 31, 381, 306);
		contentPanel.add(pnlInformacion);
		
		JLabel lblPrecioVentaUnd = new JLabel("Precio Venta Und.:");
		lblPrecioVentaUnd.setBounds(24, 200, 174, 14);
		pnlInformacion.add(lblPrecioVentaUnd);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 39, 55, 14);
		pnlInformacion.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(24, 97, 55, 14);
		pnlInformacion.add(lblMarca);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBackground(Color.WHITE);
		textName.setBounds(130, 40, 174, 23);
		pnlInformacion.add(textName);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBackground(Color.WHITE);
		textMarca.setBounds(130, 93, 174, 23);
		pnlInformacion.add(textMarca);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(24, 149, 62, 14);
		pnlInformacion.add(lblCantidad);
		
		spnCantidad = new JSpinner();
		spnCantidad.setBounds(130, 146, 86, 20);
		pnlInformacion.add(spnCantidad);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(24, 250, 117, 14);
		pnlInformacion.add(lblDescripcion);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBackground(Color.WHITE);
		textTipo.setBounds(131, 246, 240, 23);
		pnlInformacion.add(textTipo);
		
		textPrecio = new JTextField();
		textPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textPrecio.setColumns(10);
		textPrecio.setBackground(Color.WHITE);
		textPrecio.setBounds(130, 197, 86, 23);
		pnlInformacion.add(textPrecio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String name = textName.getText();
						String tipo = textTipo.getText();
						float precio = Float.parseFloat(textPrecio.getText());
						int cantidad = (int) spnCantidad.getValue();
						String marca = textMarca.getText();			
						Producto miPro = new Producto(tipo, name, precio, marca, cantidad); 
						
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
							
						} 
						try {
							Bike_Rental.getInstance().insertProducto(miPro);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textName.setText(null);
						textTipo.setText(null);
						textPrecio.setText(null);
						spnCantidad.setValue(0);
						textMarca.setText(null);			
						
						JOptionPane
						.showMessageDialog(null,
								"Producto Agregado Satisfactoriamente");
					}
				});
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
				btnCancelar.setIcon(new ImageIcon(Producto.class.getResource("/icons/borrar.png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
