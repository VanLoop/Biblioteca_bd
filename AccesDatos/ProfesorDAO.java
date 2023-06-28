
package AccesDatos;

import Logica.Profesor;
import java.sql.*;


public class ProfesorDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public ProfesorDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_profesor(Profesor modelo_profesor){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO profesor(usuario_id,dependencia, titulo) VALUES ('" +
                modelo_profesor.getUsuario_id()+ "', '" + 
                modelo_profesor.getDependencia() + "', '" +
                modelo_profesor.getTitulo() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Profesor seleccionar_profesor(String codigo_usuario_profesor){

        Profesor modelo_profesor= new Profesor();
        
        String sql_select;
        sql_select="SELECT "
                + "usuario_id, "
                + "titulo, "
                + "dependencia "
                + "FROM profesor WHERE usuario_id = '" + codigo_usuario_profesor +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_profesor.setUsuario_id(seleccion.getString(1));
               modelo_profesor.setTitulo(seleccion.getString(2));
               modelo_profesor.setDependencia(seleccion.getString(3));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_profesor;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void eliminar_profesor(String usuario_id) {
    String sql_eliminar = "DELETE FROM profesor WHERE usuario_id = '" + usuario_id + "'";

    try {
        Statement sentencia = this.conexion.createStatement();
        int numeroFilas = sentencia.executeUpdate(sql_eliminar);
        
        System.out.println("Eliminación exitosa");
    } catch (SQLException e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
    } catch (Exception e) {
        System.out.println("Eliminación fallida");
        System.out.println(e);
        }
    }
    
    
}
