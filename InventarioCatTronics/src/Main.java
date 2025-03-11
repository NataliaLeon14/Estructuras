import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregando productos de prueba
        inventario.agregarProducto(new Producto("C001", "Laptop HP", 5, 750.99));
        inventario.agregarProducto(new Producto("J006", "Mouse Logitech", 10, 25.50));
        inventario.agregarProducto(new Producto("N004", "Teclado Mecánico", 7, 60.00));
        inventario.agregarProducto(new Producto("Q007", "Monitor Dell", 4, 150.00));

        System.out.println("\nInventario inicial:");
        inventario.mostrarInventario();

        // Pila de devoluciones
        Producto devuelto = new Producto("N004", "Monitor Samsung", 2, 180.00);
        inventario.devolverProducto(devuelto);
        inventario.procesarDevolucion();
        System.out.println("\nInventario después de procesar devolución:");
        inventario.mostrarInventario();

        // Cola reposiciones
        Producto reposicion = new Producto("C001", "Teclado Inalámbrico", 3, 40.00);
        inventario.solicitarReposicion(reposicion);
        inventario.procesarReposicion();
        System.out.println("\nInventario después de procesar reposición:");
        inventario.mostrarInventario();

        System.out.println("\n Buscando el producto con código 'J006':");
        inventario.buscarProducto("J006");


        System.out.println("\nInventario Ordenado por Código:");
        inventario.mostrarInventarioOrdenadoPorCodigo();

        System.out.println("\nInventario Ordenado por Precio Ascendente:");
        inventario.mostrarInventarioOrdenadoPorPrecio();
    }
}