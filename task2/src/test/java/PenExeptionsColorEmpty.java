import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PenExeptionsColorEmpty {

    private Pen pen;
    private int testinkContainerValue = 2;
    private int testsizeLetter = 2;
    private String testColor = "";
    private Boolean actual;
    private Boolean expResult = true;

    @After
    public void tearDown() {
        pen = null;
    }

    @Test
    public void createWithInkContV_SizeLetter_Color(){
        actual = false;
        try {
            new Pen(testinkContainerValue, testsizeLetter, testColor);
        } catch (Exception e){
            actual = true;
        }
        assertEquals(expResult,actual);

    }


}