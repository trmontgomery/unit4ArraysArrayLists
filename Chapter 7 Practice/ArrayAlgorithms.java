
public class ArrayAlgorithms
{
    private int[] values;
    
    public ArrayAlgorithms()
    {
        values = new int[10];
    }
    
    public String toString()
    {
        String str = "[";
        for (int i = 0; i<values.length; i++)
        {
            if (i > 0)
            {
                str += ", ";
            }
            str+= values[i];
        }
        str += "]";
        return str;
    }
    
    public void fillWithSquares()
    {
        for (int i = 0; i < values.length; i++)
        {
            values[i] = i * i;
        }
    }
    
    public double getAverage()
    {
        double sum = 0;
        
        for (int val: values)
        {
            sum += val;
        }
        
        double average = sum / values.length;
        return average;
    }
    
    public int getIndexofMaximum()
    {
        int maximumValue = values[0];
        int indexOfMaximum = 0;
        
        for (int i = 1; i < values.length; i++)
        {
            if(values[i] > maximumValue)
            {
                maximumValue = values[i];
                indexOfMaximum = i;
            }
            
            
        }
        return indexOfMaximum;
    }

}
