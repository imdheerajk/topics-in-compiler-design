/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lolcode_compiler;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Dheeraj
 */
//create token types as enum
enum token_type {
   IDENTIFIER, KEYWORD, SEPARATOR, OPERATOR, LITERAL, COMMENT
}
//To set the values of each token getter and setter methods
class lex_token
{
    private String Type;
    private String Value;
//GETTERS AND SETTER METHODS
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
    
    
    public lex_token(String Type, String Value)
    {
        this.Type = Type;
        this.Value = Value;
    }
    
    public lex_token(){
    }
//GETTING THE VALUES OF THE TOKEN AND PREPARING IT FOR DISPLAY
    @Override
    public String toString() {
        if (this.Type == "KEYWORD")
        return "(KEYWORD,"+ this.Value+")";
        
        
        
        else if(this.Type == "LIBRARY")
            return "(LIBRARY,"+ this.Value+")";
        
        else if(this.Type == "NUM")
            return "(NUM,"+ this.Value+")";
        
        else
            return "(IDENTIFIER,"+ this.Value+")";
    }
    
}
    

public class Lexical_analyzer {
  List<lex_token>  tokens= new ArrayList<>(); //ARRAY LIST FOR STORING THE LIST OF TOKEN GENERATED BY THE LEXICAL ANALYZER
   
    char nextChar;        
    String nextToken = "";
    lexemes token;
    int position = 0;        
    String currentLine;
    Scanner file;
    
    Lexical_analyzer(String fileName) throws FileNotFoundException  //CONSTRUCTOR FOR GETTING ALL THE LINES OF THE CODE INTO SINGLE LINE
    { 
        file = new Scanner(new File(fileName));
            currentLine = file.nextLine();
            
            while(file.hasNextLine())
            {
                
                currentLine =currentLine+ file.nextLine();

            }
            
           analzer(currentLine); //CALLING THE ANALYZER FUNCTION FOR PROCESSING THE STRING GENERARTED BY THE CONSTRUCTOR
            
    }
    protected final void analzer(String source_code)
    {
         String[] words = source_code.split(" ");  //CREATE ARRAY OF WORDS 
         
         int flag = 0;
         String check_string = "" ;
         for(String word: words)
         {
             word = word.trim(); //REMOVE UNWANTED SPACES FROM THE SOURCE CODE

             if(word.isEmpty()) //SKIP ANY EMPTY SPCAES
             {
                 continue;
             }
             char first = word.charAt(0);
             char last = word.charAt(word.length()-1);
//             System.out.println("first+ "+first+"--"+last);
            
            if(first == '"')  //CHECK FOR THE PRINT STATEMENTS
            {
                
                //check_string = word;
                flag = 1;
            }
            if(flag == 0)
            {
                    if(check_keyword(word)) //CHECK IF CURRENT WORD IS A KEYWORD
                     {

                        lex_token  lex= new lex_token();
                        lex.setType("KEYWORD");
                        lex.setValue(word);
                        tokens.add(lex);
                         //tokens.add("KEYWORD", word);
                     }
                     else if(check_library(word)) //CHECK IF THE WORD I LIBRARY OR NOT
                     {
                         if(word.charAt(word.length()-1) == '?')
                         {
                           
                             word = word.substring(0, word.length() - 1);
                             
                         }
                         lex_token  lex= new lex_token();
                          lex.setType("LIBRARY");
                         lex.setValue(word);
                         tokens.add(lex);
                         
                     }
                     else if (isNumeric(word)) //CHECK IS WORD IS NUMBER OR NOT
                     {
                         lex_token  lex= new lex_token();
                          lex.setType("NUM");
                         lex.setValue(word);
                         tokens.add(lex);
                     }
                     else  //EVERYTHING ELSE BESIDE ABOVE WILL BE IDENTIFIER
                     {
                       lex_token  lex= new lex_token();
                          lex.setType("IDENTIFIER");
                         lex.setValue(word);
                         tokens.add(lex);  
                     }
            }
            if(flag == 1)
            {
                if(last == '"')  //TO CREATE THE IDENTIFIER WHICH IS THE VISIBLE STATEMENT LIKE System.out.println in case of java
                {
                    check_string = check_string+" "+word;
                    lex_token  lex= new lex_token();
                              lex.setType("IDENTIFIER");
                             lex.setValue(check_string);
                             tokens.add(lex);
                    flag = 0;
                    check_string = "";
                }
                else
                {
                    check_string =check_string+" "+ word;
                }
            }
            
             
              //tokens.add(new Token(Type.TAIMES,subStr) );

         }
         
        for (lex_token t: tokens){
                  System.out.println(t.toString());
              }

    }
    public boolean check_keyword(String token) //ALL THE KEYWORDS DEFINES IN THE LEXEMES FILE AND COMPARED HERE
    {
        if(token.equalsIgnoreCase(lexemes.DOC_BEGIN)|| token.equalsIgnoreCase(lexemes.HAS)||
                token.equalsIgnoreCase(lexemes.SAEM)|| token.equalsIgnoreCase(lexemes.OF)||
                token.equalsIgnoreCase(lexemes.RLY)|| token.equalsIgnoreCase(lexemes.QUESTION)||
                token.equalsIgnoreCase(lexemes.A)|| token.equalsIgnoreCase(lexemes.AN)||
                token.equalsIgnoreCase(lexemes.DOC_END)|| token.equalsIgnoreCase(lexemes.SINGLE_COMMENT)||
                token.equalsIgnoreCase(lexemes.COMMENT_BEGIN)|| token.equalsIgnoreCase(lexemes.COMMENT_END)||
                token.equalsIgnoreCase(lexemes.LIBRARY_CHECK)|| token.equalsIgnoreCase(lexemes.BOTH_SAME_EXP)||
                token.equalsIgnoreCase(lexemes.BOTH_DIFF_EXP)|| token.equalsIgnoreCase(lexemes.BIGGER_COMP)||
                token.equalsIgnoreCase(lexemes.SMALLER_COMP)|| token.equalsIgnoreCase(lexemes.SUM)||
                token.equalsIgnoreCase(lexemes.DIFF)|| token.equalsIgnoreCase(lexemes.PRODUCT)||
                token.equalsIgnoreCase(lexemes.QUOTIENT)|| token.equalsIgnoreCase(lexemes.MOD)||
                token.equalsIgnoreCase(lexemes.SMOOSH)|| token.equalsIgnoreCase(lexemes.O)||
                token.equalsIgnoreCase(lexemes.YA)|| token.equalsIgnoreCase(lexemes.NO)||
                token.equalsIgnoreCase(lexemes.WAY)|| token.equalsIgnoreCase(lexemes.OIC)||
                token.equalsIgnoreCase(lexemes.WTF)|| token.equalsIgnoreCase(lexemes.OMGWTF)||
                token.equalsIgnoreCase(lexemes.OMG)|| token.equalsIgnoreCase(lexemes.GIMMEH_END)||
                token.equalsIgnoreCase(lexemes.VARIABLE_BEGIN)|| token.equalsIgnoreCase(lexemes.VARIABLE_CALL)||
                token.equalsIgnoreCase(lexemes.ITZ)||token.equalsIgnoreCase(lexemes.GIMMEH))
        {
           return true; 
        }
        else
        return false;
    }
    public boolean check_library(String token) //LIBRARY FILES METHOD
    {
        if(token.equalsIgnoreCase(lexemes.STDIO))
            return true;
        else
            return false;
    }
   
    public static boolean isNumeric(String str)  //CHECK IF WORD IS NUMERIC OR NOT
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }




    
}
