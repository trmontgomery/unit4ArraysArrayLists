
/**
 * The model for radar scan and accumulator
 * 
 * @author Tiffany Montgomery
 * @version December 28, 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    
    //create copy of the current arrray to compare to the next array
    private boolean[][] prevScan;
    
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;
    
    // maximum displacement x and y
    private int maxX;
    private int maxY;
    
    //displacement of the monster
    private int dX;
    private int dY;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols, int startX, int startY, int mX, int mY, int dx, int dy)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        prevScan = new boolean[rows][cols];
        accumulator = new int[(mX*2)+1][(mY*2)+1]; // elements will be set to 0
        
        // randomly set the location of the monster (can be explicity set through the setMonsterLocation method)
        monsterLocationRow = startX;
        monsterLocationCol = startY;
        
        //set maximum x,y displacement
        maxX = mX;
        maxY = mY;
        
        //set displacements x,y
        dX = dx;
        dY = dy;
        
        noiseFraction = 0.05;
        numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        
        // zero the current scan grid
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                if (currentScan[row][col] == true)
                {
                  prevScan[row][col] = true;
                  currentScan[row][col] = false;  
                }
            }
        }
        
        // move the monster
        monsterLocationRow = monsterLocationRow + dX;
        monsterLocationCol = monsterLocationCol + dY;
        
        // inject noise into the grid
        injectNoise();
        
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                if (currentScan[row][col] == true)
                {
                    for (int prevRow = 0; row < prevScan.length; prevRow++)
                    {
                        for (int prevCol = 0; col < prevScan.length; prevCol++)
                        {
                            if (prevScan[prevRow][prevCol] == true)
                            {
                                int currentDisplacementX = row - prevRow;
                                int currentDisplacementY = col - prevCol;
                                accumulator[currentDisplacementX + maxX][currentDisplacementY + maxY]++;
                            }
                        }
                    }
                }
            }
        }
        
        // keep track of the total number of scans
        numScans++;
    }
    
    /**
     * Return an array with the horizontal and vertical displacements
     * 
     * @return an array with the horizontal and vertical displacements
     */
    public int[] findVelocity()
    {
        int maxVal = accumulator[0][0];
        
        for (int row = 0; row < accumulator.length; row++)
        {
            for (int col = 0; col < accumulator[0].length; col++)
            {
                if (accumulator[row][col] > maxVal)
                {
                    maxVal = accumulator[row][col];
                    dX = row;
                    dY = col;
                }
            }
        }
        
        System.out.println("dx of monster: "+ dX);
        System.out.println("dy of monster: "+ dY);
        
        int [] velocity = {dX,dY};
        return velocity;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
}
