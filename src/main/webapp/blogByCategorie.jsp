 <%@page import="java.util.*"%>
  <%@page import="java.io.*"%>
        <%@page import="entities.poste"%>
        <%@page import="entities.categorie"%>
        <%@page import="dao.posteDAO"%>
        <%@page import="dao.categorieDAO"%>
        
<%


HttpSession s = request.getSession();



HttpSession ss = request.getSession();

posteDAO pdao = new posteDAO();

categorieDAO cdao = new categorieDAO();

int idca = Integer.parseInt(request.getParameter("c"));

categorie c = cdao.getcategorieById(idca);

String nomCat = c.getNomcategorie();

ArrayList<poste> postes = pdao.getPostesByIdCategorie(idca);

s.setAttribute("source", "Categorie?c="+idca);


%>
<jsp:include page="navBar.jsp"></jsp:include>


<jsp:include page="header.jsp"></jsp:include>

<div class="pageContainer">

	<div class="container">
		<div class="pageSubject">
			<span>Home</span>
			<span> / </span>
			<span>Blog</span>
			<span> / </span>
			<span><%=nomCat %></span>
		</div>
		<div class="pageContent">
			<div class="blog" id="blog">
			
				<%
	if(postes != null){
		for(int i = 0 ; i < postes.size() ; i++) {	

			byte[] imgdata = null;

			
			poste p = new poste();
			p = postes.get(i);
			
			int idPoste = p.getId();
			
			String title =  p.getTitle();
			
			int nblike = p.getNbrLike();
			
			int nbcomm = p.getNbrComments();
			
			 Calendar cal = Calendar.getInstance();
			    cal.setTime(p.getPublishDate());
			
			int day =  cal.get(Calendar.DAY_OF_MONTH);
			
			String month = null;
			
			int mo =  p.getPublishDate().getMonth();
			
			month = pdao.getMonth(mo);
			
			String content = p.getContent(); 
			

			
			byte[] imageBytes=p.getImage().getBytes(1, (int)p.getImage().length());
		  	String encodedImage=Base64.getEncoder().encodeToString(imageBytes);
		  	String image = "data:image/jpg;base64,"+encodedImage;
		  	
				%>
						<div class="postes">
							<a class="posteLink" href="poste.jsp?p=<%=idPoste%>">
							<div class="posteBG">
								<img src="<%=image%>">
								<div class="posteDate">
									<p><%=day %></p>
									<p><%=month %></p>
								</div>
							</div>
							<div class="posteDetails">
								<div class="details">
									<div class="posteTitle">
										<p><%=title %></p>
									</div>
									<div class="Stat">
										<div class="owner">
											<i class="fa-regular fa-user"></i>
											<p>Admin</p>
										</div>
										<div class="likes">
											<i class="fa-regular fa-thumbs-up"></i>
											<p><%=nblike %></p>
										</div>
										<div class="comments">
											<i class="fa-regular fa-message"></i>
											<p><%=nbcomm %>  Commentaire</p>
										</div>
									</div>
									<div class="content">
										<%=content%>
									</div>
								</div>
								<div class="posteBttn">
									<i class="fa-solid fa-chevron-right"></i>
								</div>
							</div>
								</a>
						</div>
				
				<%}}else{%>
					
					<p style="color:red;">Un error est servenu, Pas de poste pour le moment !</p>
				<% }%>		
			</div>
			<jsp:include page="sideBar.jsp"></jsp:include>
		</div>
	</div>

</div>








<jsp:include page="footer.jsp"></jsp:include>
