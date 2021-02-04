import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;

public class ResultadoConsulta {
	Vector <Vector <String>> datos = null;
	Vector <String> nombreColumna = null;

	public ResultadoConsulta(ResultSet set) {
		datos = ResultSetToVector.getDatos(set);
		nombreColumna = ResultSetToVector.getColumnas(set);
	}

	public JTable getTable(){
		return new JTable(datos, nombreColumna);
	}
	
	public Vector<String>  getFila(int i) {
		return datos.get(i);
	}
}