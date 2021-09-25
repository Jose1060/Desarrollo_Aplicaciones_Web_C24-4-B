/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

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
        out.print("<link rel=\"stylesheet\" \n"
                + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
        try {
            String par1 = request.getParameter("num1");
            String par2 = request.getParameter("num2");
            String op = request.getParameter("op");
            
            int n1 = Integer.parseInt(par1);
            int n2 = Integer.parseInt(par2);
            out.print("<div class='container'>");
            out.print("<div class=\"card\" style=\"width: 18rem;\">\n"
                    + "  <div class=\"card-body\">\n"
                    + "    <h5 class=\"card-title\">Parametros:</h5>\n"
                    + "    <h6 class=\"card-title\">"+ n1 + " y " + n2 +"</h6>\n"
                    + "    <p class=\"card-text\">");
            if(op.equals("suma"))
                out.print("La suma es " + (n1 + n2));
            else if(op.equals("resta"))
                out.print("La resta es " + (n1 - n2));
            else if(op.equals("multiplicacion"))
                out.print("La multiplicacion es " + (n1 * n2));
            else if(op.equals("division"))
                out.print("La division es " + (n1 / n2));
                
            out.print("</p>\n" + "    <a href=\"FormOperaciones.jsp\" class=\"btn btn-primary\">Volver</a>\n"
                    + "  </div>\n"
                    + "</div>");
            out.print("</div>");
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
