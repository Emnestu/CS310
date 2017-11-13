package Example3;

/**
 * @author u180105
 *
 */
public class Token {

	public static final int RESERVED_WORD = 0;
	public static final int SPECIAL_CHARACTER = 1;
	public static final int IDENTIFIER = 2;
	public static final int INT_LITERAL = 3;
	public static final int FLT_LITERAL = 4;
	public static final int STR_LITERAL = 5;	

	public static final int EOF = -1;

	// public static final int IDENT = 10;
	// public static final int IF = 11;
	// public static final int INT = 12;
	// public static final int REAL = 13;

	private int tokenID;
	private Object value;

	/**
	 * Constructor for new Token object.
	 * 
	 * @param tokenID	the number that identifies the type of the token
	 * @param value		the contents of the token itself
	 */
	public Token(int tokenID, Object value) {
		this.tokenID = tokenID;
		this.value = value;
	}

	/**
	 * Getter method for the token number.
	 * 
	 * @return	the number that identifies the type of the token
	 */
	public int getTokenID() {
		return this.tokenID;
	}

	/**
	 * Getter method for the token contents.
	 * 
	 * @return	the contents of the token itself
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * Returns the internals of the Token object as a human-readable string.
	 * 
	 * @return	a string containing the number that identifies the type of the token and the contents of the token itself
	 */
	public String toString() {
		return "Token ID: |" + tokenID + "|" + " Token value: |" + value + "|";
	}
}
