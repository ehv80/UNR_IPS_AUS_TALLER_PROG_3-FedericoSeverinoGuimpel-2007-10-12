import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import java.awt.Font;

public class ABM extends JFrame {
	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;

	public ABM() {
		super();
		initialize();
	}
	private void initialize() {
		this.setSize(500, 300);
		this.setFont(new Font("Dialog", Font.PLAIN, 12));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJDesktopPane());
		this.setTitle("Administrador de Datos");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
			}
		});
	}

	/*This method initializes jDesktopPane	
	 * @return javax.swing.JDesktopPane	*/
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null)
			jDesktopPane = new JDesktopPane();
		return jDesktopPane;
	}

	/*This method initializes jJMenuBar	
	 * @return javax.swing.JMenuBar	*/
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/*This method initializes jMenu ABM menu
	 * @return javax.swing.JMenu	*/
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Menu");
			jMenu.setMnemonic(KeyEvent.VK_A);
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getJMenuItem2());
			jMenu.add(getJMenuItem3());
		}
		return jMenu;
	}

	/*This method initializes jMenuItem	ALTAS
	 * @return javax.swing.JMenuItem	*/
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Altas");
			jMenuItem.setMnemonic(KeyEvent.VK_A);
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] v=jDesktopPane.getAllFrames();
					boolean existeVentana=false;
					for(int i=0;i<v.length;i++){
						if (v[i]instanceof Altas){
							v[i].toFront();
							existeVentana=true;
						}
					}
					if(!existeVentana){ //Si NO existe la ventana, la creo
						Altas a=new Altas();
						jDesktopPane.add(a);
						a.setVisible(true);
					}
				}
			});
		}
		return jMenuItem;
	}

	/*This method initializes jMenuItem1 BAJAS
	 * @return javax.swing.JMenuItem	*/
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Bajas");
			jMenuItem1.setMnemonic(KeyEvent.VK_B);
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
						JInternalFrame[] v=jDesktopPane.getAllFrames();
						boolean existeVentana=false;
						for(int i=0;i<v.length;i++){
							if (v[i]instanceof Bajas){
								v[i].toFront();
								existeVentana=true;
							}
						}
						if(!existeVentana){ //Si NO existe la ventana, la creo
							Bajas a=new Bajas(jDesktopPane);
							jDesktopPane.add(a);
							a.setVisible(true);
						}
					}
				}
			);
		}
		return jMenuItem1;
	}

	/*This method initializes jMenuItem2 MODIFICACIONES	
	 * @return javax.swing.JMenuItem	*/
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setMnemonic(KeyEvent.VK_M);
			jMenuItem2.setText("Modificaciones");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] v=jDesktopPane.getAllFrames();
					boolean existeVentana=false;
					for(int i=0;i<v.length;i++){
						if (v[i]instanceof Modificaciones){
							v[i].toFront();
							existeVentana=true;
						}
					}
					if(!existeVentana){ //Si NO existe la ventana, la creo
						Modificaciones a=new Modificaciones(jDesktopPane);
						jDesktopPane.add(a);
						a.setVisible(true);
					}
				}
			});
		}
		return jMenuItem2;
	}

	/*This method initializes jMenuItem3 SALIR
	 * @return javax.swing.JMenuItem	*/
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Salir");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jMenuItem3;
	}

	public static void main(String[] args) {
		ABM m=new ABM();
		m.setExtendedState(JFrame.MAXIMIZED_BOTH);//Maximiza la ventana ABM
		m.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"