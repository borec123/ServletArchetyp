package cz.ysoft.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.ysoft.demo.encryption.Encoder;
import cz.ysoft.demo.encryption.EncoderFactory;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//--- process parameters:
		String buttonPressed = request.getParameter("button");
		boolean encode = "Encrypt".equals(buttonPressed);
		String algorithm = request.getParameter("algorithm");
		String message = request.getParameter("message");
		
		
		response.getWriter().println("<html><form method=\"post\"><label>Message:</label><br> " +
				"<textarea id=\"message\" name=\"message\" rows=\"10\" cols=\"35\">" +
				"</textarea> "
				+ "<br><br> <label for=\"alg\">Algorithm:</label>  <br>"
				+ " <select id=\"alg\" name=\"algorithm\"> "
				//+ " <option value=\"\">--Please choose an option--</option> " 
				+ " <option value=\"Morse\">Morse</option> " 
				+ " <option value=\"AES\">AES</option> " 
				+ " <option value=\"DES\">DES</option> " 
				+ " </select> "
				+ "<input type=\"submit\" name=\"button\" value=\"Encrypt\"/>"
				+ "<input type=\"submit\" name=\"button\" value=\"Decrypt\"/>"
				+ "</form> "
				+ "Result:<br>" 
				+ (buttonPressed != null ? processResult(encode, message, algorithm) : "")
				 + "</html>");
	}
	
	private String processResult(boolean encode, String message, String algorithm) {
		Encoder encoder = EncoderFactory.createEncoder(algorithm);
		String retValue;
		try {
			retValue = encode ? encoder.encode(message) : encoder.decode(message);
			return retValue;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() + e.getStackTrace();
		}
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