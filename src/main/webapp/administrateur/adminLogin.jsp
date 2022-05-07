<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset= "UTF-8" />
	<title>S'dentifier</title>
	<link rel="stylesheet" href="../css/styleBO.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
   <body>

<form action="adminLogin" method="post">
	<div class="loginPage">   
		<div class="adminLogin">
			<h1>Authentification</h1>
			<div class="mailInput">
				<i class="fa fa-envelope"></i>
				 <input type="text" name="username" placeholder="E-mail...">
			</div>
			<div class="passwordInput">
				<i class="fa fa-key"></i>
				 <input type="password" placeholder="Mot de passe..." name="password" id="password">
				 <span class="eye" onclick="showPassword()">
				 <i id="eyeShow" class="fa fa-eye"></i>
				 <i id="eyeHide" class="fa fa-eye-slash"></i>
				 </span>
			</div>
			<button type="submit" class="loginBtn">S'authentifier</button> 
<% String LoFai = (String)request.getAttribute("Failed");
	
	if(LoFai != null){
		if(LoFai.equals("true")){
		
	%>
		<p style="color:red;">*Username ou Mot de pass est incorrect !</p>
		<% 
	}else if(LoFai.equals("false")){%>
		<p style="color:red; display:none;">*Username ou Mot de pass est incorrect !</p>
	<% }
		}
	%>
		</div>
	</div>
</form>	
		<script src="../js/scriptBO.js"></script>




	</body>
</html>