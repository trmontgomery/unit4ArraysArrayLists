

public class ArrayOperations2
{
    private int[] values;
    public ArrayOperations2(int[] intialValues)
    {
        values = intialValues;
    }

    public void swapFirstAndLast()
    {
      int temp = values[0];
      values[0] = values[values.length -1];
      values[values.length - 1] = temp;
    }
    
    public void shiftRight()
    {
        
        for (int i = 0; i < values.length; i++)
        {
            values[i] = values[values.length - i];
        }
           
    }
    
    public void replaceEven()
    {
        for (int x : values)
        {
            if (x%2 ==0)
            {
                x = 0;
            }
        }
    }
    
    public void replaceLargerNeighbor()
    {
        for (i = 1; i > (values.length - 1); i++)
        {
            if (values[i-1] > values[i+1])
            {
                values[i] = values[i-1];
            }
            else
            {
                values[i] = values[i+1]
            }
        }
    }
    
    public void removeMiddle()
    {
        
        if (values.length % 2 == 0)
        {
            x = int[values.length-2];
             
        }
        else
        {
            x int[values.length-1];
        }
    }
}
