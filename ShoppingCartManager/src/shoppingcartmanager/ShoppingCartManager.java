
package shoppingcartmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartManager {
    
    static Scanner scan = new Scanner(System.in);
    
    public static void myMenu() {
        System.out.println("MENU\n" +
                            "a - Add item to cart\n" +
                            "d - Remove item from cart\n" +
                            "c - Change item quantity\n" +
                            "i - Output items' descriptions\n" +
                            "o - Output shopping cart\n" +
                            "q - Quit\n");
        //System.out.println("Choose an option: ");
    }
    
    public static void printMenu(ShoppingCart myCart) {
                
        boolean quit = false;
        char option;
        
        while(quit == false) {
            System.out.println("Choose an option: ");
            //myMenu();
            option = scan.next().charAt(0);
        
            switch(option) {
                case 'o':
                    System.out.println("OUTPUT SHOPPING CART");
                    myCart.printTotal();
                    System.out.println("");
                    myMenu();
                    break;
                case 'i':
                    System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                    myCart.printDescription();
                    System.out.println("");
                    myMenu();
                    break;
                case 'a':
                    System.out.println("ADD ITEM TO CART");
                    ItemToPurchase item = new ItemToPurchase();
                    System.out.println("Enter the item name: ");
                    scan.nextLine();
                    String itemName = scan.nextLine();      
                    item.setName(itemName);
                    System.out.println("Enter the item description: ");
                    String description = scan.nextLine();
                    item.setDescription(description);
                    System.out.println("Enter the item price: ");
                    int itemprice = scan.nextInt();
                    item.setPrice(itemprice);
                    System.out.println("Enter the item quantity: ");
                    int itemquantity = scan.nextInt();
                    item.setQuantity(itemquantity);
                    myCart.addItem(item);
                    System.out.println("");
                    myMenu();
                    break;
                case 'd':
                    System.out.println("REMOVE ITEM FROM CART");
                    System.out.println("Enter name of item to remove: ");
                    scan.nextLine();
                    String itemname = scan.nextLine();
                    myCart.removeItem(itemname);
                    System.out.println("");
                    myMenu();
                    break;                    
                case 'c':  
                    System.out.println("CHANGE ITEM QUANTITY");
                    System.out.println("Enter the item name: ");
                    scan.nextLine();
                    String nameOfItem = scan.nextLine();
                    int newQuantity;
                    ArrayList<ItemToPurchase> myItems = myCart.getCarItems();
                    System.out.println("Enter the new quantity: ");
                    
                    boolean itemThere = false;
                    int LIST_SIZE = myItems.size();
                    for(int i = 0; i < LIST_SIZE; i++) {
                        ItemToPurchase itemToChange = myItems.get(i);
                        if(nameOfItem.equals(itemToChange.getName())) {
                            newQuantity = scan.nextInt();
                            itemToChange.setQuantity(newQuantity);
                            itemThere = true;
                        }
                    }
                    if(itemThere == false) {
                        System.out.println("Item not found in cart. Nothing modified.");
                        System.out.println("");
                    }
                    scan.nextLine();
                    myMenu();
                    break;
                case 'q':
                    quit = true;
                    break;
            }
        }
        
    }

    public static void main(String[] args) {
        
        ShoppingCart myCar = new ShoppingCart();
        
        System.out.println("Enter Customer's Name: ");
        String customerName = scan.nextLine();
        myCar.setCustomerName(customerName);
        System.out.println("Enter Today's Date: ");
        String date = scan.nextLine();
        myCar.setDate(date);
        System.out.println("Customer Name: " + myCar.getCustomerName());
        System.out.println("Today's Date: " + myCar.getDate());        
        System.out.println("");
        myMenu();
        printMenu(myCar);
    }
    
}
