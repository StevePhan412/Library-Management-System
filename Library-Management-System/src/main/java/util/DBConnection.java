package util;

//src/util/DatabaseConnection.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
 private static final String URL = "jdbc:mysql://gamestart.ddn:3306/LibraryManagement";
 private static final String USERNAME = "trung";
 private static final String PASSWORD = "password";

 public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(URL, USERNAME, PASSWORD);
 }
}

