package webui;

import core.BookRepository;
import core.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete_all_books extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp");
                dispatcher.forward(request, response);
           }
            
        
        try {
            BookRepository.getInstance(getServletContext()).deleteAll((Session) request.getSession().getAttribute("someUser"));
            response.sendRedirect("List_all_books");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Delete_1_book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
