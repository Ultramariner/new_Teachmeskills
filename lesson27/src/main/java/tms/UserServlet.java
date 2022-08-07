package tms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user", loadOnStartup = 1)
public class UserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        UsersSingleton list = UsersSingleton.getInstance();
        list.addUser(new User("admin", "admin", true, "123", "admin"));
        list.addUser(new User("user", "user", false, "321", "user"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersSingleton list = UsersSingleton.getInstance();
        List<User> users = list.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("userLogin");
        UsersSingleton list = UsersSingleton.getInstance();
        User userDel = list.getAll().stream()
                .filter(user -> user.getLogin().equals(userLogin))
                .findFirst().orElse(null);
        list.deleteUser(userDel);
        resp.sendRedirect("http://localhost:8080/lesson27/user");
    }
}
