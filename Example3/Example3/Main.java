package Example3;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author u180105
 *
 */
public class Main {
	/**
	 * Parses a text file and displays the result as output in the console.
	 * 
	 * @param args	the text file to parse
	 */
	public static void main(String args[]) {
		FileReader fin = null;
		if ((args == null) || (args.length != 1)) {
			System.out.println("Usage: java test <input-file>");
			System.exit(-1);
		}
		try {
			fin = new FileReader(args[0]);

			Yylex lexer = new Yylex(fin);
			Token currentToken = null;
			while ((currentToken = lexer.yylex()).getTokenID() != Token.EOF)
				System.out.println(currentToken);

		} catch (IOException ioe) {
			System.out.println("Error opening input file: " + args[0]);
		} catch (Exception e) {
			System.out.println("Error analysing input: " + e.getMessage());
		} finally {
			try {
				fin.close();
			} catch (Exception e) {
			}
		}
	}
}
