package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Person;
import Repository.PersonRepository;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if (name.length() > 20) {
			out.println("Name too long");
			return;
		}
		if (email.length() > 20) {
			out.println("email too long");
			return;
		}
		PersonRepository pRep = new PersonRepository();
		if (pRep.emailAvailable(email)) {
			pRep.insert(new Person(name, email));
			out.println("WELCOME");
		} else
			out.println("ERROR EMAIL");
	}

}
