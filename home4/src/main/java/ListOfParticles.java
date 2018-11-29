import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ListOfParticles {

    static List <WebElement> elements;

    static public String clickOnSomeItem() {

        WebDriver driver = WebBrowser.getInstance();

        elements = driver.findElements(By.className("Catalog__SectionLevel1"));

        Random random = new Random();
        int n = random.nextInt(elements.size());
        String someTitle = elements.get(n).getText();
        elements.get(n).click();
        return someTitle;

    }


}
