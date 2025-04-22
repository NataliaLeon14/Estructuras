//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Arrays;

class BusquedaEstudiantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[100];

        String[] nombresEstudiantes = {
                "Ana", "Luis", "Carlos", "María", "Juan", "Laura", "José", "Diana", "Pedro", "Camila",
                "Andrés", "Valentina", "Miguel", "Daniela", "Ricardo", "Sara", "Julián", "Fernanda", "Mateo", "Isabella"
        };

        // Llenar datos los 100 estudiantes
        for (int i = 0; i < estudiantes.length; i++) {
            String id = "IdEstudiante" + (i + 1);
            String nombre = nombresEstudiantes[i % nombresEstudiantes.length];
            float promedio = (float) (3.0 + Math.random() * 2.0); // 3.0 a 5.0
            estudiantes[i] = new Estudiante(id, nombre, promedio);
        }

        Arrays.sort(estudiantes); // Ordenar por promedio


        System.out.println("Lista de los 100 estudiantes ordenados por promedio:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }

        // Búsqueda binaria iterativa
        System.out.print("\nIngrese el promedio a buscar (ej: 4.0): ");
        String entrada = scanner.next();
        float notaBuscar = Float.parseFloat(entrada);

        int resultadoIterativo = busquedaBinariaIterativa(estudiantes, notaBuscar);
        if (resultadoIterativo != -1)
            System.out.println("Encontrado (iterativo): " + estudiantes[resultadoIterativo]);
        else
            System.out.println("No se encontró estudiante con ese promedio");

        // Búsqueda binaria recursiva
        int resultado = busquedaBinariaRecursiva(estudiantes, notaBuscar, 0, estudiantes.length - 1);
        if (resultado != -1)
            System.out.println("Encontrado (recursivo): " + estudiantes[resultado]);
        else
            System.out.println("No se encontró estudiante con ese promedio");

        // Contar estudiantes con promedio mayor a uno ingresado
        System.out.print("\nIngrese un promedio para contar cuántos lo superan (ej: 4.5): ");
        String entrada2 = scanner.next();
        float notaLimite = Float.parseFloat(entrada2.replace(",", "."));

        int contador = contarMayoresA(estudiantes, notaLimite);
        System.out.println("Cantidad de estudiantes con promedio mayor a " + notaLimite + ": " + contador);

        scanner.close();
    }

    public static int busquedaBinariaIterativa(Estudiante[] arr, float objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            float promedio = arr[medio].getPromedioAcum();

            if (promedio == objetivo) return medio;
            if (promedio < objetivo) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        return -1;
    }

    public static int busquedaBinariaRecursiva(Estudiante[] arr, float objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) return -1;

        int medio = izquierda + (derecha - izquierda) / 2;
        float promedio = arr[medio].getPromedioAcum();

        if (promedio == objetivo) return medio;
        if (promedio > objetivo)
            return busquedaBinariaRecursiva(arr, objetivo, izquierda, medio - 1);
        else
            return busquedaBinariaRecursiva(arr, objetivo, medio + 1, derecha);
    }

    public static int contarMayoresA(Estudiante[] arr, float nota) {
        int contador = 0;
        for (Estudiante e : arr) {
            if (e.getPromedioAcum() > nota) {
                contador++;
            }
        }
        return contador;
    }
}