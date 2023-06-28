

package Logica;


public class Libro {
        
    private String isbn;
    private String titulo;
    private String ano_publicacion;
    private String idioma;
    private String numero_pag;
    private String codigo_area;
    private String codigo_autor;
    private String codigo;

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno_publicacion() {
        return ano_publicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getNumero_pag() {
        return numero_pag;
    }

    public String getCodigo_area() {
        return codigo_area;
    }
    
    public String getCodigo_autor() {
        return codigo_autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno_publicacion(String ano_publicacion) {
        this.ano_publicacion = ano_publicacion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNumero_pag(String numero_pag) {
        this.numero_pag = numero_pag;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }
    
    public void setCodigo_autor(String codigo_autor) {
        this.codigo_autor = codigo_autor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
