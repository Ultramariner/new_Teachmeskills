package tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/car")
public class CarService extends HttpServlet {

    Map<Integer, String> carMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();
        if (id != null) {
            writer.println(id + ", " + carMap.get(Integer.valueOf(id)));
        } else {
            writer.println(carMap);
        }
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("last_entrance_time")) {
                    writer.println("Last entrance time: " + cookie.getValue());
                }
            }
        }
        resp.addCookie(new Cookie("last_entrance_time", "" + System.currentTimeMillis()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String model = req.getParameter("model");
        PrintWriter writer = resp.getWriter();
        carMap.put(Integer.valueOf(id), model);
        writer.println("Car was added");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();
        if (id != null) {
            carMap.remove(Integer.valueOf(id));
            writer.println("Car was removed");
        }
    }
}
