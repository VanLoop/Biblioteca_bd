
package Logica;


public class Peticion {

    private String ISBN;
    private String usuario_id;
    private String titulo;
    private String fecha;
    private String descripcion;
    

    public String getISBN() {
        return ISBN;
    }

    public String getUsuario_id() {
        return usuario_id;
    }
    
    public String getTitulo() {
        return titulo;
    }


    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
