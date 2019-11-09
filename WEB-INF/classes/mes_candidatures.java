import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/mes_candidatures")
public class mes_candidatures extends HttpServlet {
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
				
				if(joinCookie == null) {
					res.setStatus(HttpServletResponse.SC_FOUND);
					res.setHeader("Location", "http://localhost:8080/iWork");
				}
				else {
					ResultSet rs = stat.executeQuery("SELECT * FROM membres JOIN offres ON membres.join_membre LIKE '%' + offres.join_offre + '%' WHERE join_membre = '"+joinCookie.getValue()+"'");
					
					if(nomCookie.getName().equals("NOM_UTILISATEUR")) {
						while(rs.next()) {
							out.println(rs.getString("nom_membre")+"<br />");
							out.println(rs.getString("titre_offre")+"<br />");
							out.println(rs.getString("description_offre"));
						}

						rs.close();					
					}
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