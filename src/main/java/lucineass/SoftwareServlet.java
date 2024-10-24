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

@WebServlet("/createSoftware")
public class SoftwareServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/yourdb";
    private static final String JDBC_USER = "Lucine";
    private static final String JDBC_PASS = "Niteesh";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String softwareName = request.getParameter("softwareName");
        String description = request.getParameter("description");

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            String sql = "INSERT INTO software (name, description) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, softwareName);
            stmt.setString(2, description);
            stmt.executeUpdate();
            response.sendRedirect("createSoftware.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
