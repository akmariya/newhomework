import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PenWriteTwiceIntContV_SizeLetter_Color {

    private Pen pen;
    private int testinkContainerValue;
    private String testWord;
    private double testSizeLetter;
    private String testColor;
    private String expResult;

    public PenWriteTwiceIntContV_SizeLetter_Color(int testinkContainerValue, double testSizeLetter, String testWord, String testColor, String expResult){
        this.testinkContainerValue = testinkContainerValue;
        this.testSizeLetter = testSizeLetter;
        this.testWord = testWord;
        this.testColor = testColor;
        this.expResult = expResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{1,1,"","Color",""},{1,1,"lo","Color",""},
                {1,2,"lo","Color",""}, {2,1,"lo","Color",""},{300,1,"longlongword","Color","longlongword"},{3,300,"longlongword","Color",""}});
    }

    @Before
    public void setUp() {
        pen = new Pen(testinkContainerValue,testSizeLetter,testColor);

    }

    @After
    public void tearDown(){
        pen = null;
    }

    @Test
    public void write() {
        pen.write(testWord);
        assertEquals(expResult,pen.write(testWord));
    }



}