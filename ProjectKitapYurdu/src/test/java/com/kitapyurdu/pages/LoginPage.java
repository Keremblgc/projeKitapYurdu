package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.kitapyurdu.driver.BaseTest.driver;

public class LoginPage {
    Methods methods;

    public LoginPage() {
        methods = new Methods();
    }

    public void login() {
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.sendKeys(By.id("login-email"), "kerem.bilgic@testinium.com");
        methods.sendKeys(By.id("login-password"), "1q2w3e4r5t");
        methods.click(By.cssSelector(".ky-form-buttons>button"));
        Assert.assertTrue(methods.isElementVisible(By.xpath("(//*[@class='highlight-link'])[5]")));
    }

    public void logout() {
        methods.scroll(By.xpath("(//*[@class='common-sprite'][1])"));
        methods.click(By.xpath("//*[@id=\"header-top\"]/div/div[1]/div[1]/ul/li/div/ul/li[4]/a"));

    }
}
