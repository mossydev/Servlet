/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.primerservlet.servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author moss_
 */
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    Controladora control = new Controladora();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        int id_editar= Integer.parseInt(request.getParameter("id_usuarioEdit"));
        Usuario usu = control.traerUsuarios(id_editar);
        
        HttpSession misesion=request.getSession();
        misesion.setAttribute("usuEditar",usu);
        
        response.sendRedirect("editar.jsp");
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
        //processRequest(request, response);
        
            String dni=request.getParameter("dni");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String telefono=request.getParameter("telefono");
            
            Usuario usu=(Usuario)request.getSession().getAttribute("usuEditar");
            usu.setDni(dni);
            usu.setNombre(nombre);
            usu.setApellido(apellido);
            usu.setTelefono(telefono);
            
            control.editarUsuario(usu);
            response.sendRedirect("index.jsp");
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
