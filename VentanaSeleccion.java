import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Dimension;

public class VentanaSeleccion extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private ResultadoConsulta res;
	private JButton jBtnSalir = null;
	private Modificaciones m= null;
	private Bajas b= null;

	/**
	 * This is the default constructor
	 * @param texNombre 
	 * @param r 
	 */


	public VentanaSeleccion(ResultadoConsulta res, Modificaciones m) {
		super();
		initialize();
		this.res=res;
		this.m = m;
    	jTable = res.getTable();
		jTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				getM().cargaDatos(getRes().getFila(jTable.getSelectedRow()));
				setVisible(false);
			}
		});
		jScrollPane.setViewportView(jTable);
	}

	public VentanaSeleccion(ResultadoConsulta res, Bajas b) {
		super();
		initialize();
		this.res=res;
		this.b = b;
    	jTable = res.getTable();
		jTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				getB().cargaDatos(getRes().getFila(jTable.getSelectedRow()));
				setVisible(false);
			}
		});
		jScrollPane.setViewportView(jTable);
	}

	public ResultadoConsulta getRes() {
		return this.res;
	}
	
	public Modificaciones getM() {
		return this.m;
	}

	public Bajas getB() {
		return this.b;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(324, 240);
		this.setContentPane(getJContentPane());
		this.setTitle("Busqueda");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJBtnSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(1, 3, 291, 165));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();

		}
		return jTable;
	}

	/**
	 * This method initializes jBtnSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJBtnSalir() {
		if (jBtnSalir == null) {
			jBtnSalir = new JButton();
			jBtnSalir.setBounds(new Rectangle(127, 176, 80, 22));
			jBtnSalir.setText("Cerrar");
			jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jBtnSalir;
	}

}  //  @jve:decl-index=0:visual-constraint="28,8"
