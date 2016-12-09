
package Procedimientos;

import Ventanas.MenuPrincipal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Usuario {

public static ResultSet resultado;


public static void Agregar_Usuario(String Nombre, int IDEmp, String Contraseña, String Privilegio ){
    try {
        
          
   
//        int ID = IDEmp;
//    
//
//  
//    String NombreLogin = null;
//    int j = 0;
//   
//    String NombreEmpleado = Nombre ;
    
//    StringTokenizer Usuario= new StringTokenizer(NombreEmpleado, " ");
//                   while(Usuario.hasMoreTokens()){
//                       
//                    if(j!=0){
//                      NombreLogin = NombreLogin.concat(Usuario.nextToken());
//                    }
//                    if(j==0){
//                        NombreLogin = Usuario.nextToken();
//                        
//                        j++;
//                    }
//                  
//                     }

//    int i = 0;
//    String NombreUsuario = null;
    
//    String NombreCompleto = Nombre;
    
//    StringTokenizer User= new StringTokenizer(NombreCompleto, " ");
//                   while(User.hasMoreTokens()){
//                     
//                     if(i==2){
//                      NombreUsuario = NombreUsuario.concat("_"+User.nextToken());
//                       // JOptionPane.showMessageDialog(null, "Token ="+NombreUsuario+"\n i= "+i);
//                      break;
//                     }  
//                       if(i==1){
//                           User.nextToken();
//                           i=2;
//                       }
//                       
//                        if(i==0){
//                    NombreUsuario = User.nextToken();
//                    i=1;
//                //    JOptionPane.showMessageDialog(null, "Token ="+NombreUsuario+"\n i= "+i);
//                            
//                       }
                        
//                   }
                   
//     NombreUsuario = NombreUsuario.concat(String.valueOf(ID));
//     NombreUsuario = NombreUsuario.trim();
//     NombreLogin = NombreLogin.concat(String.valueOf(ID));
//     NombreLogin = NombreLogin.trim();


            //+"', Default_Database = [FarmaciaProyecto]";
    
    
    CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Agregar_Usuario](?,?,?,?,?)}");

   
        
        
                        consulta.setInt(1, IDEmp);
                        consulta.setString(2, Privilegio);
                        consulta.setString(3, Contraseña);
                        consulta.setString(4, Nombre);
                        consulta.setInt(5, MenuPrincipal.ID_Usuario);

                      
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Datos del Usuario Guardados Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

       
 
  try{
  Statement Ejecutar = Conexion.con.createStatement();
  String CreateLogin = "Create Login "+Nombre+" with password = '"+Contraseña+"'";
  Ejecutar.executeQuery(CreateLogin);
 // JOptionPane.showMessageDialog(null, "Login Creado Correctamente");
  
    } catch (SQLException ex) {
       //   JOptionPane.showMessageDialog(null,ex.getMessage());  
    //      JOptionPane.showMessageDialog(null, "Login Creado Correctamente");
    }
  
  
  
    try{
    Statement Ejecutar1 = Conexion.con.createStatement();
    String CrearUsuario = "sp_adduser "+Nombre+" , "+Nombre;
    Ejecutar1.executeQuery(CrearUsuario);
  //  JOptionPane.showMessageDialog(null, "Usuario Creado Correctamente");
       } catch (SQLException ex) {
        //  JOptionPane.showMessageDialog(null,ex.getMessage());
        //  JOptionPane.showMessageDialog(null, "Usuario Creado Correctamente");
       
    }
    
      
         try{
    Statement Ejecutar12 = Conexion.con.createStatement();
    String CrearUsuario2 = "sp_addrolemember [db_owner] , "+Nombre;
    Ejecutar12.executeQuery(CrearUsuario2);
  //  JOptionPane.showMessageDialog(null, "Usuario Creado Correctamente");
       } catch (SQLException ex) {
        //  JOptionPane.showMessageDialog(null,ex.getMessage());
      //    JOptionPane.showMessageDialog(null, "Usuario Creado Correctamente");
       
    }
         
          try{
  Statement Ejecutar4 = Conexion.con.createStatement();
  String CreateLogin2 = "alter server role [sysadmin] add member "+Nombre;
  Ejecutar4.executeQuery(CreateLogin2);
  //JOptionPane.showMessageDialog(null, "Login Creado Correctamente");
  
    } catch (SQLException ex) {
       //   JOptionPane.showMessageDialog(null,ex.getMessage());  
        //  JOptionPane.showMessageDialog(null, "Login Creado Correctamente");
    }
          
}   catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

   
}

}
public static void Cambiar_Contraseña(int ID, String NuevaContraseña){
    
  

        try {

        CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[CambiarContrasena_Usuario](?,?)}");
       
                        consulta.setInt(1,ID);
                        consulta.setString(2, NuevaContraseña);
                     
                        consulta.execute();

         JOptionPane.showMessageDialog(null,"Contraseña del Usuario Actualizada Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
}

public static void CambiarPrivilegio(int ID, String Privilegio){
 try {
     
//    String NombreUsuario= "";
// 
//    
//    
//    
//       resultado = Conexion.consulta("Select [Nombre_Usuario] from [dbo].[Usuario] "
//                + "where [ID_Usuario] = "+ID);
//  
//            while(resultado.next()){
//
//            NombreUsuario = resultado.getString(1);
//           
//            }
//    
// JOptionPane.showMessageDialog(null, "Nombre Usuario "+NombreUsuario);
// 
// 
//     String PrivilegioActual = null;
//    
//    
//       resultado = Conexion.consulta("Select [Privilegio] from [dbo].[Usuario] "
//                + "where [ID_Usuario] = "+ID);
//  
//            while(resultado.next()){
//
//            PrivilegioActual = resultado.getString(1);
//           
//            }
//            
//             JOptionPane.showMessageDialog(null, "Privilegio Actual "+PrivilegioActual);
//     
//     if("Público".equals(Privilegio)){
//         ID_Privilegio = 2;
//         if("Público".equals(PrivilegioActual)){
//         
//         }
//         else{
//             
//           try{
//    Statement Ejecutar4 = Conexion.con.createStatement();
//    String QuitarRole= "sp_droprolemember [db_owner] , "+NombreUsuario;
//    Ejecutar4.executeQuery(QuitarRole);
//    //JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Administrador Correctamente");  
//       } catch (SQLException ex) {
//         JOptionPane.showMessageDialog(null,ex.getMessage());
//          JOptionPane.showMessageDialog(null, "Usuario Eliminado del Rol Administrador Correctamente");  
//    }
//           
//            try{
//    Statement Ejecutar5 = Conexion.con.createStatement();
//    String AgregarRole= "sp_addrolemember Publico , "+NombreUsuario;
//    Ejecutar5.executeQuery(AgregarRole);
//    //JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Administrador Correctamente");  
//       } catch (SQLException ex) {
//          JOptionPane.showMessageDialog(null,ex.getMessage());
//          JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Público Correctamente");  
//    }
//         } 
//           
//     }
//     
//     if("Administrador".equals(Privilegio)){
//         ID_Privilegio = 1;
//          if("Administrador".equals(PrivilegioActual)){
//         
//         }
//          else{
//             
//          
//           try{
//    Statement Ejecutar4 = Conexion.con.createStatement();
//    String QuitarRole= "sp_droprolemember [Publico] , "+NombreUsuario;
//    Ejecutar4.executeQuery(QuitarRole);
//    //JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Administrador Correctamente");  
//       } catch (SQLException ex) {
//      //    JOptionPane.showMessageDialog(null,ex.getMessage());
//          JOptionPane.showMessageDialog(null, "Usuario Eliminado del Rol Público Correctamente");  
//    }
//           
//            try{
//    Statement Ejecutar5 = Conexion.con.createStatement();
//    String AgregarRole= "sp_addrolemember [db_owner] , "+NombreUsuario;
//    Ejecutar5.executeQuery(AgregarRole);
//    //JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Administrador Correctamente");  
//       } catch (SQLException ex) {
//      //    JOptionPane.showMessageDialog(null,ex.getMessage());
//          JOptionPane.showMessageDialog(null, "Usuario Agregado Al Rol Administrador Correctamente");  
//    }
//         
//          }
//           
//     }
//      
//     
     
        CallableStatement consultac = Conexion.con.prepareCall("{call [dbo].[CambiarPrivilegios] (?,?)}");

                        consultac.setInt(1,ID);
                        consultac.setString(2, Privilegio);
                        consultac.execute();
                        
                       

         JOptionPane.showMessageDialog(null,"Privilegio del Usuario Actualizado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

        }
 
}


public static void Activar_Usuario(int ID){
    
    
    try{
        
            String estado = "";
            resultado = Conexion.consulta("Select [Estado_Usuario] from [dbo].[Usuario] where [ID_Empleado] = "+ID);
            while(resultado.next()){

            estado = resultado.getString(1);
            }
            
            if("Activo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Desactivar_Usuario] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Usuario Desactivado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
          
            }
            
            if("Inactivo".equals(estado)){
               CallableStatement consulta = Conexion.con.prepareCall("{call [dbo].[Activar_Usuario] (?)}");

               consulta.setInt(1, ID);
               consulta.execute();
      JOptionPane.showMessageDialog(null,"Usuario Activado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE); 
            }
            
  
    }catch(SQLException ex){

          JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

    }
}


}