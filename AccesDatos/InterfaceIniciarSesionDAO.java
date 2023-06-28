package AccesDatos;

import java.util.List;

import Logica.IniciarSesion;

public interface InterfaceIniciarSesionDAO {
    List<IniciarSesion> administrador();
    IniciarSesion getAdministrador(String nombre);
    void save(IniciarSesion usuario);
    void uptade(IniciarSesion usuario);
    void delete(IniciarSesion usuario);
}
