package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Steps extends Methods {
    public void clickElement(String key) {
        WebElement element = findElement(key);
        clictToElement(element);
    }

    public void randomClick(String key){
        List<WebElement> elements = findElements(key);
        clictToElement(elements.get(randomInt(key)));

    }
    public void optionClick(String key,Integer number){
        List<WebElement> elements = findElements(key);
        clictToElement(elements.get(number));

    }

    public void sendKeysToElementTest(String key, String text) {
        WebElement element = findElement(key);
        sendKeysToElement(element, text);
    }

    public void waitSecond(int second) {
        waitByMilliSeconds(second * 1000);

    }

    public void selectElement(String key, String text) {
        SelectMethod(key, text);
    }

    public void clickByXpath(String xpath){

        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        scrollToElement(element);
        element.click();
    }

    public void mouseHover(String key,String text){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(key));
        action.moveToElement(element).moveToElement(driver.findElement(By.cssSelector(text))).click().build().perform();
    }
}
