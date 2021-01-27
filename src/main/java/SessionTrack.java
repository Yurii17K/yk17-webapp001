import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTrack ", value = "/SessionTrack ")
public class SessionTrack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        // Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);

        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());

        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title = "Welcome Back to my website";
        Integer visitCount = 0;
        Integer userID = 0;
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");

        // Check if this is new comer on your web page.
        if (session.isNew()) {
            title = "Welcome to my website";
            session.setAttribute(userIDKey, userID + 1);
        } else {
            visitCount = (Integer)session.getAttribute(visitCountKey);
            if (visitCount == null) {
                visitCount = 1;
            }
            visitCount = visitCount + 1;
            userID = (Integer) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,  visitCount);
        session.setAttribute("sessionID", session.getId());
        session.setAttribute("creationTime", createTime);
        session.setAttribute("lastAccessTime", lastAccessTime);

        request.getRequestDispatcher("st_display.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
