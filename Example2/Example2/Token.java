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
	 * 
	 * 
	 * @param tokenID
	 * @param value
	 */
	public Token(int tokenID, Object value) {
		this.tokenID = tokenID;
		this.value = value;
	}

	/**
	 * @return
	 */
	public int getTokenID() {
		return this.tokenID;
	}

	/**
	 * @return
	 */
	public Object getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Token ID: |" + tokenID + "|" + " Token value: |" + value + "|";
	}
}
