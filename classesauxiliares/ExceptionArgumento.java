/**
 * 
 */
package eclipseExercise.classesauxiliares;

import java.util.Locale;

/**
 * 
 */
public final class ExceptionArgumento extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ExceptionArgumento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ExceptionArgumento(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ExceptionArgumento(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionArgumento(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ExceptionArgumento(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public void printStackTrace(String msg) {
		super.getLocalizedMessage();
		super.getMessage();
		System.err.printf(Locale.getDefault() ,"\n %s \t %s" ,  msg, getStackTrace()) ;
	}
	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} */

}
