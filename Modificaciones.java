import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JComboBox;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.mysql.jdbc.Statement;
import com.sun.jndi.ldap.Connection;
import java.awt.Dimension;

public class Modificaciones extends JInternalFrame {
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
	private JButton jButtonBuscar = null;
	private JDesktopPane j = null;

	public Modificaciones(JDesktopPane j) {
		super();
		this.j = j;
		initialize();
	}
	private void initialize() {
		this.setSize(309, 173);
		this.setTitle("Modificación de Datos");
		this.setClosable(true);
		this.setContentPane(getJContentPane());
	}

	/*This method initializes jContentPane
	 * @return javax.swing.JPanel	*/
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
			jContentPane.add(getJComboTpDeni(), null);
			jContentPane.add(getJTexNombre(), null);
			jContentPane.add(getJTextApellido(), null);
			jContentPane.add(getJTextDni(), null);
			jContentPane.add(getJTextEdad(), null);
			jContentPane.add(getJButtonGuardar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(getJButtonBuscar(), null);
		}
		return jContentPane;
	}

	/*This method initializes jComboTpDeni	
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

	/*This method initializes jTexNombre	
	 * @return javax.swing.JTextField	*/
	private JTextField getJTexNombre() {
		if (jTexNombre == null) {
			jTexNombre = new JTextField();
			jTexNombre.setBounds(new Rectangle(80, 13, 205, 19));
		}
		return jTexNombre;
	}

	/*This method initializes jTextApellido	
	 * @return javax.swing.JTextField	*/
	private JTextField getJTextApellido() {
		if (jTextApellido == null) {
			jTextApellido = new JTextField();
			jTextApellido.setBounds(new Rectangle(80, 45, 205, 19));
		}
		return jTextApellido;
	}

	/*This method initializes jTextDni	
	 * @return javax.swing.JTextField	*/
	private JTextField getJTextDni() {
		if (jTextDni == null) {
			jTextDni = new JTextField();
			jTextDni.setBounds(new Rectangle(206, 75, 79, 19));
		}
		return jTextDni;
	}

	/*This method initializes jTextEdad	
	 * @return javax.swing.JTextField	*/
	private JTextField getJTextEdad() {
		if (jTextEdad == null) {
			jTextEdad = new JTextField();
			jTextEdad.setBounds(new Rectangle(80, 75, 44, 19));
		}
		return jTextEdad;
	}

	/*This method initializes jButtonGuardar	
	 * @return javax.swing.JButton	*/
	private JButton getJButtonGuardar() {
		if (jButtonGuardar == null) {
			jButtonGuardar = new JButton();
			jButtonGuardar.setBounds(new Rectangle(15, 105, 81, 29));
			jButtonGuardar.setText("Guardar");
			jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Conexion.conectar();
						Conexion.OP("UPDATE abm SET nombre='"+ jTexNombre.getText() +"', apellido='"+ jTextApellido.getText() +"', tdoc='"+ (String) jComboTpDeni.getSelectedItem() +"', nDoc= '"+ jTextDni.getText() +"', edad='"+ jTextEdad.getText() +
											"' WHERE ndoc="+ jTextDni.getText() );
						Conexion.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
				}
			});
		}
		return jButtonGuardar;
	}

	/*This method initializes jButtonCerrar
	 * @return javax.swing.JButton	*/
	private JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setBounds(new Rectangle(203, 105, 81, 29));
			jButtonCerrar.setText("Cerrar");
			jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCerrar;
	}

	/*This method initializes jButtonBuscar
	 * @return javax.swing.JButton	*/
	private JButton getJButtonBuscar() {
		if (jButtonBuscar == null) {
			jButtonBuscar = new JButton();
			jButtonBuscar.setBounds(new Rectangle(109, 105, 81, 29));
			jButtonBuscar.setText("Buscar");
			jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String consulta = "SELECT * FROM abm ";
					if (!(jTexNombre.getText().equals(""))){
						consulta += "WHERE nombre = '" + jTexNombre.getText() + "'";
					}else if(!(jTextApellido.getText().equals(""))){
						consulta += "WHERE apellido = '" + jTextApellido.getText() + "'";
					}else if(!(jTextDni.getText().equals(""))){
						consulta += "WHERE ndoc = '" + jTextApellido.getText() + "'";
					}else if(!(jTextEdad.getText().equals(""))){
						consulta += "WHERE edad = '" + jTextApellido.getText() + "'";
					}
					try {
						Conexion.conectar();
						ResultadoConsulta res = Conexion.consulta(consulta);
						VentanaSeleccion v = new VentanaSeleccion(res,getEstaVentana());
						j.add(v);
						v.setVisible(true);
						Conexion.desconectar();
						setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return jButtonBuscar;
	}
	
	public Modificaciones getEstaVentana() {
		return this;
	}
	
	public void cargaDatos(Vector<String> datos){
		setVisible(true);
		jTexNombre.setText(datos.get(0));
		jTextApellido.setText(datos.get(1));
		jComboTpDeni.setSelectedItem(datos.get(2));
		jTextDni.setText(datos.get(3));
		jTextEdad.setText(datos.get(4));
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"