import java.util.Arrays;
import java.util.Scanner;

public class StockManagementSystem {

    private static final String[][] suppliers = new String[100][2];
    private static final String[][] itemCategories = new String[100][1];
    private static final String[][] items = new String[100][6];
    private static String[] usernameArray = new String[1];
    private static String[] passwordArray = new String[1];

    private static int supplierCount = 0;
    private static int categoryCount = 0;
    private static int itemCount = 0;
    // private static Scanner input = new Scanner(System.in);

    /////////////////////////////////////////////////////////////////////////////////////

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

    private static int getCategoryIndexByName(String name) {

        for (int i = 0; i < categoryCount; i++) {
            if (itemCategories[i][0].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private static int getItemIndexByID(String id) {

        for (int i = 0; i < itemCount; i++) {
            if (items[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static int getSupplierIndexById(String id) {
        for (int i = 0; i < supplierCount; i++) {
            if (suppliers[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        registerPage(input);
    }

    private static void registerPage(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               REGISTER PAGE                                |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Create Username : ");
        String username = input.next();
        System.out.print("Create Password : ");
        String password = input.next();
        System.out.print("Confirm Password : ");
        String confirmPassword = input.next();

        boolean isCheck = true;

        while (isCheck) {
            if (password.equals(confirmPassword)) {
                usernameArray[0] = username;
                passwordArray[0] = confirmPassword;
                isCheck = false;
                clearConsole();
                gotoLoginPage(input);
            } else {
                System.out.println("\nyour password doesn't match. try again.\n");
                System.out.print("Confirm Password : ");
                confirmPassword = input.next();
            }
        }
    }

    private static void gotoLoginPage(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                  LOGIN PAGE                                |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {
            System.out.print("username : ");
            String username = input.next();

            while (isCheck) {

                if (usernameArray[0].equals(username)) {
                    System.out.print("password : ");
                    String password = input.next();

                    while (isCheck) {

                        if (passwordArray[0].equals(password)) {
                            isCheck = false;
                            clearConsole();
                            gotoHomePage(input);
                        } else {
                            System.out.println("password is incorrect. try again.\n");
                            System.out.print("password : ");
                            password = input.next();
                        }

                    }

                } else {
                    System.out.println("username is invalid. try again.\n");
                    System.out.print("username : ");
                    username = input.next();
                }

            }

        }

    }

    private static void gotoHomePage(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                  WELCOME TO THE IJSE STOCK MANAGEMENT SYSTEM               |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1] Change The Credential\t\t");
        System.out.println("[2] Supplier Manage");
        System.out.print("[3] Stock Manage\t\t\t");
        System.out.println("[4] Log Out");
        System.out.println("[5] Exit\n");

        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        boolean isCheck = true;
        while (isCheck) {
            switch (option) {
                case 1:
                    isCheck = false;
                    clearConsole();
                    changeCredential(input);
                    break;

                case 2:
                    isCheck = false;
                    clearConsole();
                    supplierManage(input);
                    break;

                case 3:
                    isCheck = false;
                    clearConsole();
                    stockManage(input);
                    break;

                case 4:
                    isCheck = false;
                    clearConsole();
                    gotoLoginPage(input);
                    break;

                case 5:
                    isCheck = false;
                    clearConsole();
                    System.out.println("See You Again !!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option! try again.\n");
                    System.out.print("Enter an option to continue > ");
                    option = input.nextInt();
            }
        }
    }

    private static void changeCredential(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               CHANGE CREDENTIAL                            |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {
            System.out.print("Please enter the username to verify it's you : ");
            String username = input.next();

            while (isCheck) {

                if (usernameArray[0].equals(username)) {
                    System.out.println("Hey " + username);
                    System.out.print("Enter your current password : ");
                    String password = input.next();

                    while (isCheck) {

                        if (passwordArray[0].equals(password)) {
                            System.out.print("Enter your New password : ");
                            String newPassword = input.next();
                            passwordArray[0] = newPassword;

                            isCheck = false;

                            System.out.print("Password changed successfully.Do you want to go home page (y/n)? : ");
                            String option = input.next().toLowerCase();

                             System.out.println();
                            boolean isRun = true;

                           while (isRun) {
                            switch (option) {
                                case "y":
                                    isRun = false;
                                    isCheck = false;
                                    clearConsole();
                                    gotoHomePage(input);
                                    break;
                                case "n":
                                    clearConsole();
                                    System.exit(0);
                                default:
                                    System.out.print("invalid option. try again! (y/n) : ");
                                    option = input.next().toLowerCase();
                            }
                           }
                            
                        } else {
                            System.out.println("incorrect password. try again!");
                            System.out.print("\nEnter your current password : ");
                            password = input.next();

                        }

                    }

                } else {
                    System.out.println("invalid username. try again!\n");
                    System.out.print("please enter the username to verify it's you : ");
                    username = input.next();
                }

            }
        }
    }

    private static void supplierManage(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                SUPPLIER MANAGE                             |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1] Add Supplier\t\t");
        System.out.println("[2] Update Supplier");
        System.out.print("[3] Delete Supplier\t\t");
        System.out.println("[4] View Suppliers");
        System.out.print("[5] Search Supplier\t\t");
        System.out.println("[6] Home Page");

        boolean isCheck = true;

        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();

        while (isCheck) {
            switch (option) {
                case 1:
                    isCheck = false;
                    clearConsole();
                    addSupplier(input);
                    break;
                case 2:
                    isCheck = false;
                    clearConsole();
                    updateSupplier(input);
                    break;
                case 3:
                    isCheck = false;
                    clearConsole();
                    deleteSupplier(input);
                    break;
                case 4:
                    isCheck = false;
                    clearConsole();
                    viewSuppliers(input);
                    break;
                case 5:
                    isCheck = false;
                    clearConsole();
                    searchSupplier(input);
                    break;
                case 6:
                    isCheck = false;
                    clearConsole();
                    gotoHomePage(input);
                    break;
                default:
                    System.out.println("invalid option. try again !\n");
                    System.out.print("Enter an option to continue > ");
                    option = input.nextInt();
            }
        }
    }

    private static void addSupplier(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                  ADD SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("Supplier ID : ");
            String supplierId = input.next();

            if (getSupplierIndexById(supplierId) != -1) {
                System.out.println("supplier id already exists. please enter different ID.\n");
                continue;
            }

            System.out.print("Supplier Name : ");
            String supplierName = input.next();

            suppliers[supplierCount][0] = supplierId;
            suppliers[supplierCount][1] = supplierName;
            supplierCount++;

            System.out.print("Supplier added successfully. Do you want to add another supplier (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println();
            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;

                    case "n":
                        isCheck = false;
                        isRun = false;
                        clearConsole();
                        supplierManage(input);
                        break;

                    default:
                        System.out.print("invalid option. try again! (y/n) ? : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void updateSupplier(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               UPDATE SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("Supplier ID : ");
            String supplierID = input.next();
            int index = getSupplierIndexById(supplierID);

            if (index == -1) {
                System.out.println("Can't find supplier id. try again !\n");
                continue;
            }

            System.out.println("Supplier Name : " + suppliers[index][1] + "\n");
            System.out.print("Enter the new supplier Name : ");
            String newName = input.next();
            suppliers[index][1] = newName;

            System.out.print("Updated Successfully. Do you want to update another supplier (y/n) ? : ");
            String choice = input.next().toLowerCase();
            System.out.println();
            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        supplierManage(input);
                        break;
                    default:
                        System.out.print("invalid option. try again !(y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void deleteSupplier(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               DELETE SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("Supplier ID : ");
            String supplierID = input.next();
            int index = getSupplierIndexById(supplierID);

            if (index == -1) {
                System.out.println("can't find supplier id. try again !\n");
                continue;
            }
            for (int i = index; i < supplierCount - 1; i++) {
                suppliers[i] = suppliers[i + 1];
            }

            suppliers[supplierCount - 1] = new String[2];
            supplierCount--;

            System.out.print("deleted successfully. Do youn want to delete another (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println("");
            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        supplierManage(input);
                        break;
                    default:
                        System.out.print("invalid option. try again !(y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void viewSuppliers(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                VIEW SUPPLIERS                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("---------------------------------------");
        System.out.println("|       ID      |\tName          |");
        System.out.println("---------------------------------------");

        for (int i = 0; i < supplierCount; i++) {
            System.out.println("|       " + suppliers[i][0] + "\t|" + "\t" + suppliers[i][1] + "\t      |");
            System.out.println("---------------------------------------");
        }

        System.out.print("\nDo you want to go supplier manage page (y/n)? : ");
        String choice = input.next();
        boolean isRun = true;

        while (isRun) {
            switch (choice) {
                case "y":
                    isRun = false;
                    clearConsole();
                    supplierManage(input);
                    break;
                case "n":
                    isRun = false;
                    clearConsole();
                    viewSuppliers(input);
                default:
                    System.out.print("invalid option. try again !(y/n) : ");
                    choice = input.next().toLowerCase();
            }
        }
    }

    private static void searchSupplier(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                SEARCH SUPPLIER                             |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {
            System.out.print("Supplier ID : ");
            String supplierId = input.next();
            int index = getSupplierIndexById(supplierId);

            if (index == -1) {
                System.out.println("Can't find supplier id. try again !\n");
                continue;
            }

            System.out.println("Supplier Name : " + suppliers[index][1] + "\n");

            System.out.print("added successfully. Do you want add another find (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println();

            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        supplierManage(input);
                        break;
                    default:
                        System.out.print("invalid option. try again !(y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void stockManage(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                              STOCK MANAGEMENT                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1] Manage Item Categories\t\t");
        System.out.println("[2] Add Item");
        System.out.print("[3] Get Item Suppliers Wise\t\t");
        System.out.println("[4] View Items");
        System.out.print("[5] Rank Item Per Unit Price\t\t");
        System.out.println("[6] Home Page");

        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();

        boolean isCheck = true;

        while (isCheck) {
            switch (option) {
                case 1:
                    isCheck = false;
                    clearConsole();
                    manageCategory(input);
                    break;

                case 2:
                    isCheck = false;
                    clearConsole();
                    addItem(input);
                    break;

                case 3:
                    isCheck = false;
                    clearConsole();
                    getItemWiswSupplier(input);
                    break;

                case 4:
                    isCheck = false;
                    clearConsole();
                    viewItems();
                    break;

                case 5:
                    isCheck = false;
                    clearConsole();
                    rankItemsByPrice();
                    break;

                case 6:
                    isCheck = false;
                    clearConsole();
                    gotoHomePage(input);
                    break;

                default:
                    System.out.println("invalid option. try again");
                    System.out.print("\nEnter an option to continue > ");
                    option = input.nextInt();
            }
        }
    }

    private static void manageCategory(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                             MANAGE ITEM CATEGORY                           |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("[1] Add New Item Category\t\t");
        System.out.println("[2] Delete Item Category");
        System.out.print("[3] Update Item Category\t\t");
        System.out.println("[4] Stock Management");

        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();

        boolean isCheck = true;

        while (isCheck) {
            switch (option) {
                case 1:
                    isCheck = false;
                    clearConsole();
                    addCategory(input);
                    break;

                case 2:
                    isCheck = false;
                    clearConsole();
                    deleteCategory(input);
                    break;

                case 3:
                    isCheck = false;
                    clearConsole();
                    updateCategory(input);
                    break;

                case 4:
                    isCheck = false;
                    clearConsole();
                    stockManage(input);
                    break;

                default:
                    System.out.print("invalid option. try again !\n");
                    System.out.print("\nEnter an option to continue > ");
                    option = input.nextInt();

            }
        }
    }

    private static void addCategory(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                              ADD ITEM CATEGORY                             |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {
            System.out.print("Enter the new Item Category : ");
            String categoryName = input.next();

            if (getCategoryIndexByName(categoryName) != -1) {
                System.out.println("category already exists. please enter another category.\n");
                continue;
            }

            itemCategories[categoryCount][0] = categoryName;
            categoryCount++;

            System.out.print("added successfully. Do you want to add another category (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println();
            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        manageCategory(input);
                    default:
                        System.out.print("\ninvalid option. try again! (y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void updateCategory(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                              UPDATE CATEGORY                             |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("enter current category name for update : ");
            String categoryName = input.next();
            int index = getCategoryIndexByName(categoryName);

            if (index == -1) {
                System.out.println("can't find category. try again !\n");
                continue;
            }
            System.out.print("enter new name for category want update : ");
            String newCategoryName = input.next();

            itemCategories[index][0] = newCategoryName;
            System.out.print("updated successfully! Do you want to update another category (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println();

            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        manageCategory(input);
                        break;
                    default:
                        System.out.print("\ninvalid option. try again ! (y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void deleteCategory(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                              DELETE CATEGORY                             |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("category name : ");
            String categoryName = input.next();
            int index = getCategoryIndexByName(categoryName);

            if (index == -1) {
                System.out.println("can't find category. try again !\n");
                continue;
            }

            for (int i = index; i < categoryCount - 1; i++) {
                itemCategories[i] = itemCategories[i + 1];
            }

            itemCategories[categoryCount - 1] = new String[2];
            categoryCount--;

            System.out.print("deleted sucessfully. Do you ant to delete another category (y/n)? : ");
            String choice = input.next().toLowerCase();
            System.out.println();

            boolean isRun = true;

            while (isRun) {
                switch (choice) {
                    case "y":
                        isRun = false;
                        break;
                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        manageCategory(input);
                        break;
                    default:
                        System.out.print("\ninvalid option. try again.(y/n) : ");
                        choice = input.next().toLowerCase();
                }
            }
        }
    }

    private static void addItem(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                                   ADD ITEM                                 |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            if (categoryCount == 0) {
                System.out.println("oops! It seems that you don't have any item categories in the system.");
            } else if (supplierCount == 0) {
                System.out.println("oops! It seems that you don't have any suppliers in the system.");
            } else {

                System.out.print("Item Code: ");
                String code = input.next();

                if (getItemIndexByID(code) != -1) {
                    System.out.println("alredy exsists item id. try again!\n");
                    continue;
                }

                System.out.println("\nSuppliers list :");

                System.out.println("---------------------------------------");
                System.out.println("#|       ID     |\tName          |");
                System.out.println("---------------------------------------");

                for (int i = 0; i < supplierCount; i++) {
                    // System.out.println((i + 1) + ". " + suppliers[i][0] + " - " +
                    // suppliers[i][1]);
                    System.out.println(
                            (i + 1) + "|       " + suppliers[i][0] + "\t|" + "\t" + suppliers[i][1] + "\t      |");
                    System.out.println("---------------------------------------");
                }
                System.out.print("\nEnter the supplier number > ");
                int supplierIndex = input.nextInt() - 1;

                System.out.println("\nItem Categories: ");
                System.out.println("---------------------------------------");
                System.out.println("#|                 Name               |");
                System.out.println("---------------------------------------");

                for (int i = 0; i < categoryCount; i++) {
                    System.out.println((i + 1) + "|\t\t   " + itemCategories[i][0] + "\t\t   |");
                    System.out.println("---------------------------------------");
                }

                System.out.print("\nEnter the category number > ");
                int categoryIndex = input.nextInt() - 1;

                System.out.println();

                System.out.print("Description: ");
                String description = input.next();
                System.out.print("Unit Price: ");
                double unitPrice = input.nextDouble();
                System.out.print("Quantity on Hand: ");
                int quantity = input.nextInt();

                items[itemCount][0] = code;
                items[itemCount][1] = suppliers[supplierIndex][0];
                items[itemCount][2] = itemCategories[categoryIndex][0];
                items[itemCount][3] = description;
                items[itemCount][4] = String.valueOf(unitPrice);
                items[itemCount][5] = String.valueOf(quantity);
                itemCount++;

                System.out.print("added successfully. Do you want to add another item? (Y/N): ");
                String choice = input.next().toLowerCase();
                System.out.println();
                boolean isRun = true;

                while (isRun) {
                    switch (choice) {
                        case "y":
                            isRun = false;
                            break;
                        case "n":
                            isRun = false;
                            isCheck = false;
                            clearConsole();
                            stockManage(input);
                        default:
                            System.out.print("\ninvalid option. try again! (y/n) : ");
                            choice = input.next().toLowerCase();
                            System.out.println();
                    }
                }
            }
        }
    }

    private static void viewItems() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nItem List:");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println( "|       Code      |\t     Supplier     |\t   category        |\tDescription        |\tUnit Price        |\t  QTY\t  |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < itemCount; i++) {
            System.out.println("|\t" + items[i][0] + "         |   \t\t" + items[i][1] + "\t  |\t   " + items[i][2]+ "\t   |\t        " + items[i][3] + "\t   |\t    " + items[i][4] + "\t  |\t  " + items[i][5]+ "\t  |");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        }

        boolean Run = true;
        System.out.print("Want goto Stock Manage Page (y/n)? : ");
        String choice = input.next().toLowerCase();
        System.out.println();
        while (Run) {
            switch (choice) {
                case "y":
                    Run = false;
                    clearConsole();
                    stockManage(input);
                    break;
                case "n":
                    Run = false;
                    clearConsole();
                    viewItems();
                default:
                    System.out.print("\ninvalid option. try agan !");
                    choice = input.next().toLowerCase();
            }
        }
    }

    private static void rankItemsByPrice() {
        // Bubble sort implementation to rank items by unit price in ascending order
        for (int i = 0; i < itemCount - 1; i++) {
            for (int j = 0; j < itemCount - i - 1; j++) {
                if (Double.parseDouble(items[j][4]) > Double.parseDouble(items[j + 1][4])) {
                    // Swap the items
                    String[] temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        System.out.println("Items ranked by unit price in ascending order:");
        viewItems();
    }

     private static void getItemWiswSupplier(Scanner input) {

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                               SEARCH SUPPLIER                              |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println();

        boolean isCheck = true;

        while (isCheck) {

            System.out.print("Enter Supplier ID : ");
            String supplierID = input.next();
            int index = getSupplierIndexById(supplierID);

            if (index == -1) {
                System.out.println("can't find supplier. try again!\n");
                continue;
            }

            System.out.println("Supplier Name : " + suppliers[index][1] + "\n");

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("|  ITEM CODE  |  DISCRIPTION  |  UNIT PRICE  |  QTY ON HAND  |  CATEGORY  |");
            System.out.println("---------------------------------------------------------------------------");

            for (int i = 0; i < itemCount; i++) {

                if (items[i][1].equals(supplierID)) {

                    System.out.print("|     "+items[i][0]+"     |     "+items[i][2]+"     |     "+items[i][3]+"     |     "+items[i][4]+"  |     "+items[i][5]+"     |  \n");
                   
                }

            }

            System.out.println("---------------------------------------------------------------------------");

            boolean isRun = true;
            System.out.print("\nsearch successfully! Do you want to another search (y/n)? : ");
            String option = input.next().toLowerCase();
            System.out.println();
            while (isRun) {

                switch (option) {

                    case "y":
                        isRun = false;
                        break;

                    case "n":
                        isRun = false;
                        isCheck = false;
                        clearConsole();
                        stockManage(input);
                        break;

                    default:
                        System.out.print("\ninvalid option.try again! (y/n) : ");
                        option = input.next().toLowerCase();
                }
            }

        }
    }
}
