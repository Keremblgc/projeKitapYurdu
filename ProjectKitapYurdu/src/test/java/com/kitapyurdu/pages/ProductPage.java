package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static com.kitapyurdu.driver.BaseTest.driver;

public class ProductPage {
    Methods methods;
    Logger logger = LogManager.getLogger(Package.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void searchProduct() {
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
    }

    public void addFavorite() {
        methods.scroll(By.xpath("(//*[@class='add-to-favorites'])[7]"));
        for (int i = 6; i < 10; i++) {
            methods.click(By.xpath("(//*[@class='fa fa-heart'])" + "[" + i + "]"));

        }
    }

    public void orders() {
        methods.click(By.id("cart-items"));
        methods.click(By.id("js-cart"));
        doubleClick();
        methods.sendKeys(By.cssSelector(".js-cart-update-product>input"), "2");
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.click(By.cssSelector(".right>a"));
    }

    public void doubleClick() {
        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(By.cssSelector(".js-cart-update-product>input"));
        act.doubleClick(ele).perform();
    }

    public void addAddress() {
        methods.click(By.xpath("//*[@id=\"shipping-tabs\"]/a[2]"));
        methods.sendKeys(By.id("address-firstname-companyname"), "kerem");
        methods.sendKeys(By.id("address-lastname-title"), "bilgiç");
        Select drpCountry = new Select(methods.findElement(By.id("address-country-id")));
        drpCountry.selectByVisibleText("Türkiye");
        Select drpZone = new Select(methods.findElement(By.xpath("//*[@id=\"address-zone-id\"]")));
        drpZone.selectByVisibleText("Mersin");
        Select drpCity = new Select(methods.findElement(By.xpath("//*[@id=\"address-county-id\"]")));
        drpCity.selectByVisibleText("YENİŞEHİR");
        methods.sendKeys(By.id("district"), "Çiftlikköy ");
        methods.sendKeys(By.id("address-address-text"), "3250.sokak alone4 apt kat2 daire 7");
        methods.sendKeys(By.id("address-postcode"), "33330");
        methods.sendKeys(By.id("address-telephone"), "3243330033");
        methods.sendKeys(By.id("address-mobile-telephone"), "5393691575");
        methods.sendKeys(By.id("address-tax-id"), "13045408038");
        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));
        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));
    }

    public void pay() {
        methods.sendKeys(By.id("credit-card-owner"), "kerem bilgiç");
        methods.sendKeys(By.xpath("//*[@id=\"credit_card_number_1\"]"), "5487");
        methods.sendKeys(By.xpath("//*[@id=\"credit_card_number_2\"]"), "9317");
        methods.sendKeys(By.xpath("//*[@id=\"credit_card_number_3\"]"), "9149");
        methods.sendKeys(By.xpath("//*[@id=\"credit_card_number_4\"]"), "5311");
        Select drpMonth = new Select(methods.findElement(By.id("credit-card-expire-date-month")));
        drpMonth.selectByVisibleText("10");
        Select drpYear = new Select(methods.findElement(By.id("credit-card-expire-date-year")));
        drpYear.selectByVisibleText("2027");
        methods.sendKeys(By.id("credit-card-security-code"), "218");
        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));
        methods.click(By.xpath("//*[@id=\"terms-and-conditions-form\"]/div/input"));
        methods.click(By.xpath("//*[@id=\"checkout-payment-form\"]/form/div/div/input"));

    }
}
