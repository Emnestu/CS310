package Example1;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;

public class Main 
{
    public static void main (String args[]) 
    {
       // Read in input
       FileReader fin = null;
       if ((args == null) || (args.length != 1)) {
          System.out.println ("Usage: java test <input-file>");
          System.exit (-1);
       }
       try {
          fin = new FileReader(args[0]);
          
          // Create an instance of the LA
          // Call the scanning method
          Alex lexer = new Alex (fin);
          lexer.alex();

       } catch (IOException ioe) {
           System.out.println ("Error opening input file: " + args[0]);
       } catch (Exception e) {
           System.out.println ("Error analysing input: " + e.getMessage());
       }
       finally {
           try { fin.close(); } catch (Exception e) {}
       }
    }
}
