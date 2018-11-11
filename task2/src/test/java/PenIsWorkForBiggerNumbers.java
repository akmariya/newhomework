import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PenIsWorkForBiggerNumbers {

    private Pen pen, pen2, pen3;
    private int testinkContainerValue = 1000;
    private int testSizeLetter = 3000;
    private String testColor = "Color";
    private Boolean expResult = true;

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue);
        pen2 = new Pen(testinkContainerValue,testSizeLetter);
        pen3 = new Pen(testinkContainerValue,testSizeLetter,testColor);
    }

    @After
    public void tearDown() {
        pen = null;
        pen2 = null;
        pen3 = null;
    }

    @Test
    public void isWork_inkContV() {
        assertEquals(expResult,pen.isWork());
    }

    @Test
    public void isWork_inkContV_SizeLeter() {
        assertEquals(expResult,pen2.isWork());
    }

    @Test
    public void isWorkd_inkContV_SizeLeter_Color() {
        assertEquals(expResult,pen3.isWork());
    }
}