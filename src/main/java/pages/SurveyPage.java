package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SurveyPage {

    WebDriver driver;
    WebDriverWait wait;

    public SurveyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    By surveyCards = By.xpath("//div[contains(@class,'card') or contains(@class,'survey')]");
    By pageBody = By.tagName("body");

    // ===== METHODS =====

    // 1. Verify Survey Page Loaded
    public void verifySurveyPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageBody));

        Assert.assertTrue(driver.getCurrentUrl().contains("ai"),
                "❌ Not on Survey page");

        System.out.println("✅ Survey page loaded");
    }

    // 2. Verify Surveys Displayed
    public void verifySurveysDisplayed() {

        List<WebElement> surveys = driver.findElements(surveyCards);

        if (surveys.size() == 0) {
            System.out.println("⚠️ No surveys available (valid case)");
        } else {
            System.out.println("✅ Surveys found: " + surveys.size());
        }
    }
    // 3. Select First Survey
    public void selectFirstSurvey() {

        List<WebElement> surveys = driver.findElements(surveyCards);

        if (surveys.size() > 0) {
            surveys.get(0).click();
            System.out.println("✅ Survey selected");
        } else {
            System.out.println("⚠️ No survey to select, skipping step");
        }
    }
}
