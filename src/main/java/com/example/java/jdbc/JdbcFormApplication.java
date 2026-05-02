package com.example.java.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class JdbcFormApplication {
    static final String DB_URL = "jdbc:h2:~/testdb";
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        // Initialize database
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS user_details (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100), phone VARCHAR(20))";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create Swing Form
        JFrame frame = new JFrame("User Details Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        frame.add(emailField);

        frame.add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        frame.add(phoneField);

        JButton submitBtn = new JButton("Submit");
        frame.add(submitBtn);

        JLabel statusLabel = new JLabel("");
        frame.add(statusLabel);

        submitBtn.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                String sql = "INSERT INTO user_details (name, email, phone) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone);
                pstmt.executeUpdate();
                statusLabel.setText("Data saved successfully!");
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
            } catch (SQLException ex) {
                statusLabel.setText("Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}

