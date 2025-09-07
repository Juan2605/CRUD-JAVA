import java.util.Scanner;

public class CRUD {

    static final int tamaño = 2;
    static String nombre[] = new String[tamaño];
    static float salario[] = new float[tamaño];
    static char sexo[] = new char[tamaño];
    static String cargo[] = new String[tamaño];
    static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do{
            System.out.println("Bienvenido a nuestra Base de datos. Qué le gustaría hacer?\r\n"+
                                "\r\n"+
                                " __________________________________________\r\n"+
                                "|                                          |\r\n"+
                                "|               BASE DE DATOS              |\r\n"+
                                "|__________________________________________|\r\n"+
                                "|                                          |\r\n"+
                                "|          1. Crear un usario              |\r\n"+
                                "|          2. Leer un usuario              |\r\n"+
                                "|          3. Editar un usario             |\r\n"+
                                "|          4. Borrar un usario             |\r\n"+
                                "|          5. Terminar                     |\r\n"+
                                "|__________________________________________|\r\n"+
                                "\r\n"+
                                "Escoge una opción: ");
            opcion = Integer.parseInt(datos.nextLine());
            switch (opcion) {
                case 1:
                    crearUsuarios();
                    break;
                case 2:
                    leerUsuarios();
                    break;
                case 3:
                    editarUsuarios();
                default:
                    System.out.println("Opción inválida");
                    return;
            }
        }while (opcion != 5);
            System.out.println("Gracias por utilizar nuestra base de datos");            
    }    

    public static void crearUsuarios(){
        System.out.println("--- CREAR USUARIOS ---");
        for (int i = 0; i < tamaño; i++) {
            System.out.println("--- Usuario " + (i + 1) + " (ID: " + i + ") ---");
            
            System.out.print("Ingrese el nombre: ");
            nombre[i] = datos.nextLine();

            System.out.print("Ingrese el salario: ");
            salario[i] = datos.nextFloat(); 
            datos.nextLine();

            System.out.print("Ingrese el sexo (M/F): ");
            sexo[i] = datos.nextLine().charAt(0);

            System.out.print("Ingrese el cargo: ");
            cargo[i] = datos.nextLine();
        }
    return;
    }

    public static void leerUsuarios(){
        System.out.println("--- LISTA DE USUARIOS ---");
        for (int i = 0; i < tamaño; i++) {
            System.out.println("\n--- ID: " + i + " ---");
            System.out.println("Nombre: " + nombre[i]);
            System.out.println("Salario: " + salario[i]);
            System.out.println("Sexo: " + sexo[i]);
            System.out.println("Cargo: " + cargo[i]);
        }
    }

    public static void editarUsuarios(){
        int opcion;

        System.out.println("--- EDITAR USUARIOS ---");
        System.out.println("Ingrese el usuario a editar: ");
        opcion = datos.nextInt();
    }
}


