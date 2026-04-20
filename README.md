# 🚀 Selenium Automation Framework - Hercules Work

This is a **Selenium Web Automation Framework** built using **Java, TestNG, Maven, and Page Object Model (POM)**.  
The framework is designed for automating end-to-end test scenarios for the Hercules web application : https://hercules.works .

---

## 📌 Project Overview

This project automates key functionalities such as:

- Home Page validation
- Survey listing and selection
- Create Survey flow
- Question management (Add/Edit/Delete)
- Settings page validation
- Pricing & Payment flow

---

## 🏗️ Tech Stack

- Java 8
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Eclipse IDE

---

## 📁 Project Structure
```bash
HerculesWork
│
├── src/main/java
│ ├── base → Base classes (WebDriver setup, config)
│ ├── pages → Page Object Model classes
│ │ ├── HomePage
│ │ ├── SurveyPage
│ │ ├── CreateSurveyPage
│ │ ├── QuestionPage
│ │ ├── PricingPage
│ │ ├── PricingPaymentPage
│ │ ├── SettingsPage
│ │
│ └── tests → TestNG test classes
│ └── MainTest
│
├── src/test/java → (Reserved for future test layers)
├── src/main/resources
├── test-output → TestNG reports
├── target
├── pom.xml
└── README.md
```

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the repository
```bash
https://github.com/sahi1705/Hercules_SeleniumAutomation_Project.git
```
---

### 2️⃣ Import project in Eclipse/IntelliJ
Open IDE
Import as Maven Project
### 3️⃣ Install dependencies
mvn clean install
### 4️⃣ Run Tests
Run MainTest.java as TestNG Test
OR
mvn test

### 🧪 Test Scenarios Covered
✅ Home Page
Verify homepage load
Validate UI elements
Navigation checks

✅ Survey Module
Survey listing verification
Select survey functionality

✅ Create Survey
Create new survey
Validate survey creation

✅ Question Module
Add question
Edit question
Delete question

✅ Settings Page
Validate account information
Billing section validation

✅ Pricing & Payment Flow
Select pricing plan
Login flow
Payment flow validation

### 🧠 Design Pattern Used

✔ Page Object Model (POM)
✔ TestNG Test Framework
✔ WebDriverWait for synchronization
✔ Modular test structure

### 📊 Reports
TestNG default reports available in /test-output
Can be extended with Extent Reports (future enhancement)
🚀 Future Enhancements
Add Extent Reports
Add Log4j logging
Add CI/CD integration (Jenkins/GitHub Actions)
Parallel execution support
Cross-browser testing

###👨‍💻 Author

Sahil Shirale
SDET Learner | Automation Tester | Java + Selenium Enthusiast
