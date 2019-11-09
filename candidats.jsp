<%@ page pageEncoding="UTF-8" %>

<%@ include file="structure/header.jsp" %>

<%@ include file="structure/menu.html" %>
	<div id="bloc_page">
		<section id="section_candidats">
			<article>
				<div id="candidats">					
					<%
						if(request.getParameter("page") != null) {
							if(request.getParameter("page").equals("1")) {
								response.sendRedirect("login.jsp");
		
		
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