
package pruebatecnica;

public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private String catalogo;
    private double precio;

    public Productos() {
    }

    public Productos(int id, String codigo, String nombre, String catalogo, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.catalogo = catalogo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
