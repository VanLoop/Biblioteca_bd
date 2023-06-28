

package Controladores;

import Logica.Empleado;
import AccesDatos.EmpleadoDAO;

public class ControladorEmpleado {
            
    EmpleadoDAO dao_empleado;
    
    public ControladorEmpleado(){
        dao_empleado = new EmpleadoDAO();           
    }
    
    public void agregar_empleado(String id_empleado, String nombre, String cargo){
        Empleado modelo_empleado = new Empleado();        

        modelo_empleado.setId_empleado(id_empleado);
        modelo_empleado.setNombre(nombre);
        modelo_empleado.setCargo(cargo);

        dao_empleado.insertar_empleado(modelo_empleado);
    }

    public Empleado consultar_empleado(String id_empleado){
        
        Empleado modelo_empleado = dao_empleado.seleccionar_empleado(id_empleado);
      
        return modelo_empleado;
    }
}
