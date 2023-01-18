# BBCProject

An example of automated testing for the BBC website.
## How to run?
To run this project you need to have maven [installed](https://maven.apache.org/install.html)

Tests will start automatically after running following command in project directory:
``` bash 
mvn clean install
```
Command to run single test:
```bash
mvn test -Dtest="ClassName#TestName"  
```


## Technology stack 
- Java 
- Selenium 
- TestNG

## Report

The basic test report can be found in target/surefire-reports/index.html

## Test Cases 

[TC1] -	Verify the top navigation links.

ClassName = checkTopBarNavigation

Test Steps:
1. open BBC website
2. accept cookies
3. check all navigation buttons "href" attribute.

[TC2] -	Navigate to the “News” section and verify url is correct.

ClassName = checkNewsURL

Test Steps: 
1. open BBC website
2. accept cookies
3. navigate to news page
4. check URL

[TC3] -	Verify the day and date displayed on the page is correct.

ClassName = dateVerify

Test Steps:
1. open BBC website
2. accept cookies
3. check date from home page

[TC4] -	In the top navigation, perform a search for “Houghton Mifflin Harcourt” and verify the search results.

ClassName = searchVerify

Test Steps:
1. open BBC website
2. accept cookies
3. navigate to search page 
4. input “Houghton Mifflin Harcourt”
5. open searched articles to check existing searched words

