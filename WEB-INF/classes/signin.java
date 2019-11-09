import java.io.*;
import java.sql.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Random;

public class signin extends HttpServlet {
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
		
		int statut					= Integer.parseInt(req.getParameter("statut"));
		String prenom				= req.getParameter("prenom");
		String nom					= req.getParameter("nom");
		String motdepasse			= req.getParameter("mdp");
		String motdepassec			= req.getParameter("mdpc");
		String nom_entreprise		= req.getParameter("nom_entreprise");
		String adresse_entreprise	= req.getParameter("adresse_entreprise");
		String adresse				= req.getParameter("adresse");
		String codep				= req.getParameter("codep");
		String ville				= req.getParameter("ville");
		String region				= req.getParameter("region");
		String pays					= req.getParameter("pays");
		String tel					= req.getParameter("tel");
		String email				= req.getParameter("email");
		String secteur				= req.getParameter("secteur");
		String effectif 			= req.getParameter("effectif");

		String mdpCrypt				= "";
		
		Random rand = new Random();
		int join1 = rand.nextInt(50) + rand.nextInt(9) + rand.nextInt(8999);
		int join2 = rand.nextInt(25) + 97;
		int join3 = rand.nextInt(50) + rand.nextInt(9) + rand.nextInt(8999);
		
		String join = ""+join1+"" + (char)join2 + ""+join3+"";
		

		// Vérifier que les champs ne sont pas vides
		if(prenom == null || prenom.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=1");
		}
		else if(nom == null || nom.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=2");
		}
		else if(motdepasse == null || motdepasse.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=3");
		}
		else if(motdepassec == null || motdepassec.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=4");
		}
		else if(!motdepasse.equals(motdepassec)) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=34");
		}
		else if(statut == 1 && (nom_entreprise == null || nom_entreprise.trim().length() == 0)) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=5");
		}
		else if(statut == 1 && (adresse_entreprise == null || adresse_entreprise.trim().length() == 0)) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=6");
		}
		else if(adresse == null || adresse.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=7");
		}
		else if(codep == null || codep.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=8");
		}
		else if(region == null || region.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=9");
		}
		else if(ville == null || ville.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=10");
		}
		else if(pays == null || pays.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=11");
		}
		else if(tel == null || tel.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=12");
		}
		else if(email == null || email.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=13");
		}
		else if(statut == 1 && (secteur == null || secteur.trim().length() == 0)) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=14");
		}
		else if(statut == 1 && (effectif == null || effectif.trim().length() == 0)) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=15");
		}
		else {
			try {
				Class.forName(dbDriverClass);
				String dbURL = dbConnUrl;

				Connection conn = DriverManager.getConnection(dbURL);

				if (conn != null) {
					out.println("Connected to the database");

					Statement stat = conn.createStatement();

					for(int i=0;i<motdepasse.length();i++)
						mdpCrypt = mdpCrypt+((int) motdepasse.charAt(i));
					
					stat.executeUpdate("INSERT INTO membres(prenom_membre, nom_membre, mdp_membre, nom_entreprise_membre, adresse_entreprise_membre, adresse_membre, codep_membre, ville_membre, region_membre, pays_membre, tel_membre, email_membre, secteur_membre, effectif_membre, statut_membre, join_membre) values('"+prenom+"', '"+nom+"', '"+mdpCrypt+"', '"+nom_entreprise+"', '"+adresse_entreprise+"', '"+adresse+"', '"+codep+"', '"+ville+"', '"+region+"', '"+pays+"', '"+tel+"', '"+email+"', '"+secteur+"', '"+effectif+"', '"+statut+"', '"+join+"');");

					stat.close();
					conn.close();
				}
				res.setStatus(HttpServletResponse.SC_FOUND);
				res.setHeader("Location", "http://localhost:8080/iWork/signin.jsp?signin=ok");
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