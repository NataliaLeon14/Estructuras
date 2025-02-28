public class Producto implements Comparable<Producto> {

    private String nombre;
    private int cantidad;
    private double precio;

    public Producto (String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }
    @Override
    public String toString() {
        return nombre + " - " + precio + " | Cantidad: " + cantidad;
    }
}
