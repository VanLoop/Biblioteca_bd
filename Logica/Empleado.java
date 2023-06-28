

package Logica;


public class Empleado {    
            
    private String id_empleado;
    private String nombre;
    private String cargo;
    private String contrasena;

    public String getId_empleado() {
        return id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
        
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
