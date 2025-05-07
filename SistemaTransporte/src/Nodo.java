public class Nodo {
    private char letra;
    private String estacion;

    public Nodo(char letra, String estacion){
        this.letra = letra;
        this.estacion = estacion;
    }

    public char getLetra() {
        return letra;
    }

    public String getEstacion() {
        return estacion;
    }
    @Override
    public String toString(){
        return letra + " - " + estacion;
    }
}
