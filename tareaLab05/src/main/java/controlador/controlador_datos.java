/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josea
 */
@WebServlet(name = "controlador_datos", urlPatterns = {"/controlador_datos"})
public class controlador_datos extends HttpServlet {

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
             String accion = request.getParameter("accion");
            if(request.getParameter("accion").equals("editarUsuario")){
                String xcod = request.getParameter("xcod");
                request.setAttribute("xcod", xcod);
                request.getRequestDispatcher("editar.jsp").forward(request,  response);  
            }else if(request.getParameter("accion").equals("GRABAR_U")){
                if (request.getParameter("boton").compareTo("GRABAR") == 0) {
                    String[] datos = new String[4];
                    String xcod = request.getParameter("xcod");
                    String xnom = request.getParameter("xnom");
                    String xclave = request.getParameter("xclave");
                    String xest = request.getParameter("xest");
                    
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
                    String usuario = "root";
                    String clave = "";
                    
                    try {                       
                        Class.forName(driver);
                        try (Connection xcon = DriverManager.getConnection(url, usuario, clave)) {
                            String sql = "update t_usuarios set nombre=?, clave=?, estado=? where codigo=? ";
                            PreparedStatement ps = xcon.prepareStatement(sql);
                            ps.setString(1, xnom);
                            ps.setString(2, xclave);
                            ps.setString(3, xest);
                            ps.setString(4, xcod);
                            ps.executeUpdate();
                            System.out.println("Exito");
                            System.out.println(xcod);
                            System.out.println(ps);
                            xcon.close();
                        }
                    } catch (Exception e) {
                        out.println("Error: (" + e.toString() + ") no reconocida...");
                        System.out.println(e.toString());
                    }
                    
                    response.sendRedirect("/tareaLab05/jstl_sql_a.jsp");
                    
                }
                else{
                    response.sendRedirect("/tareaLab05/jstl_sql_a.jsp");
                }
                
            }else if(request.getParameter("accion").equals("ELIMINAR_U")){
                
                String xcod = request.getParameter("xcod"); 
                
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
                String usuario = "root";
                String clave = "";
                try {                       
                        Class.forName(driver);
                        try (Connection xcon = DriverManager.getConnection(url, usuario, clave)) {
                            String sql  = "DELETE FROM t_usuarios WHERE codigo=?";
                            PreparedStatement ps = xcon.prepareStatement(sql);
                            ps.setString(1, xcod);
                            ps.executeUpdate();
                            System.out.println("Exito");
                            System.out.println(xcod);
                            System.out.println(ps);
                            xcon.close();
                        }
                    } catch (Exception e) {
                        out.println("Error: (" + e.toString() + ") no reconocida...");
                        System.out.println(e.toString());
                    }
                response.sendRedirect("/tareaLab05/jstl_sql_a.jsp");
            }else{
                out.println("Accion: (" + accion + ") No valida");
            }
            }catch(IOException | ServletException ex) {
                System.out.println( ex.toString() );   
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
