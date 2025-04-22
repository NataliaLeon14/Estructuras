//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();

        miAgenda.agregarContacto("Johan", "3187272400");
        miAgenda.agregarContacto("Ana", "3117483063");
        miAgenda.agregarContacto("Natalia", "3201234567");

        miAgenda.mostrarContactos();

        System.out.println("¿Existe Ana? " + miAgenda.buscarContacto("Ana"));
        System.out.println("¿Existe Marta? " + miAgenda.buscarContacto("Marta"));
    }
}