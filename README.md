# Getting Started with Google Favourite Places api

## Instruction

### Clone the app locally and mvn clean spring-boot:run
Add google places api key from Google Console
Open [http://localhost:8080/api/favorite-places](http://localhost:8080/api/favorite-places) to view it in your browser or test manually in postman.

## Project Description 

A server side Spring Boot app that serves as backend api for a client side React app (https://github.com/VishvaaDiben/google-search-place-react)

### Features
1.A Java SpringBoot Application <br>
2.Maintainable and readable Project Structure <br>
3.Testable via client Postman (included request and response log in Postman collection) <br>
4.Project able connect to database, preferred with MySQL database. Open and Configure Workbench MySql as per application.properties (Using Local Machine DB, DB name: TESTDB). <br>
5.@transactional is implemented in the project <br>
6.GET method api with Pagination (Each Page 10 records) <br>
7.An api which will nested calling another api from 3rd party (http://localhost:8080/api/favorite-places/fetch-google-place?placeId=) <br>

### Screenshots
![screenshot-3](https://github.com/user-attachments/assets/98c727be-a79f-4f74-b896-40f7b926407d)

### Postman Collection
[FavouritePlaces-Postman-Collection.zip](https://github.com/user-attachments/files/18629438/FavouritePlaces-Postman-Collection.zip)

### Todo

Host in Netlify
