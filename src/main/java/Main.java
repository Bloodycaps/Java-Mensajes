import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----------------------");
            System.out.println("Aplicacion Mensajes");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Eliminar Mensaje");
            System.out.println("4. Editar Mensaje");
            System.out.println("5. Salir");
            //eleccion del usuario
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensaje();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }

        }while (opcion != 5);
    }
}
