package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("BIKE - RENTAL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setIcon(new ImageIcon(Principal.class.getResource("/icons/add.png")));
		mnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCliente cl;
				cl = new InsertCliente("Insertar Cliente", false, null);
				cl.setModal(true);
				cl.setLocationRelativeTo(null);
				cl.setVisible(true);
			}
		});
		mnRegistrar.add(mntmCliente);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mnRegistrar.add(mntmEmpleado);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmListClientes = new JMenuItem("Listado Clientes");
		mntmListClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCliente ll;
				ll = new ListCliente();
				ll.setModal(true);
				ll.setLocationRelativeTo(null);
				ll.setVisible(true);
			}
		});
		mnConsultas.add(mntmListClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
