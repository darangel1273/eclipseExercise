/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

/**
 * 
 */
public class MyDBHelper {
	private String controlador ="com.mysql.cj.jdbc.Driver";
	private String ponte = "jdbc";
	private String protocolo = "mysql";
	private String prefixo = "//";
	private String servidor = "ruin";
	private char dp = ':';
	private char bar = '/';
	private String bd = "contacto";
	private String porta = "3306";
	private String url = "jdbc:mysql://localhost:3306/contacto";
	private URL u ;
	private Connection ligar;
	private Properties info;
	private Statement sessao;
	private PreparedStatement sql ;
	private String comandoSQL = "SELECT cc,nif,nome,apelido,nascimento,sexo,morada,telefone,email,foto FROM `pessoa` ORDER BY nome;" ;
	private ResultSet res ;
	/**
	 * 
	 */
	public MyDBHelper() {
		// TODO Auto-generated constructor stub
		info = new Properties();
		info.put("user", "contacto"); info.put("password", "contacto");
		try {
			Class.forName(controlador) ;
			url =  ponte + dp + protocolo + dp +prefixo + servidor + dp + porta + bar + bd  ;
			ligar = DriverManager.getConnection(url, info ) ;
			sessao = ligar.createStatement();
		} catch ( ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Contacto> consultaContacto(){
		ArrayList<Contacto> contactoS = new ArrayList<Contacto>();
		 try {
			 
			res = sessao.executeQuery( comandoSQL ) ;
			while (res.next() ) {
				contactoS.add( new Contacto( res.getDouble("cc") , res.getDouble("nif" ) , res.getString("nome")  ,  res.getString("apelido") ,  res.getDate("nascimento") , 
						res.getString("sexo"), res.getString("morada") , res.getDouble("telefone") ,  res.getString("email" ) , res.getBlob("foto")  ) ) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.err.printf( Locale.getDefault() ,"%s"  , contactoS.toString() ) ;
			return contactoS;
		}
	}
	/**
	 * 
	 */
	public void close() {
		try {
			res.close();
			sql.close();
			ligar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
}











