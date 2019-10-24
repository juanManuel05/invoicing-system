package src.view;
import java.util.Scanner;
import src.controllers.MainController;
import src.utils.InputValidator;;

public class MainScreen {

    public void render(){
        
        printOptions();
        final int option=getSelectedOption(); 
        MainController.doAction(option);
    }   

    private void printOptions() {
        System.out.println("Choose an option:");
        System.out.println("1: Invoicing");
        System.out.println("2: Cancel");
        System.out.println("3: Print txt");
        System.out.println("4: Close");
    }

    private int getSelectedOption() {
        final Scanner input = new Scanner(System.in);
        final String option = input.nextLine();

        while(!InputValidator.isValid(option)){
            getSelectedOption(); 
        }
        input.close();
        return Integer.parseInt(option);
    }    
    
}