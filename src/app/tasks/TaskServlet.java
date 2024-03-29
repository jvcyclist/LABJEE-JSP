package app.tasks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		try{
		request.setAttribute("x_redirect","Jan Kowalski jest zalogowany!");
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/task_page.jsp");
		dispatcher.forward(request, response);
		}finally{
		out.close();
		}

			}

	private void outFooter(PrintWriter out) {
		out.print("</body></html>");
	}

	private void outHeader(PrintWriter out, String title) {
		String str = "<html><head>" +
				"<meta http-equiv=\"Content-Type\" content=\"" + CONTENT_TYPE + "\">" +
				"<title>" + title + "</title>" +
				"</head><body>";
				out.print(str);
	}
	
}
