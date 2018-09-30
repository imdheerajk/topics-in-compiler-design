

import java.util.Scanner;
/**
 *
 * @author Dheeraj
 * 
 * Exercise 2.4.1: Construct recursive-descent parsers, 
 * S -> 0S1 | 01
 * we have converted this grammar to following as for input 0 we have two production so,
 * to avoid ambiguity we divide the above production to the below ones
 * S -> 0X
 * X -> S1 | 1
 */

public class Compiler_c {
    
    public static int array_index = 0;
    public static char [] user_string;
    
    
    public static void main(String args[]) throws ArrayIndexOutOfBoundsException
    {
        Compiler_c comp = new Compiler_c();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string according to the following grammar");
        System.out.println("S -> 0 S 1 | 0 1");
        String input_string = s.next(); //GET INPUT FROM USER
        user_string = input_string.toCharArray(); //CONVERT THE INPUT TO CHARACTER ARRAY
        
        try
        {
            comp.s(user_string[array_index]); //CALL THE FUNCTION
            if (array_index < user_string.length) //IF THE FUNCTION DOES NOT PARSE THE ENTIRE STRING
            {
                System.out.println("Error in string");
            }
            else
            {
                System.out.println("The string is valid");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in String");
        }
        
    }
    public void s(char var)
    {
        if (user_string[array_index] == '0')
        {
            array_index++;
            x(user_string[array_index]);
        }
        else
        {
            System.out.println("Syntax error1");
        }
    }
    public void x(char var)
    {
        if (var == '0')
        {
            s(user_string[array_index]);
            char check = user_string[array_index];
            if(check != '1')
            {
                System.out.println("Syntax error2");
            }
            array_index++;
            
        }
        else if (var == '1')
        {
            array_index++;
        }
        else
        {
            System.out.println("Syntax error3");
        }
        
    }
}
