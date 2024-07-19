API Automation RestAssured (in Java)
Author: Pramod Dutta

This project showcases an API Automation Framework using RestAssured for the CRUD operations of Restful Booker.

Running Tests
To execute the tests, use the following Maven command:

bash
Copy code
mvn test -Dsurefire.suiteXmlFiles=testng.xml
Tech Stack
Java (JDK > 17)
Rest Assured
Apache POI, TestNG, Maven
AssertJ (Advanced assertions)
Jackson and GSON
Log4j
Allure Report
Folder Structure
The project follows a Full Folder Structure (Hybrid) Framework.

Jenkins Integration
Included Jenkins file for CI/CD pipeline integration.

API Framework Components
Includes comprehensive API testing components.
Basic Setup
Maven Configuration
Add the following configuration to your pom.xml to run the test suite or TestNG:

xml
Copy code
<plugins>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
      <suiteXmlFiles>
        <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
      </suiteXmlFiles>
    </configuration>
  </plugin>
</plugins>
Run tests with Maven:

bash
Copy code
mvn clean test -DsuiteXmlFile=testng.xml
Parallel Execution
To run tests in parallel, adjust your testng.xml file:

xml
Copy code
<suite name="All Test Suite" parallel="methods" thread-count="2">
Allure Report
Generate and view Allure Report:

bash
Copy code
allure serve allure-results/
Screenshots
[Include screenshots here if applicable]

Integration Tests
Example of integration tests for Create Booking, Create Token, Update and Delete Booking:

bash
Copy code
mvn clean test -DsuiteXmlFile=testng-integration.xml
Additional Assignments and Features
Includes POSTMAN assignments and advanced test scenarios.
Full CRUD operations for various APIs.
Integration scenarios and advanced assertions.
JSON schema validation for POST and PUT requests.
