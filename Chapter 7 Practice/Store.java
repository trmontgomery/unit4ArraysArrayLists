import java.util.List;


public class Store
{
    ArrayList<Customer> thisStore = new ArrayList<Customer>;
    
    public Store()
    {
    }

    
    public void addSale(String customerName, double amount)
    {
        for (int i = 0; i < thisStore.size(); i++)
        {
            Customer c = new Customer(customerName, amount);
            thisStore.add(c);
        }
    }
    
    public String nameOfBestCustomer()
    {
        for (Customer c: thisStore)
        {
            name = c.getName();
            amount = c.getAmount();
            /*
             * do I store these somewhere else and then compare them to each 
             * other outside of the for loop??
             */ 
        }
    }
    
    public static void main(String[] args)
    {
        while(price != 0)
        {
            Scanner in = new Scanner(System.out);
            System.out.println("Add Customer name: ");
            String name = in.next();
            System.out.println("Add price: ");
            String price = in.next();
            Store newStore = new Store();
            newStore.addSale(name, price)
        }
        
        
    }

}
