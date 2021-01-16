package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class FrmConfigurarObsequio extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCantidadMnimaDe;
	private JLabel lblObsequio;
	private JTextField txtObsequio;
	private JButton btnGrabar;
	private JButton btnCerrar;
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
					FrmConfigurarObsequio dialog = new FrmConfigurarObsequio();
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
	public FrmConfigurarObsequio() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar Obsequio");
		setBounds(100, 100, 392, 144);
		getContentPane().setLayout(null);

		lblCantidadMnimaDe = new JLabel("Cantidad m\u00EDnima de colchones adquiridos");
		lblCantidadMnimaDe.setBounds(10, 11, 195, 14);
		getContentPane().add(lblCantidadMnimaDe);

		lblObsequio = new JLabel("Obsequio");
		lblObsequio.setBounds(10, 36, 46, 14);
		getContentPane().add(lblObsequio);

		txtObsequio = new JTextField();
		txtObsequio.setBounds(215, 33, 149, 20);
		getContentPane().add(txtObsequio);
		txtObsequio.setColumns(10);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(FrmConfigurarObsequio.class.getResource("/img/grabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(112, 65, 93, 33);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmConfigurarObsequio.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(213, 65, 91, 33);
		getContentPane().add(btnCerrar);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(215, 8, 149, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		// Muestra los valores originales
		txtCantidad.setText(Tienda.cantidadMinimaObsequiable + "");
		txtObsequio.setText(Tienda.obsequio + "");

		// Resalta el dato a modificar
		txtCantidad.selectAll();
		txtCantidad.requestFocus();
	}

	// Administrador de eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			btnGrabarActionPerformed(arg0);
		}
	}

	// Controla el evento de la opción "Grabar"
	protected void btnGrabarActionPerformed(ActionEvent arg0) {

		// Variables
		String obsequio;
		int cantidadMinimaObsequiable;

		// Entradas
		obsequio = getObsequio();
		cantidadMinimaObsequiable = getCantidadMinimaObsequiable();

		// Procesos
		if (obsequio.length() > 0 && cantidadMinimaObsequiable > 0) {
			configurarObsequio(cantidadMinimaObsequiable, obsequio);
		} else {
			JOptionPane.showMessageDialog(this, "No se puede modificar si hay errores de ingreso.", "Operación fallida",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Controla el evento de la opción "Cerrar"
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	// Métodos
	int getCantidadMinimaObsequiable() {
		int cantidadMinimaObsequiable = 0;

		try {
			if (Integer.parseInt(txtCantidad.getText()) > 0) {
				cantidadMinimaObsequiable = Integer.parseInt(txtCantidad.getText());
			} else {
				JOptionPane.showMessageDialog(this, "La cantidad mínima obsequiable debe ser un entero mayor que 0.",
						"Error de Ingreso", JOptionPane.ERROR_MESSAGE);
				txtCantidad.selectAll();
				txtCantidad.requestFocus();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad mínima obsequiable válida.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
		}
		return cantidadMinimaObsequiable;
	}

	String getObsequio() {
		String obsequio = "";
		if (txtObsequio.getText().length() > 0) {
			obsequio = txtObsequio.getText();
		} else {
			JOptionPane.showMessageDialog(this, "El campo obsequio no puede quedar vacío.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txtObsequio.requestFocus();
		}
		return obsequio;
	}

	void configurarObsequio(int cantidadMinimaObsequiable, String obsequio) {
		Tienda.cantidadMinimaObsequiable = cantidadMinimaObsequiable;
		Tienda.obsequio = obsequio;

		// Salida
		JOptionPane.showMessageDialog(this, "Datos del obsequio actualziados.", "Operación Exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
