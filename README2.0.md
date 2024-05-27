# Expense Tracker

## Overview
The Expense Tracker is a simple application for managing user accounts and their expenses. It allows users to create new accounts, see all created accounts, create expenses, see all expenses, and search for expenses based on different criteria. The application is developed using Spring Boot, Thymeleaf, Bootstrap 5, PostgreSQL, JPA Hibernate, and JPQL.

## Project Structure

- **Model**: Contains the `User` entity class representing a user account as well as an `Expense` entity representing an expense.
- **Repository**: Contains the `UserRepository` interface and the `ExpenseRepository` interface for database operations. The `ExpenseRepository` implements 10 custom operations using JPQL and `@Modifying`.
- **Service**: Contains the `UserService` and `ExpenseService` interfaces for business logic. Service methods are annotated with `@Transactional` to ensure transactional integrity.
- **Controller**: Contains the `ExpenseTrackerController` class for handling web requests. It implements endpoints for CRUD operations and custom operations.
- **ExpenseTrackerApplication**: Runs the whole application.
- **Templates**: Contains all HTML files developed using Thymeleaf templates and Bootstrap 5.

## Entities

### User Entity
- `id`: Long (Primary Key)
- `username`: String
- `password`: String
- `email`: String

### Expense Entity
- `id`: Long (Primary Key)
- `amount`: Double
- `description`: String
- `category`: String
- `date`: LocalDate
- `user`: User (Many-to-One relationship)

## HTML Templates

### expense-detail.html
- **Description**: Displays the details of a specific expense, including its ID, amount, description, category, date, and associated user. Provides a link to go back to the list of expenses.

### expense-form.html
- **Description**: Provides a form for creating or editing an expense. Includes fields for the amount, description, category, date, and user. Offers a button to save the expense and a link to cancel the operation.

### expense-list.html
- **Description**: Displays a list of all expenses in a table format, showing their ID, amount, description, category, date, and user. Provides links to view details or delete each expense and a button to add a new expense.

### user-detail.html
- **Description**: Displays the details of a specific user, including their ID, username, and email. Provides a link to go back to the list of users.

### user-form.html
- **Description**: Provides a form for creating or editing a user. Includes fields for the username, password, and email. Offers a button to save the user and a link to cancel the operation.

### user-list.html
- **Description**: Displays a list of all users in a table format, showing their ID, username, and email. Provides links to view details or delete each user and a button to add a new user.

## Usage

### Home Page
- **URL**: `/`
- **Description**: Displays the home page.

### Create New User
- **URL**: `/users/new`
- **Method**: `GET`
- **Description**: Displays the form to create a new user.

- **URL**: `/users/new`
- **Method**: `POST`
- **Description**: Creates a new user and redirects to the home page.

### Create New Expense
- **URL**: `/expenses/new`
- **Method**: `GET`
- **Description**: Displays the form to create a new expense.

- **URL**: `/expenses/new`
- **Method**: `POST`
- **Description**: Creates a new expense and redirects to the home page.

### List all Expenses
- **URL**: `/expenses/all`
- **Method**: `GET`
- **Description**: Displays all expenses.

## API Endpoints

| Endpoint       | Method | Description                       |
| -------------- | ------ | --------------------------------- |
| `/`            | GET    | Home page                         |
| `/users/new`   | GET    | Display form to create a new user |
| `/users/new`   | POST   | Create a new user                 |
| `/expenses/new`| GET    | Display form to create a new expense |
| `/expenses/new`| POST   | Create a new expense              |
| `/expenses/all`| GET    | List all expenses                 |

## Testing
- Manual testing of the services and features has been conducted.
- All custom operations are tested for correctness.

## Setup Instructions
1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd expense-tracker
    ```
2. **Configure PostgreSQL Database**:
    - Create a PostgreSQL database named `expense_tracker`.
    - Update the `application.properties` file with your PostgreSQL credentials.
3. **Build and Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```
4. **Access the Application**:
   Open your web browser and go to `http://localhost:8080`.

## Evaluation Criteria
- Correctness and completeness of the implementation.
- Proper use of Spring Boot, Thymeleaf, Bootstrap 5, PostgreSQL, JPA Hibernate, and JPQL.
- Implementation of 10 custom repository operations with `@Modifying` and `@Transactional`.
- User-friendly interface.
- Code quality, including readability, organization, and documentation.
