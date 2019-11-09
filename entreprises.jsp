<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>

 <%@ include file="structure/menu.html" %> 
	<div id="bloc_page">
		<section id="section_entreprises">
			<article>
				<div id="entreprises">
					<%
						if(request.getParameter("page") != null) {
							if(request.getParameter("page").equals("1")) {
					%>
								<div class="title">
									<h4>Accès Entreprise</h4>
								</div>
					<%
								if(request.getParameter("err") != null) {
										out.println("<div class=\"err\">");
											if(request.getParameter("err").equals("1"))
												out.println("Veuillez indiquer le nom de votre entreprise.");
											if(request.getParameter("err").equals("2"))
												out.println("Veuillez indiquer un mot de passe.");
											if(request.getParameter("err").equals("3"))
												out.println("Veuillez indiquer un nom valide.");
											if(request.getParameter("err").equals("2"))
												out.println("Veuillez indiquer un mot de passe valide.");
										out.println("</div>");
								}
							%>
								<form method="POST" action="http://localhost:8080/iWork/connexion">
									<p>
										<input type="text" name="identifiant_entreprise" placeholder="Nom de l'entreprise" />
									</p>
									<p>
										<input type="password" name="Motdepasse" placeholder="Mot de passe" />
									</p>
									
									<br />
									<p>
										<input type="hidden" name="type_connexion" value="1" />
										<input type="submit" value="CONNEXION" />
									</p>
								</form>
							<%
							}
							if(request.getParameter("page").equals("2")) {
							 	response.sendRedirect("login.jsp");
							
							}
							if(request.getParameter("page").equals("3")) {
							 	response.sendRedirect("login.jsp");
							
							
							}
							if(request.getParameter("page").equals("4")) {
								response.sendRedirect("login.jsp");
						
							}
						}
					%>
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