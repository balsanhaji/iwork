<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>

<%@ include file="structure/menu.html" %>
	<div id="bloc_page">
		<section id="section_apropos">
			<article>
					<%
						if(request.getParameter("page") != null) {
							if(request.getParameter("page").equals("1")) {
							%>
							<div id="apropos1">
								<div class="title">
									<h4>A propos</h4>
								</div>
								
								<p>
									iWork emploi est une plateforme dédiée aux demandeurs d'emploi, aux personnes recherchant une formation ou une alternance et aux entreprises qui recrutent.
								</p>
								
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
								</p>
								
								<p>
									Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
								</p>
							</div>
							<%
							}
							if(request.getParameter("page").equals("2")) {
							%>
							<div id="apropos2">
								<div class="title">
									<h4>Carrières</h4>
								</div>
								
								<p>
									Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
								</p>
							</div>
							<%
							}
							if(request.getParameter("page").equals("3")) {
							%>
							<div id="apropos3">
								<div class="title">
									<h4>Informations légales</h4>
								</div>
								
								<p>
									Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
								</p>
							</div>
							<%
							}
							if(request.getParameter("page").equals("4")) {
							%>
							<div id="apropos4">
								<div class="title">
									<h4>Politique de confidentialité</h4>
								</div>
								
								<p>
									Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
								</p>
							</div>
							<%
							}
						}
					%>
			</article>	
			
			<aside>
				<div class="side">
					<div class="title">
						<h4>Contact</h4>
					</div>
					
					<p>
						<b>iWork Emploi</b><br />
						100 rue du Bois<br />
						75000 Paris
					</p>
					
					<p>
						Tél  : 03 20 09 01 08<br />
						Fax  : 03 20 09 01 07<br />
						Mail : contact@iwork.com
					</p>

					<ul class="icons">
						<li><a href="#" class="icon fab fa-twitter"></a></li>
						<li><a href="#" class="icon fab fa-facebook"></a></li>
						<li><a href="#" class="icon fab fa-tumblr-square"></a></li>
						<li><a href="#" class="icon fas fa-rss-square"></a></li>
					</ul>
				</div>
			</aside>
		</section>
	</div>
	
<%@ include file="structure/footer.html" %>