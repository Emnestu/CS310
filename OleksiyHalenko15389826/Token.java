package Example2;

/**
 * @author u180105
 *
 */
public class Token {

	public static final int IDENT = 10;
	public static final int IF = 11;
	public static final int INT = 12;
	public static final int REAL = 13;
	public static final int EOF = -1;

	private int tokenID;
	private Object value;

	/**
	 * Constructor for Token object.
	 * 
	 * @param tokenID	the token number to assign to the new object
	 * @param value		the value associated with the token number to assign to the new object
	 */
	public Token(int tokenID, Object value) {
		this.tokenID = tokenID;
		this.value = value;
	}

	/**
	 * Getter method for the token number.
	 * 
	 * @return	the token number of the object
	 */
	public int getTokenID() {
		return this.tokenID;
	}

	/**
	 * Getter method for the value associated with the token number.
	 * 
	 * @return	the value associated with the token number of the object
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * Returns the internals of the Token object as a human-readable string.
	 * 
	 * @return	a string containing the token number of the object and the value associated with the token number of the object
	 */
	public String toString() {
		return "Token ID: |" + tokenID + "|" + " Token value: |" + value + "|";
	}
}
