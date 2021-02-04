import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.ResultSet;

public class Conexion {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String urlBase = "jdbc:mysql://192.168.5.217/taller3";
	private static String usuario = "root";
	private static String password = "root";
	private static java.sql.Connection conexion = null;
	private static java.sql.Statement statement = null;
	
	public static void conectar(){
		if (conexion==null){
			try {
				Class.forName(driver);
				conexion = DriverManager.getConnection(urlBase,usuario,password);
				statement = conexion.createStatement();
			} catch (ClassNotFoundException e) {
				System.out.println("Problema, no hay driver.");
			} catch (SQLException e) {
				System.out.println("No se pudo conectar a la Base de Datos.");
			}
		}
	}

	public static void desconectar(){
		if(conexion!=null){
			try {
				statement.close();
				statement= null;
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//Agregar, Actualizar, Eliminar
	public static void OP(String s) throws SQLException{
		if(statement!=null)
				statement.executeUpdate(s);
	}

	public static ResultadoConsulta consulta(String s) throws SQLException{
		if(statement!=null)
			return new ResultadoConsulta(statement.executeQuery(s));
		return null;
	}
}