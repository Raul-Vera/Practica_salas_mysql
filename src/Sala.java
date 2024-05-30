public class Sala {
    private String nombre;
    private String cod;

    public Sala(String nombre,String cod){
        this.cod=cod;
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "COD_SALA: "+cod+" Nombre: "+nombre;
    }
}
