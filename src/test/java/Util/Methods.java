package Util;

import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {
    public static String text = "";

    public WebElement findElement(String key) {
        try {
            WebElement element = (new WebDriverWait(driver, 15, 300))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
            return element;
        } catch (Exception ex) {
            Assertions.fail(" " + key + "'li element 10 saniye boyunca arandı fakat bulunamadı...!!!!");
            return null;
        }
    }
    public List<WebElement> findElements(String key){
        try {
            WebDriverWait waitForFormLabel = new WebDriverWait(driver,30);
            List<WebElement> elements = driver.findElements(By.cssSelector(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (Exception ex){
            Assertions.fail(" " + key + "'li element 10 saniye boyunca arandı fakat bulunamadı...!!!!");
            return null;
        }
    }
    public void clictToElement(WebElement element){
        scrollToElement(element);
        waitByMilliSeconds(500);
        element.click();
    }

    public void sendKeysToElement(WebElement element, String text) {

        scrollToElement(element);
        waitByMilliSeconds(500);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
    }


    public void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int randomInt(String key) {
        List <WebElement> element= findElements(key);
        Random r = new Random();
        int low = 1;
        int high = element.size()-1;
        int result = r.nextInt(high - low) + low;
        System.out.println(result + ". Elemente tıklandı..");
        return result;
    }
    public void SelectMethod(String key, String text) {
        Select element = new Select(findElement(key));
        element.selectByVisibleText(text);
    }


}
