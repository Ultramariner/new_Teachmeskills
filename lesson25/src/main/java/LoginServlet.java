import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UsersSingleton list = UsersSingleton.getInstance();
        for (User user: list.getAll()) {
            if (user.getLogin().equals(login)) {
                if (user.getRole().equals("admin")) {
                    resp.sendRedirect("http://localhost:8080/lesson25/management.html");
                    break;
                } else if (user.getRole().equals("user")) {
                    resp.sendRedirect("http://localhost:8080/lesson25/picture.html");
                    break;
                }
            }
        }
    }
}
