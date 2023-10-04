# MakeMyTrip-WebApplication

This project is a backend service for a travel booking application called Make-My-Trip. It uses Java, Spring Boot, and MySQL database to provide RESTful APIs for various features such as searching, booking, cancelling, and reviewing flights, hotels, and packages.

## Features

- **Flight Search:** Users can search for available flights based on their origin, destination, date, and number of passengers. The service returns a list of flights with details such as airline, flight number, departure and arrival time, duration, price, and availability.
- **Flight Booking:** Users can book a flight by providing their personal and payment information. The service validates the input and confirms the booking by generating a booking ID and sending an email confirmation to the user.
- **Flight Cancellation:** Users can cancel a flight booking by providing their booking ID. The service verifies the booking and processes the cancellation by refunding the payment and sending an email confirmation to the user.

   ![image](https://github.com/BIMAL-DEBNATH/MakeMyTrip-WebApplication/assets/131388946/c019f698-6fa8-462c-bb74-e0ce5d60fe6e)


## Technologies

- **Java:** The programming language used to develop the backend service.
- **Spring Boot:** The framework used to create standalone, production-grade Spring based applications that run on embedded servers such as Tomcat or Jetty.
- **MySQL:** The relational database management system used to store and manage data for the backend service.
- **Maven:** The tool used to manage dependencies and build automation for the backend service.
- **Postman:** The tool used to test and document the RESTful APIs for the backend service.

## Installation

To run this project locally, you need to have Java 8 or higher, MySQL 5.7 or higher, and Maven 3.6 or higher installed on your machine. You also need to create a database named `make_my_trip` in MySQL and configure the username and password in the `application.properties` file under `src/main/resources`. Then follow these steps:

1. Clone this repository using `git clone https://github.com/BIMAL-DEBNATH/MakeMyTrip-WebApplication.git`.
2. Navigate to the project directory using `cd make-my-trip-backend`.
3. Run `mvn clean install` to build the project and generate a JAR file under `target` folder.
4. Run `java -jar target/make-my-trip-backend-0.0.1-SNAPSHOT.jar` to start the backend service on port 8080.
5. Use Postman or any other API testing tool to access the endpoints defined in the `MakeMyTripController.java` file under `src/main/java/com/example/makemytrip/controller`.

## License

This project is licensed under the MIT License - see the [LICENSE] file for details.

I hope this helps you with your project. 😊
