package webSteam;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.io.File;
import java.util.Date;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitFor extends BaseEntity {

    static Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Params.loadTimeOut, SECONDS)
            .pollingEvery(Params.pullEvery, SECONDS).ignoring(ElementNotVisibleException.class, NoSuchElementException.class);

    public static WebElement waitForXPath(String xPath) {
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xPath));
            }
        });
        return element;
    }

    public static WebElement waitForId(String id) {
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(id));
            }
        });
        return element;
    }

    public static Boolean waitFor() {
        Date date1 = new Date();
        Date date2 = new Date();
        while ((date2.getTime()-date1.getTime()) < Params.fileDownloadTimeOut){
            date2 = new Date();
            if(new File(Params.filePath).isFile()==true)
                return true;
        }
        return false;
    }
}
