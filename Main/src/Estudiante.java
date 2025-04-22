
public class Estudiante implements Comparable<Estudiante> {
    private String idEstudiante;
    private String nombre;
    private float promedioAcum;

    public Estudiante(String idEstudiante, String nombre, float promedioAcum) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.promedioAcum = promedioAcum;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPromedioAcum() {
        return promedioAcum;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Float.compare(this.promedioAcum, otro.promedioAcum);
    }

    @Override
    public String toString() {
        return "ID: " + idEstudiante + ", Nombre: " + nombre + ", Promedio: " + String.format("%.2f", promedioAcum);
    }
}
