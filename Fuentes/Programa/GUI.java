package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase Gui: Crea y diseña la interfaz grafica del programa.
 * @author Parra, Nadina y Diomedi, Antonela.
 * Proyecto Estructura de Datos - 2020.
 *
 */
public class GUI extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private Logica logica=new Logica();
	private JTextField textField_ValorTransaccion;
	private JTextField textField_Descripcion;
	private JTextField textField_montoABuscar;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/Programa/logo.png")));
		setTitle("Cuenta Bancaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 561, 374);
		contentPane.add(layeredPane);
		
		JPanel panel_OpCostosa = new JPanel();
		panel_OpCostosa.setBackground(new Color(176, 196, 222));
		panel_OpCostosa.setBounds(0, 0, 306, 259);
		panel_OpCostosa.setLayout(null);
		
		JLabel lblOpCostosa = new JLabel("Operaci\u00F3n m\u00E1s costosa");
		lblOpCostosa.setBounds(64, 11, 192, 31);
		lblOpCostosa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_OpCostosa.add(lblOpCostosa);
		
		JTextPane textPane_OpCostosa = new JTextPane();
		textPane_OpCostosa.setEditable(false);
		textPane_OpCostosa.setBounds(27, 55, 257, 151);
		panel_OpCostosa.add(textPane_OpCostosa);
		
		JPanel panel_OpHistorica = new JPanel();
		panel_OpHistorica.setBackground(new Color(176, 196, 222));
		panel_OpHistorica.setBounds(0, 0, 306, 259);
		panel_OpHistorica.setLayout(null);
		
		JLabel lblOpHistorica = new JLabel("Operaci\u00F3n m\u00E1s historica");
		lblOpHistorica.setBounds(64, 11, 188, 22);
		lblOpHistorica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_OpHistorica.add(lblOpHistorica);
		
		JTextPane txtpnTransaccionHistorica = new JTextPane();
		txtpnTransaccionHistorica.setEditable(false);
		txtpnTransaccionHistorica.setBounds(27, 55, 257, 151);
		txtpnTransaccionHistorica.setText("Valor: ******\r\n\r\n\r\nDescripci\u00F3n: ****************\r\n");
		panel_OpHistorica.add(txtpnTransaccionHistorica);
		
		JPanel panel_OpReciente = new JPanel();
		panel_OpReciente.setBackground(new Color(176, 196, 222));
		panel_OpReciente.setBounds(0, 0, 306, 259);
		panel_OpReciente.setLayout(null);
		
		JLabel lblOpReciente = new JLabel("Operaci\u00F3n m\u00E1s reciente");
		lblOpReciente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOpReciente.setBounds(64, 11, 192, 31);
		panel_OpReciente.add(lblOpReciente);
		
		JTextPane txtpnTransaccionReciente = new JTextPane();
		txtpnTransaccionReciente.setEditable(false);
		txtpnTransaccionReciente.setText("Valor: ******\r\n\r\n\r\nDescripci\u00F3n: ****************\r\n");
		txtpnTransaccionReciente.setBounds(27, 55, 257, 151);
		panel_OpReciente.add(txtpnTransaccionReciente);
		
		JPanel panel_NuevaTransaccion = new JPanel();
		panel_NuevaTransaccion.setBackground(new Color(176, 196, 222));
		panel_NuevaTransaccion.setBounds(0, 0, 306, 259);
		panel_NuevaTransaccion.setLayout(null);
		
		JLabel lblNuevaTransaccion = new JLabel("Nueva Transaccion");
		lblNuevaTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNuevaTransaccion.setBounds(89, 11, 148, 32);
		panel_NuevaTransaccion.add(lblNuevaTransaccion);
		
		JLabel lblValorTransaccion = new JLabel("Valor: $");
		lblValorTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorTransaccion.setBounds(38, 73, 48, 14);
		panel_NuevaTransaccion.add(lblValorTransaccion);
		
		textField_ValorTransaccion = new JTextField();
		textField_ValorTransaccion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char valido=e.getKeyChar();
				if((valido<'0' || valido>'9' )&& (valido<'.' || valido>'.') && (valido<'-' || valido>'-'))
					e.consume();
			}
		});
		textField_ValorTransaccion.setBounds(108, 72, 189, 20);
		panel_NuevaTransaccion.add(textField_ValorTransaccion);
		textField_ValorTransaccion.setColumns(10);
		
		JLabel lblDescripcionTransaccion = new JLabel("Descripci\u00F3n: ");
		lblDescripcionTransaccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcionTransaccion.setBounds(24, 113, 86, 14);
		panel_NuevaTransaccion.add(lblDescripcionTransaccion);
		
		textField_Descripcion = new JTextField();
		textField_Descripcion.setBounds(108, 113, 189, 23);
		panel_NuevaTransaccion.add(textField_Descripcion);
		textField_Descripcion.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(204, 225, 93, 23);
		panel_NuevaTransaccion.add(btnConfirmar);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		
		JPanel panel_Ingreso = new JPanel();
		panel_Ingreso.setBackground(new Color(70, 130, 180));
		panel_Ingreso.setBounds(0, 0, 564, 377);
		layeredPane.add(panel_Ingreso);
		panel_Ingreso.setLayout(null);
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(234, 185, 89, 23);
		panel_Ingreso.add(btnEntrar);
		
		JLabel lblContraseña = new JLabel("Ingrese contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContraseña.setBounds(202, 120, 164, 23);
		panel_Ingreso.add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(202, 154, 146, 20);
		panel_Ingreso.add(passwordField);
		
		JButton btnPassword = new JButton(new ImageIcon(GUI.class.getResource("/Programa/ojoPassword2.png")));
		btnPassword.setBounds(355, 157, 22, 14);
		panel_Ingreso.add(btnPassword);
		
		JPanel panel_Cuenta = new JPanel();
		panel_Cuenta.setBackground(new Color(70, 130, 180));
		panel_Cuenta.setBounds(0, 0, 564, 377);
		
		panel_Cuenta.setLayout(null);
		
		JPanel panel_Usuario = new JPanel();
		panel_Usuario.setBackground(new Color(176, 196, 222));
		panel_Usuario.setBounds(10, 11, 544, 85);
		panel_Cuenta.add(panel_Usuario);
		panel_Usuario.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenido.setBounds(20, 11, 120, 41);
		panel_Usuario.add(lblBienvenido);
		
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreUsuario.setBounds(20, 51, 159, 22);
		panel_Usuario.add(lblNombreUsuario);
		
		JLabel lblSaldo = new JLabel("Saldo Actual:");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSaldo.setBounds(385, 11, 102, 22);
		panel_Usuario.add(lblSaldo);
		
		JLabel lblValorSaldo = new JLabel(""+logica.saldo());
		lblValorSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorSaldo.setBounds(387, 42, 147, 37);
		panel_Usuario.add(lblValorSaldo);
		
		JPanel panel_Botones = new JPanel();
		panel_Botones.setBackground(new Color(176, 196, 222));
		panel_Botones.setBounds(10, 107, 228, 259);
		panel_Cuenta.add(panel_Botones);
		panel_Botones.setLayout(null);
		
		JButton btnNuevaTransaccion = new JButton("Realizar Transacci\u00F3n");
		btnNuevaTransaccion.setBounds(6, 5, 212, 23);
		panel_Botones.add(btnNuevaTransaccion);
		
		JButton btnOpMismoMonto = new JButton("Operaciones con mismo monto");
		btnOpMismoMonto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOpMismoMonto.setBounds(6, 235, 212, 23);
		panel_Botones.add(btnOpMismoMonto);
		
		JButton btnOpReciente = new JButton("Operaci\u00F3n m\u00E1s reciente");
		btnOpReciente.setBounds(6, 67, 212, 23);
		panel_Botones.add(btnOpReciente);
		
		JButton btnOpCostosa = new JButton("Operaci\u00F3n m\u00E1s costosa");
		btnOpCostosa.setBounds(6, 182, 212, 23);
		panel_Botones.add(btnOpCostosa);
		
		JButton btnOpHistorica = new JButton("Operaci\u00F3n m\u00E1s historica");
		btnOpHistorica.setBounds(6, 126, 212, 23);
		panel_Botones.add(btnOpHistorica);
		
		JLayeredPane layeredPane_Opciones = new JLayeredPane();
		layeredPane_Opciones.setBounds(248, 107, 306, 259);
		panel_Cuenta.add(layeredPane_Opciones);
		
		JPanel panel_OpMismoMonto = new JPanel();
		panel_OpMismoMonto.setBackground(new Color(176, 196, 222));
		panel_OpMismoMonto.setBounds(0, 0, 306, 259);
		panel_OpMismoMonto.setLayout(null);
		
		JLabel lblOpMismoMonto = new JLabel("Operaciones con mismo monto");
		lblOpMismoMonto.setBounds(45, 11, 220, 31);
		lblOpMismoMonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_OpMismoMonto.add(lblOpMismoMonto);
		
		JTextPane textPane_OpMismoMonto = new JTextPane();
		textPane_OpMismoMonto.setEditable(false);
		textPane_OpMismoMonto.setBounds(27, 97, 257, 151);
		panel_OpMismoMonto.add(textPane_OpMismoMonto);
		
		JScrollPane scrollPane = new JScrollPane(textPane_OpMismoMonto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(27, 97, 257, 151);
		panel_OpMismoMonto.add(scrollPane);
		
		JLabel lblMontoABuscar = new JLabel("Monto: $");
		lblMontoABuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMontoABuscar.setBounds(27, 63, 55, 14);
		panel_OpMismoMonto.add(lblMontoABuscar);
		
		textField_montoABuscar = new JTextField();
		textField_montoABuscar.setBounds(83, 61, 86, 20);
		panel_OpMismoMonto.add(textField_montoABuscar);
		textField_montoABuscar.setColumns(10);
		textField_montoABuscar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char valido=e.getKeyChar();
				if((valido<'0' || valido>'9' )&& (valido<'.' || valido>'.') && (valido<'-' || valido>'-') )
					e.consume();
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(195, 60, 80, 23);
		panel_OpMismoMonto.add(btnBuscar);
		
		JPanel panel_Imagen = new JPanel();
		panel_Imagen.setBackground(new Color(70, 130, 180));
		panel_Imagen.setBounds(0, 0, 306, 259);
		layeredPane_Opciones.add(panel_Imagen);
		panel_Imagen.setLayout(null);
		
		JLabel Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon(GUI.class.getResource("/Programa/logo.png")));
		Imagen.setBounds(10, 0, 296, 259);
		panel_Imagen.add(Imagen);
		
		
		btnNuevaTransaccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_NuevaTransaccion);
			}
		});
		
		btnOpReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_OpReciente);
				String transaccion=logica.opReciente();
				if (transaccion==null) 
					txtpnTransaccionReciente.setText("No se realizaron transacciones.");
				else
					txtpnTransaccionReciente.setText(transaccion);
			}
		});
		
		btnOpHistorica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_OpHistorica);
				String transaccion=logica.opHistorica();
				if (transaccion==null) 
					txtpnTransaccionHistorica.setText("No se realizaron transacciones.");
				else
					txtpnTransaccionHistorica.setText(transaccion);
			}
		});
		
		btnOpCostosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_OpCostosa);
				String transaccion=logica.opMasCostosa();
				if (transaccion==null) 
					textPane_OpCostosa.setText("No se realizaron transacciones.");
				else
					textPane_OpCostosa.setText(transaccion);
			}
		});
		
		btnOpMismoMonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_OpMismoMonto);
				textPane_OpMismoMonto.setText(null);
				textField_montoABuscar.setText(null);
			}
				
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_OpMismoMonto.setText(null);
				String transacciones=logica.opMismoMonto(textField_montoABuscar.getText());
				if (transacciones==null) 
					textPane_OpMismoMonto.setText("No se realizaron transacciones con ese monto.");
				else {
					textPane_OpMismoMonto.setText(transacciones);
				}
			}
		});
		
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getEchoChar()==0)
					passwordField.setEchoChar((char)'*');
				else
					passwordField.setEchoChar((char)0);
			}
		});
		
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo=passwordField.getText();
				if(logica.codigoAcceso(codigo)) {
					layeredPane.removeAll();
					layeredPane.add(panel_Cuenta);
					lblNombreUsuario.setText(logica.nombreUsuario().toUpperCase());
				}
				else {
					JOptionPane.showMessageDialog(null,"Contraseña invalida.","",JOptionPane.PLAIN_MESSAGE);
					passwordField.setText(null);
				}
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exito=logica.nuevaTransaccion(textField_ValorTransaccion.getText(), textField_Descripcion.getText());
				if(exito==0) {
					JOptionPane.showMessageDialog(null,"Transacción realizada con exito.","Transacción exitosa",JOptionPane.PLAIN_MESSAGE);
					lblValorSaldo.setText(logica.saldo());
				}
				else {
					JOptionPane.showMessageDialog(null,"No se puede realizar la extracción. Saldo insuficiente","Saldo insuficiente",JOptionPane.PLAIN_MESSAGE);
				}
				textField_ValorTransaccion.setText(null);
				textField_Descripcion.setText(null);
				layeredPane_Opciones.removeAll();
				layeredPane_Opciones.add(panel_Imagen);
			}
		});
	}
}
