package lucineass;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/yourdb";
    private static final String JDBC_USER = "lucine";
    private static final String JDBC_PASS = "niteesh";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int softwareId = Integer.parseInt(request.getParameter("softwareId"));
        String username = (String) request.getSession().getAttribute("username");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            String sql = "INSERT INTO requests (software_id, username, status) VALUES (?, ?, 'pending')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, softwareId);
            stmt.setString(2, username);
            stmt.executeUpdate();
            response.sendRedirect("requestAccess.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
