package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/morning/forward"})
public class ForwardServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里的getRequestDispatcher()参数只接受相对于Servlet Container路径(/hello)和当前Servlet的路径(hello)，不接受网络路径(//www.baidu.com)
        req.getRequestDispatcher("hello").forward(req, resp);
    }

}
