public class Departamento {
    private String cod_dep;
    private String nombre;
    public Departamento(String nombre,String cod_dep){
        this.cod_dep=cod_dep;
        this.nombre=nombre;
    }

    public String getCod_dep() {
        return cod_dep;
    }

    public void setCod_dep(String cod_dep) {
        this.cod_dep = cod_dep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
