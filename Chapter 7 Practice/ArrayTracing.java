

public class ArrayTracing
{
    
    public static void main(String[] argsssssssssssss)
    {
        int[] a = {1,2,3,4,5,4,3,2,1,0};
        
        for (int i = 0; i < 9; i++)
        {
            a[i] = a[i + 1];
            System.out.println(a[i]);
        }
    }

}
