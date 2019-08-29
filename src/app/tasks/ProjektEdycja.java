package app.tasks;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Student;
import app.util.HibernateUtil;

@WebServlet("/ProjektEdycja")
public class ProjektEdycja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Set<Student> studenci;


	
	public ProjektEdycja() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_zapisz") != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

			/*Zadanie zadanie = new Zadanie();
			zadanie.setDataczasDodania(LocalDateTime.now());
			zadanie.setKolejnosc(1);
			zadanie.setNazwa("Zadanie nazwa");
			zadanie.setOpis("Zadanie opis");

			List<Zadanie> zadania = new ArrayList<>();
			zadania.add(zadanie);

			Projekt projekt = new Projekt();
			projekt.setNazwa("Projekt testowy");
			projekt.setDataczasUtworzenia(LocalDateTime.now());
			projekt.setNazwa("Nazwa testowa");
			projekt.setOpis("Przykładowy opis");

			entityManager.getTransaction().begin();
			entityManager.persist(projekt);
			entityManager.persist(zadanie);
			entityManager.getTransaction().commit();*/
			
			List<Object[]> results = entityManager.createNativeQuery("SELECT projekt_id, nazwa FROM projekt").getResultList();
					for (Object[] objects : results) {
					Integer projektId = (Integer) objects[0];
					String nazwa = (String) objects[1];
					System.out.println("ID: " + projektId + ", NAZWA: " + nazwa);
					}

			//request.setAttribute("projekt", projekt);

		}

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_edycja.jsp");
		dispatcher.forward(request, response);

	}

}
