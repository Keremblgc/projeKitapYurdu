package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.FavoritePage;
import com.kitapyurdu.pages.LoginPage;
import com.kitapyurdu.pages.ProductPage;
import com.kitapyurdu.pages.ScoreCatalogue;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage=new LoginPage();
        ProductPage productPage=new ProductPage();
        FavoritePage favoritePage = new FavoritePage();
        ScoreCatalogue scoreCatalogue=new ScoreCatalogue();
        loginPage.login();
        productPage.searchProduct();
        productPage.addFavorite();
        favoritePage.checkFavorite();
        scoreCatalogue.selectRanking();
        scoreCatalogue.selectRandom();
        productPage.orders();
        productPage.addAddress();
        productPage.pay();
        loginPage.logout();
    }

}
