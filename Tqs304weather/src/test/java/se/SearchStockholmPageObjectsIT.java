/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

import se.pages.SearchResultPage;
import se.pages.LocationPage;
import se.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.seljup.SeleniumExtension;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

/**
 *
 * @author ico
 */
@ExtendWith(SeleniumExtension.class)
public class SearchStockholmPageObjectsIT {

    WebDriver driver;

    public SearchStockholmPageObjectsIT(FirefoxDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    public void setup() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyThatStockholmCanBeFound() {
        HomePage home = new HomePage(driver);
        SearchResultPage searchResult = home.searchFor("Stockholm");

        LocationPage stockholm = searchResult.clickOnTopSearchResultLink();

        String expected = "Stockholm";
        String actual = stockholm.getHeadLine();
        assertTrue(actual.contains(expected));
    }
    
    


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

}
