import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalasDB {
    protected static int error;
    public static boolean añadirSala(Sala sala){
        try {
            String sql = "insert into Salas (cod_sala,nombre) values (?,?)";
            PreparedStatement ps = AdminConexion.con.prepareStatement(sql);
            ps.setString(1,sala.getCod());
            ps.setString(2,sala.getNombre());
            ps.executeUpdate();
            error=InfoError.OK;
            return true;
        }catch (SQLException sqle){
            if(sqle.getMessage().contains("PRIMARY")){
                error=InfoError.DUPLICADO_COD_SAL;
            } else if (sqle.getMessage().contains("uk1")) {
                error=InfoError.DUPLICADO_NOMBRE_sala;
            } else {
                error = InfoError.ERRPR_RECOGER_DATOS;
            }
            return false;
        }
    }
    public static void listarSal(){
        try {
            Sala aux=new Sala("","");
            PreparedStatement ps=AdminConexion.con.prepareStatement("SELECT cod_sala,nombre from salas");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                aux.setCod(rs.getString("cod_sala"));
                aux.setNombre(rs.getString("nombre"));
                System.out.println(aux);
            }
            ps.close();
            rs.close();
        }catch (SQLException sqle){
            error=InfoError.ERRPR_RECOGER_DATOS;
            InfoError.getMensaje(error);
        }
    }
    public static boolean eliminarSal(String cod){
        try {
            PreparedStatement ps=AdminConexion.con.prepareStatement("delete from salas where cod_sala=?");
            ps.setString(1,cod);
            if(ps.executeUpdate()==1){
                error=InfoError.OK;
                return true;
            }else {
                error=InfoError.ERRPR_RECOGER_DATOS;
                return false;
            }


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }

}
