//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Stack;

class PilasyColas {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Stack<String> pilaTexto = new Stack<>();
        String textoActual = "";
        int opcion;

        while (true) {
            System.out.println("\nTexto actual en el editor: " + textoActual);
            System.out.println("Seleccione una opción: \n1) Ingresar texto\n2) Deshacer\n3) Salir\n4) Mostrar texto actual\n5) Mostrar historial de cambios");
            opcion = lector.nextInt();
            lector.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Escribe tu texto:");
                    String nuevoTexto = lector.nextLine();

                    pilaTexto.push(textoActual); // Guardar el estado actual antes del cambio
                    textoActual += nuevoTexto; // Concatenar el nuevo texto
                    break;

                case 2:
                    if (!pilaTexto.isEmpty()) {
                        textoActual = pilaTexto.pop(); // Restaurar el estado anterior
                    } else {
                        System.out.println("No hay acciones para deshacer.");
                    }
                    break;

                case 3:
                    System.out.println("Cerrando...");
                    lector.close();
                    return; // Salir del programa (el break después de esto no es necesario)

                case 4:
                    System.out.println("Texto actual en el editor: " + textoActual);
                    break;

                case 5:
                    if (pilaTexto.isEmpty()) {
                        System.out.println("No hay historial de cambios.");
                    } else {
                        System.out.println("Historial de cambios (de más antiguo a reciente):");
                        Stack<String> pilaAuxiliar = new Stack<>();

                        // Pasamos los elementos de pilaTexto a pilaAuxiliar para invertir el orden
                        while (!pilaTexto.isEmpty()) {
                            pilaAuxiliar.push(pilaTexto.pop());
                        }

                        // Imprimimos en orden correcto y devolvemos los elementos a pilaTexto
                        while (!pilaAuxiliar.isEmpty()) {
                            String estado = pilaAuxiliar.pop();
                            System.out.println(estado);
                            pilaTexto.push(estado); // Restaurar la pila original
                        }
                    }
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
}