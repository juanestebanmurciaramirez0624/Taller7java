package co.edu.sena.javataller4.util;

import java.sql.*;

public class BasicConnectionSingleton {
    private static String url = "jdbc:mysql://localhost:3306/Javataller?serverTimezone=America/Bogota";
    private static String user = "JuanEsteban";
    private static String pass = "JuanContraseña45";
    private static Connection conn;
    public static Connection getInstance()
            throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, pass);
        }
        return conn;
    }
} // BasicConnectionSingleton
