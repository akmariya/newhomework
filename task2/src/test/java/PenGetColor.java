import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PenGetColor {

    private Pen pen, pen2, pen3;
    private int testinkContainerValue = 3;
    private int testSizeLetter = 3;
    private String testColor = "Color";
    private String expResult1 = "BLUE";
    private String expResult2 = "BLUE";
    private String expResult3 = "Color";

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue);
        pen2 = new Pen(testinkContainerValue,testSizeLetter);
        pen3 = new Pen(testinkContainerValue,testSizeLetter,testColor);
    }

    @After
    public void tearDown()  {
        pen = null;
        pen2 = null;
        pen3 = null;
    }

    @Test
    public void getColor_inkContV() {
        assertEquals(expResult1,pen.getColor());
    }

    @Test
    public void getColor_inkContV_SizeLeter() {
        assertEquals(expResult2,pen.getColor());
    }

    @Test
    public void getColor_inkContV_SizeLeter_Color() {
        assertEquals(expResult3,pen.getColor());
    }
}