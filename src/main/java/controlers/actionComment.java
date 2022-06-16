package controlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.commentDAO;

/**
 * Servlet implementation class actionComment
 */
public class actionComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actionComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		commentDAO cdao = new commentDAO();
		
		HttpSession ss = request.getSession();
		
		
		
		int idcomment = Integer.parseInt(request.getParameter("id"));
		
		String action = request.getParameter("action");
		
		int result = 0;
		
		if(action != null) {
			
			if(action.equals("Supprimer")) {
				
				result = cdao.deleteCommentById(idcomment);
				
				request.getRequestDispatcher("commentaires.jsp?result="+result).forward(request, response);
				
				
				
			}else if(action.equals("Accepter")) {
				
				result = cdao.acceptCommentById(idcomment);
				
				request.getRequestDispatcher("commentaires.jsp?result="+result).forward(request, response);
				
				
				
			}else {
				
				response.sendRedirect("commentaires.jsp");
			}
			
		}
		
		
		
	}

}