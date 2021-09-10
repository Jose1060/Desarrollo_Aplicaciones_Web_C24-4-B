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
@WebServlet(name = "ServletPrimos", urlPatterns = {"/ServletPrimos"})
public class ServletPrimos extends HttpServlet {

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
        
          
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int num = Integer.parseInt (request.getParameter("num"));
        
            int k = 0;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPares</title>");
            out.print("<link rel=\"stylesheet\" \n"
                    + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
            out.println("<body>");
            out.print("<div class='container'>");
            out.print("<h1>Tablas de Primos los primeros "+ num +"  primos</h1>");
            
            
            out.print("<div class='container'>");
            out.print("<table class='table table-success table-striped'>");
            out.print("<thead>");
            out.print("<tr><th>#</th><th>Numero</th></tr>");
            out.print("</thead>");
            out.print("<tbody>");
            
            for (int i = 1; i < num + 1; ++i) {   
                int r = 0;
                for (int n = 1; n <= i; ++n)
                    if(i % n == 0) {
                        System.out.println("numero: " + i);
                        System.out.println("divisor: " + n);
                        System.out.println("Resultado: "+ i % n);
                        System.out.println("-------------------------------");
                        r = r + 1;
                    }
                System.out.println("divisores"+r + "numero" + i);
              
                if (r == 2){
                    out.print("<tr><th>"+(k+1)+"</th><th>"+ i +"</th></tr>");
                    k++;
                }
                else{
                    num ++;
                    if (k == num){
                        break;
                    }
                }
            }
            out.print("</tbody>" + "</table>");
            out.println("</body>");
            out.println("</html>");
            out.print("</div>");
            
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
