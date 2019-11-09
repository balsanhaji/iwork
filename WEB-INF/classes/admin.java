import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/admin")
public class admin extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
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
		
		String identifiant		= req.getParameter("Identifiant");
		String motdepasse		= req.getParameter("Motdepasse");
		String identifiantOk	= null;
		String motdepasseOk		= null;
		String joinOk			= null;
		
		String mdpDecrypt		= "";
	
		if(identifiant == null || identifiant.trim().length() == 0){
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/index.jsp?p=1");
		}
		else if(motdepasse == null || motdepasse.trim().length() == 0){
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/index.jsp?p=2");
		}
		else {
			try {
				Class.forName(dbDriverClass);
				String dbURL = dbConnUrl;

				Connection conn = DriverManager.getConnection(dbURL);

				if(conn != null) {
					out.println("Connected to the database");
					Statement stat = conn.createStatement();

					for(int j=0;j<motdepasse.length();j++)
						mdpDecrypt = mdpDecrypt+((int) motdepasse.charAt(j));
					
					ResultSet rs = stat.executeQuery("SELECT * FROM admins WHERE nom_admin = '"+identifiant+"'");
					
					while(rs.next()) {
						identifiantOk	= rs.getString("nom_admin");
						motdepasseOk	= rs.getString("mdp_admin");
						joinOk			= rs.getString("join_admin");
					}
					
					if(identifiantOk == null) {
						res.setStatus(HttpServletResponse.SC_FOUND);
						res.setHeader("Location", "http://localhost:8080/iWork");
					}
					else {
						if(!mdpDecrypt.equals(motdepasseOk)) {
							res.setStatus(HttpServletResponse.SC_FOUND);
							res.setHeader("Location", "http://localhost:8080/iWork");
						}
						else {
							Cookie nomCookie = new Cookie("NOM_ADMIN", identifiantOk);
							Cookie joinCookie = new Cookie("JOIN_ADMIN", joinOk);
							res.addCookie(nomCookie);
							res.addCookie(joinCookie);
							res.setStatus(HttpServletResponse.SC_FOUND);
							res.setHeader("Location", "http://localhost:8080/iWork/admin.jsp");
						}
					}

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
}