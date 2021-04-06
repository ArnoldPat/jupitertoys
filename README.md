**Technical Assessment – Automation**

**Deliverable/s:**
Execute the following test cases using testing tool and framework of choice. Validate results at the end of each execution as specified per case.

**Test Cases:**

Test case 1:

    1. From the home page go to contact page
    2. Click submit button
    3. Validate errors
    4. Populate mandatory fields
    5. Validate errors are gone


Test case 2:

    1. From the home page go to contact page
    2. Populate mandatory fields
    3. Click submit button
    4. Validate successful submission message


Test case 3: 

    1. From the home page go to contact page
    2. Populate mandatory fields with invalid data
    3. Validate errors


Test case 4:

    1. From the home page go to shop page
    2. Click buy button 2 times on “Funny Cow”
    3. Click buy button 1 time on “Fluffy Bunny”
    4. Click the cart menu
    5. Verify the items are in the cart

**Application URL**: 
- https://jupiter.cloud.planittesting.com/#/

**Test Automation Tool**: 
- Selenium Web Driver (Java Flavor)

**Installation Requirements**: (Note: Set Java and Maven to PATH)
1. Java/JRE System Library (jdk-16)
	https://www.oracle.com/java/technologies/javase-jdk16-downloads.html

2. Maven/apache-maven-3.8.1 (Binary Zip Archive)
	https://maven.apache.org/download.cgi

3. TestNG
	http://dl.bintray.com/testng-team/testng-eclipse-release/ 

3. Google Chrome (used release 89.x.x for this test)
	https://www.google.com.au/intl/en_au/chrome/

4. ChromeDriver (Webdriver for Chrome)
	https://chromedriver.chromium.org/downloads

**Required Packages/Libraries/Dependencies**:
- org.openqa.selenium.By				                    - Element locator class
- org.openqa.selenium.WebDriver			                - Invoke the Webdriver interface
- org.openqa.selenium.ChromeDriver		              - Webdriver Chrome implementation
- org.openqa.selenium.WebElement		                - Interface for webpage elements
- org.openqa.selenium.support.ui.ExpectedConditions	- For delay handling
- org.openqa.selenium.support.ui.WebDriverWait		  - For delay handling
- org.testng.Assert					- Test case verification tool
- org.testng.annotations.Test				- Test execution flow manager

**Execution Notes:**
- Invoke CLI with administrator privilege
- From root directory(POM.xml location) run: mvn install

**Miscellaneous Notes**:
- Purge from repository after assessment
