package lolcode_compiler;

import java.io.FileNotFoundException;

/**
 *
 * @author Dheeraj
 */
public class Lolcode_compiler {

    /**
     * @param args the command line arguments
     */
    public static String token;
    static Lexical_analyzer lexer;
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        token = "";
        String fileName = args[0]; //GET THR FILE FROM THE COMMAND LINE ARGUMENT

        //checks if there is only one 1 file
        if(args.length != 1) {
                System.err.println("ERROR: more than one file found"); //IF MORE THAN ONE FILE IS FOUND
                System.exit(0);			
        }

        if(!fileName.endsWith(".lol"))
        {
                System.err.println("ERROR: file is not in '.lol' format"); //IF THE FILE IS NOT IN THE .LOL FORMAT
                System.exit(0);	                    
        }
        lexer = new Lexical_analyzer(fileName);     
    }
    
}
