package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CreateSurveyPage;
import pages.HomePage;
import pages.PricingPaymentPage;
import pages.QuestionPage;
import pages.SettingsPage;
import pages.SurveyPage;

public class MainTest extends BaseTest {

    // ===== TEST CASE 1: HOMEPAGE =====
    @Test(priority = 1)
    public void testHomePageScenario() {
        HomePage home = new HomePage(driver);

        home.verifyHomePageLoaded();
        home.verifyUIElements();
        home.verifyNavigation();

        System.out.println("✅ Homepage test passed");
    }

    // ===== TEST CASE 2: SURVEY LISTING =====
    @Test(priority = 2)
    public void testSurveyListing() {
        SurveyPage survey = new SurveyPage(driver);

        // Navigate to AI (Survey page assumed already handled in Base or Page)
        survey.verifySurveyPageLoaded();
        survey.verifySurveysDisplayed();
        survey.selectFirstSurvey();

        System.out.println("✅ Survey listing test passed");
    }

    // ===== TEST CASE 3: CREATE SURVEY =====
    @Test(priority = 3)
    public void testCreateSurvey() {

        driver.get("https://hercules.works/ai");

        CreateSurveyPage create = new CreateSurveyPage(driver);

        create.clickCreateSurvey();
        create.enterSurveyName("Test Survey");
        create.submitSurvey();
        create.verifySurveyCreated();

        System.out.println("✅ Create Survey test completed");
    }

    // ===== TEST CASE 4: QUESTION FLOW =====
    @Test(priority = 4)
    public void testQuestionFlow() {

        driver.get("https://hercules.works/ai ");
        
        CreateSurveyPage create = new CreateSurveyPage(driver);

        QuestionPage question = new QuestionPage(driver);

        // Create Survey first
    
        create.clickCreateSurvey();
        create.enterSurveyName("Test Survey");
        create.submitSurvey();

        // Add Question
        question.addQuestion("What do you like most about your dog?");
        
        // Edit Question
        question.editQuestion("How do you bond with your dog?");
        
        // Delete Question
        question.deleteQuestion();

        System.out.println("✅ Question flow test completed");
    }

    // ===== TEST CASE 5: PRICING + PAYMENT FLOW =====
    @Test(priority = 5)
    public void testPricingAndPaymentFlow() {

        PricingPaymentPage flow = new PricingPaymentPage(driver);

        flow.openPricing();
        flow.selectAnnualPlan();
        flow.clickGetStarted();
        flow.login("sahilshirale324@gmail.com", "sahi@1705");
        flow.upgradePlan();
        flow.clickGetStarted();
        flow.selectMobiquik();
        flow.enterOTP();
        flow.verifyPaymentFailure();
        flow.closeAll();

        System.out.println("✅ Pricing + Payment flow completed");
    }
    
    @Test(priority = 7)
    public void testSettingsFlow() throws InterruptedException {

        SettingsPage settings = new SettingsPage(driver);

        // Step 1: Open Settings
        settings.openSettings();

        // Step 2: Verify name
        settings.verifyFullName("Sahil Shirale");
        
        Thread.sleep(5000);
        
     
        // Step 3: Click Account
        settings.clickAccount();

        // Step 4: Wait 5 sec
        Thread.sleep(5000);

        // Step 5: Click Billing
        settings.clickBilling();

        System.out.println("✅ Settings flow completed successfully");
    }
}