import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MainPage {

    static WebDriver driver = WebBrowser.getInstance();

    public static void openMainPage(){
        WebElement mainPage;
        mainPage = driver.findElement(By.className("header-logo"));
        mainPage.click();
    }

    public static String[] getResurses(){

        String resourse = driver.getPageSource();
        String middleResourses;
        ArrayList<String> list = new ArrayList();

        String startSearch = "ModelReviewsHome__NameModel";
        String endSearch = "</a>";
        String midleSearch = ">";

        while (resourse.indexOf(startSearch)>-1){
            resourse = resourse.substring(resourse.indexOf(startSearch));
            middleResourses = resourse.substring(resourse.indexOf(midleSearch)+1, resourse.indexOf(endSearch));
            list.add(middleResourses);
            resourse = resourse.substring(resourse.indexOf(endSearch));
        }
        String[] listFinal = list.toArray(new String[0]);
        return listFinal;

    }

}
