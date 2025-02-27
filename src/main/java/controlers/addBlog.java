package controlers;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import tools.DBconnection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import dao.categorieDAO;
import dao.posteDAO;
import entities.categorie;
import entities.poste;

/**
 * Servlet implementation class addBlog
 */

@MultipartConfig
public class addBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//String imageFileName = blogImage.getSubmittedFileName();
		
		

		
		HttpSession s = request.getSession();

		
		InputStream is = null;	
		
		int result = 0;
		
		poste p1 = new poste();
		posteDAO pdao= new posteDAO();
		
		categorie c1 = new categorie();
		categorieDAO cdao = new categorieDAO();
		
		String decision = request.getParameter("decision");
		
		String source = (String) s.getAttribute("source");

		
		
		
		
		 
			
			if(decision.equals("Valider")) {
				
				
				
				Part blogImage = request.getPart("blogImage");
				
				if( blogImage != null) {
				is = blogImage.getInputStream();
				p1.setImageis(is);	
				}
				
				int idcategorie = Integer.parseInt(request.getParameter("categorie"));
				p1.setIdCategorie(idcategorie);
				
				String title = request.getParameter("blogTitle");
				p1.setTitle(title);
				
				String content = request.getParameter("article");
				p1.setContent(content);
				
				
				
				
				
				result = pdao.addPoste(p1);;
				
				request.getRequestDispatcher("AjouterArticle?result="+result).forward(request, response);
				
			}else if(decision.equals("Ajouter")){
				
				String cate = request.getParameter("addcat");
				c1.setNomcategorie(cate);
				
				result = cdao.addcategorie(c1);
				request.getRequestDispatcher(source+"?result="+result).forward(request, response);

			}
		

		
		
		
		
		
		
		
		/*
		
		 if (blogImage != null) {
			  
	            // Prints out some information
	            // for debugging
	            System.out.println(blogImage.getName());
	            System.out.println(blogImage.getSize());
	            System.out.println(blogImage.getContentType());
	  
	            // Obtains input stream of the upload file
	    		 is = blogImage.getInputStream();
	        }
	  
	        // Sends the statement to the
	        // database server
	
		
		 String SQL = "INSERT INTO blogimages (image) values (?)";
			
		 
		 
		
		  PreparedStatement preparedStatement;
	        try {
	            preparedStatement = DBconnection.connect().prepareStatement(SQL);
	  
	  
	            if (is != null) {
	  
	                // Fetches the input stream
	                // of the upload file for
	                // the blob column
	                preparedStatement.setBlob(1, is);
	            }

	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        
	        
	        
	        
	        
	        	Blob img = null;
		       byte[] imgdata = null;
		       
		       ArrayList<String> imgsrc = new ArrayList<String>();
		       
		   
	        try {
				st = DBconnection.connect().createStatement();
				   rs =  st.executeQuery("select * from blogimages;");
				   
				   
				   while(rs.next()){
					  	      
					      
					  	img=rs.getBlob(2);
					  	
					  	   byte[] imageBytes=img.getBytes(1, (int)img.length());

					  	   String encodedImage=Base64.getEncoder().encodeToString(imageBytes);
	  	
					  	   String image = "data:image/jpg;base64,"+encodedImage;
					  	   
					  	imgsrc.add(image);

						
						
					   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("imgssrc", imgsrc);
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
	        
	    */
		
		
	}

}
