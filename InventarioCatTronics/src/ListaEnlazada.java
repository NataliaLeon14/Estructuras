import java.util.ArrayList;
import java.util.List;

public class ListaEnlazada {
    private class Nodo {
        Producto producto;
        Nodo siguiente;

        public Nodo(Producto producto){
            this.producto = producto;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public void agregarProducto(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if(cabeza == null) {
            cabeza = nuevo;
        }
        else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public boolean eliminarProducto(String codigo) {
        if (cabeza == null) return false;

        if (cabeza.producto.getCodigo().equals(codigo)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.producto.getCodigo().equals(codigo)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) return false;

        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    public Producto buscarProducto(String codigo) {
        List<Producto> listaOrdenada = obtenerListaOrdenada();
        int inicio = 0, fin = listaOrdenada.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int comparacion = listaOrdenada.get(medio).getCodigo().compareTo(codigo);

            if (comparacion == 0) {
                return listaOrdenada.get(medio);
            }
            if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }

    public List<Producto> obtenerListaOrdenada() {
        List<Producto> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.producto);
            actual = actual.siguiente;
        }
        ordenarBurbuja(lista);
        return lista;
    }

    public void ordenarBurbuja(List<Producto> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {
                    Producto temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    public void mostrarInventario() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }


    public void mostrarInventarioOrdenadoPorCodigo() {
        List<Producto> listaOrdenada = obtenerListaOrdenada();
        for (Producto producto : listaOrdenada) {
            System.out.println(producto);
        }
    }


    public void mostrarInventarioOrdenadoPorPrecio() {
        List<Producto> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.producto);
            actual = actual.siguiente;
        }
        lista.sort(Producto.compararPorPrecio);
        for (Producto producto : lista) {
            System.out.println(producto);
        }
    }
}


