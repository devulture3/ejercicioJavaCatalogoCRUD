package pruebatecnica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ProductosD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    //Metodo para registrarNuevaCategoria //LISTOOO
    public boolean registrarProducto(Productos prod) {
        String sql = "INSERT INTO productos(codigo, nombre, catalogo, precio) values (?,?,?,?)";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getCatalogo());
            ps.setDouble(4, prod.getPrecio());
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        } finally {//Finalmente cerramos la conexion
            try {
                con.close();
            } catch (SQLException ex) {
//                Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }

    //Metodo para listar Productos //LISTO
    public List listarProductos() {
        List<Productos> lista = new ArrayList();
        String sql = "SELECT * FROM productos";
        con = cn.conectar();//Conectamos a la base de datos
        try {
            ps = con.prepareStatement(sql);//Preparamos la sentencia 
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCatalogo(rs.getString("catalogo"));
                lista.add(pro);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return lista;
    }

    //Metodo para eliminar Productos //LISTO
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id= ?";
        con = cn.conectar();//Conectamos a la base de datos
        try {
            
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setInt(1, id);
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        } finally {//Finalmente cerramos la conexion
            try {
                con.close();
            } catch (SQLException ex) {
//                Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
    }

    //Metodo para modificar productos
    public boolean modificarProducto(Productos pro) {
        String sql = "UPDATE productos SET codigo=?, nombre=?, precio=?, catalogo=? WHERE id=?";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia sql
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setString(4, pro.getCatalogo());
            ps.setInt(5, pro.getId());
            ps.execute();//Se ejecuta la sentencia sql
            return true;//Si se realizo correctamente retornamos true
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            return false;
        }
    }

    //Metodo para consultar categorias y agregarlos //LISTO
    public void ConsultarCategorias(JComboBox categorias) {
        categorias.removeAllItems();
        String sql = "SELECT categoria FROM catalogo";
        try {
            con = cn.conectar();//Conectamos a la base de datos
            ps = con.prepareStatement(sql);//Preparamos la sentencia 
            rs = ps.executeQuery();
            while (rs.next()) {
                categorias.addItem(rs.getString("categoria"));
            }
        } catch (SQLException ex) {
//            Logger.getLogger(CatalogoD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
