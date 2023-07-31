# Book Store 
<hr/>

## Authors
* Ola Ibrahim - olaib@edu.hac.ac.il
<hr/>

![Screenshot 1](/src/main/resources/static/images/home.png)
*Description: Home Page*
![Screenshot 2](/src/main/resources/static/images/cover.png)
*Description: store page*


## Description

This project is an online book store with an admin zone that can be accessed through login. The admin zone, located at the URL "/admin," allows administrators to manage the store by adding, updating, and deleting products. The website also keeps track of payments made by customers and stores them in MYSQL DB. 
The stock of the Books is automatically updated when a payment is completed. If a book becomes unavailable, the payment is canceled, and an appropriate message is displayed.

The website utilizes session beans to implement the shopping cart functionality.
using the Spring MVS(Model View Controller) architecture, 
using scoped beans and inversion of control (IOC). 
Thymeleaf is used for views, including validation, and annotations are used for various features.

### General information
This project is built using the following frameworks and technologies:

Frontend: Bootstrap 5, Java
Backend: MySQL, Spring

### Functionality
The online book store provides the following functionality:

* Books browsing and search
* Adding products to the shopping basket
* Updating the shopping Cart(stored in session)
* Checkout and payment processing
* Admin zone for managing products (adding, updating, deleting)
* middleware(filter) for prevent accessing to /checkout page when cart is empty
* displaying the current number of active sessions in the console using listeners

To access the admin section, the following credentials must be used:

* Username: admin
* Password: password
## Installation

To install and run the project, follow these steps:

1. Download and install XAMPP.app and all the required Spring plugins.
2. Set up a MySQL database named "ex5" in XAMPP.app.
3. Insert the data (start from insert into) for initialize the store with books

## Running
1. Make sure the project is running and the server is up and the mysql is running
2. Open a web browser.
3. In the address bar, type `localhost:8080` .
4. The home page of the website will be displayed.
5. From there, you can navigate through the website, search for books, add them to your shopping basket, and proceed with the checkout process.
6. You can also explore other sections of the website, such as the services offered... .

## Useful information
To access the website and test its functionality, use the following credentials:
- Admin section:
    - Username: admin
    - Password: password
  
- see javadoc for more information about the code

Enjoy your shopping experience and make the most of the website's services! 😊
