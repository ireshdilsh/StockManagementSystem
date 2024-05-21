import java.util.Scanner;

public class StockManagementSystem {

    // clearConsole method
    
    public final static void clearConsole() {
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

    // register page

    public static void registerPage() {

        Scanner input = new Scanner(System.in);

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n");

        System.out.println("|\t\t   REGISTER PAGE \t\t   |");

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n\n");

        final String[] usernameArray = new String[1];
        final String[] passwordArray = new String[1];

        System.out.print("Create Username : ");
        String useString = input.next();
        usernameArray[0] = useString;

        System.out.print("Create Password : ");
        String passString = input.next();
        passwordArray[0] = passString;

        clearConsole();

        gotoLoginPage(usernameArray, passwordArray);

    }

    public static void gotoLoginPage(String[] usernameArray, String[] passwordArray) {

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n");

        System.out.println("|\t\t     LOGIN PAGE \t\t   |");

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Username : ");
        String username = input.next();

        System.out.print("Password : ");
        String password = input.next();

        if (username.equals(usernameArray[0]) && password.equals(passwordArray[0])) {
            clearConsole();
            gotoHomepage(usernameArray, passwordArray);

        } else {
            System.out.println("Your username or password incorrect.Please try again.");
            gotoLoginPage(usernameArray, passwordArray);
        }
    }

    // changeCredentials method

    public static void changeCredentials(String[]usernameArray,String[]passwordArray) {
        
        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n");

        System.out.println("|\t\tCREDENTIAL MANAGE\t\t   |");

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Current Username : ");
        String currentUsername = input.next();

        System.out.print("Enter Current Password : ");
        String currentPassword = input.next();

        if (currentUsername.equals(usernameArray[0])) {
            System.out.print("Enter New Username : ");
            String newUsername = input.next();
            usernameArray[0] = newUsername;
        }else{
            System.out.println("Your username incorrect.Please try again.");
        }

        if (currentPassword.equals(passwordArray[0])) {
            System.out.print("Enter New Password : ");
            String newPassword = input.next();
            passwordArray[0] = newPassword;
        } else {
            System.out.println("Your password incorrect.Please try again.");
        }
    }

    // supplierManage method

    public static void supplierManage(){

    }

    // stockManage method

    public static void stockManage() {
        
    }

    public static void gotoHomepage(String[] usernameArray, String[] passwordArray) {

        Scanner input = new Scanner(System.in);

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n");

        System.out.println("|\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM    |");

        System.out.print("+");
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.print("+\n\n");

        System.out.println("[1] Change the Credentials\t\t\t[2] Supplier Manage");
        System.out.println("[3] Stock Management      \t\t\t[4] Log out");
        System.out.println("[5] Exit the System");

        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                changeCredentials(usernameArray, passwordArray);
                break;
            case 2:
                clearConsole();
                supplierManage();
                break;
            case 3:
                clearConsole();
                stockManage();
                break;
            case 4:
                clearConsole();
                gotoLoginPage(usernameArray, passwordArray);
                break;
            case 5:
                clearConsole();
                System.out.println("See you !!!!");
                System.exit(0);
                break;
            default:
                clearConsole();
                System.out.println("Invalid option. please try again.\n");
                gotoHomepage(usernameArray, passwordArray);
                break;
        }
    }

    public static void main(String[] args) {
        registerPage();
    }
}
