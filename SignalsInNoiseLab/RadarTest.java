import org.junit.Assert;
import javax.swing.JFrame;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarTest.
 *
 * @author  Tiffany Montgomery
 * @version 12/22/14
 */
public class RadarTest
{
    /**
     * Default constructor for test class RadarTest
     */
    public RadarTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public static void testState1() throws InterruptedException 
    {
        int startRow = 1;
        int startCol = 1;
        int maxX = 5;
        int maxY = 5;
        int dx = 1;
        int dy = 2;
            
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar = new Radar(ROWS, COLS, startRow, startCol, maxX, maxY, dx, dy);
        radar.setNoiseFraction(0.000);
        radar.scan();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 40; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            radar.scan();
            frame.repaint();
        }
        int [] expectedVelocity = {dx,dy};
        int [] velocity = radar.findVelocity();
        Assert.assertArrayEquals(expectedVelocity, velocity);
    }
    
    @Test
    public static void testState2() throws InterruptedException
    {
        int startRow = 12;
        int startCol = 7;
        int maxX = 5;
        int maxY = 5;
        int dx = 3;
        int dy = 4;
            
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar = new Radar(ROWS, COLS, startRow, startCol, maxX, maxY, dx, dy);
        radar.setNoiseFraction(0.000);
        radar.scan();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 40; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            radar.scan();
            frame.repaint();
        }
        
        int [] expectedVelocity = {dx,dy};
        int [] velocity = radar.findVelocity();
        Assert.assertArrayEquals(expectedVelocity, velocity);
    }
    
    @Test
    public static void testState3() throws InterruptedException
    {
        int startRow = 99;
        int startCol = 4;
        int maxX = 5;
        int maxY = 5;
        int dx = 1;
        int dy = -1;
            
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        Radar radar = new Radar(ROWS, COLS, startRow, startCol, maxX, maxY, dx, dy);
        radar.setNoiseFraction(0.000);
        radar.scan();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 40; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            radar.scan();
            frame.repaint();
        }
        
        int [] expectedVelocity = {dx,dy};
        int [] velocity = radar.findVelocity();
        Assert.assertArrayEquals(expectedVelocity, velocity);
    }
}
