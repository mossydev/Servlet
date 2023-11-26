/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.primerservlet.servlets;

import Logica.Controladora;
import Logica.Usuario; //se importó para que la clase SvUsuario(servlet) lo pueda ver y tener acceso.
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {   

    Controladora control = new Controladora();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario>listaUsuarios=new ArrayList<>();
        listaUsuarios=control.traerUsuarios();
        
        /*//Sólo se hacía de esta manera para pruebas lógicas, pero en la vida real no por aquí se enváin los datos.
        listaUsuarios.add(new Usuario(1,"123","Luisisna","de Paula","4444444"));
        listaUsuarios.add(new Usuario(2,"127","Iraisi","Cantón","8888888"));*/
        
        HttpSession misesion=request.getSession();
        misesion.setAttribute("listaUsuarios",listaUsuarios);
        
        response.sendRedirect("mostrarUsuarios.jsp");
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String dni=request.getParameter("dni");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String telefono=request.getParameter("telefono");
            
            Usuario usu = new Usuario();
            usu.setDni(dni);
            usu.setNombre(nombre);
            usu.setApellido(apellido);
            usu.setTelefono(telefono);
            
            control.crearUsuario(usu);
            response.sendRedirect("index.jsp");
            /*//Solo para programadores, para verificar en consola la obtención correctad e los datos.
              System.out.println("Dni es:"+ dni);
              System.out.println("Nombre es:"+ nombre);
              System.out.println("Apellido es:"+ apellido);
              System.out.println("Teléfono es:"+ telefono);
            */
                //processRequest(request, response);
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
