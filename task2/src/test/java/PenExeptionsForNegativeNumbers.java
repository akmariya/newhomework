import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PenExeptionsForNegativeNumbers {

    private Pen pen;
    private int testinkContainerValue = -2;
    private int testsizeLetter = -2;



    @Before
    public void setUp() {
           }

    @After
    public void tearDown() {
        pen = null;
    }

    @Test(expected = Exception.class)
    public void createWithInkContV() {
        new Pen(testinkContainerValue);
    }

    @Test(expected = Exception.class)
    public void createWithInkContV_SizeLetter(){
        new Pen(testinkContainerValue, testsizeLetter);
    }

    @Test(expected = Exception.class)
    public void createWithInkContV_SizeLetter_Color(){
        new Pen(testinkContainerValue, testsizeLetter, "Color");
    }


}