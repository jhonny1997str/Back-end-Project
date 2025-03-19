package com.futbolista.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connecting {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/examen_civa";
        String user = "root";
        String password = "solocali123#";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
