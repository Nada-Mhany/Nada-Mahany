**Introduction:**

This project is for implementing best buy api-playground scenairos by automation framework with design pattern.

**Used Tools:**

- Java programming language.
  
- TestNG annotations and test framework
  
  _Used dependsOnMethod to wait until one test case is done to run the other_

- Rest-Assured.
  
- Page object model design pattern.
  
  _Separate the test cases at the test source which contains the test and the assertion for this test case._

**Designed Test Cases Applied for api-playground**

- Check GET all categories and assert on its repsonse code 200
- Check saving the response body.
- Check GET total of the categories and assert on its reponse code 200
- Check assert and log the total that appears with the valid total
- Check GET category by ID in parameters and assert its response code 200
- Check assert and log the valid ID with the name that related to this iD
- Check GET category by Name in parameters and assert its response code 200
- Check assert and log the valid Name with the first sub category in the array that related to this Name
  
**Dependencies:**

- Rest-Assured
- rest-assured json-schema-validator
- rest-assured json-path
- testng 
  
**This is a demo video for the executed test cases:**

https://drive.google.com/file/d/1b3k4O02NfeRGHKDl62Br1YhD99sBzwFY/view?usp=sharing

To run this project you need to setup all the dependencies from pom.xml and run from testNG file.

After the run you will find the listener of testNG exported test-output folder that contains the files.html to see the report of the run of each test case

I've downloaded the api-playground project and installed the needed commands in order to run these apis, then I get postman collection to run it manually and see what api gets response 200 to validate.After this I created the rest-assured maven project.
