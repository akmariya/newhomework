import au.com.bytecode.opencsv.CSVWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FireFoxTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = WebBrowser.getInstance(new FirefoxDriver());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fireFoxCommonTest() {
        driver.get(Input.site);

        AuthoraizeWindow.logIn(Input.login,Input.password);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        WebElement nameOnPage = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("Header__BlockNameUser"));
            }
        });
        assertEquals(Input.nameUser,nameOnPage.getText());

        String expect = ListOfParticles.clickOnSomeItem();
        WebElement titleOnPage = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("Page__TitleActivePage"));
            }
        });
        assertEquals(expect,titleOnPage.getText());

        MainPage.openMainPage();

        String cvs = Input.outputFileFireFox;
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(cvs));
            writer.writeNext(MainPage.getResurses());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogOut.logOut();

    }
}
