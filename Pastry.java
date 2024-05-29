//This is a subclass called Pastry
public class Pastry extends Bakery
{
    private int qtyPerBox;         //declaration of attribute qtyrPerBox
    private String flavour;        //declaration of attribute flavour
    private boolean addCheese;     //declaration of attribure addCheese 
    
    //normal constructor
    public Pastry (int quantity, String code, Customer []cust, int qtyPerBox, String flavour, boolean addCheese)
    {   
        super(quantity, code, cust);    //refer to the Bakery of a class or to call the Bakery constructor
        this.qtyPerBox = qtyPerBox;     //name value accepted from parameter as qtyPerBox
        this.flavour = flavour;         //name value accepted from parameter as flavour 
        this.addCheese = addCheese;     //name value accepted from paramater as addCheese 
    }
    
    //setter method for Bakery class
    public void setBakery(int quantity, String code, Customer []cust, int qtyPerBox, String flavour, boolean addCheese)
    {
        super.setBakery(quantity, code, cust);      //refer to the Bakery of a class or to call the Bakery setter method  
        this.qtyPerBox = qtyPerBox;                //set the current qtyperBox's value
        this.flavour = flavour;                    //set the current flavour's value
        this.addCheese = addCheese;                //set the current addCheese's value 
    }            
    
    //setter method for each Pastry attributes
    public void setQtyPerBox(int qtyPerBox){this.qtyPerBox = qtyPerBox; }      //set current qtyPerBox's value
    public void setFlavour(String flavour){this.flavour = flavour; }           //set current flavour's value
    public void setAddCheese(boolean addCheese){this.addCheese = addCheese; }  //set current addCheese's value
    public void setCust(Customer[] cust) {super.setCust(cust);}                // set current customer's value
    
    //getter method 
    public int getQtyPerBox(){return qtyPerBox; }      //return value of the attribute qtyPerBox
    public String getFlavour(){return flavour; }        //return value of the attribute flavour 
    public boolean getAddCheese(){return addCheese; }   //return value of the attribute addCheese
        
    //calculatePrice()
    public double calculatePrice()
    {
        double add = 0, qtyPrice = 6.00;  //set the price for each pastry
        
        //calculate the pastry based on qtyPerBox and qtyBox
        double pastryPrice = qtyPrice * qtyPerBox;
                
        if(addCheese == true)   //if the addCheese is true
            add = 5.00;         //add the price "RM5.00"
        else                    //else (addCheese=false)
            add = 0.00;         //add the price "RM0.00)
                
        double newPrice = (pastryPrice * super.getQuantity()) + add; //calculate the total price 
        return newPrice; //return the price 
    }
        
    //toString() method
    public String toString()
    {   
        return(super.toString() + "\nQuantity per box: " + qtyPerBox +  //return to display qtyPerBox
                                  "\nFlavour: " + flavour +             //return to display flavour
                                  "\nAddCheese: " + addCheese);         //return to display addCheese
    }
}