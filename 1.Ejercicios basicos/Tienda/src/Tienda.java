import java.util.Scanner;

public class Tienda {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los productos que has comprado: ");
        String producto = sc.nextLine();
        StringBuilder lista = new StringBuilder("");
        if(producto == "Fin"){
            System.out.println("No has comprado ningún producto");
        }
        while(producto != "Fin"){
            System.out.println("Introduce los productos que has comprado: ");
            producto = sc.nextLine();
            if(producto != "Fin"){
                lista.append(producto);
            }
        }
        System.out.println("la compra es");
    }
}
