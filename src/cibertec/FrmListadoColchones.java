package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class FrmListadoColchones extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtS;
	private JButton btnListar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;

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
					FrmListadoColchones dialog = new FrmListadoColchones();
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
	public FrmListadoColchones() {
		setModal(true);
		setResizable(false);
		setTitle("Listado de Colchones");
		setBounds(100, 100, 540, 440);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 11, 492, 330);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

		btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(FrmListadoColchones.class.getResource("/img/listar.png")));
		btnListar.addActionListener(this);
		btnListar.setBounds(171, 352, 87, 33);
		getContentPane().add(btnListar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(FrmListadoColchones.class.getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(270, 352, 91, 33);
		getContentPane().add(btnCerrar);

	}

	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			btnListarActionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}

	// Controla el evento de la opción "Listar"
	protected void btnListarActionPerformed(ActionEvent arg0) {
		imprimirListado();
	}

	// Controla el evento de la opción "Cerrar"
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}
	
	// Métodos
	void imprimirListado() {
		txtS.setText("                   Listado de Colchones" + "\n" + "\n");
		
		txtS.append("Marca       : " + Tienda.marca0 + "\n");
		txtS.append("Precio      : S/. " + Tienda.precio0 + "\n");
		txtS.append("Garantía    : " + Tienda.garantia0 + " años" + "\n");
		txtS.append("Tamaño      : " + Tienda.tamaño0 + "\n");
		txtS.append("Material    : " + Tienda.material0 + "\n" + "\n");
		
		txtS.append("Marca       : " + Tienda.marca1 + "\n");
		txtS.append("Precio      : S/. " + Tienda.precio1 + "\n");
		txtS.append("Garantía    : " + Tienda.garantia1 + " años" + "\n");
		txtS.append("Tamaño      : " + Tienda.tamaño1 + "\n");
		txtS.append("Material    : " + Tienda.material1 + "\n" + "\n");
		
		txtS.append("Marca       : " + Tienda.marca2 + "\n");
		txtS.append("Precio      : S/. " + Tienda.precio2 + "\n");
		txtS.append("Garantía    : " + Tienda.garantia2 + " años" + "\n");
		txtS.append("Tamaño      : " + Tienda.tamaño2 + "\n");
		txtS.append("Material    : " + Tienda.material2 + "\n" + "\n");
		
		txtS.append("Marca       : " + Tienda.marca3 + "\n");
		txtS.append("Precio      : S/. " + Tienda.precio3 + "\n");
		txtS.append("Garantía    : " + Tienda.garantia3 + " años" + "\n");
		txtS.append("Tamaño      : " + Tienda.tamaño3 + "\n");
		txtS.append("Material    : " + Tienda.material3 + "\n" + "\n");
		
		txtS.append("Marca       : " + Tienda.marca4 + "\n");
		txtS.append("Precio      : S/. " + Tienda.precio4 + "\n");
		txtS.append("Garantía    : " + Tienda.garantia4 + " años" + "\n");
		txtS.append("Tamaño      : " + Tienda.tamaño4 + "\n");
		txtS.append("Material    : " + Tienda.material4 + "\n" + "\n");
		
		txtS.setCaretPosition(0);
	}
}
