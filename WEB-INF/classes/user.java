import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/user")
public class user extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		// Create Properties object.
		Properties props = new Properties();
		
		String dbSettingsPropertyFile = "/tomcat8/webapps/iWork/WEB-INF/classes/JDBCSettings.properties";
		// Properties will use a FileInputStream object as input.
		FileInputStream file = new FileInputStream(dbSettingsPropertyFile);
		
		// Load jdbc related properties in above file. 
		props.load(file);
		
		// Get each property value.
		String dbDriverClass = props.getProperty("db.driver.class");
		String dbConnUrl = props.getProperty("db.conn.url");

		Cookie nomCookie = null;
		Cookie joinCookie = null;
		Cookie[] cookies = null;
		
		cookies = req.getCookies();
		
		if(cookies != null) {
			if(nomCookie == null) {
				for(int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("NOM_UTILISATEUR") || cookies[i].getName().equals("NOM_ADMIN"))
						nomCookie = cookies[i];
					if(cookies[i].getName().equals("JOIN_UTILISATEUR"))
						joinCookie = cookies[i];
				}
			}
		}
		else {
			nomCookie = null;
			joinCookie = null;
		}
		
		try {
			Class.forName(dbDriverClass);
			String dbURL = dbConnUrl;

			Connection conn = DriverManager.getConnection(dbURL);

			if(conn != null) {
				Statement stat = conn.createStatement();
				
				if(joinCookie == null)
					out.println("<a href=\"signin.jsp\">Inscription</a>");
				else {
					// out.println(nomCookie.getName()+" "+nomCookie.getValue());
					ResultSet rs = stat.executeQuery("SELECT * FROM membres WHERE join_membre = '"+joinCookie.getValue()+"'");
					
					if(nomCookie.getName().equals("NOM_UTILISATEUR")) {
						out.println("<div class=\"dropdown\">");
							out.println("<button class=\"dropbtn\">"+nomCookie.getValue()+"<i class=\"fas fa-sign-in-alt\"></i></button>");
							out.println("<div class=\"dropdown-content\">");
								if("".equals(rs.getString("nom_entreprise_membre"))) {
									out.println("<a href=\"compte_membre.jsp\">Mon compte<i class=\"fas fa-user\"></i></a>");
									out.println("<a href=\"compte_membre.jsp\">Mes candidatures<i class=\"fas fa-file-invoice\"></i></a>");
									out.println("<a href=\"compte_membre.jsp\">Mes documents<i class=\"fas fa-file\"></i></a>");
									out.println("<a href=\"http://localhost:8080/iWork/deconnexion\">Deconnexion<i class=\"fas fa-sign-out-alt\"></i></a>");
								}
								else {
									out.println("<a href=\"compte_entreprise.jsp\">Mon compte<i class=\"fas fa-user\"></i></a>");
									out.println("<a href=\"compte_entreprise.jsp\">Mes offres<i class=\"fas fa-file-invoice\"></i></a>");
									out.println("<a href=\"http://localhost:8080/iWork/deconnexion\">Deconnexion<i class=\"fas fa-sign-out-alt\"></i></a>");
								}
							out.println("</div>");
						out.println("</div>");
					}
					if(nomCookie.getName().equals("NOM_ADMIN"))
						out.println("<a href=\"http://localhost:8080/iWork/deconnexion\">Deconnexion</a>");
					
					rs.close();
				}

				stat.close();
				conn.close();
			}
		}
		catch (ClassNotFoundException ex) {
				ex.printStackTrace();
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
	}
}