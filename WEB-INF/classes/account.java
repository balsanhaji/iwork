import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class connexion extends HttpServlet {
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
		
		String identifiant		= req.getParameter("Identifiant");
		String motdepasse		= req.getParameter("Motdepasse");
		String prenomOk			= null;
		String identifiantOk	= null;
		String motdepasseOk		= null;
		String entrepriseOk		= null;
		
		String mdpDecrypt		= "";
		int i = 0;

		if(identifiant == null || identifiant.trim().length() == 0){
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/login.jsp?login=1");
		}
		else if(motdepasse == null || motdepasse.trim().length() == 0){
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/login.jsp?login=2");
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
					
					ResultSet rs = stat.executeQuery("SELECT prenom_membre, email_membre, mdp_membre, nom_entreprise_membre FROM membres WHERE email_membre = '"+identifiant+"' OR nom_entreprise_membre = '"+identifiant+"'");
					
					while(rs.next()) {
						prenomOk		= rs.getString("prenom_membre");
						identifiantOk	= rs.getString("email_membre");
						motdepasseOk	= rs.getString("mdp_membre");
						entrepriseOk	= rs.getString("nom_entreprise_membre");
					}
					
					if(identifiantOk == null || entrepriseOk == null) {
						res.setStatus(HttpServletResponse.SC_FOUND);
						res.setHeader("Location", "http://localhost:8080/iWork/login.jsp?login=3");
					}
					else {
						if(!mdpDecrypt.equals(motdepasseOk)) {
							res.setStatus(HttpServletResponse.SC_FOUND);
							res.setHeader("Location", "http://localhost:8080/iWork/login.jsp?login=4");
						}
						else {
							Cookie nomCookie = new Cookie("NOM_UTILISATEUR", prenomOk);
							res.addCookie(nomCookie);
							res.setStatus(HttpServletResponse.SC_FOUND);
							res.setHeader("Location", "http://localhost:8080/iWork/");
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