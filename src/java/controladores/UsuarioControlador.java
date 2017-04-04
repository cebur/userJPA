/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Usuarios;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloUsuario;


@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB ModeloUsuario modeloUsuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Crear el objeto usuario
        Usuarios user = null, uCreado = new Usuarios();
        
        //Extraer el dato desde el modelo
        int numeroUsuarios = 0;
        try {
            numeroUsuarios = modeloUsuario.contarUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Extrar un usuario por id
            user = modeloUsuario.buscarUsuarioId(1);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Extraer lista de usuarios
        List<Usuarios> lista = null;
        try {
            lista = modeloUsuario.listaUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //crear usuario
        uCreado.setNombre("Gato");
        uCreado.setApellido("Pelao");
        uCreado.setEmail("b@g.com");
        uCreado.setPassword("holaMundo");
        
        try {
            modeloUsuario.crearUsuario(uCreado);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Preparar contenido para la vista
        request.setAttribute("numeroUsuarios", numeroUsuarios);
        request.setAttribute("user", user.toString());//Se está enviando el objeto completo
        request.setAttribute("lista", lista);
        
        //Enviar la vista
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vistas/usuarios.jsp");
        rd.forward(request, response); 
        
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
