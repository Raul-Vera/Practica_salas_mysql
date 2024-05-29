import java.util.Scanner;

public class app {
    public static Scanner teclado = new Scanner(System.in);
   public static boolean seguir=true;
     public static boolean admin=true;

    public static void menuAdmin(String eleccion, String menu) {
        System.out.println("1) Añadir departamento");
        System.out.println("1) Listar departamento");
        System.out.println("1) Añadir departamento");
        eleccion=teclado.nextLine();
        if (eleccion.equals("1")) {
            String cod_dep;
            String nombre;
            System.out.println("Introduce el cod_dep");
            cod_dep = teclado.nextLine();
            System.out.println("Introduce el nombre");
            nombre = teclado.nextLine();
            if (!DepartamentosDB.añadirDep(new Departamento(nombre, cod_dep))) {
                System.out.println(InfoError.getMensaje(DepartamentosDB.error));
            }

        } else if (eleccion.equals("3")) {
            admin=false;
        }
    }

    public static void main(String[] args) {
        AdminConexion.obtenerConexion();
        String con;
        String eleccion_meu;
        String eleccion = "0";

        while (seguir){
        System.out.println("BUENAS");
        System.out.println("1) Login de Administrador");
        System.out.println("2) Login de Departamento");
        eleccion_meu = teclado.nextLine();
        if (eleccion_meu.equals("1")) {
                System.out.println("Introduce la contraseña");
                con = teclado.nextLine();
                while (con.equals("12345") && admin) {
                        menuAdmin(eleccion, eleccion_meu);
                    }

                }

            }
        }
    }
