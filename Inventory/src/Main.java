//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.LinkedList;
import java.util.Queue;


class Inventory {
    //EJERCICIO PREPARACIÓN DEL PARCIAL:
//1. usar la clase Producto de la primera tarea para agregar Producto y no string a lacola
//2. No permitir hacer poll de un objeto si tiene cantidad -- 0
    public static void main(String[] args) {
        Queue<String> inventario = new LinkedList<String>();

        inventario.add("Nuevo producto 1");
        inventario.add("Nuevo producto 2");
        inventario.add("Nuevo producto 3");

        System.out.println("Inventario actual:" + inventario);

        /* Se vende un producto y sale un producto del inventario: *A
        /* con el poll de despacha o se elimina de la cola */


        System.out.println("Producto vendido: " + inventario.poll());
        System.out.println("se vendio otro producto: " + inventario.poll());

        inventario.add("Nuevo producto 4");

        System.out.println("Inventario final:" + inventario);

    }
}