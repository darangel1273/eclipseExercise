/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.util.Scanner;

/**
 * 
 */
public class HelloWorld {
	private String atributo;
	
	
	/**
	 * 
	 */
	public HelloWorld(String atributo) {
		// TODO Auto-generated constructor stub
		setAtributo(atributo);
	}
	
	private HelloWorld() {
		// TODO Auto-generated constructor stub
		setAtributo("Olá Mundo");
	}

	public String getAtributo() {
		return atributo;
	}
	@SuppressWarnings("finally")
	public String pedeAtributo() {
		String p="";
		Scanner sc = new Scanner(System.in);
		try {
			p=sc.nextLine();
		}
		catch(Exception e) {
			e.printStackTrace();
			p="erro";
		}
		finally {
			sc.close();
			return p;
		}
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String a :args) {
			System.out.printf("\n %d %s", args.length , a  );
		}
		HelloWorld hw= new HelloWorld();
		
	}

}
