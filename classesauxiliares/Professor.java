/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JTextField;

/**
 * 
 */
public class Professor extends Contacto {

	/**
	 * @param cc
	 * @param nif
	 * @param nome
	 * @param apelido
	 * @param nascimento
	 * @param sx
	 * @param morada
	 * @param telefone
	 * @param email
	 */
	public Professor(JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento,
			String sx, JTextField morada, JTextField telefone, JTextField email) {
		super(cc, nif, nome, apelido, nascimento, sx, morada, telefone, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cc
	 * @param nif
	 * @param nome
	 * @param apelido
	 * @param nascimento
	 * @param sexo
	 * @param morada
	 * @param telefone
	 * @param email
	 * @param b
	 */
	public Professor(double cc, double nif, String nome, String apelido, LocalDate nascimento, String sexo,
			String morada, double telefone, String email, Blob b) {
		super(cc, nif, nome, apelido, nascimento, sexo, morada, telefone, email, b);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cc
	 * @param nif
	 * @param nome
	 * @param apelido
	 * @param nascimento
	 * @param sexo
	 * @param morada
	 * @param telefone
	 * @param email
	 * @param blob
	 */
	public Professor(double cc, double nif, String nome, String apelido, Date nascimento, String sexo, String morada,
			double telefone, String email, Blob blob) {
		super(cc, nif, nome, apelido, nascimento, sexo, morada, telefone, email, blob);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
