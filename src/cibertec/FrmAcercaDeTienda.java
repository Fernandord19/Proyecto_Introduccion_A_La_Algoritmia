package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAcercaDeTienda extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAutores;
	private JSeparator separator;
	private JLabel lblFernandoRevillaDaz;
	private JLabel lblCorreoFernandorevilladgmailcom;
	private JButton btnCerrar;
	private JLabel lblFoto;

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
					FrmAcercaDeTienda dialog = new FrmAcercaDeTienda();
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
	public FrmAcercaDeTienda() {
		setResizable(false);
		setModal(true);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 508, 345);
		getContentPane().setLayout(null);
		
		lblAutores = new JLabel("AUTORES");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAutores.setBounds(205, 11, 85, 22);
		getContentPane().add(lblAutores);
		
		separator = new JSeparator();
		separator.setBounds(23, 42, 448, 2);
		getContentPane().add(separator);
		
		lblFernandoRevillaDaz = new JLabel("Nombre: Fernando Revilla D\u00EDaz");
		lblFernandoRevillaDaz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFernandoRevillaDaz.setBounds(137, 49, 220, 20);
		getContentPane().add(lblFernandoRevillaDaz);
		
		lblCorreoFernandorevilladgmailcom = new JLabel("Correo: fernandorevillad@gmail.com");
		lblCorreoFernandorevilladgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreoFernandorevilladgmailcom.setBounds(116, 80, 262, 20);
		getContentPane().add(lblCorreoFernandorevilladgmailcom);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(203, 277, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(FrmAcercaDeTienda.class.getResource("/img/foto_perfil.png")));
		lblFoto.setBounds(190, 114, 115, 152);
		getContentPane().add(lblFoto);

	}
	
	// Administrador de Eventos ActionPerformed
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}
	
	// Controla el evento del botón Cerrar
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
