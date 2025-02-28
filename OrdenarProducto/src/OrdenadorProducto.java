public class OrdenadorProducto {

    public static Producto[] ordenarBurbuja(Producto[] arr) {
        Producto[] ordenado = arr.clone();
        int n = ordenado.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ordenado[j].getPrecio() > ordenado[j + 1].getPrecio()) {
                    Producto temp = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = temp;
                }
            }
        }
        return ordenado;
    }
    public static Producto[] insertionSort(Producto[] arr) {
        Producto[] ordenado = arr.clone();
        int n = ordenado.length;
        for (int i = 1; i < n; i++) {
            Producto key = ordenado[i];
            int j = i - 1;
            while (j >= 0 && ordenado[j].getPrecio() > key.getPrecio()) {
                ordenado[j + 1] = ordenado[j];
                j--;
            }
            ordenado[j + 1] = key;
        }
        return ordenado;
    }
    public static int buscarProductoBinario(Producto[] productos, String nombreBuscado) {
        int inicio = 0, fin = productos.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = productos[medio].getNombre().compareToIgnoreCase(nombreBuscado);

            if (comparacion == 0) {
                return medio;
            }
            if (comparacion < 0) {
                inicio = medio + 1;
            }
            else {
                fin = medio - 1;
            }
        }
        return - 1;
    }
    public static void imprimirProducto(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Posición " + i + ": " + productos[i]);
        }
    }
}
