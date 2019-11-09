<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>

<%@ include file="structure/menu.html" %>
	<div id="bloc_page">
		<section id="section_metiers">
			<article>
				<div id="metiers">					
					<%
						if(request.getParameter("page") != null) {
							if(request.getParameter("page").equals("1")) {
							%>
								<div class="title">
									<h4>INFORMATIONS</h4>
								</div>
							<%
							}
							if(request.getParameter("page").equals("2")) {
							%>
								<div class="title">
									<h4>Actualités</h4>
								</div>
							<%
							}
							if(request.getParameter("page").equals("3")) {
							%>
								<div class="title">
									<h4>Régions</h4>
								</div>
							<%
							}
							if(request.getParameter("page").equals("4")) {
							%>
								<div class="title">
									<h4>Mobilité internationale</h4>
								</div>
							<%
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