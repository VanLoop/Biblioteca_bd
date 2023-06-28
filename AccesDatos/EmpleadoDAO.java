

package AccesDatos;

import Logica.Empleado;
import java.sql.*;


public class EmpleadoDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public EmpleadoDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_empleado(Empleado modelo_empleado){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO empleado(id, nombre, cargo, contrasena) VALUES ('" +
                modelo_empleado.getId_empleado()+ "', '" + 
                modelo_empleado.getNombre() + "', '" +
                modelo_empleado.getCargo() + "', '" + 
                modelo_empleado.getContrasena() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Empleado seleccionar_empleado(String identificacion_empleado){

        Empleado modelo_empleado= new Empleado();
        
        String sql_select;
        sql_select="SELECT "
                + "id_empleado, "
                + "nombre, "
                + "cargo, "
                + "contrasena "
                + "FROM empleado WHERE id_empleado = '" + identificacion_empleado +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
               modelo_empleado.setId_empleado(seleccion.getString(1));
               modelo_empleado.setNombre(seleccion.getString(2));
               modelo_empleado.setCargo(seleccion.getString(3));
               modelo_empleado.setContrasena(seleccion.getString(4));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_empleado;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    
}
