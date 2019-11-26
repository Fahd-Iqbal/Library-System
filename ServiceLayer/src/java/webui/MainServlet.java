package webui;

import core.Book;
import core.BookRepository;
import core.IBookRepository;
import core.Session;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {

    private IBookRepository singleton = null;

    public static String useMd5(String input) {
        try {
            MessageDigest message = MessageDigest.getInstance("MD5");
            byte[] messageDigest = message.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String encodedText = number.toString(16);
            while (encodedText.length() < 32) {
                encodedText = "0" + encodedText;
            }
            return encodedText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        singleton = BookRepository.getInstance(getServletContext());
        String img =" ";
        
        Session mySession = new Session();
       
        
        
        
        try {
          img = request.getParameter("format");
            
          
          String encoded_pass = useMd5(request.getParameter("password"));
            
            mySession.login(request.getParameter("username"), encoded_pass, getServletContext());
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NullPointerException e){
           RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp");
            dispatcher.forward(request, response);    
        }
        request.getSession().setAttribute("Cover", img);
        
        
        if (mySession.isUserLoggedIn()) {
            request.getSession().setAttribute("someUser", mySession);
            List<Book> booksList = singleton.listBooks((Session) request.getSession().getAttribute("someUser"));
            request.setAttribute("booksList", booksList);
           
           if(img.equals("Cover")){
               RequestDispatcher dispatcher = request.getRequestDispatcher("home_page.jsp");
            dispatcher.forward(request, response);
           
           }
           
           else {
           
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("home2_pagejsp.jsp");
            dispatcher.forward(request, response);
           }
            
            
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    // Handles the HTTP <code>GET</code> method.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Handles the HTTP <code>POST</code> method.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Returns a short description of the servlet.
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
