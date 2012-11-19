/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.servlets;

import cse305.project3.auction_objects.Auction;
import cse305.project3.auction_objects.AuctionItem;
import cse305.project3.auction_objects.Customer;
import cse305.project3.auction_objects.Employee;
import cse305.project3.auction_objects.Person;
import cse305.project3.session_factory.SessionFactoryStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Tomasz
 */
public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");

            SessionFactory sessionFactory =
                    SessionFactoryStore.getSessionFactoryStore().getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // get customer 1 info
            int id = 1;
            Customer customer = (Customer) session.get(Customer.class, id);
            if (customer != null) {
                out.println("customer id=" + customer.getPersonID() + " name=" + customer.getLastName()+"<BR>");
            } else {
                out.println("There is no customer with id=" + id+"<BR>");
            }

            // get a list of all auction items
            Query queryItems = session.createQuery("from AuctionItem");
            List listOfItems = queryItems.list();
            Iterator itemsIterator = listOfItems.iterator();
            while(itemsIterator.hasNext()){
                AuctionItem item = (AuctionItem)itemsIterator.next();
                out.println("item "+item.getName()+" "+item.getType()+"<BR>");
            }
            
            // get all persons with last name Smith
            Query query=session.createQuery("from Person where lastName=:lastname");
            query.setParameter("lastname","Smith");
            List queryResult=query.list();
            Iterator iter = queryResult.iterator();
            while(iter.hasNext()){
                Person person = (Person)iter.next();
                out.println("last name="+person.getLastName()+"<BR>");
            }
            


            session.save(customer);
            session.getTransaction().commit();
            session.close();
            
            

                




            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
