import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASS")
            );

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(name, age) VALUES (?, ?)"
            );

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();

            conn.close();

            response.getWriter().println("Saved Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
