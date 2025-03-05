/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionarioa;

import java.io.Serializable;

/**
 *
 * @author natalia leon
 */
public class Vehiculo implements Serializable{
    private String placa;
    private String modelo;
    
    public Vehiculo(String placaP, String modeloP){
        this.placa = placaP;
        this.modelo = modeloP;
    }
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placaP){
        this.placa = placaP;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modeloP){
        this.modelo = modeloP;
    }
    @Override
    public String toString(){
        return "La placa es: " + placa + "El modelo es: " + modelo;
    }
}
