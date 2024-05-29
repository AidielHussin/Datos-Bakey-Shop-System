//This is superclass Bakery 
public abstract class Bakery
{
    protected int quantity;                                            //declaration attribute quantity
    protected String code;                                             //declaration attribute code
    protected Customer []cust = new Customer[5];                       //declaration of array for cust attribute
    
    //normal constructor
    public Bakery(int quantity, String code, Customer []cust)          //normal constructor
    {
        this.quantity = quantity;                                      //quantity value accepted from parameter as quantity attribute
        this.code = code;                                              //code value accepted from parameter as code attribute
        for(int i = 0; i < cust.length; i++)                           //loop through the length of cust array
            this.cust[i] = cust[i];                                    //cust value accepted from parameter as cust attribute
    }
    
    //setter method (group)
    public void setBakery(int quantity, String code, Customer []cust)  //setter method (group)
    {
        this.quantity = quantity;                                      //quantity value accepted from parameter as quantity attribute
        this.code = code;                                              //code value accepted from parameter as code attribute
        for(int i = 0; i < cust.length; i++)                           //loop through the length of cust array
            this.cust[i] = cust[i];                                    //cust value accepted from parameter as cust attribute
    }
    
    //setter method (separate)
    public void setQuantity(int quantity){this.quantity = quantity; }  //set current quantity's value
    public void setCode(String code){this.code = code; }               //set current code's value
    public void setCust(Customer[] cust) {this.cust = cust;}           //set current cust's value
    
    //getter method
    public int getQuantity(){return quantity; }                        //return the value of the attribute quantity
    public String getCode(){return code; }                             //return the value of the attribute code
    public Customer getCust(int loc){return cust[loc]; }               //return the value of the attribute cust
    
    
    public abstract double calculatePrice();                           //calculate price
    
    //print
    public String toString()
    {
        return("\nQuantity ordered: " + quantity +                     //return to display quantity
               "\nCode of selected dessert: " + code);                 //return to display code
    }
}