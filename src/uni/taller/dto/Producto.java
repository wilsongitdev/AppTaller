
package uni.taller.dto;

public class Producto {
 //atributos
 private String idProducto;
 private String descripcion;
 private int idLinea;
 private double precioCompra;
 private double precioVenta;
 private int stock;
 
 //constructor

    public Producto() {
    }

    public Producto(String idProducto, String descripcion, int idLinea, double precioCompra, double precioVenta, int stock) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.idLinea = idLinea;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
 // metodos de encapsulacion: get y set

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
