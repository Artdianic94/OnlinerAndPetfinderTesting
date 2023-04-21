# OnlinerAndPetfinderTesting
This is a project aimed at automating the testing of two websites: [Onliner](https://catalog.onliner.by/) and [Petfinder](https://www.petfinder.com/). 
The UI testing was performed for [Onliner](https://catalog.onliner.by/), while the API testing was conducted for [Petfinder](https://www.petfinder.com/).
This project itilizes a Behavior-Driven Development (BDD) approach to testing, and uses the Cucumber tool. Selenide is used for UI testing, while the
RestAssured library is used for API testing. All tests are written in Java.
## Covered functionality
*UI Tests:*
  1. Search products:
    
    1.1 Enter valid value in the search field (ex. 'Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)')
    
    1.2 Select the n-th product from the list
    
    1.3 Click on [Search]
            
   *Expected result:* Searched product page (Смартфон Samsung Galaxy A52 SM-A525F/DS 4GB/128GB (черный)) appear on the screen	
  
  2. Adding the product into the cart from product’s page

    2.1 Compare actual and expected product name
    
    2.2 Check the module with the description is displayed
    
    2.3 Choose the first product with the min price and Click on [Add to Cart] on product’s page
    
   *Expected result:* The box with product, text "Product added to cart", the buttons "Go to cart" and ""Continue shopping"" will appear on the screen.
   A icon value of count shopping cart is change on 1.
    
  3. Added product is displayed in the cart

    3.1 Click on the shopping cart icon
    
   *Expected result:* The page 'Shopping Cart' is opened. The added product displays on the page.	    
    
  4. Removing a product from the cart
    
    4.1 Hover the cursor over the product
    
    4.2 Сlick on the delete icon
    
    4.3 Сlose the box with the product(Click on [Close])

   *Expected result:* Get the message "Your shopping cart is empty".	

*API Tests:*
  1. Retrieving a list of animals by type and location				
  
    1.1 Send a GET request to the URL https://www.petfinder.com/api/v2/animals with the parameters animal type and location set
    to "dog" and "New York" respectively.
    
    1.2 Check the response status code.
    
    1.3 Verify the response format matches the expected JSON format.
    
    1.4 Check that the response contains a list of animals with the specified type and location.
    
    1.5 Verify that each animal in the list contains the required information such as name, age, breed, and photo.
  
*Expected result:* The response status code is 200 and response should be in JSON format. The response should contain a list of 
animals that match the specified type and location. Each animal in the list should have the expected information available.
  
  2. Searching for a specific animal by its ID	
  
    2.1 Send a GET request to the URL "https://www.petfinder.com/api/v2/animals/{animal_id}" with the specific animal ID.
    
    2.2 Verify that the information about the animal matches the expected values, based on known data about the animal.

*Expected result:* The information about the animal in the response should match the expected values based on the known data about
the animal.

### :hammer_and_wrench: Languages and Tools :
<div>
  <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/apache/apache-original-wordmark.svg" title="Maven" alt="Maven" width="40" height="40"/>&nbsp;
  <img src="https://github.com/devicons/devicon/blob/master/icons/cucumber/cucumber-plain-wordmark.svg" title="Cucumber" alt="Cucumber" width="40" height="40"/>&nbsp;
  <img src="https://selenide.org/images/selenide-logo-big.png" title="Selenide" alt="Selenide" width="70" height="40"/>&nbsp;
  <img src="https://e7.pngegg.com/pngimages/640/776/png-clipart-testng-logo-software-testing-software-framework-computer-icons-automation-testing-angle-text.png" title="Testng" alt="Testng" width="70" height="40"/>&nbsp;
  <img src="https://media.licdn.com/dms/image/C4D12AQEkxehOAz4jGA/article-cover_image-shrink_600_2000/0/1611865361884?e=2147483647&v=beta&t=JUTsqJYWhnNWHHvBCgNsap022H3SJkNqQoEVxycOT1o" title="Allure" alt="Allure" width="70" height="40"/>&nbsp;
</div>

## Allure report

![Image1](https://github.com/Artdianic94/OnlinerAndPetfinderTesting/blob/master/src/test/allureScreenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202023-04-21%20%D0%B2%2017.05.35.png)

![Image2](https://github.com/Artdianic94/OnlinerAndPetfinderTesting/blob/master/src/test/allureScreenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202023-04-21%20%D0%B2%2017.06.54.png)

![Image3](https://github.com/Artdianic94/OnlinerAndPetfinderTesting/blob/master/src/test/allureScreenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202023-04-21%20%D0%B2%2017.07.19.png)
