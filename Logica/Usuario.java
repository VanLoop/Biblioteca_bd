
package Logica;


public class Usuario {
    
    private String usuario_id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasena;

    public String getUsuario_id() {
        return usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
            
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
