//This is a subclass called Pastry
public class Cake extends Bakery
{
    private String shape;       //declaration attribute shape into String data type
    private double weight;      //declaration attribute weight into double data type
    private double radius;      //declaration attribute radius into double data type
    
    //normal constructor
    public Cake (int quantity, String code, Customer []cust, String shape, double weight, double radius)
    {   
        super(quantity, code, cust);    //refer to the Bakery of a class or to call the Bakery constructor
        this.shape = shape;         //initialize attribute shape into Cake class
        this.weight = weight;       //initialize attribute weight into Cake class
        this.radius = radius;       //initialize attribute radius into Cake class
    }
    
    //setter method for Bakery class
    public void setBakery(int quantity, String code, Customer []cust, String shape, double weight, double radius)
    {
        super.setBakery(quantity, code, cust);      //refer to the Bakery of a class or to call the Bakery setter method
        this.shape = shape;         //set new value for shape
        this.weight = weight;       //set new value for weight
        this.radius = radius;       //set new value for radius
    }
    
    //setter method for each Cake attributes
    public void setShape(String shape){this.shape = shape; }        //set new value for shape
    public void setWeight(double weight){this.weight = weight; }       //set new value for weight
    public void setRadius(double radius){this.radius = radius; }    //set new value for radius
    
    //getter method
    public String getShape(){return shape; }        //return the value of the attribute shape
    public double getWeight(){return weight; }      //return the value of the attribute weight
    public double getRadius(){return radius; }      //return the value of the attribute radius
    
    //calculation for Cake's Order
    public double calculatePrice()
    {
        double radPrice = 5.00; //price radius for 1centimetre
        double wPrice = 50.00; //price weight for 1kilogram
        
        double weightPrice = wPrice * weight;   //calculation for weight price (weight in kg)
        double radiusPrice = radPrice * radius;    //calculation for radius price (price in cm)       
            
        double newPrice = (weightPrice + radiusPrice) * super.getQuantity();    //calculation of total price for Cake order
        return newPrice;    //return the value of the attribute newPrice
    }
    
    //toString() method
    public String toString()
    {   
        return(super.toString() + "\nShape: " + shape +             //return to display shape detail
                                  "\nWeight: " + weight + " g"+     //return to display weight detail
                                  "\nRadius: " + radius + " cm");   //return to display radius detail
    }
}