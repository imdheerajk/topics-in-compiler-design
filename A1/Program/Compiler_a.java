
import java.util.Scanner;


/**
 *
 * @author Dheeraj
 * 
 * Exercise 2.4.1: Construct recursive-descent parsers, 
 * S -> + SS | -SS | a
 */
public class Compiler_a {
    public static int index = 0; //GLOBAL VARIABLE FOR INDEX
    public static char [] user_string; //GLOBAL VARIABLE FOR STRING
    public static void main(String args[])
    {
        Compiler_a comp = new Compiler_a();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string according to the following grammar");
        System.out.println("S -> + SS | -SS | a");
        String ip_string = s.next(); //GET INPUT FROM USER
        user_string = ip_string.toCharArray(); //CONVERT THE INPUT TO CHARACTER ARRAY
        
        comp.s(user_string[index]); //CALL THE FUNCTION
        if (index < user_string.length) //IF THE FUNCTION DOES NOT PARSE THE ENTIRE STRING
        {
            System.out.println("Error in string");
        }
        else
        {
            System.out.println("The string is valid");
        }
    }
    
    public void s(char var)
    {
   
//        System.out.println("char "+ var);
        
        if (var == 'a') 
        {
            index++;    // MOVE THE POINTER TO THE NEXT CHARACTER OF STRING
        }
        else if (var == '+' || var == '-') 
        {
//            System.out.println("+ or -");
            index++;
//            System.out.println("inside +:"+ var);
            s(user_string[index]); //FUNCTION CALL
            s(user_string[index]); //FUNCTION CALL
           
        }
        else
        {
            System.out.println("Syntax error"); //IF STRING CONTAINS ANY OTHER SYMBOL OTHER THAN THE SPECIED IN GRAMMAR
        }    
    }
}
