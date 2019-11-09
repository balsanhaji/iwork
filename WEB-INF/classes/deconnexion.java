import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class deconnexion extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		Cookie cookie = null;
		Cookie[] cookies = null;

		cookies = req.getCookies();

		if(cookies != null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("NOM_UTILISATEUR")) {
					cookie = cookies[i];

					cookie.setMaxAge(0);
					res.addCookie(cookie);
					res.setStatus(HttpServletResponse.SC_FOUND);
					res.setHeader("Location", "http://localhost:8080/iWork/");
				}
				if(cookies[i].getName().equals("JOIN_UTILISATEUR")) {
					cookie = cookies[i];

					cookie.setMaxAge(0);
					res.addCookie(cookie);
					res.setStatus(HttpServletResponse.SC_FOUND);
					res.setHeader("Location", "http://localhost:8080/iWork/");
				}

				if(cookies[i].getName().equals("NOM_ADMIN")) {
					cookie = cookies[i];

					cookie.setMaxAge(0);
					res.addCookie(cookie);
					res.setStatus(HttpServletResponse.SC_FOUND);
					res.setHeader("Location", "http://localhost:8080/iWork/");
				}
			}
		}
	}
}