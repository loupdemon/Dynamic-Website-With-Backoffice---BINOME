
    <%@page import="entities.admin"%>
    
    <%
    admin a= new admin();
    if(session.getAttribute("admin")==null){
    	response.sendRedirect("adminLogin.jsp");
    	
    	
    }else{
    	
    	 a = (admin)session.getAttribute("admin");
    }
    
    %>
<div class="adminSideBar" id="adminSideBar">

	<div class="admin">
		<li><i class="fa-solid fa-bars" id="burger"></i><span class="showSpan"><%=a.getUsername() %></span></li>
	</div>
	<div class="list">
		<ul class="mainList">
			<li><a href="Dashboard"><i class="fa-solid fa-house-chimney"></i><span class="showSpan">TABLEAU DE BOARD</span></a></li>
			<li class="li" id="blogli">
				<div class="dropDown" id="blog"><i class="fa-solid fa-newspaper"></i><span class="showSpan">BLOG<i class="normal fa-solid fa-caret-down" id="blogi"></i></span></div>
				<ul class="subList" id="blogul">
					<li><a href="AjouterArticle"><i class="fa-solid fa-plus"></i><span class="showSpan">AJOUTER POST</span></a></li>
					<li><a href="Articles"><i class="fa-solid fa-list"></i><span class="showSpan">POSTS</span></a></li>
				</ul>
			</li>
			<li><a href="Commentaires"><i class="fa-regular fa-comments"></i><span class="showSpan">COMMENTAIRES</span></a></li>
			<li><a href="Ebook"><i class="fa-solid fa-book"></i><span class="showSpan">EBOOK</span></a></li>
			<li><a href="OffresEmploi"><i class="fa-solid fa-briefcase"></i><span class="showSpan">OFFRES D'EMPLOI</span></a></li>
			<li><a href="Utilisateurs"><i class="fa-solid fa-users"></i></i><span class="showSpan">UTILISATEURS</span></a></li>
			<li><a href="NewsLetter"><i class="fa-solid fa-paper-plane"></i><span class="showSpan">NEWSLETTER</span></a></li>
			<li><a href="Profile"><i class="fa-solid fa-user"></i><span class="showSpan">PROFILE</span></a></li>
		</ul>
	</div>
	<div class="logout">
		<li><a href="LogoutS"><i class="fa-solid fa-power-off"></i><span class="showSpan">DECONNECTION</span></a></li>
	</div>
</div>



