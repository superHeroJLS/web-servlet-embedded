package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 匹配所有用户请求
@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从HttpSession获取当前用户名:
        String user = (String) req.getSession().getAttribute("user");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("X-Powered-By", "JavaEE Servlet");
        PrintWriter pw = resp.getWriter();
        
        // 判断语言
        String lang = parseLanguageFromCookie(req);
        String welcome = "Welcome";
        String guest = "Guest";
        if ("zh".equals(lang)) {
        	welcome = "欢迎";
        	guest = "访客";
        }
        pw.write("<h1>" + welcome + ", " + (user != null ? user : guest) + "</h1>");
        if (user == null) {
            // 未登录，显示登录链接:
            pw.write("<p><a href=\"/login\">Log In</a></p>");
            // 显示语言切换连接
            pw.write("<a href=\"/pref?lang=en\">English</a>");
            pw.write("<b>|</b>");
            pw.write("<a href=\"/pref?lang=zh\">中文</a>");
        } else {
            // 已登录，显示登出链接:
            pw.write("<p><a href=\"/logout\">Log Out</a></p>");
            // 显示语言切换连接
            pw.write("<a href=\"/pref?lang=en\">English</a>");
            pw.write("<b>|</b>");
            pw.write("<a href=\"/pref?lang=zh\">中文</a>");
        }
        pw.flush();
    }
	
	/**
	 * 解析cookie中是否带有language信息
	 * @param req
	 * @return
	 */
	private String parseLanguageFromCookie(HttpServletRequest req) {
	    // 获取请求附带的所有Cookie:
	    Cookie[] cookies = req.getCookies();
	    // 如果获取到Cookie:
	    if (cookies != null) {
	        // 循环每个Cookie:
	        for (Cookie cookie : cookies) {
	            // 如果Cookie名称为lang:
	            if (cookie.getName().equals("lang")) {
	                // 返回Cookie的值:
	                return cookie.getValue();
	            }
	        }
	    }
	    // 返回默认值:
	    return "en";
	}

}
