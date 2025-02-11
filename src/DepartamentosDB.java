import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public static void listardep(){
        try {
            Departamento aux=new Departamento("","");
            PreparedStatement ps=AdminConexion.con.prepareStatement("SELECT cod_dep,nombre from departamentos");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                aux.setCod_dep(rs.getString("cod_dep"));
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
    public static boolean eliminarDep(String cod){
        try {
            PreparedStatement ps=AdminConexion.con.prepareStatement("delete from departamentos where cod_dep=?");
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
