
package AccesDatos;

import Logica.Peticion;
import java.sql.*;


public class PeticionDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public PeticionDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_peticion(Peticion modelo_peticion){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO peticion (ISBN, usuario_id, titulo, descripcion, fecha) VALUES ('" +

                modelo_peticion.getISBN() + "', '" + 
                modelo_peticion.getUsuario_id()+ "', '" + 
                modelo_peticion.getTitulo()+ "', '" + 
                modelo_peticion.getDescripcion()+ "', '" + 
                 modelo_peticion.getFecha() + "')";
        
                
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Peticion seleccionar_peticion(String isbn, String id){

        Peticion modelo_libro= new Peticion();
        
        String sql_select;
        sql_select="SELECT "
                + "ISBN, "
                + "usuario_id, "
                + "titulo, "
                + "fecha, "
                + "descripcion "
                + "FROM peticion WHERE ISBN = '" + isbn +  "'"
                + "AND usuario_id = '" + id + "'" ;
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_libro.setISBN(seleccion.getString(1));
               modelo_libro.setUsuario_id(seleccion.getString(2));
               modelo_libro.setTitulo(seleccion.getString(3));
               modelo_libro.setFecha(seleccion.getString(4));
               modelo_libro.setDescripcion(seleccion.getString(5));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_libro;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    public void eliminar_peticion(String isbn, String id) {
    String sql_eliminar = "DELETE FROM peticion WHERE isbn = '" + isbn + "'"
                           + "AND usuario_id = '" + id + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);

        if (numeroFilas > 0) {
            System.out.println("Eliminación exitosa");
        } else {
            System.out.println("No se encontró ningún registro para eliminar");
        }
    } catch (SQLException e) {
        System.out.println("Error al intentar eliminar el registro");
        System.out.println(e);
        }
    }

    
    
}
