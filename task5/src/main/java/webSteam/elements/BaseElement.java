package webSteam.elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import webSteam.BaseEntity;
import webSteam.WaitFor;


public abstract class BaseElement extends BaseEntity {

    public WebElement element;

    public BaseElement (String xPath) {
        element = WaitFor.waitForXPath(xPath);
    }

    public static void hang (BaseElement someElement){
        Actions builder = new Actions(BaseEntity.driver);
        builder.moveToElement(someElement.element);
        Action action  = builder.build();
        action.perform();
        builder.moveToElement(someElement.element);
        action  = builder.build();
        action.perform();

    }

    public static void click (BaseElement someElement) {
        someElement.element.click();
    }

}

