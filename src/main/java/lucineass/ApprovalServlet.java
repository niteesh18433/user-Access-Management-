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

@WebServlet("/approveRequest")
public class ApprovalServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/yourdb";
    private static final String JDBC_USER = "lucine";
    private static final String JDBC_PASS = "niteesh";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            String sql = "UPDATE requests SET status = 'approved' WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, requestId);
            stmt.executeUpdate();
            response.sendRedirect("pendingRequests.jsp?approved=1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
