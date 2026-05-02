package com.example.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final String DB_URL = "jdbc:h2:~/authdb";
    static final String USER = "sa";
    static final String PASS = "";

    public void init() throws ServletException {
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, userId VARCHAR(50), password VARCHAR(50))";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if ("login".equals(action)) {
                String sql = "SELECT * FROM users WHERE userId = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userId);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    out.println("<h1>Login Success</h1>");
                } else {
                    out.println("<h1>Login Failed</h1>");
                    out.println("<p>Invalid credentials. <a href='login-signup.html'>Try again or Signup</a></p>");
                }
            } else if ("signup".equals(action)) {
                String sql = "INSERT INTO users (userId, password) VALUES (?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userId);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                out.println("<h1>Signup Successful</h1>");
                out.println("<p>You can now <a href='login-signup.html'>Login</a></p>");
            }
        } catch (SQLException e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }

        out.println("</body></html>");
    }
}

