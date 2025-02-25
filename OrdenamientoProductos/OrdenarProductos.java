/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenarproductos;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}


public class OrdenarProductos {
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
    
    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Airpods", 1400),
            new Producto("Celular", 1800),
            new Producto("Aipad", 980),
            new Producto("Bafle", 650),
            new Producto("Alexa", 289)
        };

        System.out.println("Productos desordenados :");
        imprimirProductos(productos);

        Producto[] productosBurbuja = ordenarBurbuja(productos);
        System.out.println("Productos ordenados con Burbuja:");
        imprimirProductos(productosBurbuja);
        
        Producto[] productosInsertion = insertionSort(productos);
        System.out.println("\nProductos ordenados con Insertion Sort:");
        imprimirProductos(productosInsertion);
    }

    private static void imprimirProductos(Producto[] productos) {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
 }

