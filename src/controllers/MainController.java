package src.controllers;

import src.view.MainScreen;

public class MainController {

    public static void doAction(final int option){        

        switch (option){
            case 1: 
                    final Invoicing invoicing = new Invoicing();
                    invoicing.processPedidos();               
                    break;
            case 2: final Cancelation cancelation = new Cancelation();
                    cancelation.cancelInvoices();
                    break;
            case 3: final Exporting exporting = new Exporting();
                    exporting.generateTxtFile();
                    break;
            case 4: System.out.println("3: shutting down, bye!");
                    System.exit(0);
        }
        final MainScreen mainScreen = new MainScreen();
        mainScreen.render();
    }
    
}