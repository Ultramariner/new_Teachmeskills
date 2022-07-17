import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean sex = Boolean.parseBoolean(req.getParameter("sex"));
        String desc = req.getParameter("desc");
        String role = req.getParameter("role");
        UsersSingleton list = UsersSingleton.getInstance();
        for (User user: list.getAll()) {
            if (user.getLogin().equals(login)) {
                resp.sendRedirect("http://localhost:8080/lesson24/error.html");
                break;
            }
        }
        UsersSingleton.getInstance().addUser(new User(login, password, sex, desc, role));
    }
}
