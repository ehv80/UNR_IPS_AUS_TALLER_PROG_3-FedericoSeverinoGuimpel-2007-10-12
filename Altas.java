import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JComboBox;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.mysql.jdbc.Statement;
import com.sun.jndi.ldap.Connection;
import java.awt.Dimension;

public class Altas extends JInternalFrame {
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JComboBox jComboTpDeni = null;
	private JTextField jTexNombre = null;
	private JTextField jTextApellido = null;
	private JTextField jTextDni = null;
	private JTextField jTextEdad = null;
	private JButton jButtonGuardar = null;
	private JButton jButtonCerrar = null;

	public Altas() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(309, 173);
		this.setTitle("ALTAS de Datos");
		this.setClosable(true);
		this.setContentPane(getJContentPane());
	}

	/* cuadro con nombre, apellido...
	 * @return javax.swing.JPanel	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 75, 57, 19));
			jLabel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabel2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel2.setText("Edad: ");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 45, 57, 19));
			jLabel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabel1.setText("Apellido: ");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(15, 13, 57, 19));
			jLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jLabel.setText("Nombre: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTexNombre(), null);
			jContentPane.add(getJTextApellido(), null);
			jContentPane.add(getJTextDni(), null);
			jContentPane.add(getJTextEdad(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(getJComboTpDeni(), null);
		}
		return jContentPane;
	}

	/*Tipo de doc
	 * @return javax.swing.JComboBox	*/
	private JComboBox getJComboTpDeni() {
		if (jComboTpDeni == null) {
			jComboTpDeni = new JComboBox();
			jComboTpDeni.setBounds(new Rectangle(148, 75, 51, 19));
			jComboTpDeni.addItem("DNI");
			jComboTpDeni.addItem("LC");
			jComboTpDeni.addItem("LE");
		}
		return jComboTpDeni;
	}

	/*Nombre. @return javax.swing.JTextField	*/
	private JTextField getJTexNombre() {
		if (jTexNombre == null) {
			jTexNombre = new JTextField();
			jTexNombre.setBounds(new Rectangle(80, 13, 205, 19));
		}
		return jTexNombre;
	}

	/*Apellido. @return javax.swing.JTextField	*/
	private JTextField getJTextApellido() {
		if (jTextApellido == null) {
			jTextApellido = new JTextField();
			jTextApellido.setBounds(new Rectangle(80, 45, 205, 19));
		}
		return jTextApellido;
	}

	/* Dni. @return javax.swing.JTextField	*/
	private JTextField getJTextDni() {
		if (jTextDni == null) {
			jTextDni = new JTextField();
			jTextDni.setBounds(new Rectangle(206, 75, 79, 19));
		}
		return jTextDni;
	}

	/* Edad. @return javax.swing.JTextField	 */
	private JTextField getJTextEdad() {
		if (jTextEdad == null) {
			jTextEdad = new JTextField();
			jTextEdad.setBounds(new Rectangle(80, 75, 44, 19));
		}
		return jTextEdad;
	}

	/* GUARDAR. @return javax.swing.JButton	*/
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(15, 105, 92, 29));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Conexion conec= new Conexion();
						conec.conectar();
						conec.OP("INSERT INTO abm VALUES('"+ jTexNombre.getText() +"','" + jTextApellido.getText() + "','"+ (String) jComboTpDeni.getSelectedItem() +"','"+ jTextDni.getText() +"','"+ jTextEdad.getText() +"')");
						conec.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
				}
			});
		}
		return jButtonGuardar;
	}

	/* CERRAR. * @return javax.swing.JButton	*/
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setBounds(new Rectangle(192, 105, 92, 29));
			jButtonCerrar.setText("Cerrar");
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"