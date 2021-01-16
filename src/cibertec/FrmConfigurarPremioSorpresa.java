package cibertec;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmConfigurarPremioSorpresa extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNúmeroDeCliente;
	private JLabel lblPremioSorpresa;
	private JTextField txtPremioSorpresa;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JTextField txtNumeroCliente;

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
					FrmConfigurarPremioSorpresa dialog = new FrmConfigurarPremioSorpresa();
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
	public FrmConfigurarPremioSorpresa() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar Premio Sorpresa");
		setBounds(100, 100, 349, 148);
		getContentPane().setLayout(null);

		lblNúmeroDeCliente = new JLabel("Número de Cliente: ");
		lblNúmeroDeCliente.setBounds(10, 11, 95, 14);
		getContentPane().add(lblNúmeroDeCliente);

		lblPremioSorpresa = new JLabel("Premio sorpresa: ");
		lblPremioSorpresa.setBounds(10, 36, 84, 14);
		getContentPane().add(lblPremioSorpresa);

		txtPremioSorpresa = new JTextField();
		txtPremioSorpresa.setBounds(115, 33, 165, 20);
		getContentPane().add(txtPremioSorpresa);
		txtPremioSorpresa.setColumns(10);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(FrmConfigurarPremioSorpresa.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(74, 68, 93, 33);
		btnGrabar.addActionListener(this);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmConfigurarPremioSorpresa.class.getResource("/img/cerrar.png")));
		btnCerrar.setBounds(177, 68, 91, 33);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);

		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setBounds(115, 8, 165, 20);
		getContentPane().add(txtNumeroCliente);
		txtNumeroCliente.setColumns(10);

		// Muestra los valores actuales
		txtNumeroCliente.setText(Tienda.numeroCLienteSorpresa + "");
		txtPremioSorpresa.setText(Tienda.premioSorpresa);

		// Reslata el primer porcentaje
		txtNumeroCliente.selectAll();
		txtNumeroCliente.requestFocus();
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
		String premioSorpresa;
		int numeroClienteSorpresa;

		// Entradas
		premioSorpresa = getPremioSorpresa();
		numeroClienteSorpresa = getNumeroClienteSorpresa();

		// Procesos
		if (premioSorpresa.length() > 0 && numeroClienteSorpresa > 0) {
			actualizarPremioSorpresa(numeroClienteSorpresa, premioSorpresa);
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
	int getNumeroClienteSorpresa() {
		int numeroClienteSorpresa = 0;

		try {
			if (Integer.parseInt(txtNumeroCliente.getText()) > 0) {
				numeroClienteSorpresa = Integer.parseInt(txtNumeroCliente.getText());
			} else {
				JOptionPane.showMessageDialog(this, "El número de cliente sorpresa debe ser un entero mayor que 0.",
						"Error de Ingreso", JOptionPane.ERROR_MESSAGE);
				txtNumeroCliente.selectAll();
				txtNumeroCliente.requestFocus();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese una número de cliente sorpresa válido.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
		}
		return numeroClienteSorpresa;
	}

	String getPremioSorpresa() {
		String premioSorpresa = "";
		if (txtPremioSorpresa.getText().length() > 0) {
			premioSorpresa = txtPremioSorpresa.getText();
		} else {
			JOptionPane.showMessageDialog(this, "El campo premioSorpresa no puede quedar vacío.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txtPremioSorpresa.requestFocus();
		}
		return premioSorpresa;
	}

	private void actualizarPremioSorpresa(int numeroClienteSorpresa, String premioSorpresa) {

		Tienda.numeroCLienteSorpresa = numeroClienteSorpresa;
		Tienda.premioSorpresa = premioSorpresa;

		JOptionPane.showMessageDialog(this, "Datos del premio sorpresa actualizados.", "Operación Exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
