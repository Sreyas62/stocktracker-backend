# Stock Tracker Backend

A simple portfolio tracker backend application to manage stock holdings. It provides the ability to add, view, edit, and delete stock details. It also retrieves real-time price updates and calculates the total portfolio value. 

---

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Steps to Run the Project Locally](#steps-to-run-the-project-locally)
- [API Endpoints](#api-endpoints)
- [Assumptions and Limitations](#assumptions-and-limitations)
- [Links](#links)

---

## Features
- **CRUD Operations**: Create, Read, Update, and Delete stocks in the portfolio.
- **Real-time Updates**: Fetches real-time stock prices using an external API.
- **CORS Configuration**: Configured CORS for interaction with a frontend hosted on `http://localhost:5173`.
- **Data Persistence**: Uses MySQL as the database for storing stock details.

---

## Prerequisites
Before running the project, ensure that you have the following installed on your local machine:
1. [Java 17 or later](https://www.oracle.com/java/)
2. [Maven](https://maven.apache.org/) for dependency management.
3. A running MySQL instance.

---

## Steps to Run the Project Locally

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd stocktracker-backend
   ```

2. **Setup MySQL Database**:
   - Create a database named `portfolio` in your MySQL server.
   - Update the `application.properties` file (located under `src/main/resources`) with your MySQL username and password:
     ```
     spring.datasource.url=jdbc:mysql://127.0.0.1:3306/portfolio
     spring.datasource.username=YOUR_USERNAME
     spring.datasource.password=YOUR_PASSWORD
     ```

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

5. **Test the Endpoints** (Optional):
   Use tools like [Postman](https://www.postman.com/) or `curl` to interact with the API. Sample HTTP requests are provided in the `generated-requests.http` file in the project.

---

## API Endpoints

| Method | Endpoint                 | Description                  |
|--------|--------------------------|------------------------------|
| POST   | `/api/stocks`            | Add a new stock.            |
| GET    | `/api/stocks`            | Retrieve all stocks.        |
| GET    | `/api/stocks/{id}`       | Retrieve stock by ID.       |
| PUT    | `/api/stocks/{id}`       | Update stock by ID.         |
| DELETE | `/api/stocks/{id}`       | Delete stock by ID.         |

---

## Assumptions and Limitations

1. **Real-time Price Retrieval**:
   - Real-time stock prices are fetched from the Alpha Vantage API with the API key: `P8R71TNBO2RWAUQQ`. Rate limiting by the API provider may restrict frequent calls.
   - Tickers are assumed to follow the `.BSE` (Bombay Stock Exchange) format.

2. **Database Storage**:
   - All stock data, excluding real-time fetched prices, is persistently stored in the database.

3. **Frontend Integration**:
   - The backend is configured to work with a React-based frontend running on `http://localhost:5173`.

4. **CORS**:
   - CORS policy is set up to allow requests only from the specified frontend `http://localhost:5173`.

5. **Error Handling**:
   - Custom exceptions like `ResourceNotFoundException` handle errors for invalid stock IDs.

6. **Environment Configuration**:
   - Sensitive information (e.g., database credentials, API keys) should not be hardcoded in the source code and should instead be loaded from environment variables in a production environment.

---

## Links

- **Deployed Application**: *(Not available)*
- **Live API Documentation**: *(Not available)*
- **Frontend Repository**: *(Provide a link if available)*

---

Feel free to contribute or raise issues to enhance this application further!