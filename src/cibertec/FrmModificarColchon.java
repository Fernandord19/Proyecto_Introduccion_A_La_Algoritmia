package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmModificarColchon extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMarca;
	private JLabel lblPrecios;
	private JLabel lblGarantaaos;
	private JLabel lblTamao;
	private JLabel lblMaterial;
	private JTextField txtPrecio;
	private JTextField txtTamaño;
	private JTextField txtMaterial;
	private JComboBox<String> cboMarca;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JTextField txtGarantia;

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
					FrmModificarColchon dialog = new FrmModificarColchon();
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
	public FrmModificarColchon() {
		setResizable(false);
		setModal(true);
		setTitle("Modificar Colch\u00F3n");
		setBounds(100, 100, 524, 200);
		getContentPane().setLayout(null);

		lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(10, 11, 39, 16);
		getContentPane().add(lblMarca);

		lblPrecios = new JLabel("Precio (S/): ");
		lblPrecios.setBounds(10, 36, 63, 16);
		getContentPane().add(lblPrecios);

		lblGarantaaos = new JLabel("Garant\u00EDa (a\u00F1os): ");
		lblGarantaaos.setBounds(10, 61, 92, 16);
		getContentPane().add(lblGarantaaos);

		lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(10, 86, 46, 16);
		getContentPane().add(lblTamao);

		lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(10, 111, 43, 16);
		getContentPane().add(lblMaterial);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(102, 33, 227, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtTamaño = new JTextField();
		txtTamaño.setBounds(102, 83, 227, 20);
		getContentPane().add(txtTamaño);
		txtTamaño.setColumns(10);

		txtMaterial = new JTextField();
		txtMaterial.setBounds(102, 108, 227, 20);
		getContentPane().add(txtMaterial);
		txtMaterial.setColumns(10);

		cboMarca = new JComboBox<String>();
		cboMarca.addActionListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(
				new String[] { "[Seleccione]", "Suavestar", "Springwall", "Paraiso", "Drimer", "Cisne" }));
		cboMarca.setBounds(102, 8, 227, 20);
		getContentPane().add(cboMarca);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(FrmModificarColchon.class.getResource("/img/grabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(388, 11, 93, 33);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmModificarColchon.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(388, 53, 91, 33);
		getContentPane().add(btnCerrar);
		
		txtGarantia = new JTextField();
		txtGarantia.setBounds(102, 58, 227, 20);
		getContentPane().add(txtGarantia);
		txtGarantia.setColumns(10);

	}

	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			btnGrabarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
		if (arg0.getSource() == cboMarca) {
			cboMarcaActionPerformed(arg0);
		}
	}

	// Controla el evento del cboMarca
	protected void cboMarcaActionPerformed(ActionEvent arg0) {
		// Variables
		int marca;
		
		// Entradas
		marca = getMarca();
		
		// Procesos
		if (marca > 0) { // Si selecciona alguna marca
			listarPrecio(marca);
			listarGarantia(marca);
			listarTamaño(marca);
			listarMaterial(marca);
		} else { // Si selecciona [Seleccione]
			LimpiarTxt();
		}		
	}
	
	// Controla el evento de la opción "Grabar"
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		
		// Variables
		int marca, garantiaNueva;
		double precioNuevo;
		String tamañoNuevo, materialNuevo;
		
		// Entradas
		marca = getMarca();
		
		// Procesos
		if (marca > 0) { // Si selecciona una marca válida
			
			// Entradas
			garantiaNueva = getGarantiaNueva();
			precioNuevo = getPrecioNuevo();
			tamañoNuevo = getTamañoNuevo();
			materialNuevo = getMaterialNuevo();
			
			if (garantiaNueva > 0 && precioNuevo > 0.0 && tamañoNuevo.length() > 0 && materialNuevo.length() > 0) {
				modificarColchon(marca, precioNuevo, garantiaNueva, tamañoNuevo, materialNuevo);
			} else {
				JOptionPane.showMessageDialog(this, "No se puede modificar si hay errores de ingreso.", "Operación fallida",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			LimpiarTxt();
			JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	// Controla el evento de la opción "Cerrar"
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// Métodos
	int getMarca(){
		return cboMarca.getSelectedIndex();
	}
	
	double getPrecioNuevo(){
		double precioNuevo = 0.0;
		try {
			if (Double.parseDouble(txtPrecio.getText()) > 0) { // Si el precio es mayor que 0.0
				precioNuevo = Double.parseDouble(txtPrecio.getText()); // Asigna el valor a la variable
			} else{
				JOptionPane.showMessageDialog(this, "El precio debe ser un decimal mayor que 0.", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
				txtPrecio.selectAll();
				txtPrecio.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese un precio válido.", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
			txtPrecio.selectAll();
			txtPrecio.requestFocus();
		}
		
		return precioNuevo;
	}
	
	int getGarantiaNueva(){
		int garantiaNueva = 0;
		try {
			if (Integer.parseInt(txtGarantia.getText()) > 0) { // Si la garantía es mayor que 0
				garantiaNueva = Integer.parseInt(txtGarantia.getText()); // Asigna el valor a la variable
			} else {
				JOptionPane.showMessageDialog(this, "La garantía debe ser un entero mayor que 0.", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
				txtGarantia.selectAll();
				txtGarantia.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese una garantía válida.", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
			txtGarantia.selectAll();
			txtGarantia.requestFocus();
		}
		
		return garantiaNueva;
	}
	
	String getTamañoNuevo(){
		String tamañoNuevo = "";
		if (txtTamaño.getText().length() > 0){
			tamañoNuevo = txtTamaño.getText();
		} else {
			JOptionPane.showMessageDialog(this, "El campo tamaño no puede quedar vacío", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
			txtTamaño.requestFocus();
		}
		return tamañoNuevo;
	}
	
	String getMaterialNuevo(){
		String materialNuevo = "";
		if(txtMaterial.getText().length() > 0){
			materialNuevo = txtMaterial.getText();
		} else {
			JOptionPane.showMessageDialog(this, "El campo material no puede quedar vacío", "Error de Ingreso", JOptionPane.ERROR_MESSAGE);
			txtMaterial.requestFocus();
		}
		return materialNuevo;
	}
	
	void LimpiarTxt() {
		txtPrecio.setText("");
		txtGarantia.setText("");
		txtTamaño.setText("");
		txtMaterial.setText("");
	}

	void listarPrecio(int marca) {
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
			break;
		}
	}

	void listarGarantia(int marca) {
		switch (marca) {
		case 1:
			txtGarantia.setText(Tienda.garantia0 + "");
			break;
		case 2:
			txtGarantia.setText(Tienda.garantia1 + "");
			break;
		case 3:
			txtGarantia.setText(Tienda.garantia2 + "");
			break;
		case 4:
			txtGarantia.setText(Tienda.garantia3 + "");
			break;
		default:
			txtGarantia.setText(Tienda.garantia4 + "");
			break;
		}
	}

	void listarTamaño(int marca) {
		switch (marca) {
		case 1:
			txtTamaño.setText(Tienda.tamaño0);
			break;
		case 2:
			txtTamaño.setText(Tienda.tamaño1);
			break;
		case 3:
			txtTamaño.setText(Tienda.tamaño2);
			break;
		case 4:
			txtTamaño.setText(Tienda.tamaño3);
			break;
		default:
			txtTamaño.setText(Tienda.tamaño4);
			break;
		}
	}

	void listarMaterial(int marca) {
		switch (marca) {
		case 1:
			txtMaterial.setText(Tienda.material0);
			break;
		case 2:
			txtMaterial.setText(Tienda.material1);
			break;
		case 3:
			txtMaterial.setText(Tienda.material2);
			break;
		case 4:
			txtMaterial.setText(Tienda.material3);
			break;
		default:
			txtMaterial.setText(Tienda.material4);
			break;
		}
	}

	void modificarColchon(int marca, double precioNuevo, int garantiaNueva, String tamañoNuevo, String materialNuevo) {
		switch (marca) {
		case 1:
			Tienda.precio0 = precioNuevo;
			Tienda.garantia0 = garantiaNueva;
			Tienda.tamaño0 = tamañoNuevo;
			Tienda.material0 = materialNuevo;
			break;
		case 2:
			Tienda.precio1 = precioNuevo;
			Tienda.garantia1 = garantiaNueva;
			Tienda.tamaño1 = tamañoNuevo;
			Tienda.material1 = materialNuevo;
			break;
		case 3:
			Tienda.precio2 = precioNuevo;
			Tienda.garantia2 = garantiaNueva;
			Tienda.tamaño2 = tamañoNuevo;
			Tienda.material2 = materialNuevo;
			break;
		case 4:
			Tienda.precio3 = precioNuevo;
			Tienda.garantia3 = garantiaNueva;
			Tienda.tamaño3 = tamañoNuevo;
			Tienda.material3 = materialNuevo;
			break;
		default:
			Tienda.precio4 = precioNuevo;
			Tienda.garantia4 = garantiaNueva;
			Tienda.tamaño4 = tamañoNuevo;
			Tienda.material4 = materialNuevo;
		}
		
		// Salida
		JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.", "Operación Exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
