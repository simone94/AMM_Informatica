/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageM3.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import packageM3.Classi.FactoryVenditore;
import packageM3.Classi.Oggetti;
import packageM3.Classi.Venditore;

/**
 *
 * @author Acer
 */
@WebServlet(name = "Vendi", urlPatterns = {"/venditore.html"})
public class Vendi extends HttpServlet {

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
        int idU = Integer.parseInt(request.getParameter("idU"));
        
        if(session.getAttribute("amILogged").equals(false) || idU!=0){
            request.setAttribute("errore", true);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }
        else {
            
            if(request.getParameter("Sell") != null){
            Oggetti nuovo = new Oggetti();
    
            nuovo.setNome(request.getParameter("nome"));
            nuovo.setId(request.getParameter("id"));
            nuovo.setUrl(request.getParameter("url"));
            nuovo.setDescrizione(request.getParameter("descrizione"));
            nuovo.setDettagli(request.getParameter("dettagli"));
            nuovo.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
            nuovo.setQuantita(Integer.parseInt(request.getParameter("nPezzi")));
            
            request.setAttribute("coso", nuovo);
            request.setAttribute("utente", FactoryVenditore.getInstance().getVenditore());
            request.getRequestDispatcher("successo.jsp").forward(request, response);
            }
            request.setAttribute("giusto", true);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
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
