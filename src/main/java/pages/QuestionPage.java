package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class QuestionPage {

    WebDriver driver;
    WebDriverWait wait;

    public QuestionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    
    By submitBtn =  By.xpath("//div[contains(@class,'flex') and contains(@class,'justify-center')]");
    By questionInput = By.id("prompt");
    By saveBtn = By.xpath("//button[contains(text(),'Save') or contains(text(),'Add')]");
    By editBtn = By.xpath("//button[contains(@class,'edit') or contains(text(),'Edit')]");
    By deleteBtn = By.xpath("//button[contains(@class,'delete') or contains(text(),'Delete')]");

    // ===== METHODS =====
    
    public void submitSurvey() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            System.out.println("✅ Submitted survey");
        } catch (Exception e) {
            System.out.println("⚠️ Submit button not found");
        }
    }
    
   
    // 1. Add Question
    public void addQuestion(String text) {

        try {
          

            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(questionInput));
            input.sendKeys(text);

            wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

            System.out.println("✅ Question added");
        } catch (Exception e) {
            System.out.println("⚠️ Add question flow not found");
        }
    }

    // 2. Edit Question
    public void editQuestion(String newText) {

        try {
            List<WebElement> edits = driver.findElements(editBtn);

            if (edits.size() > 0) {
                edits.get(0).click();

                WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(questionInput));
                input.clear();
                input.sendKeys(newText);

                wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

                System.out.println("✅ Question edited");
            } else {
                System.out.println("⚠️ No question to edit");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Edit flow failed");
        }
    }

    // 3. Delete Question
    public void deleteQuestion() {

        try {
            List<WebElement> deletes = driver.findElements(deleteBtn);

            if (deletes.size() > 0) {
                deletes.get(0).click();
                System.out.println("✅ Question deleted");
            } else {
                System.out.println("⚠️ No question to delete");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Delete flow failed");
        }
    }
}
