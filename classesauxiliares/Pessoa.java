/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 * Copyright (c) 2024.
 * Ruin Mantel Die Oliver Prier
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import javax.swing.JTextField;

/**
 * Classe Pessoa
 *
 * @author Rui Pereira
 */
public class Pessoa implements Cidadao, Contribuinte {
    private Double CC;
    private Double NIF;
    private String Nome;
    private String Apelido;
    private LocalDate Nascimento;
    private char Sexo;
    private Period Idade;
    private Image Foto;

    /**
     * Constructor padrão
     *
     * @param cc            String
     * @param nif           String
     * @param nome          String
     * @param apelido       String
     * @param nascimento    String
     */
    public  Pessoa( String cc, String nif, String nome, String apelido, String nascimento, String sexo ) {
        setCC(cc);
        setNIF(nif);
        setNome(nome);
        setApelido(apelido);
        setNascimento(nascimento);
        setSexo(sexo);
    }
    
    /**
     * Constructor padrão
     *
     * @param cc            String
     * @param nif           String
     * @param nome          String
     * @param apelido       String
     * @param nascimento    String
     */
    public Pessoa( String cc, String nif, String nome, String apelido, String nascimento ) {
        setCC( cc );
        setNIF( nif );
        setNome( nome );
        setApelido( apelido );
        setNascimento( nascimento );
    }
    public Pessoa( String cc, String nif, String nome, String apelido, String nascimento, char sexo ) {
        setCC( cc );
        setNIF( nif );
        setNome( nome );
        setApelido( apelido );
        setNascimento( nascimento );
        setSexo( String.valueOf( sexo ) );
    }
    
    @Deprecated public Pessoa( JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento, JTextField sexo ){
        setCC( cc.getText() );
        setNIF(nif.getText() );
        setNome(nome.getText() );
        setApelido(apelido.getText() );
        setNascimento(nascimento.getText() );
        setSexo(sexo.getText().toString() );
    }
    public Pessoa( JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento, String sexo ){
        setCC( cc.getText() );
        setNIF( nif.getText() );
        setNome( nome.getText() );
        setApelido( apelido.getText() );
        setNascimento( nascimento.getText() );
        setSexo( sexo );
    }
    
    @Deprecated public Pessoa(JTextField cc, JTextField nif, JTextField nome, JTextField apelido, JTextField nascimento ){
        setCC( cc.getText() );
        setNIF( nif.getText() );
        setNome(nome.getText() );
        setApelido( apelido.getText() );
        setNascimento( nascimento.getText() );
    }
    public Pessoa(double cc, double nif, String nome, String apelido, LocalDate nascimento, String sexo, Blob b) {
        setCC( String.valueOf( cc ) );
        setNIF( String.valueOf( nif ) );
        setNome( nome );
        setApelido( apelido );
        setNascimento( String.valueOf(nascimento ));
        setSexo( String.valueOf( sexo ) );
        setFoto(b);
	}

	public Pessoa(double cc, double nif, String nome, String apelido, Date nascimento, String sexo, Blob b) {
        setCC( String.valueOf( cc ) );
        setNIF( String.valueOf( nif ) );
        setNome( nome );
        setApelido( apelido );
        setNascimento( String.valueOf(nascimento ));
        setSexo( String.valueOf( sexo ) );
        setFoto(b);
        // TODO Auto-generated constructor stub
	}

	/**
     * setter
     *
     * @param cc
     */
    public void setCC(String cc) {
        Cidadao.validarCC(cc);
         this.CC = Double.parseDouble(cc.substring(0, 8) );
    }

    public void setNIF(String nif) {
        Contribuinte.validarNIF(nif);
        this.NIF = Double.parseDouble(nif);
    }

    public void setNome(String nome) { this.Nome = nome;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    public void setNascimento(String nascimento) {
        try {
                Nascimento = LocalDate.parse(nascimento);
            setIdade();
        } 
        catch (Exception erro) {
            erro.printStackTrace();
            Nascimento = LocalDate.now();
        }
    }

    public void setSexo(String sexo) {
        this.Sexo = sexo.charAt(0);
    }

    private void setIdade() {
            Idade = Period.between(Nascimento, LocalDate.now());
    }

	public void setFoto(Blob blb) {
		try {
			byte[] byteS = blb.getBinaryStream().readAllBytes();
			this.Foto = Toolkit.getDefaultToolkit().createImage(byteS);
		} catch (IOException | SQLException e) { e.printStackTrace(); }
	}
	
	public void setFoto(BufferedImage fot) {
		this.Foto=fot;
	}
    /**
     * getter
     *
     * @return
     */
    public Double getCC() {
        return CC;
    }

    public Double getNIF() {
        return NIF;
    }

    public String getNome() {
        return Nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public LocalDate getNascimento() {
        return Nascimento;
    }

    public String getSexo() {
        return String.format(Locale.getDefault(), "%c", Sexo);
    }
    public Image getFoto() {
		return Foto.getScaledInstance( 50, 50, Image.SCALE_SMOOTH );
    }
    
    /**
     * Método getIdade
     *
     * @return
     */
    public Integer getIdade() {
        Integer i = 0;
        try {
        	i = Idade.getYears();
        } 
        catch (Exception erro) {
            erro.printStackTrace();
            i = -1;
        } finally { return i; }
    }

    /**
     * Método toArrayList
     *
     * @param lista
     * @return Pessoa
     * @throws IOException
     * @deprecated
     */
    @Deprecated
    public Pessoa fromArrayList(ArrayList<String> lista) throws IOException {
        try {
            setCC( lista.get(0) );
            setNIF( lista.get(1) );
            setNome( lista.get(2) );
            setApelido( lista.get(3) );
            setNascimento( lista.get(4) );
            setSexo( lista.get(5) );
            setIdade();
        } catch ( Exception erro ) {
            erro.printStackTrace();
            throw new IOException(erro.getMessage());
        } finally {
            return this;
        }
    }

    /**
     * Método toArrayList
     *
     * @return lista
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add( getCC().toString() );
        lista.add( getNIF().toString() );
        lista.add( getNome() );
        lista.add( getApelido());
        lista.add( getNascimento().toString() );
        lista.add( getIdade().toString() );
        lista.add( getSexo() );
        return lista;
    }

    /**
     * Método equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o; //Cast
        return Objects.equals(getSexo(), pessoa.getSexo()) && Objects.equals(getCC(), pessoa.getCC()) && Objects.equals(getNIF(), pessoa.getNIF()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getApelido(), pessoa.getApelido()) && Objects.equals(getNascimento(), pessoa.getNascimento()) && Objects.equals(getIdade(), pessoa.getIdade()) && Objects.equals(getSexo(), pessoa.getSexo()) ;
    }

    /**
     * Método hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCC(), getNIF(), getNome(), getApelido(), getNascimento(), getSexo(), getIdade());
    }

    /**
     * Método toString
     *
     * @return
     */

    @Override
    public String toString() {
        //return "Pessoa{" + "CC=" + getCC() + ", NIF=" + getNIF() + ", Nome='" + getNome() + ", Apelido='" + getApelido() + ", Nascimento=" + getNascimento() + ", Sexo=" + getSexo() + ", Idade=" + getIdade() + '}';
        return String.format( Locale.getDefault(),"CC=%s NIF=%s Nome=%s Apelido=%s Nascimento=%s Sexo=%s Idade=%d",getCC(),getNIF(),getNome(),getApelido(),getNascimento(),getSexo(),getIdade()  );
        //return new StringBuilder().append(getCC()).append(" ").append(getNIF()).append(" ").append(getNome()).append(" ").append(getApelido()).append(" ").append(getNascimento()).append(" ").append(getSexo()).append(" ").append(getIdade()).toString() ;
    }

    /**
     * Método toXML
     * @return
     */
    public String toXML(){
        return this.toXML();
    }
    /**
     * Método toJSON
     * @return
     */
    public String toJSON() {
        return this.toJSON();
    }
}

