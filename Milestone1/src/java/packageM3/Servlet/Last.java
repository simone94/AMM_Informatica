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
import packageM3.Classi.FactoryCliente;
import packageM3.Classi.FactoryOggetti;

/**
 *
 * @author Acer
 */
@WebServlet(name = "Last", urlPatterns = {"/Last"})
public class Last extends HttpServlet {

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
        String id = request.getParameter("idM");
        
        if(request.getParameter("Compra") != null){
            if(Double.parseDouble(request.getParameter("prezzo")) > Double.parseDouble(request.getParameter("saldo"))){
                request.setAttribute("utente", FactoryCliente.getInstance().getCliente());
                request.setAttribute("coso", FactoryOggetti.getInstance().find(id));
                request.setAttribute("errore", true);
                request.getRequestDispatcher("successo.jsp").forward(request, response);
            }
            else {
                request.setAttribute("utente", FactoryCliente.getInstance().getCliente());
                request.setAttribute("coso", FactoryOggetti.getInstance().find(id));
                request.setAttribute("giusto", true);
                
                request.getRequestDispatcher("successo.jsp").forward(request, response);
            }
                
        }
        else {
            request.setAttribute("giusto", false);
            request.setAttribute("errore", false);
            request.getRequestDispatcher("successo.jsp").forward(request, response);
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
