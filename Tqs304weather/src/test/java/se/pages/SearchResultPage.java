/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author ico
 */
public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().startsWith("Yr")) {
            throw new IllegalStateException("This is not yr.no: " + driver.getCurrentUrl());
        }
    }

    public LocationPage clickOnTopSearchResultLink() {
        String topLinkXPathExpression = "//div[@id='directories']/table/tbody/tr/td[2]/a";
        WebElement topResultLink = driver.findElement(By.xpath(topLinkXPathExpression));
        topResultLink.click();

        return new LocationPage(driver);
    }
}
