import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Auth", value = "/Auth")
public class Auth extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String git_token = request.getParameter("git_token");
        String git_login = request.getParameter("git_login");
        String git_pass = request.getParameter("git_pass");
        HttpSession session = request.getSession();



        if (git_token != null) {
            String login_name = null;

            GitHub github = new GitHubBuilder().withOAuthToken(git_token).build();
            login_name = github.getMyself().getLogin();

            session.setAttribute("login_name", login_name);
            session.setAttribute("img_url", github.getMyself().getAvatarUrl());

        }

        if (git_login != null && git_pass != null) {
            String login_name = null;

            GitHub github = new GitHubBuilder().withPassword(git_login, git_pass).build();
            login_name = github.getMyself().getLogin();

            session.setAttribute("login_name", login_name);
            session.setAttribute("img_url", github.getMyself().getAvatarUrl());

        }

        if (request.getParameterMap().isEmpty()){

            session.setAttribute("login_name", null);
        }

        request.getRequestDispatcher("auth.jsp").include(request, response);
    }

}
