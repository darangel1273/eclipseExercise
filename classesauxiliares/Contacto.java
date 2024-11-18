/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JTextField;

/**
 * 
 */
public class Contacto extends Pessoa {

	    private List<String> Endereco;
	    private String Morada;
	    private String Telefone;
	    private String Email;

	    /**
	     * Default constructor
	     *
	     * @param morada
	     * @param telefone
	     * @param email
	     */
	    @Deprecated public Contacto(String cc, String nif, String nome, String apelido, String nascimento, String sexo,String morada, String telefone, String email ) throws IOException {
	        super( cc, nif, nome, apelido, nascimento, sexo );
	        setMorada( morada );
	        setTelefone( telefone );
	        setEmail( email );
	    }
	    /**
	     * Default constructor
	     *
	     * @param morada
	     * @param telefone
	     * @param email
	     */
	    @Deprecated public Contacto(JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento, JTextField morada, JTextField telefone, JTextField email ) throws IOException {
	        super( cc, nif, nome, apelido, nascimento );
	        setMorada( morada.getText() );
	        setTelefone( telefone.getText() );
	        setEmail( email.getText() );
	    }
	    /**
	     * Default constructor
	     *
	     * @param morada
	     * @param telefone
	     * @param email
	     */
	    public Contacto( JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento, String sx ,JTextField morada, JTextField telefone, JTextField email ) {
	        super( cc, nif, nome, apelido, nascimento, sx );
	        setMorada( morada.getText() );
	        setTelefone( telefone.getText() );
	        setEmail( email.getText() );
	    }

	    public Contacto(double cc, double nif, String nome, String apelido, LocalDate nascimento, String sexo, String morada, double telefone, String email, Blob b ) {
	    	super( cc, nif, nome, apelido, nascimento, sexo, b );
	        setMorada( morada );
	        setTelefone( String.valueOf( telefone ) );
	        setEmail( email );
			// TODO Auto-generated constructor stub
		}
	    
		public Contacto(double cc, double nif, String nome, String apelido, Date nascimento, String sexo, String morada, double telefone, String email, Blob blob) {
			super(cc, nif, nome, apelido, nascimento, sexo, blob);	// TODO Auto-generated constructor stub
	        setMorada( morada );
	        setTelefone( String.valueOf( telefone ) );
	        setEmail( email );
		}
		/**
	     * Getter method for the Morada attribute.
	     *
	     * @return address.locality
	     * address.adminArea
	     * address.postalCode
	     * address.countryName
	     */
	    public List<String> getEndereco() {
	        return Endereco;
	    }

	    /**
	     * Morada to String method.
	     * @author Ruin Mantel Die Oliver Prier
	     * @return moradaString String
	     * @see <a href="https://developer.android.com/reference/android/location/Address">Address</a>
	     * @see <a href="https://developer.android.com/reference/android/location/Geocoder">Geocoder</a>
	     */
	    public String moradaToString() {
	        //return Morada.get(0).getLocality() + ", " + Morada.get(0).getAdminArea() + ", " + Morada.get(0).getPostalCode() + ", " + Morada.get(0).getCountryName();
	        // return String.format( Locale.getDefault() , " Locale:%s Locality:%s AdminArea:%s PostalCode:%s CountryName:%s ",
	        //        this.Morada.get(0).getLocale(),this.Morada.get(0).getLocality(),this.Morada.get(0).getAdminArea(),
	        //        this.Morada.get(0).getPostalCode() , this.Morada.get(0).getCountryName() ) ;
	        StringBuilder s = new StringBuilder();
	        for ( String a: Endereco ){ s.append(" , " ) ; s.append(a );  }
	        return s.toString() ;
	    }

	    public String getTelefone() {
	        return Telefone;
	    }
	    public String getMorada() {
	        return this.Morada;
	    }

	    public String getEmail() {
	        return Email;
	    }

	    /**
	     * Setter method for the Morada attribute.
	     *
	     * @param morada address.locality
	     *               address.adminArea
	     *               address.postalCode
	     *               address.countryName
	     */
	    public void setMorada(String morada) {
	        this.Morada = morada;
	    }

	    public void setTelefone(String telefone) {
	    	this.Telefone = telefone;
	    }

	    public void setEmail(String email) {
	    	this.Email = email;
	    }

	    /**
	     * @param lista
	     * @return
	     * @throws IOException
	     */
	    @Override
	    @Deprecated public Pessoa fromArrayList(ArrayList<String> lista) throws IOException {
	        super.fromArrayList( lista );
	        setMorada( lista.get(7) );
	        setTelefone( lista.get(8) );
	        setEmail( lista.get(9) );
	        return this;
	    }

	    /**
	     * To ArrayList method.
	     * @return
	     */
	    public ArrayList<String> toArrayList() {
	        ArrayList<String> r = super.toArrayList();
		       // r.add( moradaToString() ); // Morada
		    r.add( getMorada() ); // Morada
	        r.add( getTelefone() ); // Telefone
	        r.add( getEmail() ); // Email
	        return r;
	    }

	    /**
	     * To String method.
	     *
	     * @return
	     */
	    @Override
	    public String toString() {
	        return super.toString() + "Contacto{" + "Morada=" + Morada + ", Telefone='" + Telefone + ", Email='" + Email + '}';
	    }

	    /**
	     * Equals method.
	     *
	     * @param o
	     * @return
	     */
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Contacto)) return false;
	        if (!super.equals(o)) return false;
	        Contacto contacto = (Contacto) o;
	        return Objects.equals(getMorada(), contacto.getMorada()) && Objects.equals(getTelefone(), contacto.getTelefone()) && Objects.equals(getEmail(), contacto.getEmail());
	    }

	    /**
	     * HashCode method.
	     * @return
	     */
	    @Override
	    public int hashCode() {
	        return Objects.hash(super.hashCode(), getMorada(), getTelefone(), getEmail());
	    }
	    /**
	     * Método toXML
	     * @return
	     */
	    public String toXML(){
	        return super.toXML() + this.toXML();
	    }
	    /**
	     *
	     * Método toJSON
	     * @return
	     */
	    public String toJSON() {
	        return super.toJSON() + this.toJSON();
	    }
	}
