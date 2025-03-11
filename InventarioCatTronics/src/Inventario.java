import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Inventario {
    private ListaEnlazada productos = new ListaEnlazada();
    private Stack<Producto> devoluciones = new Stack<>();
    private Queue<Producto> reposiciones = new LinkedList<>();

    public void agregarProducto(Producto producto) {
        productos.agregarProducto(producto);
    }

    public void eliminarProducto(String codigo) {
        if (productos.eliminarProducto(codigo)) {
            System.out.println("Producto eliminado del inventario.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void buscarProducto(String codigo) {
        Producto producto = productos.buscarProducto(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void devolverProducto(Producto producto) {
        devoluciones.push(producto);
        System.out.println("Producto agregado a la pila de devoluciones.");
    }

    public void procesarDevolucion() {
        if (!devoluciones.isEmpty()) {
            Producto producto = devoluciones.pop();
            productos.agregarProducto(producto);
            System.out.println("Devolución procesada y agregada al inventario.");
        } else {
            System.out.println("No hay devoluciones pendientes.");
        }
    }

    public void solicitarReposicion(Producto producto) {
        reposiciones.add(producto);
        System.out.println("Producto agregado a la cola de reposiciones.");
    }

    public void procesarReposicion() {
        if (!reposiciones.isEmpty()) {
            Producto producto = reposiciones.poll();
            productos.agregarProducto(producto);
            System.out.println("Reposición procesada y agregada al inventario.");
        } else {
            System.out.println("No hay reposiciones pendientes.");
        }
    }

    public void mostrarInventario() {
        productos.mostrarInventario();
    }

    public void mostrarInventarioOrdenadoPorCodigo() {
        productos.mostrarInventarioOrdenadoPorCodigo();
    }

    public void mostrarInventarioOrdenadoPorPrecio() {
        productos.mostrarInventarioOrdenadoPorPrecio();
    }
}



