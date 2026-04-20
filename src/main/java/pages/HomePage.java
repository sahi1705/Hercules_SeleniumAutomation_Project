package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    By body = By.tagName("body");
    By pricingLink = By.xpath("//a[contains(text(),'Pricing')]");

    // ===== METHODS =====

    // 1. Verify homepage loads
    public void verifyHomePageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(body));
        Assert.assertTrue(driver.getTitle() != null && !driver.getTitle().isEmpty(),
                "Homepage not loaded properly");
    }

    // 2. Verify UI elements
    public void verifyUIElements() {
        Assert.assertTrue(driver.findElement(pricingLink).isDisplayed(),
                "Pricing link not visible");

       
    }

    // 3. Verify navigation
    public void verifyNavigation() {

        // Click Pricing
        driver.findElement(pricingLink).click();
        wait.until(ExpectedConditions.urlContains("pricing"));
        Assert.assertTrue(driver.getCurrentUrl().contains("pricing"),
                "Pricing navigation failed");

        // Go back
        driver.navigate().back();
    }
}