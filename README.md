# Library Management System Tech Exercise

## Table of Contents
1. [Overview](#overview)
2. [System Structure](#system-structure)
    - [Backend](#backend)
    - [Frontend](#frontend)
3. [Additional Features](#additional-features)
4. [Technologies Required](#technologies-required)
5. [Tutorial Links](#tutorial-links)

## Overview

The Library Management System aims to enhance the efficiency of book issuance, tracking, and inventory management. It will be developed using Java for both backend logic and frontend interface. The frontend will utilize the Java Swing Library to deliver a user-friendly graphical interface. The backend, on the other hand, will be facilitated by MySQL Community Server for database management. Connectivity between the Java application and MySQL database will be handled by MySQL JDBC Connector.

This system implements a role-based access control mechanism to provide differentiated functionalities for administrators and users.

### Features:

- **Administrators**: 
    - Dashboard for managing users
    - Inventory management
    - Fine collection
    
- **Users**:
    - Search for books
    - Check issue and return dates
    - Make payments for fines or charges
    
Data will be displayed in a table format using the `rs2xml.jar` library, enhancing both the administrative and user experience.

## System Structure

### Backend

1. **Role-Based Access Control**: Differentiate between admin and user functionalities.
2. **API Layer**: Utilizes a RESTful API for CRUD (Create, Read, Update, Delete) operations related to book records, user management, and fine calculations.
3. **Service Layer**: Encapsulates business logic, like fine calculations and due date tracking.
4. **Data Access Layer**: Utilizes MySQL JDBC Connector for database interactions facilitated by MySQL Community Server.

### Frontend

1. **Java Swing Library**: Used to develop a user-friendly graphical interface.
2. **Admin Dashboard**: Provides functionalities for user management, book inventory, and fine collection.
3. **User Interface**: Enables users to search for books, check issue and return dates, and make payments.

## Additional Features

1. **Book Search Module**: This includes search functionalities for finding books by title, author, or ISBN.
2. **Data Display**: `rs2xml.jar` will be used to display data in a table format for easy management.

## Technologies Required

- **Java**: For Backend logic and frontend interface.
- **Java Swing Library**: For GUI components.
- **MySQL JDBC Connector**: For database connectivity.
- **MySQL Community Server**: As the database server.
- **rs2xml.jar**: For data display in table format.

## Tutorial Links
- [Java Programming Basics](https://www.w3schools.com/java/)
- [Java Swing Tutorial](https://www.javatpoint.com/java-swing)
- [MySQL and Java JDBC Connector](https://www.javatpoint.com/example-to-connect-to-the-mysql-database)
