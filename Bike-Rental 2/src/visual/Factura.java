package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;


public class Factura extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Factura dialog = new Factura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Factura() {
		setTitle("Factura");
		setResizable(false);
		setBounds(100, 100, 659, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlBuscar = new JPanel();
		pnlBuscar.setLayout(null);
		pnlBuscar.setBorder(new TitledBorder(null, "Buscar Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBuscar.setBounds(10, 11, 255, 58);
		contentPanel.add(pnlBuscar);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 26, 46, 14);
		pnlBuscar.add(lblCedula);
		
		JFormattedTextField ftxtCedula = new JFormattedTextField();
		ftxtCedula.setBounds(59, 23, 140, 20);
		pnlBuscar.add(ftxtCedula);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(209, 23, 30, 20);
		pnlBuscar.add(btnSearch);
		
		JPanel pnlBuscar_1 = new JPanel();
		pnlBuscar_1.setLayout(null);
		pnlBuscar_1.setBorder(new TitledBorder(null, "Buscar Cliente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBuscar_1.setBounds(10, 80, 255, 58);
		contentPanel.add(pnlBuscar_1);
		
		JLabel lblCedula_1 = new JLabel("Cedula:");
		lblCedula_1.setBounds(10, 26, 46, 14);
		pnlBuscar_1.add(lblCedula_1);
		
		JFormattedTextField ftxtCedula_1 = new JFormattedTextField((Object) null);
		ftxtCedula_1.setBounds(59, 23, 140, 20);
		pnlBuscar_1.add(ftxtCedula_1);
		
		JButton btnSearch_1 = new JButton("");
		btnSearch_1.setBounds(209, 23, 30, 20);
		pnlBuscar_1.add(btnSearch_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
