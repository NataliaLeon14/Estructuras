public class Grafo {

    private int numVertices;
    private Nodo[] nodos;
    private int [][] matrizAdyacencia;
    private int contadorVertices;

    public Grafo(int numVertices) {
        this.numVertices =numVertices;
        nodos = new Nodo[numVertices];
        matrizAdyacencia = new int [numVertices][numVertices];
        contadorVertices = 0;
    }

    public void agregarNodo(char letra, String estacion){
        if (contadorVertices < numVertices) {
            nodos [contadorVertices ++] = new Nodo(letra, estacion);
        }
        else {
            System.out.println("No se pueden agregar mas estaciones.");
        }
    }
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
            matrizAdyacencia[destino][origen] = 1;
        } else {
            System.out.println("Índices inválidos para la arista.");
        }
    }
    public void mostrarEstaciones() {
        System.out.println("Estaciones:");
        for (int i = 0; i < contadorVertices; i++) {
            System.out.println(i + ": " + nodos[i]);
        }
    }

    public void mostrarMatrizAdyacencia() {
        System.out.print("    ");
        for (int i = 0; i < contadorVertices; i++) {
            System.out.print(nodos[i].getLetra() + " ");
        }
        System.out.println();
        for (int i = 0; i < contadorVertices; i++) {
            System.out.print(nodos[i].getLetra() + " | ");
            for (int j = 0; j < contadorVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void verificarConexion(int origen, int destino) {
        if (matrizAdyacencia[origen][destino] == 1) {
            System.out.println("Las estaciones " + nodos[origen].getLetra() + " y " + nodos[destino].getLetra() + " son vecinos directos.");
        } else {
            boolean[] visitado = new boolean[numVertices];
            if (hayCaminoDFS(origen, destino, visitado)) {
                System.out.println("Las estaciones " + nodos[origen].getLetra() + " y " + nodos[destino].getLetra() + " NO son vecinos directos, pero hay un camino intermedio.");
            } else {
                System.out.println("No hay conexión entre las estaciones " + nodos[origen].getLetra() + " y " + nodos[destino].getLetra() + ".");
            }
        }
    }

    private boolean hayCaminoDFS(int actual, int destino, boolean[] visitado) {
        visitado[actual] = true;
        if (actual == destino) return true;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                if (hayCaminoDFS(i, destino, visitado)) return true;
            }
        }
        return false;
    }
}


