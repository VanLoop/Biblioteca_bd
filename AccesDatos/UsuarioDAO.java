

package AccesDatos;

import Logica.Usuario;
import java.sql.*;


public class UsuarioDAO {
    
    FachadaBD fachada;
    Connection conexion;

    public UsuarioDAO(){
        fachada = new FachadaBD();
        conexion = fachada.getConnetion();
    }
        
    public void insertar_usuario(Usuario modelo_usuario){

        int numeroFilas=0;
        
        String sql_guardar;
        sql_guardar="INSERT INTO usuario VALUES ('" +
                modelo_usuario.getUsuario_id()+ "', '" + 
                modelo_usuario.getNombre() + "', '" + 
                modelo_usuario.getTelefono()+ "', '" + 
                modelo_usuario.getEmail()+ "', '" +
                modelo_usuario.getDireccion()+ "', '" +
                modelo_usuario.getContrasena() + "')";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Insersion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Insersion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Insersion fallida"); System.out.println(e);}
        
    }
    
    public Usuario seleccionar_usuario(String usuario_id){

        Usuario modelo_usuario= new Usuario();
        
        String sql_select;
        sql_select="SELECT "
                + "usuario_id, "
                + "nombre, "
                + "direccion, "
                + "telefono, "
                + "email, "
                + "contrasena "
                + "FROM usuario WHERE usuario_id =" + "'" + usuario_id +  "'";
        
        try{

            Statement sentencia = this.conexion.createStatement();
            ResultSet seleccion = sentencia.executeQuery(sql_select);
            
            while (seleccion.next()){
                modelo_usuario.setUsuario_id(seleccion.getString(1));
                modelo_usuario.setNombre(seleccion.getString(2));
                modelo_usuario.setDireccion(seleccion.getString(3));
                modelo_usuario.setTelefono(seleccion.getString(4));
                modelo_usuario.setEmail(seleccion.getString(5));
                modelo_usuario.setContrasena(seleccion.getString(6));
            }
            
            System.out.println("Seleccion exitosa");
           
            return modelo_usuario;
        }
        catch(SQLException e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        catch(Exception e){ System.out.println("Seleccion fallida"); System.out.println(e); return null;}
        
    }
    
    public void actualizar_usuario(Usuario modelo_usuario, String columna, String valor){

        int numeroFilas=0;
        
        String sql_guardar;
        
        sql_guardar="UPDATE usuario \n" +
                "SET " + columna + " = '" + valor + "' \n" +
                "WHERE usuario_id = '" + modelo_usuario.getUsuario_id() +"' ;";
        
        try{
            Statement sentencia = this.conexion.createStatement();
            numeroFilas = sentencia.executeUpdate(sql_guardar);
            
            System.out.println("Actualizacion exitosa"); 
        }
        catch(SQLException e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        catch(Exception e){ System.out.println("Actualizacion fallida"); System.out.println(e);}
        
    }
    
    public void eliminar_usuario(String codigo_usuario) {
    String sql_eliminar = "DELETE FROM usuario WHERE usuario_id = '" + codigo_usuario + "'";

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
