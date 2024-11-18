/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

/**
 * 
 */
public class MyDBHelper {
	private String controlador ="com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/contacto";
	private Connection ligar = null;
	private Properties info = null;
	private Statement sessao = null;
	private PreparedStatement sql = null;
	private String comandoSQL = "SELECT cc,nif,nome,apelido,nascimento,sexo morada,telefone,email,foto FROM `pessoa` ORDER BY nome;" ;
	private ResultSet res = null;
	/**
	 * 
	 */
	public MyDBHelper() {
		// TODO Auto-generated constructor stub
		info = new Properties();
		info.put("user", "contacto"); info.put("password", "contacto");
		try {
			Class.forName(controlador).newInstance() ;
			ligar = DriverManager.getConnection(url, info ) ;
			sessao = ligar.createStatement();
		} catch ( ClassNotFoundException |SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Contacto> consultaContacto(){
		ArrayList<Contacto> contactoS = new ArrayList<Contacto>();
		 try {
			res = sql.executeQuery( comandoSQL ) ;
			while (res.next() ) {
				contactoS.add( new Contacto( res.getDouble("cc") , res.getDouble("nif" ) , res.getString("nome")  ,  res.getString("apelido") ,  res.getDate("nascimento") , 
						res.getString("sexo"), res.getString("morada") , res.getDouble("telefone") ,  res.getString("email" ) , res.getBlob("foto")  ) ) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.printf(Locale.getDefault() ,"%s"  , contactoS.toString() ) ;
			return contactoS;
		}
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	

}
