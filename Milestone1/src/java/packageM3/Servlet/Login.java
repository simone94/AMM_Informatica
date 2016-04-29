/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageM3.Servlet;

import packageM3.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean err=false;
        HttpSession session = request.getSession(false);
        
        
        if(session.getAttribute("amILogged").equals(true)){
            
            if(session.getAttribute("id").equals(0)){
                
                request.setAttribute("giusto", true);
                
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            
            if(session.getAttribute("id").equals(1)){
                request.setAttribute("giusto", true);
                request.setAttribute("listaMaterassi", FactoryOggetti.getInstance().getOggettiEsposti());

                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        }
        if(session.getAttribute("amILogged").equals(false)){
        
        
        if(request.getParameter("Submit") != null){
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Cliente nuovoC = FactoryCliente.getInstance().getCliente();
            Venditore nuovoV = FactoryVenditore.getInstance().getVenditore();
            
            if(password != null && username != null && nuovoC.getUsername().equals(username) && nuovoC.getPassword().equals(password)){
                session.setAttribute("amILogged", true);

                request.setAttribute("utente", nuovoC);
                request.setAttribute("giusto", true);
                request.setAttribute("listaMaterassi", FactoryOggetti.getInstance().getOggettiEsposti());

                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            
            if(password != null && username != null && nuovoV.getUsername().equals(username) && nuovoV.getPassword().equals(password)){
                session.setAttribute("amILogged", true);

                request.setAttribute("utente", nuovoV);
                request.setAttribute("giusto", true);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            if(password == null || username == null || 
                    !(nuovoV.getUsername().equals(username)) || !(nuovoV.getPassword().equals(password)) || 
                    !(nuovoC.getUsername().equals(username)) || !(nuovoC.getPassword().equals(password))){
                err=true;
            }
        }
        if(err)request.setAttribute("errore", true);
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
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
