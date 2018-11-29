package webSteam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AgePage extends BaseEntity {

    public static Boolean present () {
        Boolean check = false;
        try {
            WaitFor.waitForId(PartsOfMenu.pageAgeId);
            check = true;
        } catch (Exception e){
            return check;
        }
        return check;
    }

    public static void gameAskPage(){
        try {
            WebElement elementAskPage = WaitFor.waitForXPath(PartsOfMenu.pageAgeYearXPath);
            elementAskPage.click();
            elementAskPage.sendKeys(Params.ageBorn);
        }catch (Exception e){

        }
        WebElement openPage;
        try {
            openPage = driver.findElement(By.linkText(PartsOfMenu.pageAgeCloseRus));
        } catch (Exception e){
            openPage = driver.findElement(By.linkText(PartsOfMenu.pageAgeCloseEn));
        }
        openPage.click();
    }

}
