import java.util.Scanner;

public class GroceryManagement {

    public static void displayUI(){
        System.out.println(".......Choose one of the options....");
        System.out.println("1:Add Inventory: ");
        System.out.println("2:View Inventory: ");
        System.out.println("3:Restock Inventory: ");
        System.out.println("4:Exit: ");
    }

        public static void addInventory(Scanner sc,String[] names, double[] prices, int[] stocks){
        // Scanner sc = new Scanner(System.in);
        for(int i = 0;i<names.length;i++){
            if(names[i] == null){
                String item_name;
                double item_price;
                int item_stock;
                System.out.println("------Enter the name:-------");
                item_name = sc.next();
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
    public static void printInventory(String[] names, double[] prices, int[] stocks){
    }

    public static void restockItem(String[] names, int[] stocks, String target, int amount){

    }

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
            String name;
            double price;
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