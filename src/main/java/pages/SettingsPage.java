package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SettingsPage {

    WebDriver driver;
    WebDriverWait wait;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open Settings
    public void openSettings() {
        driver.get("https://hercules.works/settings");
    }

    // Locators
    By fullNameInput = By.xpath("//input[@value='Sahil Shirale' or contains(@value,'Sahil')]");
    By accountBtn = By.xpath("//button[normalize-space()='Account']");
    By billingTab =By.xpath("//button[normalize-space()='Billing']");

    // Verify Name in textbox
    
    public void verifyFullName(String expectedName) {
        String actualName = driver.findElement(fullNameInput).getAttribute("value");
        Assert.assertEquals(actualName, expectedName, "Name mismatch in Settings!");
    }

    public void clickAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(accountBtn)).click();
    }

    // Click Billing
    public void clickBilling() {
        driver.findElement(billingTab).click();
    }
}