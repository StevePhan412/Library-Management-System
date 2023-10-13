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

**Admin**:
    - Search for books
    - Check issue and return dates
    
## System Structure

### Backend

1. **API Layer**: Utilizes a RESTful API for CRUD (Create, Read, Update, Delete) operations related to book records, user management, and fine calculations.
2. **Data Access Layer**: Utilizes MySQL JDBC Connector for database interactions facilitated by MySQL Community Server.

### Frontend
One centralized Library Management System Dashboard

## Additional Features

1. **Book Search Module**: This includes search functionalities for finding books by title, author, or ISBN.
2. **Data Display**: `rs2xml.jar` will be used to display data in a table format for easy management.

## Technologies Required

- **Java Hibernate**: For Backend logic and frontend interface.
- **MySQL JDBC Connector**: For database connectivity.
- **MySQL Community Server**: As the database server.
- 
## Tutorial Links
- [Java Programming Basics](https://www.w3schools.com/java/)
- [Java Swing Tutorial](https://www.javatpoint.com/java-swing)
- [MySQL and Java JDBC Connector](https://www.javatpoint.com/example-to-connect-to-the-mysql-database)
