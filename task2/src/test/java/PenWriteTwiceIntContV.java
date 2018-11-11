import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PenWriteTwiceIntContV {

    private Pen pen;
    private int testinkContainerValue;
    private String testWord;
    private String expResult;

    public PenWriteTwiceIntContV(int testinkContainerValue, String testWord, String expResult){
        this.testinkContainerValue = testinkContainerValue;
        this.testWord = testWord;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{1,"l",""},{3,"lo","l"},{50,"long","long"}});
    }

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue);

    }

    @After
    public void tearDown() {
        pen = null;
    }

    @Test
    public void write() {
        pen.write(testWord);
        assertEquals(expResult,pen.write(testWord));
    }
}