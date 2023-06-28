/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesDatos;

import java.util.ArrayList;
import java.util.List;
import Logica.IniciarSesion;
/**
 *
 * @author Franklin Aguirre
 */
public class IniciarSesion_DAO  implements InterfaceIniciarSesionDAO{
    
    private  List<IniciarSesion> administradores;

    public IniciarSesion_DAO(){
        administradores = new ArrayList<IniciarSesion>();


        //Adiministradores
        administradores.add(new IniciarSesion("", ""));
        administradores.add(new IniciarSesion("", ""));
        administradores.add(new IniciarSesion("Wilson Andres", ""));
        administradores.add(new IniciarSesion("", ""));
    }

    @Override
    public List<IniciarSesion> administrador() {
        return administradores;
    }

    @Override
    public IniciarSesion getAdministrador(String nombre) {
        for(IniciarSesion usuario: administradores){
            if(usuario.getUsuario().equals(nombre)){
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void save(IniciarSesion usuario) {
        administradores.add(usuario);
    }

    @Override
    public void uptade(IniciarSesion usuario) {
        for(IniciarSesion iniciarSesion : administradores){
            if(iniciarSesion.getUsuario().equals(usuario.getUsuario())){
                usuario.setContraseña(usuario.getContraseña());;
            }
        }
    }

    @Override
    public void delete(IniciarSesion usuario) {
        administradores.remove(usuario);
    }
    
}
