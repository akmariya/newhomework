import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PenDoSomElseInkContV {

    private Pen pen, pen2, pen3;
    private int testinkContainerValue = 2;
    private int testSizeLetter = 2;
    private String testColor = "Color";
    private String expResult = "BLUE\r\n";
    private String expResult2 = "BLUE\r\n";
    private String expResult3 = "Color\r\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue);
        pen2 = new Pen(testinkContainerValue,testSizeLetter);
        pen3 = new Pen(testinkContainerValue,testSizeLetter,testColor);
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void tearDown() {
        pen = null;
        pen2 = null;
        pen3 = null;
        System.setOut(null);
    }


    @Test
    public void doSomethingElse_inkContV() {
        pen.doSomethingElse();

        assertEquals(expResult, outContent.toString());
    }

    @Test
    public void doSomethingElse_inkContV_SizeLeter() {
        pen2.doSomethingElse();
        assertEquals(expResult2, outContent.toString());
    }

    @Test
    public void doSomethingElse_inkContV_SizeLeter_Color() {
        pen3.doSomethingElse();
        assertEquals(expResult3, outContent.toString());
    }
}