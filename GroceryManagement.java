import java.util.Scanner;

public class GroceryManagement {

    /**
    Function: displayUI()

    Prerequisites: None.

    Description: Prints a simple menu to the console showing the available
             inventory system options:
             1) Add Inventory
             2) View Inventory
             3) Restock Inventory
             4) Exit

    Post: The menu text is displayed to the console. No variables or arrays
      are modified.
    */    
    public static void displayUI(){
        System.out.println(".......Choose one of the options....");
        System.out.println("1:Add Inventory: ");
        System.out.println("2:View Inventory: ");
        System.out.println("3:Restock Inventory: ");
        System.out.println("4:Exit: ");
        System.out.println(".....................................");
    }

    /**
     * Searches for the first empty slot in names (where names[i] == null).
     * Prompts the user for item name, price, and stock quantity.
     * Stores values at the same index in all three arrays.
     *
     * @param sc Scanner used for user input
     * @param names array of item names
     * @param prices array of item prices
     * @param stocks array of stock quantities
     */
    public static void addInventory(Scanner sc,String[] names, double[] prices, int[] stocks){
        // Scanner sc = new Scanner(System.in);
        for(int i = 0;i<names.length;i++){
            if(names[i] == null){
                String item_name;
                double item_price;
                int item_stock;
                System.out.println("------Enter the name:-------");
                sc.nextLine();
                item_name = sc.nextLine();
                System.out.println("------Enter the price:-------");
                item_price = sc.nextDouble();
                System.out.println("------Enter the number of stocks:-------");
                item_stock = sc.nextInt();
                names[i] = item_name;
                prices[i] = item_price;
                stocks[i] = item_stock;
                break;
            }
        }
    }

    /**
     * Prints the current inventory items to the console.
     * <p>
     * For each index {@code i}, the method prints the item name, price, and stock
     * if {@code names[i] != null}. Empty slots are skipped.
     * </p>
     *
     * @param names  array of item names
     * @param prices array of item prices
     * @param stocks array of item stock quantities
     *
     * @implNote This method does not modify any arrays.
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks){
        boolean empty = true;

        for (int i = 0; i < names.length; i++) {
            
            if (names[i] != null) {
                empty = false;
                System.out.println("Item Name: " + names[i]);
                System.out.println("Price: $" + prices[i]);
                System.out.println("Stock: " + stocks[i]);
                System.out.println("-----------------------");
            }  
        }
        if (empty) {
                System.out.println("Inventory is empty.");
                break;
            }
    }

    /**
     * Restocks an existing inventory item by adding a given amount to its stock.
     * <p>
     * The method searches for {@code target} inside {@code names}. If found at index {@code i},
     * it increases {@code stocks[i]} by {@code amount}.
     * </p>
     *
     * @param names  array of item names
     * @param stocks array of item stock quantities (same length as {@code names})
     * @param target the name of the item to restock
     * @param amount the amount of stock to add
     *
     * @implNote If the target item is not found, the method prints {@code "Item not found"}.
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount){
        boolean item_found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals(target)) {
                stocks[i] += amount;
                item_found = true;
                break;
            }
        }

        if (!item_found) {
            System.out.println("Item not found");
        }
    }

    /**
     * Program entry point.
     * <p>
     * Creates inventory arrays, displays the menu, and processes user input in a loop
     * until the user chooses to exit.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String[] item_names = new String[10];
        double[] item_prices= new double[10];
        int[] item_stocks = new int[10]; 

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------");
        System.out.println("*******************Grocery_Stock_Management*******************");
        System.out.println("-------------------------------------------------------------");
        displayUI();
        
        char c;
        c = sc.next().charAt(0);

        while(true){
            if(c == '1'){
                System.out.println("Inside the add option");
                addInventory(sc,item_names,item_prices,item_stocks);
            }
            else if (c == '2'){
                printInventory(item_names,item_prices,item_stocks);
            }

            else if(c == '3'){
                String target;
                int amount;
                System.out.println("Enter the target:-------");
                target = sc.next();
                System.out.println("Enter the amount: ");
                amount = sc.nextInt();
                restockItem(item_names,item_stocks,target,amount);
            }
            else if(c == '4'){
                break;
            }
            else{
                System.out.println("-------Enter the correct option---------");
            }
            displayUI();
            c = sc.next().charAt(0);
        }
    }
}
