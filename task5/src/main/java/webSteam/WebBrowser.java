package webSteam;

import org.openqa.selenium.WebDriver;

public class WebBrowser {

   private static WebDriver ourInstance;

    public static WebDriver getInstance(WebDriver driver) {
        ourInstance = driver;
        return ourInstance;
    }
    public static WebDriver getInstance() {
        return ourInstance;
    }

    private WebBrowser() {
    }
}
