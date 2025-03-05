/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concesionarioa;

import java.util.Scanner;

/**
 *
 * @author natalia leon
 */
public class ConcesionarioA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TallerMecanico tallerMecanico = new TallerMecanico("Taller Mazda");
        int opcion;
        
        do {
            System.out.println("\n --- Menu de taller mecanico \n");
            System.out.println("1. Agregar vehiculo en el taller: ");
            System.out.println("2. Guardar vehiculo en el taller: ");
            System.out.println("3. Mostrar vehiculos agregados en el taller: ");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion){
                case 1:
                    System.out.println("La placa del vehiculo es: ");
                    String placa = scanner.nextLine();
                    System.out.println("El modelo del vehiculo es: ");
                    String modelo = scanner.nextLine();
                    scanner.nextLine();
                    Vehiculo vehiculo = new Vehiculo(placa, modelo);
                    tallerMecanico.agregarVehiculo(vehiculo);
                    break;
                case 2:
                    tallerMecanico.guardarVehiculo();
                    break;
                case 3:
                    tallerMecanico.mostrarVehiculo();
                    break;
                case 4:
                    System.out.println("Saliendo del programa ");
                    break;
                default:
                    System.out.println("Opcion invalidad, intentalo nuevamente");
                    break;
            }  }
        while (opcion !=4);
        scanner.close();
    }
    
}
