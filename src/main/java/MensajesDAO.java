import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion db_connected = new Conexion();

        try (Connection conecxion = db_connected.getConnetion()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO  mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conecxion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");

            } catch (SQLException ex) {
                System.out.println(ex);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void leerMensajeDB() {
        Conexion db_connected = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection connection = db_connected.getConnetion()) {
            String query = "SELECT * FROM  mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensajes"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor del mensaje: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha del mensajes: " + rs.getString("fecha_mensaje"));
                System.out.println("");

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void borrarMensajesDB(int id_mensaje) {
        Conexion db_connected = new Conexion();
        try (Connection connection = db_connected.getConnetion()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensajes = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se ha podido borrar el mensaje");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {
        Conexion db_connected = new Conexion();
        try (Connection connection = db_connected.getConnetion()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensajes = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Se ha actualizado el mensaje");

            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se ha podido actualizar el mensaje");
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }
}
