<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>
	<div id="bloc_page">
		<section id="section_signin">
			<article>
				<div id="signin">
					<div class="title">
						<h4>INSCRIPTION</h4>
					</div>
					
					<%
						if(request.getParameter("signin") != null) {
							if(request.getParameter("signin").equals("ok"))
								out.println("<div class=\"ok\">L'inscription a bien été effectuée.</div>");
							else {
								out.println("<div class=\"err\">");
									if(request.getParameter("signin").equals("1"))
										out.println("Veuillez indiquer un prénom.");
									if(request.getParameter("signin").equals("2"))
										out.println("Veuillez indiquer un nom.");
									if(request.getParameter("signin").equals("3"))
										out.println("Veuillez indiquer un mot de passe.");
									if(request.getParameter("signin").equals("4"))
										out.println("Veuillez confimer votre mot de passe.");
									if(request.getParameter("signin").equals("34"))
										out.println("Les mots de passe ne sont pas identiques.");
									if(request.getParameter("signin").equals("5"))
										out.println("Si vous êtes une entreprise, veuillez indiquer votre nom d'entreprise.");
									if(request.getParameter("signin").equals("6"))
										out.println("Si vous êtes une entreprise, veuilez indiquer votre adresse.");
									if(request.getParameter("signin").equals("7"))
										out.println("Veuilez indiquer votre adresse.");
									if(request.getParameter("signin").equals("8"))
										out.println("Veuillez indiquer votre code postal.");
									if(request.getParameter("signin").equals("9"))
										out.println("Veuillez indiquer votre région de résidence.");
									if(request.getParameter("signin").equals("10"))
										out.println("Veuillez indiquer votre ville de résidence.");
									if(request.getParameter("signin").equals("11"))
										out.println("Veuillez indiquer votre pays de résidence.");
									if(request.getParameter("signin").equals("12"))
										out.println("Veuillez indiquer votre numéro de téléphone (pro si vous êtes une entreprise).");
									if(request.getParameter("signin").equals("13"))
										out.println("Veuillez indiquer une adresse email.");
									if(request.getParameter("signin").equals("14"))
										out.println("Si vous êtes une entreprise, veuillez indiquer votre secteur d'activité.");
									if(request.getParameter("signin").equals("15"))
										out.println("Si vous êtes une entreprise, veuillez indiquer votre effectif.");
								out.println("</div>");
							}
						}
					%>
					
					<form method="POST" action="http://localhost:8080/iWork/signin">
						<br />
						<p>
							<label class="container">Candidat
							  <input type="radio" checked="checked" name="statut" value="0">
							  <span class="checkmark"></span>
							</label>
						</p>
						<p>
							<label class="container">Entreprise
							  <input type="radio" name="statut" value="1">
							  <span class="checkmark"></span>
							</label>
						</p>
						<br />
						<hr />
						<p>
							<h5>Identité</h5>
						</p>
						<p>
							<input type="text" name="prenom" placeholder="Prénom*" />
						</p>
						<p>
							<input type="text" name="nom" placeholder="Nom*" />
						</p>
						<p>
							<input type="password" name="mdp" placeholder="Mot de passe*" />
						</p>
						<p>
							<input type="password" name="mdpc" placeholder="Confirmation du mot de passe*" />
						</p>
						<br /><br />
						<hr />
						<p>
							<h5>Adresse</h5>
						</p>
						<p>
							<input type="text" name="nom_entreprise" placeholder="Nom de l'entreprise**" />
						</p>
						<p>
							<input type="text" name="adresse_entreprise" placeholder="Adresse de l'entreprise**" />
						</p>
						<br />
						<p>
							<input type="text" name="adresse" placeholder="Adresse*" />
						</p>
						<p>
							<input type="text" name="codep" placeholder="Code postal*" />
						</p>
						<p>
							<input type="text" name="ville" placeholder="Ville*" />
						</p>
						<p>
							<input type="text" name="region" placeholder="Région*" />
						</p>
						<p>
							<input type="text" name="pays" placeholder="Pays*" />
						</p>
						<br /><br />
						<hr />
						<p>
							<h5>Contact</h5>
						</p>
						<p>
							<input type="text" name="tel" placeholder="Tél professionnel*" />
						</p>
						<p>
							<input type="mail" name="email" placeholder="Adresse email*" />
						</p>
						<br /><br />
						<hr />
						<p>
							<h5>Informations sur l'entreprise</h5>
						</p>
						<p>
							<input type="text" name="secteur" placeholder="Secteur d'activité**" />
						</p>
						<p>
							<input type="number" name="effectif" placeholder="Effectif**" min="1" max="5000" />
						</p>
						<br />
							<b style="font-size:11px">* Champs obligatoires</b><br />
							<b style="font-size:11px">** Champs obligatoires Entreprise</b>
						<br />
						<br />
						<p>
							<input type="submit" value="VALIDER L'INSCRIPTION" />
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