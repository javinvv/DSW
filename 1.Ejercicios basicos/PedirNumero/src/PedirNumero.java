import java.util.Scanner;

public class PedirNumero{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero del 1 al 10: ");
        int numero = sc.nextInt();

        sc.nextLine();

        if(numero <= 10){
            System.out.println("Introduce tu nombre: ");
            String nombre = sc.nextLine();
            for (int i = 0; i < numero; i++){
                System.out.println("Hola " + nombre);
            }
            int longitud = nombre.length();
            System.out.println(nombre +", tu nombre tiene " + longitud + " caracteres");

        }
        else{
            System.out.println("El numero introducido está fuera de rango, introduce otro numero.");
        }
    }
}