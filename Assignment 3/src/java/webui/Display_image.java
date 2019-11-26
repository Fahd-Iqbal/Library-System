package webui;

import core.Book;
import core.BookRepository;
import core.Session;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 16177215)
public class Display_image extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         if (request.getSession().getAttribute("someUser") == null){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp");
                dispatcher.forward(request, response);
           }
            
        
        try {
            if (request.getSession().getAttribute("someUser") == null) {
                request.getRequestDispatcher("login_page.jsp").forward(request, response);
            }
            int myId = Integer.parseInt(request.getParameter("id"));
            Book myBook = BookRepository.getInstance(getServletContext()).infoById((Session) request.getSession().getAttribute("someUser"), myId);
            response.setContentType(myBook.getCoverMimeType());
            OutputStream display = response.getOutputStream();
            display.write(myBook.getCoverImageData());
            display.flush();
            display.close();
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
