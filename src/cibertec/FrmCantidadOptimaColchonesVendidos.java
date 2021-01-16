package cibertec;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class FrmCantidadOptimaColchonesVendidos extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCantidadÓptima;
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
					FrmCantidadOptimaColchonesVendidos dialog = new FrmCantidadOptimaColchonesVendidos();
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
	public FrmCantidadOptimaColchonesVendidos() {
		setResizable(false);
		setModal(true);
		setTitle("Configurar Cantidad óptima de Colchones Vendidos");
		setBounds(100, 100, 351, 145);
		getContentPane().setLayout(null);

		lblCantidadÓptima = new JLabel("Cantidad óptima de colchones vendidos: ");
		lblCantidadÓptima.setBounds(10, 21, 196, 14);
		getContentPane().add(lblCantidadÓptima);

		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(FrmCantidadOptimaColchonesVendidos.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(71, 58, 93, 33);
		btnGrabar.addActionListener(this);
		getContentPane().add(btnGrabar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmCantidadOptimaColchonesVendidos.class.getResource("/img/cerrar.png")));
		btnCerrar.setBounds(174, 58, 91, 33);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(216, 18, 86, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		// Muestra los valores originales
		txtCantidad.setText(Tienda.cantidadOptima+"");

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
		int cantidadOptima;
		
		// Entradas
		cantidadOptima = getCantidadOptima();
		
		// Procesos
		if (cantidadOptima > 0) {
			actualizarCantidadOptimaColchonesVendidos(cantidadOptima);
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
	int getCantidadOptima(){
		int cantidadOptima = 0;
		
		try {
			if (Integer.parseInt(txtCantidad.getText()) > 0) {
				cantidadOptima = Integer.parseInt(txtCantidad.getText());
			} else {
				JOptionPane.showMessageDialog(this, "La cantidad óptima debe ser un entero mayor que 0.", "Error de Ingreso",
						JOptionPane.ERROR_MESSAGE);
				txtCantidad.selectAll();
				txtCantidad.requestFocus();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ingrese una cantidad óptima válida.", "Error de Ingreso",
					JOptionPane.ERROR_MESSAGE);
		}
		return cantidadOptima;
	}
	
	void actualizarCantidadOptimaColchonesVendidos(int cantidadOptima) {

		Tienda.cantidadOptima = cantidadOptima;

		// Salida
		JOptionPane.showMessageDialog(this, "Cantidad óptima actualizada.", "Operación Exitosa",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
