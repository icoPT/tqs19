/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.seljup.SeleniumExtension;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

/**
 *
 * @author ico
 */
@ExtendWith(SeleniumExtension.class)
public class SearchStockolmExportedIT {


    WebDriver driver;

    public SearchStockolmExportedIT(FirefoxDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

       @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    
       @Test
    public void testSearchExportedFromIDE() throws Exception {
       String baseUrl = "http://www.yr.no";
        driver.get(baseUrl + "/");

        WebElement searchField = driver.findElement(By.id("sted"));
        searchField.clear();
        searchField.sendKeys("Stockholm");
        searchField.submit();

        String topLinkXPathExpression = "//div[@id='directories']/table/tbody/tr/td[2]/a";
        WebElement topSearchResult = driver.findElement(By.xpath(topLinkXPathExpression));
        topSearchResult.click();
        /// driver.findElement(By.cssSelector("li")).click();
        String expected = "Stockholm";
        WebElement actualHeadLine = driver.findElement(By.cssSelector("h1"));
        String actual = actualHeadLine.getText();
        assertTrue(actual.contains(expected));
    }

}
