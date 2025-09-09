import java.util.Scanner;

public class CRUD {

    static final int tamañoArreglos = 3; //Se crea una variable global para que la persona que cree la base de datoso solo tenga que editar esta variable para la capacidad de la base de datos
    //Se crean cuatro arreglos tipo texto, tipo decimal, tipo caracter. Donde se van a guardar los nombres,salarios, sexos y cargos de las personas de las bases de datos estos arreglos son de tamaño que la persona digite en la variable 
    static String nombres[] = new String[tamañoArreglos]; 
    static float salarios[] = new float[tamañoArreglos];
    static char sexos[] = new char[tamañoArreglos];
    static String cargos[] = new String[tamañoArreglos];

    //Se crea otro arreglo de tipo entero para guardar un identificador de cada usuario
    static int[] identificador = new int[tamañoArreglos];

    //Se crea un contador global para el control de usuarios registrados
    static int contadorUsuarios = 0;
    //Scanner global para guardar los datos
    static Scanner datos = new Scanner(System.in);

    //clase donde siempre va a estar el menú y donde se podrá escoger las diferentes opciones, a menos que se ingrese la opción terminar.
    public static void main(String[] args) {
        int opcion;
        //Se utiliza un do while en la que cada opción llama a un metodo predeterminado del crud hasta que se de la opción #5  y se termine
        do{
            mostrarMenu();
            opcion = datos.nextInt(); //Se guarda la opción del usuario en la variable opción, previamente creada como entero
            datos.nextLine(); //Esto es para que no se salte espacios cuando el usuario digite una opción
            switch (opcion) {
                case 1:
                    crearUsuarios();
                    break;
                case 2:
                    leerUsuarios();
                    break;
                case 3:
                    editarUsuarios();
                    break;
                case 4:
                    borrarUsuarios();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar nuestra base de datos");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }while (opcion != 5);          
    } 
    //Visualización del menu
    public static void mostrarMenu() {
        System.out.println(     "\r\n"+
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
        
    }
    //Metodo crear Usuarios
    public static void crearUsuarios(){
        //Se utiliza un if para que si la función length donde sabe hasta donde llegar en el arreglo como nombres es el primer ítem que se pide si el contador ya detecta n de usuarios y es el límite imprime que ya no se pueden agregar más usuarios y retorna al menú.
        if (contadorUsuarios >= nombres.length) {
            System.out.println("No se pueden agregar más usuarios. Límite alcanzado.");
            return;
        }
        System.out.println("\n--- CREAR NUEVO USUARIO ---");
        //Se agrega cogiendo el arreglo de identificador para cada usuario, donde va a empezar desde 0, pero va a ser igual a al contadorusuarios + 1 para poder identificar a cada usuario más adelante
        identificador[contadorUsuarios] = contadorUsuarios + 1;
        //Se le solicita cada ítem al usuario y se guarda en su respectivo arreglo pero además se guarda en la asginación de contador de usuario  que es igual a lo que registra el usuario en la consola
        System.out.print("Ingrese el nombre: ");
        nombres[contadorUsuarios] = datos.nextLine().toUpperCase(); // Se utiliza upper case para estandarización de poner todo en mayúscula.
        
        System.out.print("Ingrese el salario: ");
        salarios[contadorUsuarios] = datos.nextFloat();
        datos.nextLine();
    
        System.out.print("Ingrese el sexo (M/F): ");
        sexos[contadorUsuarios] = datos.next().toUpperCase().charAt(0);
        datos.nextLine();
        
        System.out.print("Ingrese el cargo: ");
        cargos[contadorUsuarios] = datos.nextLine();
        //Una vez agregado cada usuario con su ítem se imprime que se guard exitosamente para que el usuario sepa y su id correspondiente 
        System.out.println("\n¡Usuario creado exitosamente!");
        System.out.println("ID asignado: " + contadorUsuarios + 1);
        //Cuando se crea el usuario se incremtenta cada contador
        contadorUsuarios++; 
    }
    //Metodo leer usuarios   
    public static void leerUsuarios(){

        //Se le pide al usuario cual es ID a consultar, este
        System.out.println("\n=== LEER USUARIO ===");
        System.out.print("Ingrese el ID del usuario que desea consultar: ");
        int idBuscado = datos.nextInt(); //Lee el id que el usuario desea y lo guarda en la variable idBuscado de tipo entero
        datos.nextLine();

        int posicion = -1; //Esta variable posicion se inicializa en -1 que significa "no encontrado"
        for (int i = 0; i < contadorUsuarios; i++) { //Recorre todos los usuarios registrados desde la posición 0 que se crea el arreglo hasta contadorUsuarios donde se resta -1
            if (identificador[i] == idBuscado) { //Se utiliza un if para comparar el ID del usuario en posición i con el ID que se desea mostrar
                posicion = i; //Si encuentra una coincidencia guarda la posición de donde se encuentra el usuario
                break;//Sale del for 
            }
        }

        if (posicion == -1) {//Si la posición sigue siendo igual a -1 imprime que no se encuentra el id
            System.out.println("Usuario con ID " + idBuscado + " no encontrado.");
            return;
        } else {//Si no es igual a -1 entonces imprime la información del usuario
            System.out.println("\n--- INFORMACIÓN DEL USUARIO ---");
            //Imprime la ítem correspondiente + los arreglos que pertenece a cada item de acuerdo a la posición
            System.out.println("ID: " + identificador[posicion]);
            System.out.println("Nombre: " + nombres[posicion]);
            System.out.println("Salario: $" + salarios[posicion]);
            System.out.println("Sexo: " + sexos[posicion]);
            System.out.println("Cargo: " + cargos[posicion]);
        }
    }
    //Metodo editar Usuarios
    public static void editarUsuarios(){

        System.out.println("\n=== EDITAR USUARIO ===");
        System.out.print("Ingrese el ID del usuario que desea editar: ");
        int idBuscado = datos.nextInt();//Lee el id que el usuario desea y lo guarda en la variable idBuscado de tipo entero
        datos.nextLine(); 
        
        // Buscar usuario por ID
        int posicion = -1;
        for (int i = 0; i < contadorUsuarios; i++) {
            if (identificador[i] == idBuscado) {
                posicion = i;
                break;
            }
        }
        //Si no se encuentra el id pues imprime que usuario no encontrado y vuelve al menu
        if (posicion == -1) {
            System.out.println("Usuario con ID " + idBuscado + " no encontrado.");
            return;
        }
        
        // Muestra la información para saber que editar
        System.out.println("\nInformación actual del usuario:");
        System.out.println("1. Nombre: " + nombres[posicion]);
        System.out.println("2. Salario: $" + salarios[posicion]);
        System.out.println("3. Sexo: " + sexos[posicion]);
        System.out.println("4. Cargo: " + cargos[posicion]);
        
        System.out.print("\n¿Qué campo desea editar? (1-4): ");
        int campoEditar = datos.nextInt(); //Se crea una variable para guardar que campo es el que se desea editar
        // Se utiliza un switch para elegir el campo y que se pueda editar donde de acuerdo a la posición lo vuelve a capturar en el scanner y se imprime que se guardo exitosamente
        switch (campoEditar) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                nombres[posicion] = datos.nextLine();
                datos.nextLine();
                System.out.println("Nombre actualizado correctamente.");
                break;
            case 2:
                System.out.print("Ingrese el nuevo salario: ");
                salarios[posicion] = datos.nextFloat();
                datos.nextLine(); // Limpiar buffer
                System.out.println("Salario actualizado correctamente.");
                break;
            case 3:
                System.out.print("Ingrese el nuevo sexo (M/F): ");
                sexos[posicion] = datos.nextLine().toUpperCase().charAt(0);
                datos.nextLine();
                System.out.println("Sexo actualizado correctamente.");
                break;
            case 4:
                System.out.print("Ingrese el nuevo cargo: ");
                cargos[posicion] = datos.nextLine();
                datos.nextLine();
                System.out.println("Cargo actualizado correctamente.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
    //Metodo borrar usuarios
    public static void borrarUsuarios(){
        System.out.println("\n=== BORRAR USUARIO ===");
        System.out.print("Ingrese el ID del usuario que desea borrar: ");
        int idBuscado = datos.nextInt();
        datos.nextLine();
        
        // Buscar el usuario por ID
        int posicion = -1;
        for (int i = 0; i < contadorUsuarios; i++) {
            if (identificador[i] == idBuscado) {
                posicion = i;
                break;
            }
        }
        //Si no encuentra el ID entonces:
        if (posicion == -1) {
            System.out.println("Usuario con ID " + idBuscado + " no encontrado.");
        } else {
            // Mostrar información del usuario a borrar
            System.out.println("\nUsuario a borrar:");
            System.out.println("ID: " + identificador[posicion]);
            System.out.println("Nombre: " + nombres[posicion]);
            //Se le pregunta 
            System.out.print("¿Está seguro de que desea borrar este usuario? (S/N): ");
            String confirmacion = datos.nextLine().toUpperCase(); //Se crea una variable tipo texto para confirmar si el usuario desea borrar el usuario y se pone en mayúscula para poder compararla 
            
            if (confirmacion.equals("S")) { //Si la variable confirmación es igual al caracter S que lo hace con la funcion equals que lo que hace es que compara entonces:
                // Se crea un for para poder correr la posición del usuario, que va desde la variable posición del usuario que se quiere eliminar hasta el ultimo usuario guardado en el contador de usuarios y y se imcrementa para pasarlo a una nueva posición
                for (int i = posicion; i < contadorUsuarios - 1; i++) {
                    //lo que hace es que de acuerdo al arreglo y a la posición en que se busco va a ser igual al usuario que esta despues del que se elimino
                    identificador[i] = identificador[i + 1];
                    nombres[i] = nombres[i + 1];
                    salarios[i] = salarios[i + 1];
                    sexos[i] = sexos[i + 1];
                    cargos[i] = cargos[i + 1];
                }
                //se reduci el contador global para organizar los usuarios
                contadorUsuarios--;

                 // Limpiar la última posición que ya no se usa con un if donde verifica que si el contador de usuarios es mayor o igual a 0 entonces:
                 if (contadorUsuarios >= 0) {
                    //pone los arreglos de la ultima posición y se coloca un valor definido
                    identificador[contadorUsuarios] = 0;
                    nombres[contadorUsuarios] = "";
                    salarios[contadorUsuarios] = 0.0f;
                    sexos[contadorUsuarios] = '\0';
                    cargos[contadorUsuarios] = "";
                }
                
                // Se reorganizan los IDS con un for que va desde el identificador de usuarios y le suma uno para que se pueda identificar no como 0 sino como 1 para que sean secuenciales (1, 2, 3, etc.)
                for (int i = 0; i < contadorUsuarios; i++) {
                    identificador[i] = i + 1;
                }
                //Se imprime que se borro exitosamente el usuario
                System.out.println("Usuario borrado correctamente.");
            } else {
                //si por el contrario se selecciona que no se desea borrar el usuario entonces imprime un mensaje y retorna al menu
                System.out.println("Operación cancelada.");
                return;
            }
        }  
    }
}


