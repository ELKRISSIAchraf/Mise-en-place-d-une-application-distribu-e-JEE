package ma.fstt.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.busniss.EJBEtudiantLocal;
import ma.fstt.busniss.EJBEtudiantRemote;
import ma.fstt.entity.Etudiant;



/**
 * Servlet implementation class EtudiantServlet
 */
@WebServlet("/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EtudiantServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB
    EJBEtudiantLocal ejb;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");	 
        try {
            switch (action) {
            case "ajouter":
                ajouteretudiant(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "ajouterEtudiant":
            	 RequestDispatcher dispatcher = request.getRequestDispatcher("AjouterEtudiant.jsp");
                 dispatcher.forward(request, response);
                break; 
          
            case "delete":
                deleteetudiant(request, response);
                break;          
            case "update":
               updateetudiant(request, response);
                break;
            case "updateEtudiant":
       		 Long id = Long.parseLong(request.getParameter("id"));
            	Etudiant et =ejb.trouverById(id);
            	request.setAttribute("etudiant", et);
            	RequestDispatcher dispatcher1 = request.getRequestDispatcher("UpdateEtudiant.jsp");
                dispatcher1.forward(request, response);
                 break;
            case "find":
              //  findetudiant(request, response);
                break;
                
            default:
            	response.getWriter().append("Served ---------------------------list-----------------: ").append(request.getContextPath());
                listEtudiants(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listEtudiants(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Etudiant> listetudiants =ejb.getEtudiants();
       
        //response.getWriter().append((CharSequence) listclients).append(request.getContextPath());
       //RequestDispatcher dispatcher = request.getRequestDispatcher(null);
        // dispatcher.forward(request, response);
       //System.out.println(listusers);
     /* PrintWriter out= response.getWriter();
        out.println("<html><body>");
        out.println("<li> Nom:"+listetudiants.size()+"</li>");
        out.println("</html></body>");*/
       request.setAttribute("listetudiants", listetudiants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile.jsp");
      dispatcher.forward(request, response);
    }
	private void ajouteretudiant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cne = request.getParameter("cne");
		String adresse = request.getParameter("adresse");
		String niveau = request.getParameter("niveau");
Etudiant etu = new Etudiant( nom, prenom, cne, adresse, niveau);
System.out.println(etu);
ejb.ajouterEtudiant(etu);
		response.sendRedirect("etudiant?action=list");  	
	}
	 private void deleteetudiant(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
		 Long id = Long.parseLong(request.getParameter("id"));	        
	    //   Client client = new Client(id);
	        ejb.deleteEtudiant(id);
	        response.sendRedirect("etudiant?action=list"); 
	    }
	 private void updateetudiant(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String cne = request.getParameter("cne");
			String adresse = request.getParameter("adresse");
			String niveau = request.getParameter("niveau");
	Etudiant etu = new Etudiant(id,nom, prenom, cne, adresse, niveau);
	ejb.updateEtudiant(etu);
	        response.sendRedirect("etudiant?action=list");  
		 }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
