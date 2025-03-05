/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionarioa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natalia leon
 */
public class TallerMecanico {
    private String nombreTaller;
    private List<Vehiculo> vehiculos;
    private static final String ARCHIVO_VEHICULO="vehiculo.dat";
    
    public TallerMecanico(String nombreTallerP){
        this.nombreTaller = nombreTallerP;
        this.vehiculos = new ArrayList<>();
        cargarVehiculo();
    }
    public void guardarVehiculo(){
        try(ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(ARCHIVO_VEHICULO))){
            oos.writeObject(vehiculos);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void cargarVehiculo(){
        try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream(ARCHIVO_VEHICULO))){
            vehiculos = (List<Vehiculo>) ois.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("No se encontro el archivo de vehiculos");
        }
        catch (IOException| ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void agregarVehiculo(Vehiculo miVehiculo){
        vehiculos.add(miVehiculo);
        guardarVehiculo();
        System.out.println("Vehiculo agregado exitosamente ");
    }
    public void mostrarVehiculo(){
        System.out.println("Vehiculos agregados al taller mecanico " + nombreTaller);
        if(vehiculos.isEmpty()){
            System.out.println("No hay vehiculos en el taller mecanico " + nombreTaller);
        }
        else {
            for(Vehiculo vehiculo: vehiculos){
                System.out.println(vehiculo);
            }
        }
    }
}
