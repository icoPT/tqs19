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
public class LocationPage {
     private WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;

        if (!driver.getTitle().startsWith("Yr")) {
            throw new IllegalStateException("This is not yr.no: " + driver.getCurrentUrl());
        }
    }

    public String getHeadLine() {
        WebElement resultPageHeadLine = driver.findElement(By.cssSelector("h1"));
        return resultPageHeadLine.getText();
    }
}
