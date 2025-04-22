public class Contacto {
    String nombre;
    String telefono;
    Contacto left, right;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.left = null;
        this.right = null;
    }
}
