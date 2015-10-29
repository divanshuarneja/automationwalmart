# automationwalmart
## Problem Statement
Automate an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome.

* Scenario to automate:
  1. Login using existing account
  2. Perform a search on home page from a pool of key words given below
  3. Identify an item from the result set that you can add to cart
  4. Add the item to cart
  5. Validate that item added is present in the cart and is the only item in the cart
  
### Test Data:
* Search terms: tv, socks, dvd, toys, iPhone.
* A Test account is created.

## Solution to the problem

### Assumptions
* Cart is empty when user login's the account.
* The code will only be used to test for search items given in test data.
* The searched and selected item should not have any additional selection options like size, color etc. 

### Instructions to run the code
* Copy the repo using command "git clone https://github.com/divanshuarneja/automationwalmart.git" .
* In Eclipse(JDK 1.8), import the project using Existing project in workspace.
* Make sure "chromerdriver.exe" is present in project directory and all the jar files are also present (selenium).
* Open automateWalmart.java class
* Intilize the string 'searchitem'with one of the search item. The value match the test data.
* Run as 'JUnit Test'.


Note - While testing it was found that sometimes 'Add to Cart' button does not repond to click which causes test case to fail.
