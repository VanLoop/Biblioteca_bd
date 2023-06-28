

package AccesDatos;

import Logica.Estudiante;
import java.sql.*;

public class EstudianteDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public EstudianteDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_estudiante(Estudiante modelo_estuduante){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO estudiante(usuario_id, carrera, universidad) VALUES ('" +
                modelo_estuduante.getUsuario_id()+ "', '" + 
                modelo_estuduante.getCarrera() + "', '" +
                modelo_estuduante.getUniversidad() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Estudiante seleccionar_estudiante(String usuario_id){

        Estudiante modelo_estudiante= new Estudiante();
        
        String sql_select;
        sql_select="SELECT "
                + "usuario_id, "
                + "carrera, "
                + "universidad "
                + "FROM estudiante WHERE usuario_id = '" + usuario_id +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_estudiante.setUsuario_id(seleccion.getString(1));
               modelo_estudiante.setUniversidad(seleccion.getString(2));
               modelo_estudiante.setCarrera(seleccion.getString(3));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_estudiante;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
}
