
/**
 * Author: Christian Vincent
 * Date: 10-30-18
 * Description: This program reads mathematical equations from a text file,
 * evaluates the equations, and writes the results to a separate text file.
 */

import java.io.*;
import java.util.*;

public class ReadFileLinebyLine {
    public static void main(String[] args) throws Exception {
        String line;
   
            try {
                Scanner input = new Scanner(new File("C:\\formulas.txt"));  
                PrintWriter output = new PrintWriter("C:\\results.txt");
                ArrayList<String> formula = new ArrayList<>();
                double result = 0;
                
                while(input.hasNextLine()) {
                    //read equations from formulas.txt
                    line = input.nextLine();
                    System.out.println("read <" + line + ">");
                    //Split String line into tokens by whitespace
                    String[] tokens = line.split(" ");
                    
                    //add individual tokens to ArrayList formula
                    formula.add(tokens[0]);
                    formula.add(tokens[1]);
                    formula.add(tokens[2]);
                    
                    if(!(tokens[1].matches("[*/+-]"))) 
                    {
                        System.out.println("Invalid equation!"); 
                    }
                    else
                    {
                        switch (tokens[1]) {
                            case "*":
                                result = Integer.valueOf(tokens[0]) * Integer.valueOf(tokens[2]);
                                break;
                            case "/":
                                result = Double.valueOf(tokens[0]) / Double.valueOf(tokens[2]);
                                break;
                            case "+":
                                result = Integer.valueOf(tokens[0]) + Integer.valueOf(tokens[2]);
                                break;
                            default:
                                result = Integer.valueOf(tokens[0]) - Integer.valueOf(tokens[2]);
                                break;
                        }
                        
                         System.out.println(formula.get(0) + ' ' + formula.get(1) + 
                            ' ' + formula.get(2) + " = " + result);
                         
                         //write result to result.txt file
                         output.println(result);
                    }
                    
                    formula.clear();
                }
                
                //close formulas.txt and result.txt files
                input.close();
                output.close();
            }
            catch(FileNotFoundException e) {
                System.out.println("FileNotFoundException: File not found!");
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException: Cannot"
                        + " access specified index of array.");
            }
       
            
        }
    }
    

