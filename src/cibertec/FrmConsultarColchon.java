package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmConsultarColchon extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMarca;
	private JLabel lblPrecios;
	private JLabel lblGarantaaos;
	private JLabel lblTamao;
	private JLabel lblMaterial;
	private JComboBox<String> cboMarca;
	private JTextField txtPrecio;
	private JTextField txtGarantia;
	private JTextField txtTamaño;
	private JTextField txtMaterial;
	private JButton btnCerrar;

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
					FrmConsultarColchon dialog = new FrmConsultarColchon();
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
	public FrmConsultarColchon() {
		setResizable(false);
		setModal(true);
		setTitle("Consultar Colch\u00F3n");
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

		lblTamao = new JLabel("Tama\u00F1o: ");
		lblTamao.setBounds(10, 86, 52, 16);
		getContentPane().add(lblTamao);

		lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(10, 111, 46, 16);
		getContentPane().add(lblMaterial);

		cboMarca = new JComboBox<String>();
		cboMarca.addActionListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<String>(
				new String[] { "[Seleccione]", "Suavestar", "Springwall", "Para\u00EDso", "Drimer", "Cisne" }));
		cboMarca.setBounds(133, 8, 227, 20);
		getContentPane().add(cboMarca);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(133, 33, 227, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtGarantia = new JTextField();
		txtGarantia.setEditable(false);
		txtGarantia.setBounds(133, 58, 227, 20);
		getContentPane().add(txtGarantia);
		txtGarantia.setColumns(10);

		txtTamaño = new JTextField();
		txtTamaño.setEditable(false);
		txtTamaño.setBounds(133, 83, 227, 20);
		getContentPane().add(txtTamaño);
		txtTamaño.setColumns(10);

		txtMaterial = new JTextField();
		txtMaterial.setEditable(false);
		txtMaterial.setBounds(133, 108, 227, 20);
		getContentPane().add(txtMaterial);
		txtMaterial.setColumns(10);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmConsultarColchon.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(405, 11, 91, 33);
		getContentPane().add(btnCerrar);

	}

	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboMarca) {
			cboMarcaActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}

	// Controla el Evento de la opción "Cerrar"
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		dispose();
	}

	// Controla el Evento del cboMarca
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
	
	// Métodos
	int getMarca(){
		return cboMarca.getSelectedIndex();
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
}
