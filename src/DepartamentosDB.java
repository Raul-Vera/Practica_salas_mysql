import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartamentosDB  {
    protected static int error;
    public static boolean añadirDep(Departamento dep) {
        try {
            String sql = "insert into Departamentos (cod_dep,nombre) values (?,?)";
            PreparedStatement ps = AdminConexion.con.prepareStatement(sql);
            ps.setString(1,dep.getCod_dep());
            ps.setString(2,dep.getNombre());
            ps.executeUpdate();
            error=InfoError.OK;
            return true;
        }catch (SQLException sqle){
            if(sqle.getMessage().contains("PRIMARY")){
                error=5;
            } else if (sqle.getMessage().contains("uk1")) {
                error=InfoError.DUPLICADO_NOMBRE;
            } else {
                error = InfoError.ERRPR_RECOGER_DATOS;
            }
            return false;
        }
    }
}
