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

public class FrmConfigurarPorcentajeDescuento extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl1A5;
	private JLabel lbl6A10;
	private JLabel lbl11A15;
	private JLabel lblMasDe15;
	private JTextField txt1A5;
	private JTextField txt6A10;
	private JTextField txt11A15;
	private JTextField txtMasDe15;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnGrabar;
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
					FrmConfigurarPorcentajeDescuento dialog = new FrmConfigurarPorcentajeDescuento();
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
	public FrmConfigurarPorcentajeDescuento() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar Porcentaje de Descuento");
		setBounds(100, 100, 420, 149);
		getContentPane().setLayout(null);

		lbl1A5 = new JLabel("1 a 5 unidades: ");
		lbl1A5.setBounds(10, 11, 77, 14);
		getContentPane().add(lbl1A5);

		lbl6A10 = new JLabel("6 a 10 unidades: ");
		lbl6A10.setBounds(10, 36, 83, 14);
		getContentPane().add(lbl6A10);

		lbl11A15 = new JLabel("11 a 15 unidades:");
		lbl11A15.setBounds(10, 61, 86, 14);
		getContentPane().add(lbl11A15);

		lblMasDe15 = new JLabel("M\u00E1s de 15 unidades: ");
		lblMasDe15.setBounds(10, 86, 102, 14);
		getContentPane().add(lblMasDe15);

		txt1A5 = new JTextField();
		txt1A5.setBounds(122, 8, 86, 20);
		getContentPane().add(txt1A5);
		txt1A5.setColumns(10);

		txt6A10 = new JTextField();
		txt6A10.setBounds(122, 33, 86, 20);
		getContentPane().add(txt6A10);
		txt6A10.setColumns(10);

		txt11A15 = new JTextField();
		txt11A15.setBounds(122, 58, 86, 20);
		getContentPane().add(txt11A15);
		txt11A15.setColumns(10);

		txtMasDe15 = new JTextField();
		txtMasDe15.setBounds(122, 83, 86, 20);
		getContentPane().add(txtMasDe15);
		txtMasDe15.setColumns(10);

		label = new JLabel("%");
		label.setBounds(218, 11, 11, 14);
		getContentPane().add(label);

		label_1 = new JLabel("%");
		label_1.setBounds(218, 36, 11, 14);
		getContentPane().add(label_1);

		label_2 = new JLabel("%");
		label_2.setBounds(218, 61, 11, 14);
		getContentPane().add(label_2);

		label_3 = new JLabel("%");
		label_3.setBounds(218, 86, 11, 14);
		getContentPane().add(label_3);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(FrmConfigurarPorcentajeDescuento.class.getResource("/img/grabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(301, 11, 93, 33);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmConfigurarPorcentajeDescuento.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(301, 52, 91, 33);
		getContentPane().add(btnCerrar);

		// Muestra los valores actuales
		txt1A5.setText(Tienda.porcentaje1 + "");
		txt6A10.setText(Tienda.porcentaje2 + "");
		txt11A15.setText(Tienda.porcentaje3 + "");
		txtMasDe15.setText(Tienda.porcentaje4 + "");

		// Reslata el primer porcentaje
		txt1A5.selectAll();
		txt1A5.requestFocus();
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
		double porcentaje1, porcentaje2, porcentaje3, porcentaje4;

		// Entradas
		porcentaje1 = getPorcentaje1();
		porcentaje2 = getPorcentaje2();
		porcentaje3 = getPorcentaje3();
		porcentaje4 = getPorcentaje4();

		// Procesos

		if (porcentaje1 >= 0.0 && porcentaje2 >= 0.0 && porcentaje3 >= 0.0 && porcentaje4 >= 0.0) {
			actualizarPorcentajesDescuento(porcentaje1, porcentaje2, porcentaje3, porcentaje4);
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
	double getPorcentaje1() {
		double porcentaje1 = -1;
		try {
			if (Double.parseDouble(txt1A5.getText()) >= 0.0 && Double.parseDouble(txt1A5.getText()) <= 10) {
				porcentaje1 = Double.parseDouble(txt1A5.getText());
			} else {
				JOptionPane.showMessageDialog(this,
						"El porcentaje 1 debe ser mayor o igual que 0 y menor o igual que 10.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txt1A5.selectAll();
				txt1A5.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el porcentaje 1.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txt1A5.selectAll();
			txt1A5.requestFocus();
		}
		return porcentaje1;
	}

	double getPorcentaje2() {
		double porcentaje2 = -1;
		try {
			if (Double.parseDouble(txt6A10.getText()) >= 0.0 && Double.parseDouble(txt6A10.getText()) <= 20) {
				porcentaje2 = Double.parseDouble(txt6A10.getText());
			} else {
				JOptionPane.showMessageDialog(this,
						"El porcentaje 2 debe ser mayor o igual que 0 y menor o igual que 20.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txt6A10.selectAll();
				txt6A10.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el porcentaje 2.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txt6A10.selectAll();
			txt6A10.requestFocus();
		}
		return porcentaje2;
	}

	double getPorcentaje3() {
		double porcentaje3 = -1;
		try {
			if (Double.parseDouble(txt11A15.getText()) >= 0.0 && Double.parseDouble(txt11A15.getText()) <= 30) {
				porcentaje3 = Double.parseDouble(txt11A15.getText());
			} else {
				JOptionPane.showMessageDialog(this,
						"El porcentaje 3 debe ser mayor o igual que 0 y menor o igual que 30.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txt11A15.selectAll();
				txt11A15.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el porcentaje 3.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txt11A15.selectAll();
			txt11A15.requestFocus();
		}
		return porcentaje3;
	}

	double getPorcentaje4() {
		double porcentaje4 = -1;
		try {
			if (Double.parseDouble(txtMasDe15.getText()) >= 0.0 && Double.parseDouble(txtMasDe15.getText()) <= 50) {
				porcentaje4 = Double.parseDouble(txtMasDe15.getText());
			} else {
				JOptionPane.showMessageDialog(this,
						"El porcentaje 4 debe ser mayor o igual que 0 y menor o igual que 50.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txtMasDe15.selectAll();
				txtMasDe15.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese un valor válido para el porcentaje 4.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
			txtMasDe15.selectAll();
			txtMasDe15.requestFocus();
		}
		return porcentaje4;
	}

	private void actualizarPorcentajesDescuento(double porcentaje1, double porcentaje2, double porcentaje3,
			double porcentaje4) {

		Tienda.porcentaje1 = porcentaje1;
		Tienda.porcentaje2 = porcentaje2;
		Tienda.porcentaje3 = porcentaje3;
		Tienda.porcentaje4 = porcentaje4;

		// Salida
		JOptionPane.showMessageDialog(this, "Porcentajes Actualizados.", "Operación Exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
