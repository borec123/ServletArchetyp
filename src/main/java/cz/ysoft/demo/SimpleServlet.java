package cz.ysoft.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().println("<html><form method=\"post\"><label>Message:</label><br> " +
				"<textarea id=\"message\" name=\"message\" rows=\"10\" cols=\"35\"> " +
				"</textarea> "
				+ "<br> <label for=\"alg\">Algorithm:</label>  <br>"
				+ " <select id=\"alg\" name=\"algorithm\"> "
				+ " <option value=\"\">--Please choose an option--</option> " 
				+ " <option value=\"AES\">AES</option> " 
				+ " <option value=\"DES\">DES</option> " 
				+ " <option value=\"Morse\">Morse</option> " 
				+ " </select> "
				+ "<input type=\"submit\" name=\"button\" value=\"Encrypt\"/>"
				+ "<input type=\"submit\" name=\"button\" value=\"Decrypt\"/>"
				+ "</form> "
				+ "<br>Result:<br>" 
				+ (request.getParameter("button") != null ? request.getParameter("button") : "")
				 + "</html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started.");
	}
	
}