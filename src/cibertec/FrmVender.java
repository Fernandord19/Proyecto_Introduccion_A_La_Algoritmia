package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmVender extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMarca;
	private JLabel lblPrecios;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtPrecio;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextField txtCantidad;
	

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
					FrmVender dialog = new FrmVender();
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
	public FrmVender() {
		setModal(true);
		setResizable(false);
		setTitle("Vender Colchones");
		setBounds(100, 100, 540, 331);
		getContentPane().setLayout(null);

		lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(10, 11, 36, 14);
		getContentPane().add(lblMarca);

		lblPrecios = new JLabel("Precio (S/.): ");
		lblPrecios.setBounds(10, 36, 61, 14);
		getContentPane().add(lblPrecios);

		lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(10, 61, 50, 14);
		getContentPane().add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.addActionListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(
				new String[] { "[Seleccione]", "Suavestar", "Springwall", "Paraiso", "Drimer", "Cisne" }));
		cboMarca.setBounds(94, 8, 151, 20);
		getContentPane().add(cboMarca);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(94, 33, 151, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 504, 182);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon(FrmVender.class.getResource("/img/vender.png")));
		btnVender.addActionListener(this);
		btnVender.setBounds(425, 7, 95, 33);
		getContentPane().add(btnVender);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmVender.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(425, 52, 91, 33);
		getContentPane().add(btnCerrar);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(94, 58, 151, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

	}

	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboMarca) {
			cboMarcaActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnVender) {
			btnVenderActionPerformed(arg0);
		}
	}

	// Controla el evento del cboMarca
	protected void cboMarcaActionPerformed(ActionEvent arg0) {
		// Variables
		int marca;

		// Entradas
		marca = getMarca();

		// Procesos
		if (marca > 0) {
			llenaPrecio(marca);
		} else {
			LimpiarTxt();
		}
	}

	// Controla el evento de la opción "Vender"
	protected void btnVenderActionPerformed(ActionEvent arg0) {
		// Variables
		int marca, cantidad;
		// Entradas
		marca = getMarca();

		// Procesos
		if (marca > 0) {
			cantidad = getCantidad();
			if (cantidad > 0) {
				vender(marca, cantidad);
			} else {
				JOptionPane.showMessageDialog(this, "No se puede vender si hay errores de ingreso.", "Operación fallida",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			LimpiarTxt();
			JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de la lista.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Controla el evento del botón "Cerrar"
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// Métodos
	int getMarca() {
		return cboMarca.getSelectedIndex();
	}

	double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	int getCantidad() {
		int cantidad = 0;
		try {
			if (Integer.parseInt(txtCantidad.getText()) > 0) { // Si la cantidad
																// es mayor que
																// 0
				cantidad = Integer.parseInt(txtCantidad.getText()); // Asigna el
																	// valor a
																	// la
																	// variable
			} else {
				JOptionPane.showMessageDialog(this, "La cantidad debe ser un entero mayor que 0.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txtCantidad.selectAll();
				txtCantidad.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txtCantidad.selectAll();
			txtCantidad.requestFocus();
		}

		return cantidad;
	}

	void LimpiarTxt() {
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtS.setText("");
	}

	void llenaPrecio(int marca) {
		switch (marca) {
		case 1:
			txtPrecio.setText(Tienda.precio0 + "");
			break;
		case 2:
			txtPrecio.setText(Tienda.precio1 + "");
			break;
		case 3:
			txtPrecio.setText(Tienda.precio2 + "");
			break;
		case 4:
			txtPrecio.setText(Tienda.precio3 + "");
			break;
		default:
			txtPrecio.setText(Tienda.precio4 + "");
		}
	}

	private void vender(int marca, int cantidad) {
		// Incrementa el contador de clientes atendidos
		Tienda.numeroCliente++;

		// Variables
		double precio, importeDescuento, importeCompra, porcentajeDescuento, importePagar;
		String obsequio, premioSorpresa;
		
		// Entradas 
		importeCompra =getImporteCompra(marca, cantidad);
		porcentajeDescuento = getPorcentajeDescuento(cantidad);
		importeDescuento = getImporteDescuento(porcentajeDescuento, importeCompra);
		obsequio = getObsequio(cantidad);
		premioSorpresa = getpremioSorpresa();
		precio = getPrecio();
		importePagar = importeCompra - importeDescuento;

		// Salidas
		txtS.setText("PRECIO               :S/." + precio + "\n");
		txtS.append("CANTIDAD             :" + cantidad + "\n");
		txtS.append("IMPORTE DE COMPRA    :S/." + importeCompra + "\n");
		txtS.append("IMPORTE DE DESCUENTO :S/." + importeDescuento + "\n");
		txtS.append("IMPORTE A PAGAR      :S/." + importePagar + "\n");
		txtS.append("OBSEQUIO             :" + obsequio + "\n");
		txtS.append("PREMIO SORPRESA      :" + premioSorpresa + "\n");

		// Actualiza los contadores y acumuladores del colchon
		contadores_Y_Acumuladores(marca, cantidad, importePagar);
	}

	double getImporteCompra(int marca, int cantidad) {
		double importeCompra = 0.0;
		
		switch (marca) {
		case 0:
			importeCompra = Tienda.precio0 * cantidad;
			break;
		case 1:
			importeCompra = Tienda.precio1 * cantidad;
			break;
		case 2:
			importeCompra = Tienda.precio2 * cantidad;
			break;
		case 3:
			importeCompra = Tienda.precio3 * cantidad;
			break;
		default:
			importeCompra = Tienda.precio4 * cantidad;
		}
		
		return importeCompra;
	}
	
	double getImporteDescuento(double porcentajeDescuento, double importeCompra) {
		return (porcentajeDescuento / 100 ) * importeCompra;
	}
	
	double getImportePagar(double importeCompra, double importeDescuento) {
		return importeCompra - importeDescuento;
	}
	
	double getPorcentajeDescuento(int cantidad) {
		double porcentajeDescuento = 0.0;

		// Calculando el descuento
		if (cantidad >= 1 && cantidad <= 5) {
			porcentajeDescuento = Tienda.porcentaje1;
		} else if (cantidad >= 6 && cantidad <= 10) {
			porcentajeDescuento = Tienda.porcentaje2;
		} else if (cantidad >= 11 && cantidad <= 15) {
			porcentajeDescuento = Tienda.porcentaje3;
		} else {
			porcentajeDescuento = Tienda.porcentaje4;
		}

		return porcentajeDescuento;
	}

	String getObsequio(int cantidad) {
		String obsequio = "No hay obsequio";

		// Verifica si corresponde obsequio
		if (cantidad >= Tienda.cantidadMinimaObsequiable) {
			obsequio = Tienda.obsequio;
		}

		return obsequio;
	}

	String getpremioSorpresa() {
		String premioSorpresa = "No hay premio sorpresa";

		// Verifica si corresponde premio sorpresa
		if (Tienda.numeroCliente == Tienda.numeroCLienteSorpresa) {
			premioSorpresa = Tienda.premioSorpresa;
		}

		return premioSorpresa;
	}

	void contadores_Y_Acumuladores(int marca, int cantidad, double importePagar) {
		switch (marca) {
		case 1:
			Tienda.cantidadVentasColchon0++;
			Tienda.cantidadVendidasColchon0 += cantidad;
			Tienda.totalAcumuladoColchon0 += importePagar;
			break;
		case 2:
			Tienda.cantidadVentasColchon1++;
			Tienda.cantidadVendidasColchon1 += cantidad;
			Tienda.totalAcumuladoColchon1 += importePagar;
			break;
		case 3:
			Tienda.cantidadVentasColchon2++;
			Tienda.cantidadVendidasColchon2 += cantidad;
			Tienda.totalAcumuladoColchon2 += importePagar;
			break;
		case 4:
			Tienda.cantidadVentasColchon3++;
			Tienda.cantidadVendidasColchon3 += cantidad;
			Tienda.totalAcumuladoColchon3 += importePagar;
			break;
		default:
			Tienda.cantidadVentasColchon4++;
			Tienda.cantidadVendidasColchon4 += cantidad;
			Tienda.totalAcumuladoColchon4 += importePagar;
		}
	}
}
