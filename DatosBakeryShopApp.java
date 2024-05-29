import java.util.*;                                 //load the contents of the java. util package
import java.io.*;                                   //to use classes from the Java I/O (Input/Output) library
import java.time.LocalDateTime;                     //to represents a date-time
import java.time.format.DateTimeFormatter;          //formatter for printing and parsing date-time objects
public class DatosBakeryShopApp
{
    public static void main(String args[]) throws IOException //throws IOException for file input/output
    {  
        try{ //start try
        
        Bakery []order = new Bakery[5];                         //declaration for array of object order into Bakery class
        Customer []cust = new Customer[5];                      //declaration for array of object cust into Customer class
        
        //menu will display at console as customer's references
        
        System.out.println("Welcome to Dato's Bakery Shop!");                           //to greet user of the console
        System.out.println("\n\t\t----------------------------------------");
        System.out.printf("\t\t\t\tMenu List");                                         // print header of the console
        System.out.println("\n\t\t----------------------------------------");
        
        System.out.printf("\n\t\tCake:");                                               // print lists of cake variations in the store
        System.out.printf("\n\t\tCC001 - Lemon Butterfly Cake");
        System.out.printf("\n\t\tCC002 - Shrek Green Tea Cake");
        System.out.printf("\n\t\tCC003 - Strawberry Night Sky Cake");
        System.out.printf("\n\t\tCC004 - Witchy Red Velvet Cake");
        System.out.printf("\n\t\tCC005 - Blue Ocean Cake");
        System.out.printf("\n\t\tCC006 - Black Orchid Cake");
        
        System.out.printf("\n\n\t\tPastry:");                                           //print lists of pastry variations in the store
        System.out.printf("\n\t\tPP001 - Brownies");
        System.out.printf("\n\t\tPP002 - Croffle");
        System.out.printf("\n\t\tPP003 - Donut");
        System.out.printf("\n\t\tPP004 - Churros");
        System.out.printf("\n\t\tPP005 - Tart");
        System.out.printf("\n\t\tPP006 - Bombolone \n\n");
        
        
        //system will input data based on file named "order.txt"
        FileReader fr = new FileReader("Order.txt");                    //to open file named order.txt
        BufferedReader br = new BufferedReader(fr);                     //buffer the input from the file
       
        int count = 0;                                                  //initialize count into 0 
        StringTokenizer st = null;                                      //initialize token as null
        String dataRow = br.readLine();                                 //to read one line of data
       
        while(dataRow != null)                                          //to make sure read until the end of data
        {   st = new StringTokenizer(dataRow, "*");                     //to cut the word based on "*" delimiter
            
            String name = st.nextToken();                               //get next token as customer's name
            String phone = st.nextToken();                              //get next token as customer's phono number
            String address =st.nextToken();                             //get next token as customer's address
            cust [count] = new Customer (name, phone, address);         //initialize customers' details into Customer class
            
            String code = st.nextToken();                               //get next token as code from menu
            int quantity = Integer.parseInt(st.nextToken());            //get next token as quantity of order
            
            //system will check the code if "CC" for cake OR "PP" for Pastry
            if(code.contains("CC"))                        //if code does contains 'CC' characters then the statement block below will be executed
            {
                String shape = st.nextToken();                                                  //get next token as shape of the cake in order
                double weight = Double.parseDouble(st.nextToken());                             //get next token as weight (kg) of the cake
                double radius = Double.parseDouble(st.nextToken());                             //get next token as radius (cm) of the cake
                
                order[count] = new Cake(quantity,code,cust,shape,weight,radius);                //initialize cake orders' details into Cake class
            }
            
            else if(code.contains("PP"))                 //however, if code contains 'PP' characters instead then the statement block below will be executed
            {
                int qtyPerBox = Integer.parseInt(st.nextToken());                               //get next token as quantity of pastry in each boxes
                String flavour = st.nextToken();                                                //get next token as flavour of pastry
                boolean addCheese = Boolean.parseBoolean(st.nextToken());                       //get next token as options to add cheese or not
                
                order[count] = new Pastry(quantity, code, cust, qtyPerBox,flavour, addCheese);  //initialize pastry orders' details into Pastry class
            }            
            count++;                        //update the count variable
            dataRow = br.readLine();        //read the new line of data
        }
        
        
        //input from console
        Scanner input = new Scanner(System.in);                         //create Scanner object to place input (int, double, float) from console into input
        Scanner inputText = new Scanner(System.in);                     //create Scanner object to place input (String) from console into inputText
        
        //this condition executes if there's any blank elements in array
        for(int i = count; i < cust.length; i++)
        {
            System.out.println("Customer " + (i + 1) + " :");        //print header Customer and the number of customer
            System.out.println("Enter Name: ");                      //prompt for customer's name
            String name = inputText.nextLine();                      //get customer's name from Scanner object, inputText
            System.out.println("Enter Number Phone ");               //prompt for customer's phone number
            String phone = inputText.nextLine();                     //get customer's phone number from Scanner object, inputText
            System.out.println("Enter State: ");                     //prompt for customer's state
            String address = inputText.nextLine();                   //get customer's address from Scanner object, inputText         
            
            cust[i] = new Customer(name, phone, address);            //initialize customers' details based on the inputs above into Customer class
            
            System.out.println("\nOrder Customer " + (i+ 1) + " :");    //print header Order Customer and the number of the order 
            System.out.println("Enter Code Bakery (Example: CCXXX - for cake /PPXXX - for pastry): "); // Prompt for the code of the order
            String code = inputText.nextLine();             //get customer's order from Scanner object, inputText
            System.out.println("Enter Quantity: ");         //prompt customer for the quantity of their order
            int quantity = input.nextInt();                 //get the quantity through Scanner object input

            //using inputText code to determine if the order is to be put into Cake class or Pastry class
            if(code.contains("CC") || code.contains("cc"))          //if code contains the characters "CC" or "cc" regardless of case, then the statement block below will be executed
            {
                System.out.println("Enter Shape (Rectangle/Triangle/Circle): ");    //prompt for the shape of the cake
                String shape = inputText.nextLine();                                //get the shape of the cake through Scanner object, inputText
                System.out.println("Enter Weight Cake (in kilogram): ");            //prompt for the weight of the cake
                double weight = input.nextDouble();                                 //get the weight of cake through Scanner object input
                System.out.println("Enter Radius Cake (in centimetre): ");               //prompt to get radies of cake 
                double radius = input.nextDouble();                                 //get radius through Scanner object input
                
                order[i] = new Cake(quantity, code, cust, shape, weight, radius);   //initialize cake order details into Cake class
            }
            
            else if(code.contains("PP") || code.contains("pp"))     //if code contains the characters "PP" or "pp" regardless of case, then the statement block below will be executed
            {
                System.out.println("Enter Quantity Per Box (Maximum: 10): ");           //prompt for quantity of pastries in each box
                int qtyPerBox = input.nextInt();                                        //get qtyPerBox through Scanner object input
                System.out.println("Enter Flavour Pastry (You can list more than 1 flavour as reference): ");       //prompt for the flavour of the pastry
                String flavour = inputText.nextLine();                                  //get flavour through Scanner object inputText
                System.out.println("Add-on Cheese? (true/false): ");                    //prompt for the options to add cheese to their pastries or not
                boolean addCheese = input.nextBoolean();                                //get addCheese through Scanner object input
                
                order[i] = new Pastry(quantity, code, cust, qtyPerBox, flavour, addCheese);     //initialize pastry orders' (input) details into Pastry class
            }
            System.out.println("\n");
        }
        
            
        //Output file: Cake Orders
        FileWriter fwC = new FileWriter("Cake Orders.txt");              // Write data fwC into a file (Cake Orders)
        BufferedWriter bwC = new BufferedWriter(fwC);                    // Buffer data for efficiet writing into the file
        PrintWriter pwC = new PrintWriter(bwC);                          // Print pwC as Cake file 
        
        //to fitler order based on Cake and Pastry
        pwC.println("Details of Cake orders:");
        for (int i = 0; i < order.length; i++)              //system will loop through every order
        {
            if (order[i] instanceof Cake)                   //if the order is from Cake class then the block below will be executed
            {
                //Write their details into an output file named Cake Orders.txt
                Cake c = (Cake) order[i];                                           //initialize order in Cake class as 'c'
                pwC.println("\nOrder " + (i + 1) + ":");                            //print header according to the number of the order
                pwC.println(order[i].getCust(i).toString());                        //invoke customer's info to be printed
                pwC.println(c.toString());
                pwC.printf("Total: RM %.2f", c.calculatePrice());    //print an actual amount customer need to pay
                pwC.print("\n"); 
            } 
        }
        
        //Output file: Pastry Orders
        FileWriter fwP = new FileWriter("Pastry Orders.txt");           //write data fwP into a file (Pastry Orders.txt)
        BufferedWriter bwP = new BufferedWriter(fwP);                   //buffer data for efficiet writing into the file
        PrintWriter pwP = new PrintWriter(bwP);                         //print data pwP for Pastry file
        
        //to fitler order based on Pastry
        pwP.println("Details of Pastry orders:");
        for(int i = 0; i < order.length; i++)               //s will loop through every order 
        {
            if (order[i] instanceof Pastry)                 //if the order is from Pastry class then the block below will be executed
            {
                //write the detail of them into an output file named Pastry Orders.txt
                Pastry p = (Pastry) order[i];                                       //initialize order in Pastry class as 'p'
                pwP.println("\nOrder " + (i + 1) + ":");                            //print header according to the number of the order 
                pwP.println(order[i].getCust(i).toString());                        //invoke customer's info
                pwP.println(p.toString());
                pwP.printf("Total: RM %.2f", p.calculatePrice());           //print and actual amount customer need to pay
                pwP.print("\n"); 
            }
        }
        
        //Output file: Pastry Cheese Orders
        FileWriter fwCheese = new FileWriter("Pastry Cheese.txt");          //write data fwCheese into a file (Pastry Cheese.txt)
        BufferedWriter bwCheese = new BufferedWriter(fwCheese);             //buffer data for efficient writing into the file
        PrintWriter pwCheese = new PrintWriter(bwCheese);                   //print data pwCheese for Pastry Cheese file
        
        //to filter order Pastry who order add cheese
        pwCheese.println("Details Order Who Add-on Cheese:");
        for (int i = 0; i < order.length; i++)              //system will loop through every order
        {
            if (order[i] instanceof Pastry)                 //if the order is from Pastry class then the block below will be executed
            {
                Pastry p2 = (Pastry) order[i];              //initialize order in Pastry class as 'p2'
                if(p2.getAddCheese())
                {
                    pwCheese.println("\nOrder " + (i + 1) + ":");           //print header according to the number of the order 
                    pwCheese.println(order[i].getCust(i).toString());       //print invoke customer's info
                    pwCheese.println(p2.toString());   //print invoked customer's orders
                    pwCheese.printf("Total: RM %.2f", p2.calculatePrice());           //print and actual amount customer need to pay
                    pwCheese.print("\n"); 
                }
            } 
        }
        
        //to calculate total sales and average sales in a day
        double sumAll = 0, average;                                     //declare sumAll and average as variables
        for(int i = 0; i < order.length; i++)                           //System will loop through every order
        {                           
            sumAll = sumAll + order[i].calculatePrice();                //sumAll will added with order[i] prices in every loop 
        }
        average = sumAll / count;                                       //the average of all orders is sumAll divided by count
        
        //to determine highest sales in a day
        double highest = order[0].calculatePrice();                     //declare highest as the price from the first order
        for(int i = 0; i < order.length; i++)                           //system will loop through every order
        {   
            if(order[i].calculatePrice() > highest)                     //if order's price is higher than 'highest'
                highest = order[i].calculatePrice();                    //then the value inside highest will be replaced with the current order's price
        }
        
        //to determine lowest sales in a day
        double lowest = order[0].calculatePrice();                      //declare lowest as the price from the first order
        for(int i = 0; i < order.length; i++)                           //system will loop through every order
        {  
            if(order[i].calculatePrice() < lowest)                      //if order's price is lower than 'lowest'
                lowest = order[i].calculatePrice();                     //then the value inside lowest will be replaced with the current order's price
        }
        
             
        //update phone number
        int found = -1, searchCount = cust.length;                          //declare found and searchCount
        System.out.println("Confirm all customer's phone number were the latest one? (Change/Confirm): ");            //prompt to use the original or change customer's phone number
        String condition = inputText.nextLine();                                                                        //get condition through inputText
        for(int i = 0 ; i < searchCount; i++)           //System will loop through every customer
        {
            if(condition.equalsIgnoreCase("Change"))    //if condition is "Change", regardless of case,the statement block below will be executed
            {
                System.out.println("\nEnter Customer's Name: ");            //prompt for customer's name
                String searchName = inputText.nextLine();                   //answer will be placed in searchName
                
                for(int j = 0; j < searchCount; j++)    //system will loop through every customer 
                {
                    if(order[j].getCust(j).getName().equalsIgnoreCase(searchName)) //if customer's name invoked is the same with searchName,
                    {
                        found = j;                                                 //then value of found will be replaced with the index of element with searchName
                        break;
                    }
                }
                
                if(found == -1)                     //if the value of found is unchanged 
                {
                    System.out.print("\nThere's no records for customer name " + searchName + ". Try again");  //a message abt searchName non-existence will appear
                    System.out.println("\nChange Another Customer's Phone Number? (Yes/No): "); //prompt to change another customer's phone number
                    String condition2 = inputText.nextLine();                                 //answer will be placed in condition2
                    
                    if(condition2.equalsIgnoreCase("No"))                   //if condition2 is 'No', then 
                        break;                                              //the loop will break
                }
                
                else                                //however, if the value of found is not -1, then
                {
                    System.out.println("Enter New Phone Number: ");     //prompt for new phone number will appear
                    String newNumber = inputText.nextLine();            //the input will be placed inside newNumber
                    order[found].getCust(found).setPhone(newNumber);    //the setPhone method from Customer class will be invoked to place the new value inside
                    
                    System.out.println("Change Another Customer's Phone Number? (Yes/No): "); //prompt to change another customer's phone number
                    String condition3= inputText.nextLine();                                 //answer will be placed in condition2
                    
                    if(condition3.equalsIgnoreCase("No"))                   //if condition2 is 'No', then 
                        break;                                              //the loop will break
                }
            }
            
            else if(condition.equalsIgnoreCase("Confirm")) //if condition is "Confirm"
                break;                                     //then this segment will be skipped
        }
        
        //to output orders into a file with 'date' Orders.dat name
        //this is for employees to record daily orders to keep track of orders they need to fulfill
        FileWriter fw = new FileWriter(java.time.LocalDate.now() +" Orders.dat");               //write data fw into a file (__-__-____ Orders.dat)
        BufferedWriter bw = new BufferedWriter(fw);                                             //buffer data for efficiet writing into the file                           
        PrintWriter pw = new PrintWriter(bw);                                                   //p data pw for Orders file
        
        for (int i = 0; i < order.length; i++)              //system will loop through every order 
        {
            pw.println("\nOrder " + (i + 1) + ":");         //print header according to the number of the order as pwP
            pw.println(order[i].getCust(i).toString());     //print invoked customer's detaild
            pw.println(order[i].toString());                //print details of recorded customers' orders
            pw.printf("\nTotal: RM %.2f", order[i].calculatePrice());    //print an actual amount customer need to pay
        }
        
        //at the end of day, system executed sales analysis 
        System.out.println("\n\t\t------------------ Sales Analysis as of "+ java.time.LocalDate.now()+ "------------------");      //header is about Sales analysis for the current date
        System.out.printf("\n\t\t\t\tTotal Revenue of the Day: RM %.2f", sumAll);       //console will display total sales 
        System.out.printf("\n\t\t\t\tAverage Revenue per Order: RM %.2f", average);     //console will display average sales 
        System.out.printf("\n\t\t\t\tHighest Order Value: RM %.2f", highest);           //console will display highest sale
        System.out.printf("\n\t\t\t\tLowest Order Value: RM %.2f", lowest);             //console will display lowest sale
                         
                          
        br.close();          //close input file
        pw.close();          //close pw output file
        pwC.close();         //close pwC output file
        pwP.close();         //close pwP output file
        pwCheese.close();    //close pwCheese output file
        
       }//end try
        catch(EOFException eof)                                        //to display a message if an error related to file occur
        {    System.out.println("\nProblem: " + eof.getMessage()); }   //display problem if the end of the file or stream is reached unexpectedly
        catch(FileNotFoundException e)                                 //a file with the specified pathname does not exist
        {    System.out.println("\nProblem: " + e.getMessage()); }     //display message of the problem
        catch(IOException ioe)                                         //failed or interrupted I/O operations
        {    System.out.println("\nProblem: " + ioe.getMessage()); }   //to display message of the problem
        finally                                                        
        {    System.out.println("\n\n\n\nEnd of the program"); }  //message displayed when program ends
    }//end main 
}