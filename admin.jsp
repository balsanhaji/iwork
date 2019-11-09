<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<%@ include file="structure/header.jsp" %>
	<div id="bloc_page">
		<section id="section_admin">
			<article>
				<div id="admin" class="div targetDiv1">
					<div class="title">
						<h4>Accueil Admin</h4>
					</div>
					
					<p>
						p
					</p>
				</div>
				
				<div id="admin" class="div1 targetDiv">
					<div class="title">
						<h4>Liste des membres</h4>
					</div>
					
					<jsp:include page="/liste_membres" />
				</div>

				<div id="admin" class="div2 targetDiv">
					<div class="title">
						<h4>Liste des candidatures</h4>
					</div>
					
				</div>
				
				<div id="admin" class="div3 targetDiv">
					<div class="title">
						<h4>Liste des documents</h4>
					</div>
					
					<p>
						iWork emploi est une plateforme dédiée aux demandeurs d'emploi, aux personnes recherchant une formation ou une alternance et aux entreprises qui recrutent.
					</p>
				</div>
				
				<div id="admin" class="div4 targetDiv">
					<div class="title">
						<h4>Paramètres</h4>
					</div>
					
					<p>
						iWork emploi est une plateforme dédiée aux demandeurs d'emploi, aux personnes recherchant une formation ou une alternance et aux entreprises qui recrutent.
					</p>
				</div>
			</article>	
			
			<aside>
				<div class="side">
					<div class="title">
						<h4>Menu</h4>
					</div>
					
					<ul>
						<li><a class="showSingle" target="1">Liste des membres</a></li>
						<li><a class="showSingle" target="2">Liste des candidatures</a></li>
						<li><a class="showSingle" target="3">Liste des documents</a></li>
						<li><a class="showSingle" target="4">Paramètres du site</a></li>
					</ul>
				</div>
			</aside>
		</section>
	</div>
	
<%@ include file="structure/footer.html" %> 