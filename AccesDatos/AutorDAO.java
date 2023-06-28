

package AccesDatos;

import Logica.Autor;
import java.sql.*;


public class AutorDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public AutorDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void AgregarAutor(Autor autorr){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO autor VALUES ('" +
                autorr.getCodigoAutor()+ "', '" + 
                autorr.getApellido1Autor() + "', '" + 
                autorr.getApellido2Autor()+ "', '" + 
                autorr.getNombre1Autor()+ "', '" + 
                autorr.getNombre2Autor() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Autor SeleccionaAutor(String CodigoAutor){

        Autor autorr= new Autor();
        
        String sql_select;
        sql_select="SELECT "
                + "codigo_autor, "
                + "primer_nombre, "
                + "segundo_nombre, "
                + "primer_apellido, "
                + "segundo_apellido "
                + "FROM autor WHERE codigo_autor = '" + CodigoAutor +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               autorr.setCodigoAutor(seleccion.getString(1));
               autorr.setNombre1Autor(seleccion.getString(2));
               autorr.setNombre2Autor(seleccion.getString(3));
               autorr.setApellido1Autor(seleccion.getString(4));
               autorr.setApellido2Autor(seleccion.getString(5));
            }
            
            System.out.println("Seleccion exitosa");
           
            return autorr;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    public void DeleteAutor(String codigo_autor) {
    String sql_eliminar = "DELETE FROM autor WHERE codigo_autor = '" + codigo_autor + "'";
    
    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);
        
        if (numeroFilas > 0) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("No se encontró el autor con el código especificado");
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
