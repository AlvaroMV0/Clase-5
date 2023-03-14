import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ejercicio a
        System.out.printf("%n"+" ----------- Ejercicio a ----------- "+"%n");
        int primerNumero = 10;
        int segundoNumero = 100;
        int tercerNumero = 20;
        char ordenar = 'd';
        ordenarNumeros(primerNumero,segundoNumero,tercerNumero, ordenar);


        //Ejercicio b
        System.out.printf("%n"+" ----------- Ejercicio b ----------- "+"%n");
        System.out.println("Por favor introduzca los números de a uno: ");
        System.out.print("Primer número: ");
        int primerNumerosc = sc.nextInt();
        System.out.print("Segundo número: ");
        int segundoNumerosc = sc.nextInt();
        System.out.print("Tercer número: ");
        int tercerNumerosc = sc.nextInt();
        System.out.print("Introduzca \"a\" para orden ascendente y \"d\" para descendente: ");
        char ordenarsc = sc.next().charAt(0);
        ordenarNumeros(primerNumerosc,segundoNumerosc,tercerNumerosc, ordenarsc);

        //Ejercicio c
        System.out.printf("%n"+" ----------- Ejercicio c ----------- "+"%n");

        //(Eliminar las // correspondientes para ejecutar correctamente)}

        //Con parámetros (como en el ejercicio a)
        //ordenarNumeros(primerNumero,segundoNumero,tercerNumero, ordenar);

        //Sin parámetros (como en el ejercicio b)
        //ordenarNumeros();


    }
    private static void ordenarNumeros(int n1, int n2, int n3, Character x){

        int[] arr = new int[]{n1, n2, n3};
        int temp;
        int i;
        int j;
        x = Character.toLowerCase(x); //NECESARIO????
        if (x.equals('a')) {
            System.out.print("El orden de los números en orden ascendente es: ");
            for(i = 0; i < arr.length; ++i) {
                for(j = i + 1; j < arr.length; ++j) {
                    if (arr[i] > arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                if (i !=2) System.out.print(arr[i]+", "); else System.out.print(arr[i]);

            } System.out.println(". ");
        } else if (x.equals('d')) {
            System.out.print("El orden de los números en orden descendente es: ");
            for(i = 0; i < arr.length; ++i) {
                for(j = i + 1; j < arr.length; ++j) {
                    if (arr[i] < arr[j]) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }

                if (i !=2) System.out.print(arr[i]+", "); else System.out.print(arr[i]);
            } System.out.println(". ");
        } else {
            System.out.println("La letra introducida no es igual a \"a\" o \"d\"");
            System.out.println("Por favor introduzca una letra viable");
            ordenarNumeros();
        }
    }
    private static void ordenarNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Primer número: ");
        int n1 = sc.nextInt();
        System.out.print("Segundo número: ");
        int n2 = sc.nextInt();
        System.out.print("Tercer número: ");
        int n3 = sc.nextInt();
        char a = sc.next().charAt(0);
        ordenarNumeros(n1, n2, n3, a);

    }
}