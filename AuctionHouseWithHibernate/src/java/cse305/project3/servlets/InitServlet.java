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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.Timestamp;

/**
 *
 * @author Tomasz
 */
public class InitServlet extends HttpServlet {

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
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InitServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InitServlet at " + request.getContextPath() + "</h1>");

            SessionFactory sessionFactory =
                    SessionFactoryStore.getSessionFactoryStore().getSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            out.println("Session opened");

            Person person = new Person();
            person.setLastName("Smith");
            session.save(person);
            out.println("person saved");

            Customer customer = new Customer();
            customer.setFirstName("ACustomer");
            customer.setLastName("Robinson");
            session.save(customer);

            Customer buyer = new Customer();
            buyer.setLastName("ABuyer");
            session.save(buyer);

            Employee employee = new Employee();
            employee.setLastName("AnEmployee");
            session.save(employee);

            AuctionItem item1 = new AuctionItem();
            item1.setName("Car");
            session.save(item1);

            AuctionItem item2 = new AuctionItem();
            item2.setName("Yacht");
            session.save(item2);

            Auction auction1 = new Auction();
            auction1.setSeller(customer);
            auction1.setBuyer(buyer);
            auction1.setItem(item1);
            Timestamp openingTimestamp = new Timestamp(new Date().getTime());      //set opening date to current time
            auction1.setOpeningDate(openingTimestamp);
            auction1.setClosingDate(
                    new Timestamp(openingTimestamp.getTime()+(1000*60*60*24*3)));   //set closing date to 3 days from opening
            

            Auction auction2 = new Auction();
            auction2.setSeller(customer);
            auction2.setItem(item2);
            Timestamp openingTimestamp2 = new Timestamp(new Date().getTime());      //set opening date to current time
            auction2.setOpeningDate(openingTimestamp2);
            auction2.setClosingDate(
                    new Timestamp(openingTimestamp2.getTime()+(1000*60*60*24*5)));   //set closing date to 5 days from opening

            session.save(auction2);
            session.save(auction1);



            Employee manager = new Employee("Washingtom",
                    "Larry",
                    "111 Some Street",
                    "Sometown",
                    "Newest York",
                    "99999",
                    "123-456-7890",
                    "111-22-33333",
                    new Date(),
                    11,
                    true, true,
                    "myloginid", "Password");
            session.save(manager);

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
