//This class has composite relationship with Bakery, its function is to collect customer's information
public class Customer
{
    private String name;                    //declaration of the attribute name (customer's name)
    private String phone;                   //declaration of the attribute phone (customer's phone number)
    private String address;                 //declaration of the attribute address (customer's address)
    
    public Customer(String name, String phone, String address) //normal constructor 
    {
        this.name = name;                  // name value accepted from parameter as name attribute
        this.phone = phone;                // phone value accepted from parameter as phone attribute
        this.address = address;            // address value accepted from parameter as address attribute
    }
    
    //setter method
    public void setCustomer(String name, String phone, String address)      //setter method for customer's details
    {
        this.name = name;                   //set the current name's value
        this.phone = phone;                 //set the current phone's value 
        this.address = address;             //set the current address' value
    }
    
    public void setName(String name){this.name = name; }                //set current name's value 
    public void setPhone(String phone){this.phone = phone; }            //set current phone's value
    public void setAddress(String address){this.address = address; }    //set current address' value
    
    //getter method
    public String getName(){return name; }          //return the value of the attribute name
    public String getPhone(){return phone; }        //return the value of the attribute phone
    public String getAddress(){return address; }    //return the value of the attribute address
    
    //display customers' details
    public String toString()        
    {
        return("\nCustomer Name: " + name +     //return to display customer's name
               "\nPhone Number: " + phone +     //return to display customer's phone number
               "\nAddress: " + address);        //return to display customer's address 
    }
}