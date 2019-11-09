import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/liste_offres")
public class liste_offres extends HttpServlet {
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
					ResultSet rs = stat.executeQuery("SELECT * FROM membres JOIN offres ON membres.nom_entreprise_membre = offres.entreprise_offre WHERE join_membre = '"+joinCookie.getValue()+"'");
					
					if(nomCookie.getName().equals("NOM_UTILISATEUR")) {
						// if(rs.next() == true) {
							out.println("<table>");
								out.println("<tr>");
									out.println("<th class=\"title\">Id offre</th>");
									out.println("<th class=\"title\">Titre</th>");
									out.println("<th class=\"title\">Date</th>");
									out.println("<th class=\"title\">Description</th>");
									out.println("<th class=\"title\">Lieu</th>");
								out.println("</tr>");
							
							while(rs.next()) {
								out.println("</tr>");
									out.println("<td>"+rs.getString("id_offre")+"</td>");
									out.println("<td>"+rs.getString("titre_offre")+"</td>");
									out.println("<td>"+rs.getString("date_offre")+"</td>");
									out.println("<td>"+rs.getString("description_offre")+"</td>");
									out.println("<td>");
										out.println(rs.getString("ville_offre")+"<br />");
										out.println(rs.getString("region_offre"));
									out.println("</td>");
								out.println("</tr>");
							}
							out.println("</table>");
						// }
						// else
							// out.println("<p>Aucune offre ajoutee.</p>");
						
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