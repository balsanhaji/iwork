<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>

<%@ include file="structure/menu.html" %>
	<div id="bloc_page">
		<section id="section_services">
			<article>
				<%
					if(request.getParameter("page") != null) {
						if(request.getParameter("page").equals("1")) {
						%>
						<div id="services1">
							<div class="title">
								<h4> // a completer si l'on met pas s'inscrire</h4>
							</div>
						</div>
						<%
						}
						if(request.getParameter("page").equals("2")) {
						%>
						<div id="services2">
							<div class="title">
								<h4>Mes conseillers</h4>

							</div>
							<p>
									Bilal Rabbouj <br/>
									O6.69.69.59.49 <br/>
									bilal.rabbouj@gmail.com <br/>
									<br/>
									<br/>
							</p>		
							<p>
									<br/>
									<br/>
									Nassim Badaoui <br/>
									07.69.49.45.45 <br/>
									nassim.badaoui@hotmail.fr <br/>
							</p>
						</div>
						<%
						}
						if(request.getParameter("page").equals("3")) {
						%>
						<div id="services3">
							<div class="title">
								<h4>Nous Contactez</h4>
							</div>
							
							<div style="margin-left:20px">
								<p>
									<input type="text" placeholder="Sujet" />
								</p>
								
								<p>
									<input type="mail" placeholder="Adresse email" />
								</p>
								
								<p>
									<textarea rows="7" cols="57" placeholder="Ecrivez votre message."></textarea>
								</p>
								
								<p>
									<input type="submit" placeholder="Envoyer" />
								</p>
							</div>
						</div>
						<%
						}
						if(request.getParameter("page").equals("4")) {
							Cookie[] cookies = request.getCookies();
							Cookie cookie = null;
							for(int i=0;i<cookies.length;i++) {
								if(cookies[i].getName().equals("NOM_ADMIN"))
									cookie = cookies[i];
							}
							if(cookie != null)
								response.sendRedirect("admin.jsp");
							else {
						%>
						<div id="services4">
							<div class="title">
								<h4>Espace Admin</h4>
							</div>
							
							<form method="POST" action="http://localhost:8080/iWork/admin">
								<p>
									<input type="text" name="Identifiant" placeholder="Identifiant" />
								</p>
								
								<p>
									<input type="password" name="Motdepasse" placeholder="Mot de passe" />
								</p>
								
								<p>
									<input type="submit" placeholder="Envoyer" />
								</p>
							</form>
						</div>
						<%
							}
						}
					}
				%>
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