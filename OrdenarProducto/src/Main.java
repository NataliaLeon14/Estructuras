//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Producto[] productos = {
                new Producto("Airpods", 15, 1000),
                new Producto("Aipad", 10, 760),
                new Producto("Alexa", 13,980),
                new Producto("Camara Digital", 19, 1300),
                new Producto("Play Station", 14, 2100),
                new Producto("Nitendo switch", 9, 1100),
                new Producto("Apple Watch", 7, 800),
                new Producto("Dron", 3, 3200),
                new Producto("Lapto", 11, 2000),
                new Producto("Auriculares", 8, 3100),
        };
        System.out.println("\nProductos desordenados; ");
        OrdenadorProducto.imprimirProducto(productos);

        Producto[] productosBurbuja = OrdenadorProducto.ordenarBurbuja(productos);
        System.out.println("\nProductos ordenados con Burbuja: ");
        OrdenadorProducto.imprimirProducto(productosBurbuja);

        String nombreBuscar = "Apple Watch";
        int posicionBurbuja = OrdenadorProducto.buscarProductoBinario(productosBurbuja, nombreBuscar);
        if (posicionBurbuja != - 1) {
            System.out.println("\n[Burbuja] Producto encontrado en la posición: " + posicionBurbuja);
        }
        else {
            System.out.println("\n[Burbuja] Producto encontrado ");
        }
        Producto[] productosInsertion = OrdenadorProducto.insertionSort(productos);
        System.out.println("\nProductos ordenados con Insertion Sort: ");
        OrdenadorProducto.imprimirProducto(productosInsertion);

        int posicionInsertion = OrdenadorProducto.buscarProductoBinario(productosInsertion, nombreBuscar);
        if (posicionInsertion != - 1) {
            System.out.println("\n[Insertion] Producto encontrado en la posición: " + posicionInsertion);
        }
        else {
            System.out.println("\n[Insertion] Producto encontrado ");
        }
    }
}