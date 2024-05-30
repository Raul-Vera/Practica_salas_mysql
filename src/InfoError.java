public class InfoError {
    public static final int OK=0;
    public static final int FALLO_DRIVER=1;
    public static final int FALLO_CONEXION=2;
    public static final int FALLO_CERRAR_CONEXION=3;
    public static final int ERRPR_RECOGER_DATOS=4;
    public static final int DUPLICADO_COD_DEP=5;
    public static final int DUPLICADO_COD_SAL=7;
    public static final int DUPLICADO_NOMBRE=6;
    public static final int DUPLICADO_NOMBRE_sala=7;
    private static final String []MENSAJE={
            "Accion llevada a cabo con exito",
            "No se ha introducido el driver correctamente",
            "Error al conectar con la base de datos",
            "Error al cerrar conexion",
            "Error al recoger los datos",
            "Has introducido un cod_dep que ya existe",
            "HAs intoducido un nombre de dep que ya existe",
            "HAs intoducido un cod_sala que ya existe",
            "HAs intoducido un nombre de sala que ya existe",
    };
    public static String getMensaje(int codigo){
        return MENSAJE[codigo];
    }
}