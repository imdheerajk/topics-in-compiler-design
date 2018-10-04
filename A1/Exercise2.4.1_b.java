
import java.util.Scanner;
/**
 *
 * @author Dheeraj
 */

public class Compiler_b {
    private int  bracketCounter;
    public static int array_index = 0;
    public static char [] user_string;
    public static void main(String args[]) throws ArrayIndexOutOfBoundsException
    {
        Compiler_b comp = new Compiler_b();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string according to the following grammar");
        System.out.println("S -> S '(' S ')' S | epsilon");
        String input_string = s.next(); //GET INPUT FROM USER
        user_string = input_string.toCharArray(); //CONVERT THE INPUT TO CHARACTER ARRAY
        
         for(char cc: user_string) // FOR LOOP TO ITERATE OVER THE STRING
         {
          comp.s(cc);
         }
         
         if(comp.bracketCounter !=0){
             System.out.println("Syntax error");  //IF ALL THE OPENING BRACKETS DOES NOT HAVE CLOSING
         } else {
             System.out.println("VALID STRING");  //IF ALL THE BRACKETS ARE PROPERLY CLOSED WITH PROPER GRAMMAR RULE
         }     
    }

    public void s(char c)  //FUNCTION TO CHECK THE PARANTHESIS
    {
        
        if(c=='(') //INCREMENT COUNTER IF THERE IS OPENING
        {
           bracketCounter++;
        }
        else if(c==')') //DECREMENT THE COUNTER IF THERE IS CLOSING
        {
           bracketCounter--;
           if(bracketCounter<0) //SYNTAX ERROR AS THE CLOSSING PARANTHESIS CANNOT BE AT START OF STRING
           {
               System.out.println("Syntax error :: else if");
           }
        }
        else{
            System.out.println("Synatx error :: else ");
        }
        
    }
 
}
