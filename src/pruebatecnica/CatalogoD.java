package pruebatecnica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sk
 */
public class CatalogoD {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Metodo para registrarNuevaCategoria
    public boolean registrarCategoria(Catalogo cat){
        String sql = "INSERT INTO catalogo(categoria) values (?)";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setString(1, cat.getNombre());
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        }finally{//Finalmente cerramos la conexion
            try {
                con.close();
            } catch (SQLException ex) {
//                Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    //Metodo para listar Categorias
    public List listarCategorias(){
        List<Catalogo> lista= new ArrayList();
        String sql = "SELECT * FROM catalogo";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia 
            rs = ps.executeQuery();
            while(rs.next()){
                Catalogo cat = new Catalogo();
                cat.setId(rs.getInt("id"));
                cat.setNombre(rs.getString("categoria"));
                lista.add(cat);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return lista;
    }
    
    //Metodo para eliminar categoria
    public boolean eliminarCategoria(int id){
        String sql = "DELETE FROM catalogo WHERE id= ?";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setInt(1,id);
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        }finally{//Finalmente cerramos la conexion
            try {
                con.close();
            } catch (SQLException ex) {
//                Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }
    
    //Metodo para modificar categorias
    public boolean modificarCategoria(Catalogo cat){
        String sql = "UPDATE catalogo SET categoria=? WHERE id=?";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setString(1,cat.getNombre());
            ps.setInt(2, cat.getId());
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        }
    }
    
}
