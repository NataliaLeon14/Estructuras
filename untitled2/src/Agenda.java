public class Agenda {
    private Contacto raiz;

    public Agenda() {
        raiz = null;
    }

    public void agregarContacto(String nombre, String telefono) {
        raiz = insertar(raiz, nombre, telefono);
    }

    private Contacto insertar(Contacto actual, String nombre, String tlf) {
        if (actual == null) return new Contacto(nombre, tlf);

        if (nombre.compareToIgnoreCase(actual.nombre) < 0) {
            actual.left = insertar(actual.left, nombre, tlf);
        } else if (nombre.compareToIgnoreCase(actual.nombre) > 0) {
            actual.right = insertar(actual.right, nombre, tlf);
        } else {
            System.out.println("El contacto ya existe.");
        }
        return actual;
    }

    public boolean buscarContacto(String nombre) {
        return buscar(raiz, nombre) != null;
    }

    private Contacto buscar(Contacto actual, String nombre) {
        if (actual == null || actual.nombre.equalsIgnoreCase(nombre)) return actual;

        if (nombre.compareToIgnoreCase(actual.nombre) < 0)
            return buscar(actual.left, nombre);
        else
            return buscar(actual.right, nombre);
    }

    public void mostrarContactos() {
        System.out.println("Contactos registrados:");
        mostrarInOrden(raiz);
    }

    private void mostrarInOrden(Contacto actual) {
        if (actual != null) {
            mostrarInOrden(actual.left);
            System.out.println("Nombre: " + actual.nombre + ", Teléfono: " + actual.telefono);
            mostrarInOrden(actual.right);
        }
    }
}
