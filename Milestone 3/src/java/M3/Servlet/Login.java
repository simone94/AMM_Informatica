/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import M3.Classi.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author euralcoop
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
        
        HttpSession session = request.getSession(false);
        
        
        if(session.getAttribute("AmILogged").equals(true)){
            int idUtente=Integer.parseInt(request.getParameter("idUtente"));
            if(idUtente==0){
                request.setAttribute("giusto", true);
                request.setAttribute("utente", FactoryCliente.getInstance().GetCliente());
                request.setAttribute("materassi", FactoryMaterasso.getInstance().GetMaterassiList());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            if(idUtente==1){
                request.setAttribute("giusto", true);
                request.setAttribute("utente", FactoryVenditore.getInstance().GetVenditore());
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
        }
        
        if(request.getParameter("Submit") != null){
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Cliente nuovoCliente = FactoryCliente.getInstance().GetCliente();
            Venditore nuovoVenditore = FactoryVenditore.getInstance().GetVenditore();
            
            if(nuovoCliente.getUsername().equals(username) && nuovoCliente.getPassword().equals(password)){
                session.setAttribute("AmILogged", true);
                request.setAttribute("giusto", true);
                request.setAttribute("utente", nuovoCliente);
                request.setAttribute("materassi", FactoryMaterasso.getInstance().GetMaterassiList());
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            if(nuovoVenditore.getUsername().equals(username) && nuovoVenditore.getPassword().equals(password)){
                session.setAttribute("AmILogged", true);
                request.setAttribute("giusto", true);
                request.setAttribute("utente", nuovoVenditore);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
            request.setAttribute("errore", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        request.setAttribute("errore", false);
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
