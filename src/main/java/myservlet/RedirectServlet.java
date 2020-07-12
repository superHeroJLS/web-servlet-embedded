package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet重定向
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={"/hi/hi"})
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlCase = req.getParameter("urlCase");
        String redirectToUrl = null;
        switch (urlCase) {
            // 构造重定向的路径，相对于Servlet Container Root的路径，路径为：http://localhost:8080/hello?urlCase=1
            case "1":
                redirectToUrl = "/hello" + (urlCase == null ? "" : "?urlCase=" + urlCase);
                break;
            // 构造重定向的路径，相对于当前Servlet的路径，路径为：http://localhost:8080/hi/hello?urlCase=2
            case "2":
                redirectToUrl = "hello" + (urlCase == null ? "" : "?urlCase=" + urlCase);
                break;
            // 构造重定向的路径，相对于网络http的路径，路径为：https://www.baidu.com
            case "3":
                redirectToUrl = "//www.baidu.com";
                break;
            // 构造重定向的路径，相对于Servlet Container Root的路径，路径为：http://localhost:8080/hello
            default:
                redirectToUrl = "/hello";
                break;
        }
        
        // 发送重定向响应，方法实现查看：org.apache.catalina.connector.Response.sendRedirect()
        resp.sendRedirect(redirectToUrl);
        
        
    }
    
}
