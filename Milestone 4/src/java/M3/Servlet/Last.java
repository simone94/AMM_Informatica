/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.Servlet;

import M3.Classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author euralcoop
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

        if (request.getParameter("Submit") != null) {
            double saldoC = Double.parseDouble(request.getParameter("Saldo"));
            Materasso j = FactoryMaterasso.getInstance().find(request.getParameter("chiCompro"));
            int idCliente = Integer.parseInt(request.getParameter("idUtente"));
            int idVenditore = Integer.parseInt(request.getParameter("idVenditore"));
            double saldoV = (FactoryVenditore.getInstance().findWithId(idVenditore)).getSaldo();
            
            if (j != null) {
                if (saldoC < j.getPrezzo()) {
                    request.setAttribute("utente", FactoryCliente.getInstance().findWithId(idCliente));
                    request.setAttribute("materasso", j);
                    request.setAttribute("errore", true);
                    request.getRequestDispatcher("conferma.jsp").forward(request, response);   
                }
                if (saldoC > j.getPrezzo()) {
                    try {
                        FactoryMaterasso.getInstance().buy((saldoC-j.getPrezzo()), idCliente, (saldoV+j.getPrezzo()), idVenditore, j.getId(), (j.getDisponibili()-1));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    
                    request.setAttribute("utente", FactoryCliente.getInstance().findWithId(idCliente));
                    request.setAttribute("materasso", j);
                    request.setAttribute("giusto", true);
                    request.getRequestDispatcher("conferma.jsp").forward(request, response);   
                }
            }
            
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
