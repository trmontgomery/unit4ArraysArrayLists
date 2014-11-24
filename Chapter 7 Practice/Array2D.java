

public class Array2D
{
    private int [][][][] table = 
      {
         {
            {
               {1,2,3},
               {4,5,6},
               {7,8,9},
               {10,11,12}
            },
            {
               {1,2,3},
               {4,5,6},
               {7,8,9},
               {10,11,12}
            }
         
         },
         {
            {
               {1,2,3},
               {4,5,6},
               {7,8,9},
               {10,11,12}
            },
            {
               {1,2,3},
               {4,5,6},
               {7,8,9},
               {10,11,12}
            }      
         }
      };
     ;
    
    public Array2D()
    {
        
    }
    
    public String toString()
    {
        String str = "";
       
        /*
         * for (int d4 = 0; d4 < table.length; d4++)
        {
            //table[d4].length is the number of columns in row
            for (int d3 = 0; d3 < table[d4].length; d3++)
            {
                for (int d2 = 0; d2 < table[d3].length; d2++)
                {
                    for (int d1 = 0; d1 < table[d2].length; d1++)
                    {
                        str += table[d4][d3][d2][d1] + "\t";
                    }
                    str += table[d4][d3][d2] + "\t";
                    str += "\n";
                }
                str += table[d4][d3] + "\t";
                str += "\n";
            }
            str += "\n";
        }
         */
        
        for (int row = 0; row < table.length; row++)
        {
            for (int col = 0; col < table[row].length; col++)
            {
                str += table[row][col] + "\t";
            }
            str += "\n";
        }
        
        return str;
    }
    
    public String extractRow(int row)
    {
        String str = "";
        /*
         * for (int col = 0; col < table[row].length; col++)
        {
            str += table[row][col];
        }
        
         */
        
        for(int[] val : table[row])
        {
            str += val + "\t";
        }
        
        return str;
    }
    
    public String extractColumn(int col)
    {
        String str = "";
        for (int row = 0; row < table.length; row++)
        {
            str += table[row][col] + "\n";
        }
        
        for(int [] rowOfInts : table)
        {
            str += rowOfInts[col] + "\n";
        }
    }

    public static void main(String[] args)
    {
        Array2D bossLife = new Array2D();
        System.out.println(bossLife.toString());
        System.out.println(bossLife.extractRow());
        System.out.println(bossLife.extractColumn());
    }
}
