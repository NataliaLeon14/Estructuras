import java.util.Scanner;

class Contacto {
    String nombre;
    String tlf;
    Contacto izquierda, derecha;

    public Contacto(String nombre, String tlf) {
        this.nombre = nombre;
        this.tlf = tlf;
        izquierda = derecha = null;
    }
}

class Agenda {
    private Contacto raiz;

    public void agregarContacto(String nombre, String tlf) {
        raiz = insertar(raiz, nombre, tlf);
    }

    private Contacto insertar(Contacto nodo, String nombre, String tlf) {
        if (nodo == null) {
            return new Contacto(nombre, tlf);
        }
        if (nombre.compareToIgnoreCase(nodo.nombre) < 0) {
            nodo.izquierda = insertar(nodo.izquierda, nombre, tlf);
        } else if (nombre.compareToIgnoreCase(nodo.nombre) > 0) {
            nodo.derecha = insertar(nodo.derecha, nombre, tlf);
        } else {
            System.out.println("El contacto ya existe.");
        }
        return nodo;
    }

    public void buscarContacto(String nombre) {
        Contacto resultado = buscar(raiz, nombre);
        if (resultado != null) {
            System.out.println("Contacto encontrado:");
            System.out.println("Nombre: " + resultado.nombre);
            System.out.println("Teléfono: " + resultado.tlf);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private Contacto buscar(Contacto nodo, String nombre) {
        if (nodo == null || nodo.nombre.equalsIgnoreCase(nombre)) {
            return nodo;
        }
        if (nombre.compareToIgnoreCase(nodo.nombre) < 0) {
            return buscar(nodo.izquierda, nombre);
        } else {
            return buscar(nodo.derecha, nombre);
        }
    }

    public void mostrarContactos() {
        System.out.println("Contactos en orden alfabético:");
        inOrden(raiz);
    }

    private void inOrden(Contacto nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.println("Nombre: " + nodo.nombre + " | Teléfono: " + nodo.tlf);
            inOrden(nodo.derecha);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ AGENDA ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Mostrar todos los contactos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del contacto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono del contacto: ");
                    String tlf = sc.nextLine();
                    agenda.agregarContacto(nombre, tlf);
                    break;
                case 2:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    agenda.buscarContacto(nombreBuscar);
                    break;
                case 3:
                    agenda.mostrarContactos();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}