package Clase_3;

import java.util.Scanner;

public class Ejercicio_3 {

    public static void main (String args []){

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un número");
        int num1 = input.nextInt();

        System.out.println("Ingrese otro número");
        int num2 = input.nextInt();

        /*Ejercicio 3*/
        System.out.println("La multiplicación de sus números es " +multiplicar(num1, num2));

        /*Ejercicio 4*/
        System.out.println("La suma de sus números es " +suma(num1, num2));

    }

    /*Ejercicio 3*/
    public static int multiplicar (int x, int y){
        return x * y;
    }

    /*Ejercicio 4*/
    public static int suma (int x, int y){
        return x + y;
    }

}
