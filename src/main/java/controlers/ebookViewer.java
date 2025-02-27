package controlers;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import dao.offreDAO;
import entities.offre;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.epub.EpubWriter;

/**
 * Servlet implementation class ebookViewer
 */

public class ebookViewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ebookViewer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		byte[] filedata =null;
		
		
		int id  = Integer.parseInt(request.getParameter("id"));
		
		offreDAO odao = new offreDAO();
		
		offre o = odao.getoffreById(id);
		
		
		String fileName = o.getTitre()+".pdf";
        Blob blob =  o.getPdf();
        InputStream inputStream = null;
		
	
		
		
		Blob blobPdf =  o.getPdf();
		File outputFile = new File("/tmp/blah/whatever.pdf");
		FileOutputStream fout = new FileOutputStream(outputFile);
		try {
			IOUtils.copy(blobPdf.getBinaryStream(), fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

 		
	}

}
