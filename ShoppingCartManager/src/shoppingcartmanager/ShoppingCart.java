
package shoppingcartmanager;


import java.util.ArrayList;
import java.util.Iterator;


public class ShoppingCart {
    
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> carItems;

    public ShoppingCart() {
        customerName = "none";
        currentDate = "January 1, 2016";
        carItems = new ArrayList<>();
    }

    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        carItems = new ArrayList<>();
    }
    
    public ArrayList<ItemToPurchase> getCarItems() {
        return this.carItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return currentDate;
    }

    public void setDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    public void addItem(ItemToPurchase myItem) {
        carItems.add(myItem);
    }
    
    public void removeItem(String itemName) {
        
        ItemToPurchase itemToRemove;
        boolean isThere = false;
        
        Iterator<ItemToPurchase> crunchifyIterator = carItems.iterator();
		while (crunchifyIterator.hasNext() && isThere == false) {
			itemToRemove = crunchifyIterator.next();
                        if(itemName.equalsIgnoreCase(itemToRemove.getName())) {
                            carItems.remove(itemToRemove);
                            isThere = true;
                        }                        
		}
                if(isThere == false) {
                    System.out.println("Item not found in cart. Nothing removed.");
                }

    }
    
    public void modifyItem(ItemToPurchase itemToModify) {
        String name = itemToModify.getName();
        String description = itemToModify.getDescription();
        int price = itemToModify.getPrice();
        int quantity = itemToModify.getQuantity();
        int LIST_SIZE = carItems.size();
        ItemToPurchase defaultItem = new ItemToPurchase();
        for(int i = 0; i < LIST_SIZE; i++) {
            ItemToPurchase modifyItem = carItems.get(i);
            if(name.equals(modifyItem.getName())) {
               if(price != 0 && quantity != 0 && !description.equalsIgnoreCase("none")) {
                   carItems.set(i, defaultItem);
               }
            }
            else {
                System.out.println("Item not found in cart.\nNothing modified.");
            }
        }
    }
    
    public int getNumItemsInCart() {
        int quantity = 0;
        int LIST_SIZE = carItems.size();
        
        for(int i = 0; i < LIST_SIZE; i++) {
            ItemToPurchase myItem = carItems.get(i);
            quantity+=myItem.getQuantity();
        }
        return quantity;
    }
    
    public int getCostOfCart() {
        int totalCost = 0;
        int quantity;
        int price;
        int itemCost;
        
        int LIST_SIZE = carItems.size();        
        for(int i = 0; i < LIST_SIZE; i++) {
            ItemToPurchase myItem = carItems.get(i);
            quantity = myItem.getQuantity();
            price = myItem.getPrice();
            itemCost = quantity * price;
            
            totalCost+=itemCost;
            
        }
        return totalCost;
    }
    
    public void printTotal() {
        int totalItemsInCart = getNumItemsInCart();
        System.out.println(this.customerName + "'s Shopping Cart - " + this.currentDate);
        System.out.println("Number of Items: " + totalItemsInCart);
        System.out.println("");
        int costOfCart = getCostOfCart();
        if(carItems.size() > 0) {
            
            int LIST_SIZE = carItems.size();    
        
            for(int i = 0; i < LIST_SIZE; i++) {
                ItemToPurchase myItem = carItems.get(i);
                int itemQuantity = myItem.getQuantity();
                int itemPrice = myItem.getPrice();
                int subtotal = itemQuantity * itemPrice;
                System.out.println(myItem.getName() + " " + itemQuantity + " @ $" + itemPrice + " = $" + subtotal);
            }
        }        
        if(carItems.size() < 1) { 
            System.out.println("SHOPPING CART IS EMPTY");
        }
        System.out.println("");
        System.out.println("Total: $" + costOfCart);
        
                
    }
    
    public void printDescription() {
        int LIST_SIZE = carItems.size();
        System.out.println(this.customerName + "'s Shopping Cart - " + this.currentDate);
        System.out.println("");
        System.out.println("Item Descriptions");
        for(int i = 0; i < LIST_SIZE; i++) {
            ItemToPurchase myItem = carItems.get(i);
            myItem.printItemDescription();        }
    }    
    
}
