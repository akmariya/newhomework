import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut {
    static public void logOut(){

        WebDriver driver = WebBrowser.getInstance();
        WebElement logout;
        logout = driver.findElement(By.xpath("//*[@id=\"Header__Authentication\"]/div[2]/a"));
        logout.click();
        WebElement exit;
        exit = driver.findElement(By.id("yt0"));
        exit.click();
    }
}
