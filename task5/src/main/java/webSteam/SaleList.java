package webSteam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SaleList extends BaseEntity{

    public static WebElement maxSaleElement;
    public static String maxSaleCount;

    public static void findMaxSale(){

        List<WebElement> saleElements;
        List<WebElement> baseSaleElements;
        ArrayList<String> saleString = new ArrayList<>();
        ArrayList<Integer> saleInteger = new ArrayList<>();

        saleElements = driver.findElements(By.xpath(PartsOfMenu.saleListXPath));
        baseSaleElements = driver.findElements(By.xpath(PartsOfMenu.baseSaleListXPath));

        for (WebElement s : saleElements){
            saleString.add(s.getText());
        }

        for (WebElement s : baseSaleElements){
            saleString.add(s.getText());
        }

        for (String s : saleString){
            s = s.replace("-","");
            s = s.replace("%","");
            if (!s.equals(""))
                saleInteger.add(Integer.parseInt(s));
        }

        int maxSale = 0;

        for (Integer i : saleInteger){
            if ((int)i > maxSale)
                maxSale = i;
        }

        maxSaleCount = "-" + maxSale + "%";

        for (WebElement e : saleElements){
            if (e.getText().equals(maxSaleCount)){
                maxSaleElement = e;
            }
        }
    }
}
