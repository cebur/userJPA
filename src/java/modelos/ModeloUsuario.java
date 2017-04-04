/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Usuarios;
import java.util.List;


public interface ModeloUsuario {

    public Usuarios buscarUsuarioId(Integer id) throws Exception;
    
    public int contarUsuarios() throws Exception;

    public List<Usuarios>  listaUsuarios() throws Exception;
    
    public void crearUsuario(Usuarios usuarios) throws Exception;
    
}



