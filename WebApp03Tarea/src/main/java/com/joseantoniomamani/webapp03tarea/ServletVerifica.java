/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseantoniomamani.webapp03tarea;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josea
 */
@WebServlet(name = "ServletVerifica", urlPatterns = {"/ServletVerifica"})
public class ServletVerifica extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String xusu = request.getParameter("xusu");
            String xpas = request.getParameter("xpas");
            String usuario = "Jose";
            String clave = "12345";
            if (xusu.equals(usuario) && xpas.equals(clave))
                response.sendRedirect("/WebApp03Tarea/servlets.html");
            else if (xusu.equals(usuario) && xpas != clave){              
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletPares</title>");
                out.print("<link rel=\"stylesheet\" \n"
                        + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
                out.println("<body>");
                out.print("<div class='container'>");
                out.println("<h1>Error clave " + clave + " </h1>");
                out.println("</body>");
                out.println("</html>");
                out.print("</div>");}
                
            else if (xusu != usuario){            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletPares</title>");
                out.print("<link rel=\"stylesheet\" \n"
                        + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
                out.println("<body>");
                out.print("<div class='container'>");
                out.println("<h1>Error usuario " + xpas + " </h1>");
                out.println("</body>");
                out.println("</html>");
                out.print("</div>");}
            else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletPares</title>");
                out.print("<link rel=\"stylesheet\" \n"
                        + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
                out.println("<body>");
                out.print("<div class='container'>");
                out.println("<h1>Error clave y usuario </h1>");
                out.println("</body>");
                out.println("</html>");
                out.print("</div>");}
            
            
        } finally { 
            out.close();
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
