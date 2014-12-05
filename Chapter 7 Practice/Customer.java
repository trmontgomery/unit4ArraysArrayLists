import java.util.List
public class Customer
{
    private String name;
    private double amount;

    public Customer(String n, double a)
    {
        name = n; 
        amount = a;
    }

    public String getName()
    {
        return name;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public void setName(String newName)
    {
       name = newName; 
    }
    
    public void setAmount(double newAmount)
    {
        amount = newAmount;
    }
        
}
