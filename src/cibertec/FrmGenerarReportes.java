package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmGenerarReportes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTipoDeReporte;
	private JComboBox<String> cboTipoReporte;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private static final String menor = "(menor que el precio promedio)";
	private static final String mayor = "(mayor o igual que el precio promedio)";
	private static final int numeroColchones = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGenerarReportes dialog = new FrmGenerarReportes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmGenerarReportes() {
		setTitle("Generar Reportes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 576, 309);
		getContentPane().setLayout(null);

		lblTipoDeReporte = new JLabel("Tipo de Reporte: ");
		lblTipoDeReporte.setBounds(10, 19, 84, 14);
		getContentPane().add(lblTipoDeReporte);

		cboTipoReporte = new JComboBox<String>();
		cboTipoReporte.addActionListener(this);
		cboTipoReporte.setModel(new DefaultComboBoxModel<String>(new String[] { "[Seleccione]", "Ventas por colchón",
				"Marcas con venta óptima", "Precios en relación al promedio", "Precio promedio, mayor y menor" }));
		cboTipoReporte.setBounds(104, 10, 331, 33);
		getContentPane().add(cboTipoReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmGenerarReportes.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(460, 10, 91, 33);
		getContentPane().add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 54, 536, 206);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

	}

	// Administrador de eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboTipoReporte) {
			cboTipoReporteActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}

	// Controla el evento del cboTipoReporte
	protected void cboTipoReporteActionPerformed(ActionEvent arg0) {
		int opcionReporte = cboTipoReporte.getSelectedIndex();

		switch (opcionReporte) {
		case 0:
			txtS.setText("");
			break;
		case 1:
			ventasPorColchon();
			break;
		case 2:
			marcasConVentaOptima();
			break;
		case 3:
			preciosRelacionPromedio();
			break;
		default:
			precioMenorPromedioMayor();
			break;
		}
		
		txtS.setCaretPosition(0);
	}

	// Controla el evento del botón cerrar
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// Métodos
	void ventasPorColchon() {
		txtS.setText("                     VENTAS POR COLCHÓN" + "\n" + "\n");
		txtS.append("Marca                                 : " + Tienda.marca0 + "\n");
		txtS.append("Cantidad de ventas                    : " + Tienda.cantidadVentasColchon0 + "\n");
		txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon0 + "\n");
		txtS.append("Importe total acumulado               : S/. " + Tienda.totalAcumuladoColchon0 + "\n" + "\n");

		txtS.append("Marca                                 : " + Tienda.marca1 + "\n");
		txtS.append("Cantidad de ventas                    : " + Tienda.cantidadVentasColchon1 + "\n");
		txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon1 + "\n");
		txtS.append("Importe total acumulado               : S/. " + Tienda.totalAcumuladoColchon1 + "\n" + "\n");

		txtS.append("Marca                                 : " + Tienda.marca2 + "\n");
		txtS.append("Cantidad de ventas                    : " + Tienda.cantidadVentasColchon2 + "\n");
		txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon2 + "\n");
		txtS.append("Importe total acumulado               : S/. " + Tienda.totalAcumuladoColchon2 + "\n" + "\n");

		txtS.append("Marca                                 : " + Tienda.marca3 + "\n");
		txtS.append("Cantidad de ventas                    : " + Tienda.cantidadVentasColchon3 + "\n");
		txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon3 + "\n");
		txtS.append("Importe total acumulado               : S/. " + Tienda.totalAcumuladoColchon3 + "\n" + "\n");

		txtS.append("Marca                                 : " + Tienda.marca4 + "\n");
		txtS.append("Cantidad de ventas                    : " + Tienda.cantidadVentasColchon4 + "\n");
		txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon4 + "\n");
		txtS.append("Importe total acumulado               : S/. " + Tienda.totalAcumuladoColchon4);

	}

	void marcasConVentaOptima() {

		int diferencia0 = Tienda.cantidadVendidasColchon0 - Tienda.cantidadOptima;
		int diferencia1 = Tienda.cantidadVendidasColchon1 - Tienda.cantidadOptima;
		int diferencia2 = Tienda.cantidadVendidasColchon2 - Tienda.cantidadOptima;
		int diferencia3 = Tienda.cantidadVendidasColchon3 - Tienda.cantidadOptima;
		int diferencia4 = Tienda.cantidadVendidasColchon4 - Tienda.cantidadOptima;

		if (diferencia0 >= 0 || diferencia1 >= 0 || diferencia2 >= 0 || diferencia3 >= 0 || diferencia4 >= 0) {
			// Si alguna marca tiene ventas mañores que la cantida óptima se imprime en el
			// reporte
			txtS.setText("                 MARCAS CON VENTA ÓPTIMA" + "\n");
			txtS.append("                    VENTA ÓPTIMA: " + Tienda.cantidadOptima + "\n" + "\n");

			if (diferencia0 >= 0) { // Verifica la marca 0
				txtS.append("Marca                                 : " + Tienda.marca0 + "\n");
				txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon0 + " ("
						+ diferencia0 + " más que la cantida óptima)" + "\n" + "\n");
			}

			if (diferencia1 >= 0) { // Verifica la marca 1
				txtS.append("Marca                                 : " + Tienda.marca1 + "\n");
				txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon1 + " ("
						+ diferencia1 + " más que la cantida óptima)" + "\n" + "\n");
			}

			if (diferencia2 >= 0) { // Verifica la marca 2
				txtS.append("Marca                                 : " + Tienda.marca2 + "\n");
				txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon2 + " ("
						+ diferencia2 + " más que la cantida óptima)" + "\n" + "\n");
			}

			if (diferencia3 >= 0) { // Verifica la marca 3
				txtS.append("Marca                                 : " + Tienda.marca3 + "\n");
				txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon3 + " ("
						+ diferencia3 + " más que la cantida óptima)" + "\n" + "\n");
			}

			if (diferencia4 >= 0) { // Verifica la marca 4
				txtS.append("Marca                                 : " + Tienda.marca4 + "\n");
				txtS.append("Cantidad total de unidades vendidas   : " + Tienda.cantidadVendidasColchon4 + " ("
						+ diferencia4 + " más que la cantida óptima)" + "\n" + "\n");
			}

		} else { // Si ninguna marca tiene mayor venta que la cantidad óptima
			txtS.setText("No existen marcas con venta óptima.");
		}
	}

	void preciosRelacionPromedio() {
		double sumaPrecios = Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4;
		double precioPromedio = sumaPrecios / numeroColchones;

		double diferencia0 = Tienda.precio0 - precioPromedio, diferencia1 = Tienda.precio1 - precioPromedio,
				diferencia2 = Tienda.precio2 - precioPromedio, diferencia3 = Tienda.precio3 - precioPromedio,
				diferencia4 = Tienda.precio4 - precioPromedio;

		String mensaje0, mensaje1, mensaje2, mensaje3, mensaje4;

		if (diferencia0 >= 0)
			mensaje0 = mayor;
		else
			mensaje0 = menor;
		if (diferencia1 >= 0)
			mensaje1 = mayor;
		else
			mensaje1 = menor;
		if (diferencia2 >= 0)
			mensaje2 = mayor;
		else
			mensaje2 = menor;
		if (diferencia3 >= 0)
			mensaje3 = mayor;
		else
			mensaje3 = menor;
		if (diferencia4 >= 4)
			mensaje4 = mayor;
		else
			mensaje4 = menor;

		txtS.setText("                 PRECIOS EN RELACIÓN AL PROMEDIO" + "\n");
		txtS.append("                   PRECIO PROMEDIO: S/. " + precioPromedio + "\n" + "\n");

		txtS.append("Nombre       : " + Tienda.marca0 + "\n");
		txtS.append("Precio       : S/. " + Tienda.precio0 + " " + mensaje0 + "\n" + "\n");

		txtS.append("Nombre       : " + Tienda.marca1 + "\n");
		txtS.append("Precio       : S/. " + Tienda.precio1 + " " + mensaje1 + "\n" + "\n");

		txtS.append("Nombre       : " + Tienda.marca2 + "\n");
		txtS.append("Precio       : S/. " + Tienda.precio2 + " " + mensaje2 + "\n" + "\n");

		txtS.append("Nombre       : " + Tienda.marca3 + "\n");
		txtS.append("Precio       : S/. " + Tienda.precio3 + " " + mensaje3 + "\n" + "\n");

		txtS.append("Nombre       : " + Tienda.marca4 + "\n");
		txtS.append("Precio       : S/. " + Tienda.precio4 + " " + mensaje4 + "\n" + "\n");
	}

	void precioMenorPromedioMayor() {
		double sumaPrecios = Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4;
		double precioPromedio = sumaPrecios / numeroColchones;
		double precioMenor = Tienda.precio0;
		double precioMayor = Tienda.precio0;

		// Calculando el precio menor
		if (precioMenor > Tienda.precio1)
			precioMenor = Tienda.precio1;
		if (precioMenor > Tienda.precio2)
			precioMenor = Tienda.precio2;
		if (precioMenor > Tienda.precio3)
			precioMenor = Tienda.precio3;
		if (precioMenor > Tienda.precio4)
			precioMenor = Tienda.precio4;

		// Calculando el precio mayor
		if (precioMayor < Tienda.precio1)
			precioMayor = Tienda.precio1;
		if (precioMayor < Tienda.precio2)
			precioMayor = Tienda.precio2;
		if (precioMayor < Tienda.precio3)
			precioMayor = Tienda.precio3;
		if (precioMayor < Tienda.precio4)
			precioMayor = Tienda.precio4;

		txtS.setText("                    PRECIO PROMEDIO, MENOR Y MAYOR" + "\n" + "\n");
		
		txtS.append("Precio promedio  : S/. " + precioPromedio + "\n");
		txtS.append("Precio menor     : S/. " + precioMenor + "\n");
		txtS.append("Precio mayor     : S/. " + precioMayor + "\n");
	}
}
