package eclipseExercise.classesauxiliares;

/**
 * @author Ruin Mantel Die Oliver Prier
 * @param nif
 * @return
 */
public interface Contribuinte {
	static Boolean validarNIF( String nif ) {
	    final int max = 9;
	    //check if is numeric and has 9 numbers
	    if ( !nif.matches("[0-9]+" ) || nif.length() != max )
	        return false;
	    int checkSum = 0;
	    //calculate checkSum
	    for ( int i = 0; i < max - 1; i++ ) {
	        checkSum += ( nif.charAt( i ) - '0') * ( max - i );
	    }
	    int checkDigit = 11 - ( checkSum % 11 );
	    //if checkDigit is higher than 9 set it to zero
	    if ( checkDigit > 9 )
	        checkDigit = 0;
	    //compare checkDigit with the last number of NIF
	    return checkDigit == nif.charAt( max - 1 ) - '0';
	}
}