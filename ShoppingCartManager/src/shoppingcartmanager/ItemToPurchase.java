package shoppingcartmanager;


public class ItemToPurchase {
    
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;
    
    public ItemToPurchase() {
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }

    public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }
    
    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    
    public String getDescription() {
        return itemDescription;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return itemPrice;
    }

    public void setPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public void setQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    
    public void printCost() {
        int subtotal = itemQuantity * itemPrice;
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + subtotal);
    }
    
    public void printItemDescription() {
        //String name = this.getName();
        //String descrip = this.getDescription();
        System.out.println(itemName + ": " + itemDescription);
    }   
}
