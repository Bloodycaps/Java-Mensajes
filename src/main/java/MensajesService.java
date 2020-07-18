import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribir Mensaje");
        String mensaje = scanner.nextLine();

        System.out.println("Autor mensaje");
        String autor_Mensaje = scanner.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(autor_Mensaje);
        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensaje(){
        MensajesDAO.leerMensajeDB();
    }
    public static void borrarMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el ID del mensaje a borrar: ");
         int mensaje_a_borrar = scanner.nextInt();
         MensajesDAO.borrarMensajesDB(mensaje_a_borrar);

    }
    public static void editarMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nuevo mensaje: ");
        String nuevo_Mensaje = scanner.nextLine();

        System.out.println("Ingrese el ID del mensaje a editar: ");
        int id_Mensaje = scanner.nextInt();

        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_Mensaje);
        actualizacion.setMensaje(nuevo_Mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }
}
