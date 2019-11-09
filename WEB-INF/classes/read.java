import java.sql.*;
// import javax.servlet.*;
// import javax.servlet.http.*;

// @WebServlet("/read")
public class read {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			// String dbURL = "jdbc:sqlite:/tomcat8/webapps/iWork/WEB-INF/classes/iworktest.db";
			String dbURL = "jdbc:sqlite:iworkbase.db";

			Connection conn = DriverManager.getConnection(dbURL);

			if(conn != null) {
				System.out.println("Connected to the database");

				Statement stat = conn.createStatement();

				ResultSet rs = stat.executeQuery("SELECT * FROM membres;");
				
				while(rs.next()) {
					int idjava = rs.getInt("id_membre");
					String prenomjava = rs.getString("prenom_membre");
					String nomjava = rs.getString("nom_membre");
					System.out.println( "ID = " + idjava+" Prenom = "+prenomjava+" Nom = "+nomjava);
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