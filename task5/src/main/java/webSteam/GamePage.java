package webSteam;

import org.openqa.selenium.WebElement;

public class GamePage extends BaseEntity {

    public static String saleCount;

    public static String getSale(){
        WebElement saleLabel;

        try {
            saleLabel = WaitFor.waitForXPath(PartsOfMenu.saleInGameXPath);
        }
        catch (Exception e){
            saleLabel = WaitFor.waitForXPath(PartsOfMenu.baseSaleInGamestXPath);
        }

        saleCount = saleLabel.getText();
        return saleCount;
    }

}
