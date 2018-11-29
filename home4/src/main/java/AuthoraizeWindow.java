import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class AuthoraizeWindow {

    static public void logIn(String login, String password){

        WebDriver driver = WebBrowser.getInstance();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement logIn = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.className("Header__Authentication"));
            }
        });
        logIn.click();

        WebElement loginField;
        loginField = driver.findElement(By.id("LLoginForm_phone"));
        loginField.sendKeys(login);

        WebElement passwordKey;
        passwordKey = driver.findElement(By.id("LLoginForm_password"));
        passwordKey.sendKeys(password);

        WebElement button;
        button = driver.findElement(By.className("Header__ButtonLogIn"));
        Actions builder = new Actions(driver);
        builder.moveToElement(button);
        builder.click(button);
        Action action  = builder.build();
        action.perform();

    }

}
