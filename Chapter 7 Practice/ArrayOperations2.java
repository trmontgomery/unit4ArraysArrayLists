

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
        /*
         * for (int i = values.length; i > values.length; i--)
        {
            values[i] = values[values.length - i];
        }
           
         */
        /*
         * Schmit's Code:
         * 
         * life becomes easier when you iterate through things backwards
         * 
         * int last = arr.length - 1;
         * int temp = arr.[last];
         * 
         * for (int i = last; i > 0; i--)
         * {
         *     arr[i] = arr[i -1]
         *  }
         *  arr[0] = temp;
         */
       
           
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
        for (int i = 1; i > (values.length - 1); i++)
        {
            if (values[i-1] > values[i+1])
            {
                values[i] = values[i-1];
            }
            else
            {
                values[i] = values[i+1];
            }
        }
        
        /*
         * You can't walk through the array, because you will overwrite the thing you are trying 
         * analyze.  You need to remember the value that you are about to overwrite.   
         */
    }
    
    public void removeMiddle()
    {
        /*
         * if (values.length % 2 == 0)
        {
            x = int[values.length-2];
        }
        else
        {
            x int[values.length-1];
        }
         */
        
        /*
         * write two separate algorithms.
         * Make new array with a length that is shorter.
         */
    }
}
