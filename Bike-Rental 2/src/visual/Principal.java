package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;
	private JLabel lblhora; 
	private JLabel lblyear; 

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/Cyclist-icon.png")));
		setTitle("BIKE-RENTAL, STORE MANAGER");
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
		
		JMenuItem mntmProv = new JMenuItem("Proveedor");
		mntmProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertProveedor miprov;
				miprov = new InsertProveedor("Insertar Proveedor", false, null);
				miprov.setModal(true);
				miprov.setLocationRelativeTo(null);
				miprov.setVisible(true);
			}
		});
		mntmProv.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
		mnRegistrar.add(mntmProv);
		
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
		
		JMenuItem mntmListProv = new JMenuItem("Listado Proveedores");
		mntmListProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListProveedor lp;
				lp = new ListProveedor();
				lp.setModal(true);
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
			}
		});
		mnConsultas.add(mntmListProv);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 579, 1350, 59);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblhora = new JLabel("");
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblhora.setBounds(24, 11, 140, 39);
		panel_1.add(lblhora);
		
		lblyear = new JLabel("");
		lblyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblyear.setBounds(131, 11, 212, 39);
		panel_1.add(lblyear);
		
		reloj();
	}
	
	public void reloj() {

		Thread reloj = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar calen = new GregorianCalendar();
						int dia = calen.get(Calendar.DAY_OF_WEEK_IN_MONTH);
						int diaSemana = calen.get(Calendar.DAY_OF_WEEK);
						int mes = calen.get(Calendar.MONTH + 1);
						int minutos = calen.get(Calendar.MINUTE);
						int hora = calen.get(Calendar.HOUR);
						int sec = calen.get(Calendar.SECOND);
						int meri = calen.get(Calendar.AM_PM);
						LocalDate date = LocalDate.now();
						int anno = date.getYear();
						int mess= date.getMonthValue();
						int dias = date.getDayOfMonth();
						String realmes = "";
						String merid = "";
						if (meri == 1) {
							merid = " PM";
						} else {
							merid = " AM";
						}
						if (mess == 1) {
							realmes = "Enero";
						}
						if (mess == 2) {
							realmes = "Febreo";
						}
						if (mess == 3) {
							realmes = "Marzo";
						}
						if (mess == 4) {
							realmes = "Abril";
						}
						if (mess == 5) {
							realmes = "Mayo";
						}
						if (mess == 6) {
							realmes = "Junio";
						}
						if (mess == 7) {
							realmes = "Julio";
						}
						if (mess == 8) {
							realmes = "Agosto";
						}
						if (mess == 9) {
							realmes = "Septiembre";
						}
						if (mess == 10) {
							realmes = "Octubre";
						}
						if (mess == 11) {
							realmes = "Noviembre";
						}
						if (mess == 12) {
							realmes = "Diciembre";
						}
						lblhora.setText(hora + ":" + minutos + ":" + sec + merid);
						lblyear.setText(dias+", "+realmes+", "+anno);
						

						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		reloj.start();

	}


}
