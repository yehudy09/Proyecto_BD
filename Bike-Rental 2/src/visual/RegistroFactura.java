package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField ftxtCedula;
	private JLabel lblTotal;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField txtF;

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
		pnlVenta.setBounds(318, 235, 553, 204);
		contentPanel.add(pnlVenta);
		pnlVenta.setLayout(new BorderLayout(0, 0));
		
		JButton btnDevolver = new JButton("Eliminar");
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
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JPanel pnlGeneral = new JPanel();
		pnlGeneral.setBackground(SystemColor.inactiveCaptionBorder);
		pnlGeneral.setLayout(null);
		pnlGeneral.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlGeneral.setBounds(10, 22, 276, 208);
		contentPanel.add(pnlGeneral);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula:");
		lblNewLabel.setBounds(10, 29, 46, 14);
		pnlGeneral.add(lblNewLabel);
		
		JButton btnVerificar = new JButton("Check");
		btnVerificar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/Check.png")));
		btnVerificar.setBounds(171, 25, 94, 23);
		pnlGeneral.add(btnVerificar);
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInformacion.setBorder(new TitledBorder(null, "Informaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBounds(10, 66, 255, 135);
		pnlGeneral.add(pnlInformacion);
		pnlInformacion.setLayout(null);
		
		JLabel lblCedula = new JLabel("**********************");
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
		
		JLabel lblNombre = new JLabel("**********************");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setEnabled(false);
		lblNombre.setBounds(86, 60, 159, 14);
		pnlInformacion.add(lblNombre);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3.setBounds(10, 98, 53, 14);
		pnlInformacion.add(lblNewLabel_3);
		
		JLabel lblTelefono = new JLabel("**********************");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setEnabled(false);
		lblTelefono.setBounds(86, 98, 159, 14);
		pnlInformacion.add(lblTelefono);
		
		MaskFormatter aux2 = new MaskFormatter("###-#######-#");
		aux2.setPlaceholderCharacter(' ');
		ftxtCedula = new JFormattedTextField(aux2);
		ftxtCedula.setBounds(59, 26, 102, 20);
		pnlGeneral.add(ftxtCedula);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBorder(new TitledBorder(null, "Inventario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(318, 22, 553, 171);
		contentPanel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "name_535546469129700");
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "name_535633779652799");
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 235, 276, 204);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setEnabled(false);
		textField.setBounds(10, 43, 111, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		lblNewLabel_4.setBounds(10, 24, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		txtF = new JTextField();
		txtF.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtF.setText("F - ");
		txtF.setEnabled(false);
		txtF.setColumns(10);
		txtF.setBounds(10, 93, 90, 20);
		panel_1.add(txtF);
		
		JLabel lblNewLabel_4_1 = new JLabel("Id Factura:");
		lblNewLabel_4_1.setBounds(10, 74, 60, 14);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Comprobante de Factura:");
		lblNewLabel_5.setBounds(58, 127, 164, 14);
		panel_1.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("S\u00ED");
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton.setBounds(77, 148, 53, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton_1.setBounds(143, 148, 65, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinner.setEnabled(false);
		spinner.setBounds(151, 93, 115, 20);
		panel_1.add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad:");
		lblNewLabel_6.setBounds(152, 75, 79, 14);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaptionBorder);
		panel_5.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_5.setBounds(318, 192, 553, 38);
		contentPanel.add(panel_5);
		
		JRadioButton rdbtnProd = new JRadioButton("Productos");
		rdbtnProd.setBackground(SystemColor.inactiveCaptionBorder);
		panel_5.add(rdbtnProd);
		
		JRadioButton rdbtnServicio = new JRadioButton("Servicios");
		rdbtnServicio.setBackground(SystemColor.inactiveCaptionBorder);
		panel_5.add(rdbtnServicio);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(RegistroFactura.class.getResource("/icons/add.png")));
		panel_5.add(btnAgregar);
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
}
