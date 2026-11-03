import java.util.Scanner;

public class Notas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que nota has sacado en el examen del otro dia: ");
        int nota = sc.nextInt();

        sc.nextLine();

        System.out.println("Cual es tu nombre: ");
        String nombre = sc.nextLine();

        if(nota >= 0){
            if(nota <= 10){
                if (nota < 5){
                    System.out.println("Has suspendido, la proxima vez sacaras una mejor nota");
                } else if (nota < 7) {
                    System.out.println("Has aprovado, la proxima vez mejor");
                } else if (nota < 9) {
                    System.out.println("Has sacado un notable muy bien");
                } else {
                    System.out.println("Has sacado un sobresaliene, eres de los mejores de la clase");
                }
            }
            else{
                System.out.println("Nota incorrecta, introduce de nuevo:");
            }
        }
        else{
            System.out.println("Nota incorrecta, introduce de nuevo:");
        }
        System.out.println(nombre + " ha sacado un " + nota);
    }
}
