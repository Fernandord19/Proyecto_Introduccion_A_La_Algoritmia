package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Tienda extends JFrame implements ActionListener {

	/**
	 * @author Fernando Revilla
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Datos mínimos del primer colchón
	public static String marca0 = "Suavestar";
	public static double precio0 = 499.0;
	public static int garantia0 = 7;
	public static String tamaño0 = "1 1/2 Plazas";
	public static String material0 = "Tela Tricot Acolchada";

	// Datos mínimos del segundo colchón
	public static String marca1 = "SpringWall";
	public static double precio1 = 679.0;
	public static int garantia1 = 10;
	public static String tamaño1 = "2 Plazas";
	public static String material1 = "Tejido de punto con Algodón Orgánico";

	// Datos mínimos del tercer colchón
	public static String marca2 = "Paraiso";
	public static double precio2 = 479.0;
	public static int garantia2 = 5;
	public static String tamaño2 = "1 1/2 Plazas";
	public static String material2 = "Tejido de Punto";

	// Datos mínimos del cuarto colchón
	public static String marca3 = "Drimer";
	public static double precio3 = 749.0;
	public static int garantia3 = 4;
	public static String tamaño3 = "Queen";
	public static String material3 = "Jacquard";

	// Datos mínimos del quinto colchón
	public static String marca4 = "Cisne";
	public static double precio4 = 389.0;
	public static int garantia4 = 2;
	public static String tamaño4 = "1 1/2 Plazas";
	public static String material4 = "Tejido de Punto";

	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;

	// Cantidad óptima de colchones vendidos
	public static int cantidadOptima = 10;

	// Cantidad mínima de colchones adquiridos para acceder al obsquio
	public static int cantidadMinimaObsequiable = 3;

	// Obsequio por cantidad mínima de colchones adquiridos
	public static String obsequio = "USB";

	// Número de cliente que recibe el premio sorpresa
	public static int numeroCLienteSorpresa = 5;

	// Variable para contar la cantidad de clientes
	public static int numeroCliente = 0;

	// Premio sorpresa
	public static String premioSorpresa = "Un polo";

	// Acumuladores del primer colchón
	public static int cantidadVentasColchon0 = 0;
	public static int cantidadVendidasColchon0 = 0;
	public static double totalAcumuladoColchon0 = 0.0;

	// Acumuladores del segundo colchón
	public static int cantidadVentasColchon1 = 0;
	public static int cantidadVendidasColchon1 = 0;
	public static double totalAcumuladoColchon1 = 0.0;

	// Acumuladores del tercer colchón
	public static int cantidadVentasColchon2 = 0;
	public static int cantidadVendidasColchon2 = 0;
	public static double totalAcumuladoColchon2 = 0.0;

	// Acumuladores del cuarto colchón
	public static int cantidadVentasColchon3 = 0;
	public static int cantidadVendidasColchon3 = 0;
	public static double totalAcumuladoColchon3 = 0.0;

	// Acumuladores del quinto colchón
	public static int cantidadVentasColchon4 = 0;
	public static int cantidadVendidasColchon4 = 0;
	public static double totalAcumuladoColchon4 = 0.0;

	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCosnultarColchón;
	private JMenuItem mntmModificarColchón;
	private JMenuItem mntmListadoDeColchones;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReporte;
	private JMenu mnConfiguración;
	private JMenuItem mntmConfiguraciónDeDescuentos;
	private JMenuItem mntmConfiguraciónDeObsequios;
	private JMenuItem mntmConfigurarCantidadÓptima;
	private JMenuItem mntmConfigurarPremioSorpresa;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	private JLabel lblFondoPrincipal;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tienda() {
		setResizable(false);
		setTitle("Tienda de Coclhones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		mnArchivo.setIcon(new ImageIcon(Tienda.class.getResource("/img/archivo.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('m');
		mnMantenimiento.setIcon(new ImageIcon(Tienda.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);

		mntmCosnultarColchón = new JMenuItem("Cosnultar Colchón");
		mntmCosnultarColchón.addActionListener(this);
		mnMantenimiento.add(mntmCosnultarColchón);

		mntmModificarColchón = new JMenuItem("Modificar Colchón");
		mntmModificarColchón.addActionListener(this);
		mnMantenimiento.add(mntmModificarColchón);

		mntmListadoDeColchones = new JMenuItem("Listado de Colchones");
		mntmListadoDeColchones.addActionListener(this);
		mnMantenimiento.add(mntmListadoDeColchones);

		mnVentas = new JMenu("Ventas");
		mnVentas.setMnemonic('v');
		mnVentas.setIcon(new ImageIcon(Tienda.class.getResource("/img/ventas.png")));
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mntmGenerarReporte = new JMenuItem("Generar Reporte");
		mntmGenerarReporte.addActionListener(this);
		mnVentas.add(mntmGenerarReporte);

		mnConfiguración = new JMenu("Configuración");
		mnConfiguración.setMnemonic('c');
		mnConfiguración.setIcon(new ImageIcon(Tienda.class.getResource("/img/configuraciones.png")));
		menuBar.add(mnConfiguración);

		mntmConfiguraciónDeDescuentos = new JMenuItem("Configuración de Descuentos");
		mntmConfiguraciónDeDescuentos.addActionListener(this);
		mnConfiguración.add(mntmConfiguraciónDeDescuentos);

		mntmConfiguraciónDeObsequios = new JMenuItem("Configuración de Obsequios");
		mntmConfiguraciónDeObsequios.addActionListener(this);
		mnConfiguración.add(mntmConfiguraciónDeObsequios);

		mntmConfigurarCantidadÓptima = new JMenuItem("Configurar Cantidad óptima");
		mntmConfigurarCantidadÓptima.addActionListener(this);
		mnConfiguración.add(mntmConfigurarCantidadÓptima);

		mntmConfigurarPremioSorpresa = new JMenuItem("Configurar Premio Sorpresa");
		mntmConfigurarPremioSorpresa.addActionListener(this);
		mnConfiguración.add(mntmConfigurarPremioSorpresa);

		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('a');
		mnAyuda.setIcon(new ImageIcon(Tienda.class.getResource("/img/ayuda.png")));
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFondoPrincipal = new JLabel("");
		lblFondoPrincipal.setIcon(new ImageIcon(Tienda.class.getResource("/img/fondoPrincipal.jpg")));
		lblFondoPrincipal.setBounds(0, 0, 1018, 660);
		contentPane.add(lblFondoPrincipal);

		// Cetnra la ventana
		this.setLocationRelativeTo(null);
	}

	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmAcercaDeTienda) {
			mntmAcercaDeTiendaActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmConfigurarPremioSorpresa) {
			mntmConfigurarPremioSorpresaActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmConfigurarCantidadÓptima) {
			mntmConfigurarCantidadÓptimaActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmConfiguraciónDeObsequios) {
			mntmConfiguraciónDeObsequiosActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmConfiguraciónDeDescuentos) {
			mntmConfiguraciónDeDescuentosActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmGenerarReporte) {
			mntmGenerarReporteActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			mntmVenderActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmListadoDeColchones) {
			mntmListadoDeColchonesActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmModificarColchón) {
			mntmModificarColchónActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCosnultarColchón) {
			mntmCosnultarColchónActionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			mntmSalirActionPerformed(arg0);
		}
	}

	// Controla el Evento de la opción "Salir"
	protected void mntmSalirActionPerformed(ActionEvent arg0) {
		// Cierra el sistema
		System.exit(0);
	}

	// Controla el Evento del la opción "Consultar Colchón"
	protected void mntmCosnultarColchónActionPerformed(ActionEvent arg0) {
		FrmConsultarColchon consultaColchon = new FrmConsultarColchon();
		consultaColchon.setLocationRelativeTo(this);
		consultaColchon.setVisible(true);
	}

	// Controla el Evento de la opción "Modificar Colchón"
	protected void mntmModificarColchónActionPerformed(ActionEvent arg0) {
		FrmModificarColchon modificaColchon = new FrmModificarColchon();
		modificaColchon.setLocationRelativeTo(this);
		modificaColchon.setVisible(true);
	}

	// Controla el Evento de la opción "Listado de Colchones"
	protected void mntmListadoDeColchonesActionPerformed(ActionEvent arg0) {
		FrmListadoColchones listaColchones = new FrmListadoColchones();
		listaColchones.setLocationRelativeTo(this);
		listaColchones.setVisible(true);
	}

	// Controla el Evento de la opción "Vender"
	protected void mntmVenderActionPerformed(ActionEvent arg0) {
		FrmVender venderColchon = new FrmVender();
		venderColchon.setLocationRelativeTo(this);
		venderColchon.setVisible(true);
	}

	// Controla el Evento de la opción "Reporte"
	protected void mntmGenerarReporteActionPerformed(ActionEvent arg0) {
		FrmGenerarReportes generaReportes = new FrmGenerarReportes();
		generaReportes.setLocationRelativeTo(this);
		generaReportes.setVisible(true);
	}

	// Controla el Evento de la opción "Configurar Descuentos"
	protected void mntmConfiguraciónDeDescuentosActionPerformed(ActionEvent arg0) {
		FrmConfigurarPorcentajeDescuento configuraDescuentos = new FrmConfigurarPorcentajeDescuento();
		configuraDescuentos.setLocationRelativeTo(this);
		configuraDescuentos.setVisible(true);
	}

	// Controla el Evento de la opción "Configurar Obsequios"
	protected void mntmConfiguraciónDeObsequiosActionPerformed(ActionEvent arg0) {
		FrmConfigurarObsequio configuraObsequio = new FrmConfigurarObsequio();
		configuraObsequio.setLocationRelativeTo(this);
		configuraObsequio.setVisible(true);
	}

	// Controla el Evento de la opción "Configurar Cantidad Óptima"
	protected void mntmConfigurarCantidadÓptimaActionPerformed(ActionEvent arg0) {
		FrmCantidadOptimaColchonesVendidos configurarCantidadOptima = new FrmCantidadOptimaColchonesVendidos();
		configurarCantidadOptima.setLocationRelativeTo(this);
		configurarCantidadOptima.setVisible(true);
	}

	// Controla el Evento de la opción "Configurar Premio Sorpresa"
	protected void mntmConfigurarPremioSorpresaActionPerformed(ActionEvent arg0) {
		FrmConfigurarPremioSorpresa configurarPremioSorpresa = new FrmConfigurarPremioSorpresa();
		configurarPremioSorpresa.setLocationRelativeTo(this);
		configurarPremioSorpresa.setVisible(true);
	}

	// Controla el Evento de la opción "Acerca de Tienda"
	protected void mntmAcercaDeTiendaActionPerformed(ActionEvent arg0) {
		FrmAcercaDeTienda acercaTienda = new FrmAcercaDeTienda();
		acercaTienda.setLocationRelativeTo(this);
		acercaTienda.setVisible(true);
	}
}
