## FacebookAutomation Java Project
# Nada-Mahany
**Introduction:**

This project is for implementing Facebook scenairos by automation framework with design pattern.

**Used Tools:**

- Java programming language.
- TestNG annotations and test framework
  
  _Used beforeMethod and afterTest for opening facebook and quit the browser after each test case_
- Data driven framework using json file.
  
  _Used json file for signup data and read it by json reader in the locator method._
- Selenium webdriver.
- Firefox driver browser.
- Page object model design pattern.
  
  _Separate the locators in the main source which contains the locators and its action._
  
  _Separate the test cases at the test source which contains the test and the assertion for this test case._

**Test Cases Applied:**

- Signup to facebook with email, data is read from json file
- Signup to facebook with phone number, data is read from json file.
- Signup with invalid email 
- Signup with invalid phone number 
- Login with valid data 
- Login with invalid data

**Dependencies:**

- Selenium webdriver
- testng 
- json simple
  
**This is a diagram that shows the project structure:**

<img width="1640" alt="Screen Shot 2023-09-02 at 1 47 18 AM" src="https://github.com/Nada-Mhany/Nada-Mahany/assets/85070356/95ca1819-fa00-4a81-a3cd-440cab39aa03">

**This is a demo video for the executed test cases:**

https://drive.google.com/file/d/15okVWpDlldP9PLLqQtix9pRO0-qFk2Pk/view?usp=drive_link

To run this project you need to setup all the dependencies from pom.xml and run from testNG file.

After the run you will find the listener of testNG exported test-output folder that contains the files.html to see the report of the run of each test case
