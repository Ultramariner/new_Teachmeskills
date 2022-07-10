package tms.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class RoleFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String role = req.getHeader("role");
        if (role != null && role.equals("admin")) {
            chain.doFilter(req, res);
        } else {
            if ("GET".equals(req.getMethod())) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect("http://google.com");
            }
        }
    }
}
