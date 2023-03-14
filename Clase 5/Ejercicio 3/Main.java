
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        //scanner
        Scanner sc = new Scanner(System.in);

        //rutas
        System.out.println("Introduzca la ruta del archivo a leer");
        String pathInput = sc.nextLine();
        System.out.println("Introduzca la ruta del archivo a destinatario");
        String pathOutput = sc.nextLine();

        //codificar descodificar y espacios
        System.out.println("¿Desea codificar(C) o decodificar(D)?");
        Character yn = sc.next().charAt(0);
        System.out.println("¿Cuantos espacios desea desplazar el caracter?");
        int l = sc.nextInt();

        //llamar al metodo correcto
        if (yn.equals('C') || yn.equals('c')) {
            codificador(pathInput,pathOutput, l);
        } else if (yn.equals('D')||yn.equals('d')) {
            decodificador(pathInput,pathOutput, l);
        } else {
            System.out.print("El valor introducido no es correcto");
        }
        System.out.print("El programa finalizó correctamente");
    }


    public static void codificador(String dirInput, String dirOutput, int l) throws IOException {

        String output = "";
        for (String linea : Files.readAllLines(Paths.get(dirInput))) {


            for (int i = 0; i < linea.length(); ++i) {
                int x = linea.charAt(i);

                if ((x > 64 && x < 91 - l) || (x > 96 && x < 123 - l)) { // Esto es para que solo se modifiquen letras (máysuculas y mínúsculas)
                    x += l;
                } else if ((x >= 91 - l && x < 91) || (x >= 123 - l && x < 123)) { //x == 90 || x == 122 ||x == 89 || x == 121
                    x -= 26 - l;
                }

                output += (char)x;

            }Files.writeString(Paths.get(dirOutput), output); //escribir el output
        }
    }
    public static void decodificador(String dirInput, String dirOutput, int l) throws IOException {

        String output = "";
        for (String linea : Files.readAllLines(Paths.get(dirInput))) {
            for (int i = 0; i < linea.length(); ++i) {
                int x = linea.charAt(i);

                if ((x > 64 + l && x < 91) || (x > 96 + l && x < 123)) { // Esto es para que solo se modifiquen letras (máysuculas y mínúsculas)
                    x -= l;

                } else if ((x > 64 && x <= 64 + l) || (x > 96 && x <= 96 + l)) { //x == 65 || x == 66 ||x == 97 || x == 98
                    x += 26 - l;

                }output += (char)x;
            }   Files.writeString(Paths.get(dirOutput), output); //escribir el output
        }

    }
}