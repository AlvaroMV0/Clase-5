import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        //variables necesarias
        Scanner sc = new Scanner(System.in);
        Integer num = 0;

        System.out.printf("Por favor introduzca la ruta del archivo a leer"+"%n"
                +"!El archivo debe contener cada número en lineas separadas!"+"%n"+"Ruta de archivo: ");
        String dir = sc.nextLine();
        Path path = Paths.get(dir);


        while (true){

        //input variable
        System.out.println("Por favor introduza \"+\" para sumar, y \"*\" para multiplicar");
        String operation = sc.nextLine();

        //sumar
        if (operation.equals("+")) {
            for (String linea : Files.readAllLines(path)) {
                num = Integer.valueOf(linea);
                num += num;
            }
            System.out.println(num);
            System.exit(0);
        }//multiplicar
        else if (operation.equals("*")) {
            for (String linea : Files.readAllLines(path)) {
                num = Integer.valueOf(linea);
                num *= num;
            }
            System.out.println(num);
            System.exit(0);
        } else System.out.printf("La operación introducida no es un parámetro viable"+"%n"+"..."+"%n");

        }
    }
}