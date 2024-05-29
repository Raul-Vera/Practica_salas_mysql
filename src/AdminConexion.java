import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminConexion {
        protected static Connection con;
        protected static String error;

        public static int obtenerConexion(
        ){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reserva_de_Salas", "Admin", "12345");
                return InfoError.OK;
            }catch (SQLException sqle){
                sqle.printStackTrace();
                return InfoError.FALLO_CONEXION;
            }catch (ClassNotFoundException cnfe){
                return InfoError.FALLO_DRIVER;
            }
        }

        public Connection getCon() {
            return con;
        }
        public static int cerrarConexion(){
            try {
                con.close();
            }catch (SQLException sqle){
                return InfoError.FALLO_CERRAR_CONEXION;
            }
            return InfoError.OK;
        }
    }
