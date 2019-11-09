<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>
	<div id="bloc_page">
		 <%/*@ include file="structure/menu.html" */ %> 

		<section id="section_login">
			<article>
				<div id="login">
					<div class="title">
						<h4>CONNEXION</h4>
					</div>
					
					<%
						if(request.getParameter("login") != null) {
							out.println("<div class=\"err\">");
								if(request.getParameter("login").equals("1"))
									out.println("Veuillez indiquer une adresse email valide.");
								if(request.getParameter("login").equals("2"))
									out.println("Veuillez indiquer un mot de passe.");
								if(request.getParameter("login").equals("3"))
									out.println("Votre adresse email contient une erreur.");
								if(request.getParameter("login").equals("4"))
									out.println("Votre mot de passe contient une erreur");
							out.println("</div>");
						}
					%>
					
					<form method="POST" action="http://localhost:8080/iWork/connexion">
						<p>
							<input type="text" name="Identifiant" placeholder="Identifiant" />
						</p>
						<p>
							<input type="password" name="Motdepasse" placeholder="Mot de passe" />
						</p>
						
						<br />
						<p>
							<input type="hidden" name="type_connexion" value="0" />
							<input type="submit" name="connexion" value="CONNEXION" />
						</p>
					</form>
				</div>		
			</article>
			<!--
			<aside>
				<div class="side">
					H
				</div>
			</aside>
			-->
		</section>
	</div>
	
<%@ include file="structure/footer.html" %>