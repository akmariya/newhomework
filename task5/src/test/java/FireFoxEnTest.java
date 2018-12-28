import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import webSteam.*;
import webSteam.elements.Button;

import static org.junit.Assert.assertEquals;

public class FireFoxEnTest {

    WebDriver driver;

    @Before
    public void setUp(){
        FirefoxProfile profile= new FirefoxProfile();
        profile.setPreference("intl.accept_languages","en" );
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk" , "application/octet-stream;application/csv;text/csv;application/exe;");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = WebBrowser.getInstance(new FirefoxDriver(options));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void fireFoxEnT(){
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
