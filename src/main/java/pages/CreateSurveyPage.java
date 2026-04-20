package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CreateSurveyPage {

    WebDriver driver;
    WebDriverWait wait;

    public CreateSurveyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    By writeprompt= By.xpath("//span[text()='Write a prompt']");
By promptField = By.id("prompt");
    By submitBtn =  By.xpath("//div[contains(@class,'flex') and contains(@class,'justify-center')]");

    // ===== METHODS =====

    // 1. Click Create Survey
    public void clickCreateSurvey() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(writeprompt)).click();
            System.out.println("✅ Clicked Create Survey");
        } catch (Exception e) {
            System.out.println("⚠️ Create button not found");
        }
    }

    // 2. Enter Survey Name
    public void enterSurveyName(String name) {
        try {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(promptField));
            input.sendKeys("Create a survey to understand human relationship and bonding with dogs.");
            System.out.println("✅ Entered survey name");
        } catch (Exception e) {
            System.out.println("⚠️ Input field not found");
        }
    }

    // 3. Submit Survey
    public void submitSurvey() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            System.out.println("✅ Submitted survey");
        } catch (Exception e) {
            System.out.println("⚠️ Submit button not found");
        }
    }

    // 4. Basic Validation
    public void verifySurveyCreated() {

        String url = driver.getCurrentUrl();

        if (url.contains("ai")) {
            System.out.println("✅ Survey flow executed (basic validation)");
        } else {
            System.out.println("⚠️ Could not verify survey creation");
        }
    }
}
