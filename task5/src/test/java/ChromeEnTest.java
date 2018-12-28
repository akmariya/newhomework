import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import webSteam.*;
import webSteam.elements.Button;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ChromeEnTest {

    WebDriver driver;

    @Before
    public void setUp(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
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
    public void chromeEnT(){

        driver.get(InputTest.site);

        Button buttonGames = new Button(PartsOfMenu.game);
        Button.hang(buttonGames);

        Button buttonEkshen = new Button(PartsOfMenu.ekshenEn);
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
