<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="keywords" content="FreeVote, piattaforma voto, voto, voto online, interfaccia, admin, interfaccia Admin, amministratore, dev">
	<meta name="description" content="Interfaccia Admin">
	<meta name="author" content="Bene Sabato, Cozzolino Lidia, Napoli Riccardo, Penna Alessandro">
    <title>FreeVote &dash; Interfaccia Admin</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS --> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">						
	<!-- jQuery library --> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
	<!-- Popper JS --> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
	<!-- Latest compiled JavaScript --> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
</head>            

<body class="bg-interfaccia-admin">
	<%@ include file="admin-header.jsp"%>
	
	<div class="container-fluid py-5">
		<div class="text-interfaccia-mobile" id="cell">
			<h1 class="text-light text-center">Benvenuto amministratore&excl;</h1>
			<p class="lead text-light text-center"> Da quest&apos;interfaccia potrai accedere ad alcune operazioni riservate&period;</p>
		</div>
		<div id="xl">
			<div class=row>
				<div class="col py-5 my-5">
					<h1 class="text-light" style="text-align:left">B<br>E<br>N<br>V<br>E<br>N<br>U<br>T<br>O<br><br></h1>
				</div>
				<div class="col py-3">
					<h1 class="text-light" style="text-align:right">A<br>M<br>M<br><span class="pr-2 mr-1">I</span><br>N<br><span class="pr-2 mr-1">I</span><br>S<br>T<br>R<br>A<br>T<br>O<br>R<br>E<br></h1>
				</div>
			</div>
		</div>
	</div>
</body>
</html>