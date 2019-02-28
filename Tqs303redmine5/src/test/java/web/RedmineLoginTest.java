/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import io.github.bonigarcia.seljup.SeleniumExtension;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ico
 */
@ExtendWith(SeleniumExtension.class)
public class RedmineLoginTest {
    
    WebDriver driver;

    public RedmineLoginTest(FirefoxDriver driver) {
        this.driver = driver;
    }
    

    @BeforeEach
    public void setUp() throws Exception {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testWithFirefox() {
        driver.get("http://demo.redmine.org/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("john1");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("john1");
        driver.findElement(By.name("login")).click();
        assertEquals("john1", driver.findElement(By.linkText("john1")).getText());
        driver.findElement(By.linkText("Sign out")).click();
        assertEquals("Sign in", driver.findElement(By.linkText("Sign in")).getText());
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    
}
