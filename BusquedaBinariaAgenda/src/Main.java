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
class AgendaTelefonica {
    private Contacto raiz;

    public void agregar(String nombre, String tlf) {
        raiz = agregarRec(raiz, nombre, tlf);
    }
    private Contacto agregarRec(Contacto nodo, String nombre, String tlf) {
        if (nodo == null) return new Contacto(nombre, tlf);

        if (nombre.compareToIgnoreCase(nodo.nombre) < 0)
            nodo.izquierda = agregarRec(nodo.izquierda, nombre, tlf);
        else if (nombre.compareToIgnoreCase(nodo.nombre) > 0)
            nodo.derecha = agregarRec(nodo.derecha, nombre, tlf);
        else
            System.out.println("Ese contacto ya existe.");
        return nodo;
    }

    public void buscar(String nombre) {
        Contacto resultado = buscarRec(raiz, nombre);
        if (resultado != null)
            System.out.println("Teléfono de " + resultado.nombre + ": " + resultado.tlf);
        else
            System.out.println("Contacto no encontrado.");
    }

    private Contacto buscarRec(Contacto nodo, String nombre) {
        if (nodo == null || nombre.equalsIgnoreCase(nodo.nombre)) return nodo;
        return (nombre.compareToIgnoreCase(nodo.nombre) < 0)
                ? buscarRec(nodo.izquierda, nombre)
                : buscarRec(nodo.derecha, nombre);
    }

    public void mostrarInOrden() {
        System.out.println("\nContactos (Inorden):");
        inOrden(raiz);
    }

    public void mostrarPreOrden() {
        System.out.println("\nContactos (Preorden):");
        preOrden(raiz);
    }

    public void mostrarPostOrden() {
        System.out.println("\nContactos (Postorden):");
        postOrden(raiz);
    }

    private void inOrden(Contacto nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.println("Nombre: " + nodo.nombre + " | Teléfono: " + nodo.tlf);
            inOrden(nodo.derecha);
        }
    }

    private void preOrden(Contacto nodo) {
        if (nodo != null) {
            System.out.println("Nombre: " + nodo.nombre + " | Teléfono: " + nodo.tlf);
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }

    private void postOrden(Contacto nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            System.out.println("Nombre: " + nodo.nombre + " | Teléfono: " + nodo.tlf);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Agenda Telefónica ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Mostrar contactos (Inorden)");
            System.out.println("4. Mostrar contactos (Preorden)");
            System.out.println("5. Mostrar contactos (Postorden)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    agenda.agregar(nombre, telefono);
                    break;
                case 2:
                    System.out.print("Nombre a buscar: ");
                    String buscar = scanner.nextLine();
                    agenda.buscar(buscar);
                    break;
                case 3:
                    agenda.mostrarInOrden();
                    break;
                case 4:
                    agenda.mostrarPreOrden();
                    break;
                case 5:
                    agenda.mostrarPostOrden();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}