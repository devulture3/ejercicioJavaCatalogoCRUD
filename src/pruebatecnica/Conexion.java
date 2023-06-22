
package pruebatecnica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sk
 */
public class Conexion {
    String bd="bdpruebatec";//NOMBRE DE LA BASE DE DATOS
    String url="jdbc:mysql://localhost:3306/";//HOST DE LA BASE DE DATOS
    String user="root"; //USUARIO
    String password="";//CONTRASEÑA
    String driver="com.mysql.cj.jdbc.Driver"; //DRIVER NECESARIO PARA HACER LA CONEXION A LA BASE DE DATOS
    Connection cx;

    public Conexion() {
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd, user, password);
//            System.out.println("Se conecto a DB: "+ bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a DB: "+ bd);
            //Logger.getLogger(Conection1.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //prueba para ver si se conecta correctamente
//    public static void main(String[] args) {
//        conexion con = new conexion();
//        con.conectar();
//    }
}
