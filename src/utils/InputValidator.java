package src.utils;


public class InputValidator {

    public static boolean isValid(String input){
        try {  
            final int inputInt = Integer.parseInt(input);
            return inputInt>0 && inputInt<=4;
        } catch(NumberFormatException e){  
            return false;  
        }  
   }
    
}

