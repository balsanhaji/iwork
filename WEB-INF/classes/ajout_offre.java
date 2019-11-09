import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ajout_offre")
public class ajout_offre extends HttpServlet {
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

		String titre				= req.getParameter("titre");
		String description			= req.getParameter("description");
		String ville				= req.getParameter("ville");
		String region				= req.getParameter("region");
		String type					= req.getParameter("type");
		String experience			= req.getParameter("experience");
		String formation			= req.getParameter("formation");
		String langues				= req.getParameter("langues");
		int permis					= Integer.parseInt(req.getParameter("permis"));
		String bureautique			= req.getParameter("bureautique");
		String qualification		= req.getParameter("qualification");
		String salaire				= req.getParameter("salaire");
		String duree				= req.getParameter("duree");
		String horaires				= req.getParameter("horaires");
		int deplacements			= Integer.parseInt(req.getParameter("deplacements"));

		Random rand = new Random();
		int join1 = rand.nextInt(50) + rand.nextInt(9) + rand.nextInt(8999);
		int join2 = rand.nextInt(25) + 97;
		int join3 = rand.nextInt(50) + rand.nextInt(9) + rand.nextInt(8999);
		
		String join = ""+join1+"" + (char)join2 + ""+join3+"";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String laDateDuJour = sdf.format(new java.util.Date());
		
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
			// Vérifier que les champs ne sont pas vides
			if(titre == null || titre.trim().length() == 0) {
				res.setStatus(HttpServletResponse.SC_FOUND);
				res.setHeader("Location", "http://localhost:8080/iWork/compte_entreprise.jsp?offre=1");
			}
			else if(description == null || description.trim().length() == 0) {
				res.setStatus(HttpServletResponse.SC_FOUND);
				res.setHeader("Location", "http://localhost:8080/iWork/compte_entreprise.jsp?offre=2");
			}
			else {
				Class.forName(dbDriverClass);
				String dbURL = dbConnUrl;

				Connection conn = DriverManager.getConnection(dbURL);

				if (conn != null) {
					out.println("Connected to the database");

					Statement stat = conn.createStatement();

					ResultSet rs = stat.executeQuery("SELECT * FROM membres WHERE join_membre = '"+joinCookie.getValue()+"'");

					stat.executeUpdate("INSERT INTO offres(titre_offre, entreprise_offre, date_offre, description_offre, ville_offre, region_offre, type_offre, experience_offre, formation_offre, langues_offre, permis_offre, bureautique_offre, qualification_offre, salaire_offre, duree_offre, horaires_offre, deplacements_offre, join_offre) values('"+titre+"', '"+rs.getString("nom_entreprise_membre")+"', '"+laDateDuJour+"', '"+description+"', '"+ville+"', '"+region+"', '"+type+"', '"+experience+"', '"+formation+"', '"+langues+"', '"+permis+"', '"+bureautique+"', '"+qualification+"', '"+salaire+"', '"+duree+"', '"+horaires+"', '"+deplacements+"', '"+join+"');");

					rs.close();
					stat.close();
					conn.close();
				}
				res.setStatus(HttpServletResponse.SC_FOUND);
				res.setHeader("Location", "http://localhost:8080/iWork/compte_entreprise.jsp?offre=ok");
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