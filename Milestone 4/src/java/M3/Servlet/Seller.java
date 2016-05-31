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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Seller extends HttpServlet {

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
        
        if(session.getAttribute("AmILogged").equals(false) || request.getParameter("idUtente").equals(0)){
            request.setAttribute("errore", true);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }
        if(request.getParameter("Continua") != null){
            
            Materasso m = new Materasso();
            m.setNome(request.getParameter("nome"));
            m.setId(request.getParameter("id"));
            m.setUrl(request.getParameter("foto"));
            m.setDescrizione(request.getParameter("descrizione"));
            m.setDettagli(request.getParameter("dettagli"));
            m.setDisponibili(Integer.parseInt(request.getParameter("nPezzi")));
            m.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
            
            request.setAttribute("utente", FactoryVenditore.getInstance().GetVenditore());
            request.setAttribute("materasso", m);
            request.getRequestDispatcher("conferma.jsp").forward(request, response);
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
