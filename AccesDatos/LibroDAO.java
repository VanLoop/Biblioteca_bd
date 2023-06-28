

package AccesDatos;

import Logica.Libro;
import java.sql.*;


public class LibroDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public LibroDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_libro(Libro modelo_libro){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO libro VALUES ('" +
                modelo_libro.getIsbn()+ "', '" + 
                modelo_libro.getTitulo() + "', '" + 
                modelo_libro.getAno_publicacion()+ "', '" + 
                modelo_libro.getIdioma()+ "', '" + 
                modelo_libro.getCodigo_area()+ "', '" + 
                modelo_libro.getNumero_pag()+ "', '" + 
                modelo_libro.getCodigo_autor()+ "', '" +
                modelo_libro.getCodigo() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Libro seleccionar_libro(String isbn_libro){

        Libro modelo_libro= new Libro();
        
        String sql_select;
        sql_select="SELECT "
                + "isbn, "
                + "titulo, "
                + "ano_publicacion, "
                + "idioma, "
                + "numero_pag, "
                + "codigo_area, "
                + "codigo_autor, "
                + "codigo "
                + "FROM libro WHERE isbn = '" + isbn_libro +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_libro.setIsbn(seleccion.getString(1));
               modelo_libro.setTitulo(seleccion.getString(2));
               modelo_libro.setAno_publicacion(seleccion.getString(3));
               modelo_libro.setIdioma(seleccion.getString(4));
               modelo_libro.setNumero_pag(seleccion.getString(5));
               modelo_libro.setCodigo_area(seleccion.getString(6));
               modelo_libro.setCodigo(seleccion.getString(7));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_libro;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
    public void actualizar_libro(Libro modelo_libro, String isbn, String titulo, String ano_publicacion, String idioma, 
                String codigo_area, String numero_pag, String codigo_autor, String codigo){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE libro \n" +
                "SET  isbn" + " = " + isbn +
                ",    titulo" + " = " + titulo +
                ",    ano_publicacion" + " = " + ano_publicacion +
                ",    idioma" + " = " + idioma +
                ",    codigo_area" + " = " + codigo_area +
                ",   numero_pag" + " = " + numero_pag +
                ",    codigo_autor" + " = " + codigo_autor +
                ",    codigo" + " = " + codigo +
                "WHERE isbn = '" + modelo_libro.getIsbn() +"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        
    }
    
    public String seleccionar_libros_por_titulo(String titulo_libro){


        
        String lista_de_autores = "";
        
        String sql_select;
        sql_select="SELECT "
                + "isbn "
                + "FROM libro WHERE titulo = '" + titulo_libro +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               lista_de_autores = lista_de_autores + "- " + seleccion.getString(1) + "\n";
            }
            
            System.out.println("Seleccion exitosa");
           
            return lista_de_autores/*modelo_libros_y_autores*/;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }    
        public void eliminar_libro(String isbn_libro) {
    String sql_eliminar = "DELETE FROM libro WHERE isbn = '" + isbn_libro + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);

        if (numeroFilas > 0) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN especificado");
        }
    } catch (SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    } catch (Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }
    }
}
