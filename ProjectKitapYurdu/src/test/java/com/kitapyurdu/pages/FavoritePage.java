package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.kitapyurdu.driver.BaseTest.driver;

public class FavoritePage {
    Methods methods;

    public FavoritePage() {
        methods = new Methods();
    }

    public void checkFavorite() {
        methods.scroll(By.xpath("(//*[@class='common-sprite'])[3]"));
        methods.click(By.xpath("//*[@id=\"header-top\"]/div/div[2]/ul/li[1]/div/ul/li/div/ul/li[1]/a"));
        Assert.assertTrue(methods.isElementVisible(By.id("tag-0")));
        methods.click(By.xpath("//*[@class='logo-icon']"));

    }
    public void delete(){
        List<WebElement> items = driver.findElements(By.cssSelector(".fa.fa-heart-o"));
        items.get(2).click();
        methods.click(By.id(".fa.fa-heart-o"));
    }
}
