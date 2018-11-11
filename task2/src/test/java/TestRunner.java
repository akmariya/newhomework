import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args){

        Result result = JUnitCore.runClasses(PenExeptionsColorEmpty.class, PenExeptionsForNegativeNumbers.class,
                PenExeptionsSizeLetterNull.class, PenGetColor.class, PenIsWorkForBiggerNumbers.class,
                PenIsWorkForRangeNumbers.class, PenIsWorkForSmallerNumbers.class, PenWriteIntContV.class,
                PenWriteIntContV_SizeLetter.class, PenWriteIntContV_SizeLetter_Color.class,
                PenWriteNullWord.class, PenWriteTwiceIntContV.class, PenWriteTwiceIntContV_SizeLetter.class,
                PenWriteTwiceIntContV_SizeLetter_Color.class);
        System.out.println("Total number of tests " + result.getRunCount());
        System.out.println("Total number of tests failed " + result.getFailureCount());

        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }//PenDoSomElseInkContV.class
}

