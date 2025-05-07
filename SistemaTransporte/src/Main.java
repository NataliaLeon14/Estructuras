//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        grafo.agregarNodo('A', "Parada A");
        grafo.agregarNodo('B', "Parada B");
        grafo.agregarNodo('C', "Parada C");
        grafo.agregarNodo('D', "Parada D");
        grafo.agregarNodo('E', "Parada E");

        grafo.agregarArista(0, 1); // A-B
        grafo.agregarArista(0, 2); // A-C
        grafo.agregarArista(1, 3); // B-D
        grafo.agregarArista(2, 3); // C-D
        grafo.agregarArista(3, 4); // D-E

        grafo.mostrarEstaciones();
        System.out.println("\nMatriz de Adyacencia:");
        grafo.mostrarMatrizAdyacencia();

        System.out.println("\nVerificación de conexiones:");
        grafo.verificarConexion(0, 1); // A-B
        grafo.verificarConexion(0, 4); // A-E
        grafo.verificarConexion(1, 2); // B-C
    }
}