package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger((Methods.class));

    public Methods() {
        driver = BaseTest.driver;
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchFieldException.class);
        jsdriver=(JavascriptExecutor) driver;
    }
    public WebElement findElement(By by ){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void click(By by){findElement(by).click();   }
    public void waitBySecond(long second){
        try {
            Thread.sleep(second*500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendKeys(By by,String text){
        findElement(by).sendKeys((text));
    }
    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        }catch (Exception e){
            logger.info("False"+e.getMessage());
            return false;
        }
    }
public void scroll(By by){
    Actions actions=new Actions(driver);
    actions.moveToElement(findElement(by)).build().perform();

}

public Select getSelect(By by){return new Select(findElement(by));}
    public void selectByText(By by,String text){getSelect(by).selectByVisibleText(text);}
    public void scrollJavaScript(By by){
        jsdriver.executeScript("arguments[0].scrollIntoView();",findElement(by));
    }

}


