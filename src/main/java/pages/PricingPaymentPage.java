package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class PricingPaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PricingPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== LOCATORS =====
    By pricing = By.linkText("Pricing");
    By starterPlan = By.xpath("//h2[contains(@class,'text') and contains(text(),'Starter')]");
    By proPlan = By.xpath("//h2[contains(@class,'text') and contains(text(),'Pro')]");
    By annualPlan = By.xpath("//span[contains(text(),'Annual') and contains(text(),'20%')]");
    By getStartedBtn = By.xpath("//button[contains(text(),'Get Started')]");

    // Login
    By emailField = By.xpath("//input[@type='email']");
    By passwordField = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("(//button[contains(text(),'Log In')])[1]");

    // Upgrade
    By upgradeBtn = By.xpath("//button[contains(text(),'Upgrade') and contains(text(),'Starter') and contains(text(),'Monthly')]");
    
    By upgradeBtn2 = By.xpath("//button[contains(.,'Upgrade to starter')]");
    
    By closeIcon1 = By.xpath("//svg[path[contains(@d,'m1 1')]]");

    // Payment
    By wallet = By.xpath("//span[@data-testid='Wallet']");
    By mobikwik = By.xpath("//span[contains(@class,'font-medium') and contains(text(),'Mobikwik')]");
    By otpField = By.xpath("//input[@placeholder='Enter OTP']");
    By otpError = By.id("error_otp"); By errorMsg = By.xpath("//*[contains(text(),'error') or contains(text(),'failed')]");
    By closeIcon = By.xpath("//svg/path[contains(@d,'m1 1')]/ancestor::svg");  
    By exitbut = By.xpath("//svg[path[contains(@d,'m1 1')]]/ancestor::button");
    // ===== METHODS =====

    public void openPricing() {
        driver.get("https://hercules.works");
        wait.until(ExpectedConditions.elementToBeClickable(pricing)).click();
        System.out.println("✅ Opened Pricing Page");
    }

   
   public void selectAnnualPlan() {
        wait.until(ExpectedConditions.elementToBeClickable(annualPlan)).click();
        System.out.println("✅ Selected Annual Plan (20%)");
    }

    public void clickGetStarted() {
        wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn)).click();
        System.out.println("✅ Clicked Get Started");
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        System.out.println("✅ Logged in");
        
    }

    public void upgradePlan() {
        wait.until(ExpectedConditions.elementToBeClickable(upgradeBtn)).click();
        System.out.println("✅ Clicked Upgrade Plan");
        
        wait.until(ExpectedConditions.elementToBeClickable(upgradeBtn2)).click();
        System.out.println("✅ Clicked Upgrade Plan");
        
        wait.until(ExpectedConditions.elementToBeClickable(closeIcon1)).click();
    }
    
    
    
   
    
    public void clickwallet() {
        wait.until(ExpectedConditions.elementToBeClickable(wallet)).click();
        System.out.println("✅ Selected wallet");
    }

    public void selectMobiquik() {
        wait.until(ExpectedConditions.elementToBeClickable(mobikwik)).click();
        System.out.println("✅ Selected Mobikwik");
    }

    public void enterOTP() {
        WebElement otp = wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));

        // Validate OTP length
        String testOtp = "123456";

        if (testOtp.length() >= 6) {
            otp.sendKeys(testOtp);
            System.out.println("✅ OTP entered");
        } else {
            System.out.println("⚠️ OTP less than 6 digits");
        }
    }

    public void verifyPaymentFailure() {
        if (driver.getPageSource().toLowerCase().contains("fail") ||
            driver.getPageSource().toLowerCase().contains("error")) {
            System.out.println("✅ Payment failed as expected");
        } else {
            System.out.println("⚠️ Failure message not found");
        }
    }

    public void closeAll() {
        try {
            driver.findElement(closeIcon).click();
            driver.findElement(closeIcon).click();
            driver.findElement(exitbut).click();
            System.out.println("✅ Closed payment flow");
        } catch (Exception e) {
            System.out.println("⚠️ Close buttons not found");
        }
    }
}