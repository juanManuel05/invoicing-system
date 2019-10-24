package src.view;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import src.controllers.Cancelation;
import src.controllers.Exporting;
import src.controllers.Invoicing;

public class MainScreen {
    public void render(){
        
        printAction();
        final int option=getSelectedOption(); 
        doAction(option);
    }

    private void doAction(final int option){
        ExecutorService service = Executors.newFixedThreadPool(8);

        switch (option){
            case 1: 
                    Invoicing invoicing = new Invoicing();
                    invoicing.processPedidos();               
                    break;
            case 2: Cancelation cancelation = new Cancelation();
                    cancelation.cancelInvoices();
            case 3: Exporting exporting = new Exporting();
                    exporting.generateTxtFile();
        }
        render();
    }

    private void printAction() {
        System.out.println("Choose an option:");
        System.out.println("1: Invoicing");
        System.out.println("2: Cancel");
        System.out.println("3: Print txt");
        System.out.println("4: Close");
    }

    private int getSelectedOption() {
        final Scanner input = new Scanner(System.in);
        final String option = input.nextLine();

        while(!isValid(option)){
            getSelectedOption(); 
        }
        input.close();
        return Integer.parseInt(option);
    }

    private boolean isValid(String input){
         try {  
                final int inputInt = Integer.parseInt(input);
                return inputInt>0 && inputInt<=4;
    } catch(NumberFormatException e){  
        return false;  
    }  
    }
    
}