import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import webSteam.elements.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webSteam.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ChromeRusTest {

    WebDriver driver;

    @Before
    public void setUp(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = WebBrowser.getInstance(new ChromeDriver(cap));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void chromeRT(){

        driver.get(InputTest.site);

        Button buttonGames = new Button(PartsOfMenu.game);
        Button.hang(buttonGames);

        Button buttonEkshen = new Button(PartsOfMenu.ekshenRus);
        Button.click(buttonEkshen);

        Button buttonTopSales = new Button(PartsOfMenu.topSellersRus);
        Button.click(buttonTopSales);

        SaleList.findMaxSale();
        SaleList.maxSaleElement.click();

        if (AgePage.present())
            AgePage.gameAskPage();

        GamePage.getSale();
        assertEquals(SaleList.maxSaleCount,GamePage.saleCount);

        FileSteam.download();
        Boolean actualRes = WaitFor.waitFor();
        assertEquals(true,actualRes);

    }

}
