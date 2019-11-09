import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/liste_membres")
public class liste_membres extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
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
		
		try {
			Class.forName(dbDriverClass);
			String dbURL = dbConnUrl;

			Connection conn = DriverManager.getConnection(dbURL);

			if(conn != null) {
				Statement stat = conn.createStatement();
				
				ResultSet rs = stat.executeQuery("SELECT * FROM membres");

				out.println("<table>");
					out.println("<tr>");
						out.println("<th class=\"title\">Identite</th>");
						out.println("<th class=\"title\">Entreprise</th>");
						out.println("<th class=\"title\">Adresse et contact</th>");
						out.println("<th class=\"title\">Infos Entreprise</th>");
					out.println("</tr>");

						while(rs.next()) {
							out.println("<tr>");
								out.println("<td>"+rs.getString("prenom_membre")+" "+rs.getString("nom_membre")+"</td>");
								if("".equals(rs.getString("nom_entreprise_membre")))
									out.println("<td>Non</td>");
								else
									out.println("<td>"+rs.getString("nom_entreprise_membre")+"</td>");
								out.println("<td>");
									out.println(rs.getString("codep_membre")+" "+rs.getString("ville_membre")+"<br />");
									out.println(rs.getString("region_membre")+"<br />");
									out.println(rs.getString("pays_membre")+"<br /><br />");
									out.println("Tel : "+rs.getString("tel_membre")+"<br />");
									out.println(rs.getString("email_membre"));
								out.println("</td>");
								if("".equals(rs.getString("nom_entreprise_membre")))
									out.println("<td>\\</td>");
								else
									out.println("<td>"+rs.getString("secteur_membre")+"<br />"+rs.getString("effectif_membre")+" employes</td>");
							out.println("</tr>");
						}
				out.println("</table>");
				
				rs.close();
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