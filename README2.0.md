# Expense Tracker

## Overview
The Expense Tracker is a simple application for managing user accounts and their expenses. It allows users to create new accounts, see all created accounts, create expenses, see all expenses, and search for expenses based on different criteria.

## Project Structure

- **Model**: Contains the `User` entity class representing a user account as well as an `Expense` entity representing an expense.
- **Repository**: Contains the `UserRepository` interface and the `ExpenseRepository` interface for database operations.
- **Service**: Contains the `UserService` and `ExpenseService` interface for business logic.
- **Controller**: Contains the `ExpenseTrackerController` class for handling web requests.
- **ExpenseTrackerApplication**: Runs the whole application.
- **Templates**: Contains all HTML files.

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

## HTML Files

### expense-detail.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Expense Detail</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>Expense Detail</h1>
    <dl class="row">
        <dt class="col-sm-3">ID</dt>
        <dd class="col-sm-9" th:text="${expense.id}">1</dd>
        <dt class="col-sm-3">Amount</dt>
        <dd class="col-sm-9" th:text="${expense.amount}">100.00</dd>
        <dt class="col-sm-3">Description</dt>
        <dd class="col-sm-9" th:text="${expense.description}">Groceries</dd>
        <dt class="col-sm-3">Category</dt>
        <dd class="col-sm-9" th:text="${expense.category}">Food</dd>
        <dt class="col-sm-3">Date</dt>
        <dd class="col-sm-9" th:text="${expense.date}">2024-05-23</dd>
        <dt class="col-sm-3">User</dt>
        <dd class="col-sm-9" th:text="${expense.user.username}">username</dd>
    </dl>
    <a th:href="@{/expenses}" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>

expense-form.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Expense Form</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>Expense Form</h1>
    <form th:action="@{/expenses}" th:object="${expense}" method="post">
        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="text" id="amount" class="form-control" th:field="*{amount}" />
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" id="description" class="form-control" th:field="*{description}" />
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <input type="text" id="category" class="form-control" th:field="*{category}" />
        </div>
        <div class="form-group">
            <label for="date">Date</label>
            <input type="date" id="date" class="form-control" th:field="*{date}" />
        </div>
        <div class="form-group">
            <label for="user">User</label>
            <select id="user" class="form-control" th:field="*{user.id}">
                <option th:each="user : ${users}" th:value="${user.id}" th:text="${user.username}">User</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <a th:href="@{/expenses}" class="btn btn-secondary">Cancel</a>
</div>
</body>
</html>
expense-list.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Expense List</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>Expense List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Category</th>
            <th>Date</th>
            <th>User</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="expense : ${expenses}">
            <td th:text="${expense.id}">1</td>
            <td th:text="${expense.amount}">100.00</td>
            <td th:text="${expense.description}">Groceries</td>
            <td th:text="${expense.category}">Food</td>
            <td th:text="${expense.date}">2024-05-23</td>
            <td th:text="${expense.user.username}">username</td>
            <td>
                <a th:href="@{/expenses/{id}(id=${expense.id})}" class="btn btn-primary">View</a>
                <a th:href="@{/expenses/delete/{id}(id=${expense.id})}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>
    <a th:href="@{/expenses/new}" class="btn btn-success">Add New Expense</a>
</div>
</body>
</html>
user-detail.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Detail</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>User Detail</h1>
    <dl class="row">
        <dt class="col-sm-3">ID</dt>
        <dd class="col-sm-9" th:text="${user.id}">1</dd>
        <dt class="col-sm-3">Username</dt>
        <dd class="col-sm-9" th:text="${user.username}">username</dd>
        <dt class="col-sm-3">Email</dt>
        <dd class="col-sm-9" th:text="${user.email}">email@example.com</dd>
    </dl>
    <a th:href="@{/users}" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>
user-form.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Form</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>User Form</h1>
    <form th:action="@{/users}" th:object="${user}" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" th:field="*{username}" />
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" th:field="*{password}" />
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" class="form-control" th:field="*{email}" />
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <a th:href="@{/users}" class="btn btn-secondary">Cancel</a>
</div>
</body>
</html>
user-list.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User List</title>
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}">
</head>
<body>
<div class="container">
    <h1>User List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="user : ${users}">
            <td th:text="${user.id}">1</td>
            <td th:text="${user.username}">username</td>
            <td th:text="${user.email}">email@example.com</td>
            <td>
                <a th:href="@{/users/{id}(id=${user.id})}" class="btn btn-primary">View</a>
                <a th:href="@{/users/delete/{id}(id=${user.id})}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
        </tbody>
    </table>
    <a th:href="@{/users/new}" class="btn btn-success">Add New User</a>
</div>
</body>
</html>
