import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PenExeptionsSizeLetterNull {

    private Pen pen;
    private int testinkContainerValue = 2;
    private int testsizeLetter = 0;

    @After
    public void tearDown() {
        pen = null;
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