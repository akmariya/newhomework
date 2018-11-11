import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PenWriteNullWord {

    private Pen pen;
    private int testinkContainerValue = 1;
    private String word = null;
    private String actual;

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue);

    }

    @After
    public void tearDown() {
        pen = null;
    }

    @Test(expected = NullPointerException.class)
    public void write() {
        actual = pen.write(null);
    }
}