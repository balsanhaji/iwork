<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<%

%>

<%@ include file="structure/header.jsp" %>
	<div id="bloc_page">
		<section id="section_admin">
			<article>
				<div id="admin" class="div targetDiv1">
					<div class="title">
						<h4>Accueil Entreprise</h4>
					</div>
					
					<p>
						<%
							if(request.getParameter("offre") != null) {
								if(request.getParameter("offre").equals("ok"))
									out.println("<div class=\"ok\">L'offre a bien été ajoutée.</div>");
							}
						%>
					</p>
				</div>
				
				<div id="admin" class="div1 targetDiv">
					<div class="title">
						<h4>Mon compte</h4>
					</div>
					
					<p>
					
					</p>
				</div>
				
				<div id="admin" class="div2 targetDiv">
					<div class="title">
						<h4>Mes offres</h4>
					</div>
					
					<jsp:include page="/liste_offres" />
				</div>

				<div id="admin" class="div3 targetDiv">
					<div class="title">
						<h4>Nouvelle offre</h4>
					</div>

					<%
						if(request.getParameter("offre") != null) {
							out.println("<div class=\"err\">");
								if(request.getParameter("offre").equals("1"))
									out.println("Veuillez indiquer un titre.");
								if(request.getParameter("offre").equals("2"))
									out.println("Veuillez indiquer une description à votre offre.");
							out.println("</div>");
						}
					%>					

					<form method="POST" action="http://localhost:8080/iWork/ajout_offre">
						<br />
						<p>
							<h4>Nouvelle offre</h4>
						</p>
						<br />
						<hr />
						<p>
							<h5>Présentation</h5>
						</p>
						<p>
							<input type="text" name="titre" placeholder="Titre de l'offre" />
						</p>
						
						<p>
							<input type="text" name="description" placeholder ="Indiquez le contenu de votre offre." />
						</p>
							
						<br />
						<hr />
						<p>
							<h5>Lieu</h5>
						</p>
						<p>
							<input type="text" name="ville" placeholder="Ville" />
						</p>
						<p>
							<input type="text" name="region" placeholder="Région" />
						</p>
						<br />
						<br />
						<hr />
						<p>
							<h5>Conditions</h5>
						</p>
						<p>
							<input type="text" name="type" placeholder="Type de l'offre" />
						</p>
						<p>
							<input type="text" name="experience" placeholder="Expérience requise" />
						</p>
						<p>
							<input type="text" name="formation" placeholder="Formation minimale (Niveau d'études)" />
						</p>
						<p>
							<input type="text" name="langues" placeholder="Langues requises" />
						</p>
						<br />
						<br />
						<hr />
						<p>
							<h5>Permis B</h5>
						</p>
						<p>
							<label class="container">Non
							  <input type="radio" checked="checked" name="permis" value="0">
							  <span class="checkmark"></span>
							</label>
						</p>
						<p>
							<label class="container">Oui
							  <input type="radio" name="permis" value="1">
							  <span class="checkmark"></span>
							</label>
						</p>
						<br />
						<br />
						<hr />
						<p>
							<h5>Caractéristiques</h5>
						</p>
						
						<p>
							<textarea rows="7" cols="57" name="bureautique" placeholder="Indiquez les connaissances en bureautique requises."></textarea>
						</p>
						
						<p>
							<input type="text" name="qualification" placeholder="Qualification requise" />
						</p>
						<p>
							<input type="text" name="salaire" placeholder="Salaire" />
						</p>
						<p>
							<input type="text" name="duree" placeholder="Durée de l'offre" />
						</p>
						<p>
							<input type="text" name="horaires" placeholder="Horaires hebdomadaires" />
						</p>
						<br />
						<br />
						<hr />
						<p>
							<h5>Déplacements</h5>
						</p>
						<p>
							<label class="container">Oui
							  <input type="radio" checked="checked" name="deplacements" value="0">
							  <span class="checkmark"></span>
							</label>
						</p>
						<p>
							<label class="container">Non
							  <input type="radio" name="deplacements" value="1">
							  <span class="checkmark"></span>
							</label>
						</p>						
						<br />
						<p>
							<input type="hidden" name="type_connexion" value="0" />
							<input type="submit" name="ajout" value="AJOUTER UNE OFFRE" />
						</p>
					</form>
				</div>
			</article>	
			
			<aside>
				<div class="side">
					<div class="title">
						<h4>Menu</h4>
					</div>
					
					<ul>
						<li><a class="showSingle" target="1">Mon compte</a></li>
						<li><a class="showSingle" target="2">Mes offres</a></li>
						<li><a class="showSingle" target="3">Nouvelle offre</a></li>
					</ul>
				</div>
			</aside>
		</section>
	</div>
	
<%@ include file="structure/footer.html" %>