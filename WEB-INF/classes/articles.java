import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Random;

public class articles extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:/tomcat8/webapps/iWork/WEB-INF/classes/iworkbase.db";

			Connection conn = DriverManager.getConnection(dbURL);

			if (conn != null) {
				Statement stat = conn.createStatement();
				
				ResultSet rs = stat.executeQuery("SELECT * FROM articles;");

				while(rs.next()) {
					out.println("<div id=\"articles\">");
						out.println("<div class=\"title\">");
							out.println("<h4>"+rs.getString("titre_article")+"</h4>");
						out.println("</div>");
						
						
						out.println("<div class=\"article\"");
							out.println("<div class=\"date\"");
								out.println("Date de l'article : "+rs.getString("date_article"));
							out.println("</div>");
							
							out.println(rs.getString("contenu_article"));
						out.println("</div>");
					out.println("</div>");
				}

				rs.close();
				stat.close();
				conn.close();
			}
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:9999/iWork/signin.jsp?article=ok");
		}
		catch (ClassNotFoundException ex) {
				ex.printStackTrace();
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		String titre_article		= req.getParameter("titre");
		String date_article			= req.getParameter("date");
		String contenu_article		= req.getParameter("contenu");
		
		// Random rand = new Random();
		// int join = rand.nextInt(50) + rand.nextInt(9) + rand.nextInt(8999);

		if(titre_article == null || titre_article.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:9999/iWork/signin.jsp?articles=1");
		}
		else if(date_article == null || date_article.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:9999/iWork/signin.jsp?articles=2");
		}
		else if(contenu_article == null || contenu_article.trim().length() == 0) {
			res.setStatus(HttpServletResponse.SC_FOUND);
			res.setHeader("Location", "http://localhost:9999/iWork/signin.jsp?articles=3");
		}
		else {
				// DEMANDER AU PROF !!!
			try {
				Class.forName("org.sqlite.JDBC");
				// String dbURL = "jdbc:sqlite:iworkbase.db";
				String dbURL = "jdbc:sqlite:/tomcat8/webapps/iWork/WEB-INF/classes/iworkbase.db";

				Connection conn = DriverManager.getConnection(dbURL);

				if (conn != null) {
					Statement stat = conn.createStatement();

					stat.executeUpdate("CREATE TABLE IF NOT EXISTS articles(id_article INTEGER PRIMARY KEY AUTOINCREMENT, titre_article VARCHAR(50), date_article VARCHAR(20), contenu_article TEXT);");
					
					stat.executeUpdate("INSERT INTO articles(titre_article, date_article, contenu_article) values('"+titre_article+"', '"+date_article+"', '"+contenu_article+"');");

					stat.close();
					conn.close();
				}
				res.setStatus(HttpServletResponse.SC_FOUND);
				res.setHeader("Location", "http://localhost:9999/iWork/signin.jsp?article=ok");
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