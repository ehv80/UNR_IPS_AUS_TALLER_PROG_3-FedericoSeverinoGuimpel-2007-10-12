import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class ResultSetToVector {
	public static Vector<Vector<String>> getDatos(ResultSet r) {
		Vector<Vector<String>> datos = new Vector<Vector<String>>();
		try {
			ResultSetMetaData m = r.getMetaData();
			Vector<String> temp;
			int numColumnas = m.getColumnCount();
			while(r.next()){
				temp = new Vector<String>();
				for(int i=1; i<=numColumnas; i++)
					temp.add(r.getString(i));
				datos.add(temp);
			}
			return datos;
		} catch (SQLException e) {
			return null;
		}
	}

	public static Vector<String> getColumnas(ResultSet r) {
		Vector<String> datos = new Vector<String>();
		try {
			ResultSetMetaData m = r.getMetaData();
			int numColumnas = m.getColumnCount();
			for(int i=1; i<=numColumnas; i++)
					datos.add(m.getColumnName(i));
			return datos;
		} catch (SQLException e) {
			return null;
		}
	}
}