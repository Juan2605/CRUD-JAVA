import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombre = "";
        float salario = 0;
        char sexo = 0;
        String cargo = "";
        // char x = menu();
        boolean ACTIVO = true;
        Scanner datos = new Scanner(System.in);
        
        
        while(ACTIVO){
            char opcion = menu();
            switch (opcion) {
                case '1':
                    System.out.println("Ingresa el nombre del nuevo usuario: \r\n");
                    nombre = datos.nextLine();
                    
                    System.out.println("Ingresa el salario del nuevo usuario: \r\n");
                    salario = datos.nextFloat();
                    datos.nextLine();
                    
                    System.out.println("Ingresa el sexo del nuevo usuario M/F: \r\n");
                    String lineaDatos = datos.nextLine();
                    sexo = lineaDatos.charAt(0);
                    
                    System.out.println("Ingresa el cargo del nuevo usuario: \r\n");
                    cargo = datos.nextLine();
                    break;
                case '2':
                    System.out.println("NOMBRE: " + nombre);
                    
                    System.out.println("SALARIO: " + salario);
                    
                    System.out.println("SEXO: " + sexo);
                    
                    System.out.println("CARGO: " + cargo);
                    break;
                case '3':
                    System.out.println(" _______________________________");
                    System.out.println("|                               |");
                    System.out.println("| BIENVENIDO A LA BASE DE DATOS |");
                    System.out.println("|             EDITAR            |" );
                    System.out.println("|_______________________________|");
                    System.out.println("|                               |");
                    System.out.println("|           1. NOMBRE           |");
                    System.out.println("|           2. SALARIO          |");
                    System.out.println("|           3. SEXO             |");
                    System.out.println("|           4. CARGO            |");
                    System.out.println("|           5. CANCELAR         |");
                    System.out.println("|_______________________________|");
                    System.out.println("\r\n Escoge tu opcion:");
                    
                    String entrada = datos.nextLine();
                    opcion = entrada.charAt(0);
                    
                    switch(opcion){
                        case '1':
                            System.out.println("Nombre registrado: " + nombre);
                            System.out.println("Ingrese el nuevo nombre");
                            nombre = datos.nextLine();
                            System.out.println("Nombre editado");
                            break;
                        case '2':
                            System.out.println("Salario registrado: " + salario);
                            System.out.println("Ingrese el nuevo salario");
                            salario = datos.nextFloat();
                            datos.nextLine();
                            System.out.println("Salario editado");
                            break;
                    }
                    if (opcion == '3') {
                        System.out.println("Nombre registrado: " + sexo);
                        System.out.println("Ingrese el nuevo sexo");
                        String lineaEditar = datos.nextLine();
                        sexo = lineaEditar.charAt(0);
                        System.out.println("Sexo editado");
                    }
                    if (opcion == '4') {
                        System.out.println("Cargo registrado: " + cargo);
                        System.out.println("Ingrese el nuevo cargo");
                        cargo = datos.nextLine();
                        System.out.println("Cargo editado");
                    }
                    break;
                case '4':
                    nombre = "";
                    salario = 0;
                    sexo = 0;
                    cargo = "";
                    System.out.println("Usuario borrado");
                    break;
                case '5':
                    ACTIVO = false;
                    break;
                default:
                    System.out.println("La opcion no es valida");           
            }
        }
    }
    
    public static char menu(){
        char opcion;
        Scanner input = new Scanner(System.in);
        System.out.println(" _______________________________");
        System.out.println("|                               |");
        System.out.println("| BIENVENIDO A LA BASE DE DATOS |");
        System.out.println("|_______________________________|");
        System.out.println("|                               |");
        System.out.println("|           1. CREAR            |");
        System.out.println("|           2. LEER             |");
        System.out.println("|           3. EDITAR           |");
        System.out.println("|           4. ELIMINAR         |");
        System.out.println("|           5. TERMINAR         |");
        System.out.println("|_______________________________|");
        System.out.println("\r\n Escoge tu opcion:");
        
        String entrada = input.nextLine();
        opcion = entrada.charAt(0);
        return opcion;
    }

}
