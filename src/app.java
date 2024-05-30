import java.util.Scanner;

public class app {
    public static Scanner teclado = new Scanner(System.in);
   public static boolean seguir=true;
     public static boolean admin=true;

    public static void menuAdmin(String eleccion, String menu) {
        System.out.println("1) Añadir departamento");
        System.out.println("2) Listar departamento");
        System.out.println("3) Eliminar departamento");
        System.out.println("4) Añadir Sala");
        System.out.println("5) Listar las salas ");
        System.out.println("6) Eliminar sala ");
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
            }else {
                System.out.println("Añadido con exito");
            }

        }else if (eleccion.equals("2")) {
            DepartamentosDB.listardep();
        }
        else if (eleccion.equals("3")) {
            String cod;
            System.out.println("Introduce el cod del departamento que desea eliminar");
            cod= teclado.nextLine();
            if(DepartamentosDB.eliminarDep(cod)){
                System.out.println("Eliminado con exito");
            }else {
                System.out.println("No se encontro el departamento");
            }
        } else if (eleccion.equals("4")) {
            String cod_sal;
            String nombre;
            System.out.println("Introduce el cod_sala");
            cod_sal = teclado.nextLine();
            System.out.println("Introduce el nombre");
            nombre = teclado.nextLine();
            if(SalasDB.añadirSala(new Sala(nombre,cod_sal))){
                System.out.println("Añadida con exito");
            }else {
                System.out.println(InfoError.getMensaje(SalasDB.error));
            }
        }else if(eleccion.equals("5")){
            SalasDB.listarSal();
        } else if (eleccion.equals("6")) {
            String cod;
            System.out.println("Introduce el cod de la sala que desea eliminar");
            cod= teclado.nextLine();
            if(SalasDB.eliminarSal(cod)){
                System.out.println("Eliminada con exito");
            }else {
                System.out.println("No se encontro la sala");
            }
        }

    }

    public static void main(String[] args) {
        AdminConexion.obtenerConexion();
        String con;
        String eleccion_meu;
        String eleccion = "0";
        System.out.println("BUENAS");
        while (seguir){
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
