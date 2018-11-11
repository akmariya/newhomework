import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PenWriteIntContV {

    private Pen pen;
    private int testinkContainerValue;
    private String word;
    private String expResult;

    public PenWriteIntContV(int testinkContainerValue, String word, String expResult){
        this.testinkContainerValue = testinkContainerValue;
        this.word = word;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{1,"",""},{1,"l","l"},{2,"longword","lo"},{50,"long","long"}});
    }

    @Before
    public void setUp(){
        pen = new Pen(testinkContainerValue);

    }

    @After
    public void tearDown() {
        pen = null;
    }

    @Test
    public void write() {
        assertEquals(expResult,pen.write(word));
    }
}