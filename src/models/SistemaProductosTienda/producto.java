package modelos;

public class Producto {
    //Crearemos los atributos de la clase producto
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    //ahora crearemos los constructores - El primero vacio y el siguiente todos

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Crearemos el getter and setter

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Y el ToString

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

    //Crear los metodos solciitados por el UML

    //Mostrar producto
    public String mostrarProducto(){
        String estado = disponible()?"Disponible":"No disponible";
        return "COD: "+codigo+" - Nombre: "+nombre+" - Total: "+calcularMonto()+" - Estado: "+estado;
    }

    //Calcular el monto del producto
    public double calcularMonto(){
        return this.precio * this.cantidad;
    }

    //Disponibilidad
    public boolean disponible(){
        return this.cantidad > 0;
    }
}