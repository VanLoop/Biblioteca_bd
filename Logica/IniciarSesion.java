
package Logica;


public class IniciarSesion {
     private String Usuario;
    private String Contraseña;

    public IniciarSesion(String usuario, String contraseña){
        this.Usuario = usuario;
        this.Contraseña = contraseña;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
}
