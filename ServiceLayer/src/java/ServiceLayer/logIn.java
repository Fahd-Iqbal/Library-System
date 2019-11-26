/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiceLayer;

import core.Session;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webui.MainServlet;

/**
 *
 * @author fahd_
 */
public class logIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                response.setContentType("text/html;charset=UTF-8");
        
        Session mySession = new Session();
        
        
        
        
         try {
          
          String encoded_pass = useMd5(request.getParameter("password"));
            
            mySession.login(request.getParameter("username"), encoded_pass, getServletContext());
        } catch (FileNotFoundException | ParseException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NullPointerException e){
           RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp");
            dispatcher.forward(request, response);    
        }
          if (mySession.isUserLoggedIn()) {
            request.getSession().setAttribute("someUser", mySession);
            
             RequestDispatcher dispatcher = request.getRequestDispatcher("Book");
            dispatcher.forward(request, response);
       
    }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
