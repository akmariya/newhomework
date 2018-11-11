import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PenWriteIntContV_SizeLetter {

    private Pen pen;
    private int testinkContainerValue;
    private String testWord;
    private double testSizeLetter;
    private String expResult;

    public PenWriteIntContV_SizeLetter(int testinkContainerValue, double testSizeLetter, String testWord, String expResult){
        this.testinkContainerValue = testinkContainerValue;
        this.testSizeLetter = testSizeLetter;
        this.testWord = testWord;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{1,1,"",""},{1,1,"lo","l"},{1,1.5,"l",""},{2,1,"lo","lo"},{2,1.5,"lo","l"},
                {3,1,"long","lon"},{300,1,"longlongword","longlongword"},{3,300,"longlongword",""}});
    }

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue,testSizeLetter);

    }

    @After
    public void tearDown() {
        pen = null;
    }

    @Test
    public void write() {
        assertEquals(expResult,pen.write(testWord));
    }



}