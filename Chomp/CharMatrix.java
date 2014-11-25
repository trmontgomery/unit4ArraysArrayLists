// Implements a 2-D array of characters

public class CharMatrix
{
  // Instance variable:
  private char[][] grid;
  

  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public CharMatrix(int rows, int cols)
  {
    grid = new char[rows][cols];
  }

  // Constructor: creates a grid with dimensions rows , cols ,
  // and fills it with the fill  character
  public CharMatrix(int rows, int cols, char fill)
  {
    grid = new char[rows][cols];
    //x equals the amount of rows
    //y equal the amount of columns
    for (int x = 0; x < grid.length; x++)
    {
        for (int y = 0; y < grid[x].length; y++)
        {
            grid[x][y] = fill;
        }
    }
  }

  // Returns the number of rows in grid
  public int numRows()
  {
     return grid.length;
  }

  // Returns the number of columns in grid
  public int numCols()
  {
    return grid[0].length;
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
     return grid[row][col];
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
     grid[row][col] = ch;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
     if (grid[row][col] == ' ')
     {
         return false;
     }
     else
     {
         return true;
     }
  }

  // Fills the given rectangle with fill  characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
    for (int x = row0; x <= row1; x++)
    {
        for (int y = col0; y <= col1; y++)
        {
            grid[x][y] = fill;
        }
    }
  }

  // Fills the given rectangle with SPACE characters.
  // row0, col0 is the upper left corner and row1, col1 is the
  // lower right corner of the rectangle.
  public void clearRect(int row0, int col0, int row1, int col1)
  {
    for (int x = row0; x <= row1; x++)
    {
        for (int y = col0; y <= col1; y++)
        {
            grid[x][y] = ' ';
        }
    }
  }

  // Returns the count of all non-space characters in row 
  public int countInRow(int row)
  {
    int count = 0;
    //rows = x
    //cols = y
      for (int x = 0; x < grid[row].length; x++)
    {
        if (grid[row][x] != ' ')
            {
                count++;
            }        
    }
    return count;
  }

  // Returns the count of all non-space characters in col 
  public int countInCol(int col)
  {
    int count= 0;
      for (int x = 0; x < grid.length; x++)
    {
        if (grid[x][col] != ' ')
        {
            count++;
        }        
    }
    return count;
  }
}
