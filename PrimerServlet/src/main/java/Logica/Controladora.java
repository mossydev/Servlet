/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author moss_
 */
public class Controladora {
    //instancia para poder accesar a la clase ControladoraPersistencia y tener acceso a sus métodos. Se importa su paquete porque está en otro direfente al paquete Lógica.
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(Usuario usu){
        controlPersis.crearUsuario(usu);
    }
    
    public List<Usuario> traerUsuarios(){
        return controlPersis.traerUsuarios();
    }
    
        public void borrarUsuario(int id_eliminar){
            controlPersis.borrarUsuario(id_eliminar);
        }

    public Usuario traerUsuarios(int id_editar) {
        return controlPersis.traerUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
}
