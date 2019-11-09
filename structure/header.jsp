<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
		<link rel="icon" type="image/png" href="images/favicon.png" />
        <link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/all.css">
		<link rel="stylesheet" href="css/fontawesome.css">
		<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
		<script type="text/javascript">
			jQuery(function(){
				jQuery('.targetDiv').hide();
				
				jQuery('.showSingle').click(function() {
					jQuery('.targetDiv1').hide();
					jQuery('.targetDiv').hide();
					jQuery('.div'+$(this).attr('target')).show();
				});
			});
		</script>
        <title>iWork Emploi</title>
    </head>
    
    <body>
		<div id="header">
			<header>
				<div id="left" class="element">
					<!-- <img src="images/logo.png" alt="logo" /> -->
					<div class="title">
						<a href="index.jsp">
							<span class="i">i</span>Work
							<h2>EMPLOI</h2>
						</a>
					</div>
				</div>

				<div id="center" class="element">
					<form action="/search" method="POST">						
						<input id="filter" type="text" placeholder="Chercher un emploi, une formation..." />
						<span id="filtersubmit" class="fa fa-search"></span>
					</form>
				</div>
				
				<div id="right" class="element">
					<div class="login">
						<jsp:include page="/user" />
					</div>
				</div>
			</header>
		</div>