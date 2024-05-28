import java.util.Arrays;
import java.util.Scanner;

public class StockManagementSystem {

    static Scanner input = new Scanner(System.in);
    static String[] usernameArray = new String[1];
    static String[] passwordArray = new String[1];
    static final int MAX_SUPPLIERS = 100;
    static String[][] suppliers = new String[MAX_SUPPLIERS][2]; // index 0 == id and 1 == name
    static int supplierCount = 0;    
    
    public static void main(String[] args) {
        registerPage(input);
    }

    private static void registerPage(Scanner input) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                 REGISTER PAGE                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Create username : ");
        usernameArray[0] = input.next();

        System.out.print("Create password : ");
        passwordArray[0] = input.next();

        loginPage(input);

    }

    private static void loginPage(Scanner input) {

        clearConsole();

        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                 LOGIN PAGE                                 |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter username : ");
        String username = input.next();

       
        boolean flag = true;

        while (flag) {
           if (usernameArray[0].equals(username)) {
           
            System.out.print("Enter password : ");
            String password = input.next();    
           
            if (passwordArray[0].equals(password)) {
                flag = false;
                clearConsole();
                homePage(input);
              }else{
                System.out.println("password is incorrect. try again");
              }

           }else{
             System.out.println("username is incorrect. try again");
             System.out.print("Enter username : ");
             username = input.next();
           }
        }
    }
    private static void homePage(Scanner input){
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                    WECOME TO IJSE STOCK MANAGEMENT SYSTEM                  |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1]  Change the Credentials\t\t");
        System.out.println("[2]  Supplier Manage");
        System.out.print("[3]  Stock Manage\t\t\t");
        System.out.println("[4]  Log Out");
        System.out.println("[5]  Exit the System");

        boolean flag = true;
        
        System.out.print("\nEnter an option to continue > ");
        String choice = input.next();

        while (flag) {
            if (choice.equals("1")) {
                flag = false;
                clearConsole();
                changeTheCredentials(input);
            }else if(choice.equals("2")){
                flag = false;
                clearConsole();
                supplierManage(input);
            }else if(choice.equals("3")){
                flag = false;
                clearConsole();
                stockManage(input);
            }else if(choice.equals("4")){
                flag = false;
                loginPage(input);
            }else if(choice.equals("5")){
                flag = false;
                clearConsole();
                System.out.println("Bye bye !!!!.");
                System.exit(0);
            }else{
                System.out.println("Invalid Option. try again."); 
                System.out.print("\nEnter an option to continue > ");
                choice = input.next();
            }
        }
    }

    private static void changeTheCredentials(Scanner input){
       
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                             CREDENTIAL MANAGE                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean flag = true;

        System.out.print("Please enter the username to verify its' you : ");
        String username = input.next();

        while (flag) {
            boolean run = true;
            
            while (run) {
               
                if (usernameArray[0].equals(username)) {
                   
                    System.out.println("Hey "+username);
                    System.out.print("Enter your current password : ");
                    String curPassword = input.next();
                    boolean isCheck = true;

                        while (isCheck) {
                            if (passwordArray[0].equals(curPassword)) {
                          
                                System.out.print("Enter your new password : ");
                                String newPassword = input.next();
                                passwordArray[0] = newPassword;
                                isCheck = false;
                                run = false;
                               
                            }else{
                                System.out.print("incorrect password. try again!\n");
                                System.out.print("\nEnter your current password : ");
                                curPassword = input.next();
                            }
                        } 
                }else{
                    System.out.println("invalid username. try again!");
                    System.out.print("\nPlease enter the username to verify its' you : ");
                    username = input.next();
                }
            }
            System.out.print("Password change successfully! Do you want to go home page (y/n) : ");
            String option = input.next().toLowerCase();

           boolean isYes = true;

           while (isYes) {
             if (option.equals("y")) {
                isYes = false;
                clearConsole();
                homePage(input);
            }else if(option.equals("n")){
              flag = true;
            }else{
                System.out.print("Invalid option. try again. (y/n): ");
                option = input.next().toLowerCase();
            }
           }
        }
    }
    
    ///////////////////////////////     SUPPLIER MANAGEMENT     ///////////////////////////////      
    
    private static void supplierManage(Scanner input){
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                              SUPPLIER MANAGE                               |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1]  Add Supplier\t\t");
        System.out.println("[2]  Update Supplier");
        System.out.print("[3]  Delete Supplier\t\t");
        System.out.println("[4]  View Suppliers");
        System.out.print("[5]  Search Supplier\t\t");
        System.out.println("[6]  Home Page");

        System.out.print("\nEnter an option to continue > ");
        String choice = input.next();

        boolean flag = true;

        while (flag) {

            if (choice.equals("1")) {
                flag = false;
                clearConsole();
                addSupplier(input);
            }else if(choice.equals("2")){
                flag = false;
                clearConsole();
                updateSupplier(input);
            }else if(choice.equals("3")){
                flag = false;
                clearConsole();
                deleteSupplier(input);
            }else if(choice.equals("4")){
                flag = false;
                clearConsole();
                viewSupplier();
            }else if(choice.equals("5")){
                flag = false;
                clearConsole();
                serarchSupplier(input);
            }else if(choice.equals("6")){
                flag = false;
                clearConsole();
                homePage(input);
            }else{
                System.out.println("Invalid option.try again !\n");
                System.out.print("Enter an option to continue > ");
                choice = input.next();
            }
        }

    }

    private static void serarchSupplier(Scanner input) {
       
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               SEARCH SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        
        String supplierId;
        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("Supplier ID : ");
            supplierId = input.next();

            int supplierIndex = -1;

            for (int i = 0; i < supplierCount; i++) {
                if (suppliers[i][0] != null && suppliers[i][0].equals(supplierId)) {
                    supplierIndex = i;
                    break;
                }
            }

            if (supplierIndex == -1) {
                System.out.println("Can't find supplier id. try again!\n");
            }else{

                String suppName = suppliers[supplierIndex][1];
                System.out.println("Supplier Name : "+suppName);
            }

            System.out.print("Do you want to find another supplier (y/n)? : ");
            String choice = input.next().toLowerCase();

            System.out.println();

            boolean isRun = true;

            while (isRun) {
                if (choice.equals("y")) {
                    isRun = false;
                }else if(choice.equals("n")){
                    clearConsole();
                    supplierManage(input);
                }else{
                    System.out.print("Invalid Option! try agian. (y/n) : ");
                    choice = input.next().toLowerCase();
                    System.out.println("");
                }
            }
        }
    }

    private static void viewSupplier() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewSupplier'");
    }

    private static void deleteSupplier(Scanner input) {
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               DELETE SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();


    }

    private static void updateSupplier(Scanner input) {
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               UPDATE SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        
        String supplierId;
        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("Supplier ID : ");
            supplierId = input.next();

            int supplierIndex = -1;

            for (int i = 0; i < supplierCount; i++) {
                if (suppliers[i][0] != null && suppliers[i][0].equals(supplierId)) {
                    supplierIndex = i;
                    break;
                }
            }

            if (supplierIndex == -1) {
                System.out.println("Can't find supplier id. try again!");
            }else{

                String suppName = suppliers[supplierIndex][1];
                System.out.println("Supplier Name : "+suppName);
                System.out.print("\nEnter the new supplier name : ");
                String newSuppName = input.next();
                suppliers[supplierIndex][1] = newSuppName;

                System.out.print("Updated successfully.Do you want to update another supplier (y/n)? : ");
                String choice = input.next().toLowerCase();
                System.out.println();
                boolean isRun = true;

                while (isRun) {
                    if (choice.equals("y")) {
                        isRun = false;
                    }else if(choice.equals("n")){
                        clearConsole();
                        supplierManage(input);
                    }else{
                        System.out.print("Invalid Option! try again. (y/n) : ");
                        choice = input.next().toLowerCase();
                    }
                }
            }
        }

        
    }

    private static void addSupplier(Scanner input) {
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                ADD SUPPLIER                                |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        
        boolean flag = true;
        while (flag) {
            System.out.print("Enter Supplier ID: ");
            String id = input.next();
            
            if (containsSuppliertId(id)) {
                System.out.println("already exsists. try another supplier id.\n");

            }else{
              
                System.out.print("Enter supplier name : ");
                String name = input.next();
    
                suppliers[supplierCount][0] = id;
                suppliers[supplierCount][1] = name;
                supplierCount++;
    
                System.out.print("added successfully! Do you want to add another supplier (y/n)? ");
                String choice = input.next().toLowerCase();
                System.out.println();
                boolean isRun = true;
    
                while (isRun) {
                    if (choice.equals("y")) {
                       isRun = false;
                    }else if(choice.equals("n")){
                        isRun = true;
                        clearConsole();
                        supplierManage(input);
                    }else{
                        System.out.print("Invalid Option. try again. (y/n) : ");
                        choice = input.next(); 
                    }
                    System.out.println();
                }
            }
        }
    }

    /////////////////////////////       Stock Management Methods        /////////////////////////////////////
    private static void stockManage(Scanner input){
       
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                STOCK MANAGE                                |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        
    }
    
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // handle the exception
            System.err.println(e.getMessage());
        }
    }

    private static boolean containsSuppliertId(String supplierID) {
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0] != null && suppliers[i][0].equals(supplierID)) {
                return true;
            }
        }
        return false;
    }
}