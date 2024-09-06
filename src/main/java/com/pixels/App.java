package com.pixels;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] firstPair = new int[2];
        int[] secondPair = new int[2];


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую пару");
        firstPair[0] = scanner.nextInt();
        firstPair[1] = scanner.nextInt();
        System.out.println("Введите вторую пару");
        secondPair[0] = scanner.nextInt();
        secondPair[1] = scanner.nextInt();

        int[] it = new int[2];
        int b = 0;
        for(int i: secondPair){

            if(i >= firstPair[0] && i <= firstPair[1] || i >= firstPair[1] && i <= firstPair[0]){
                it[b] = 1;
            }else{
                it[b] = 0;
            }
            b++;
        }
        System.out.println(Arrays.toString(it));
        if(it[0] == 1 && it[1] == 1 || it[0] == 0 && it[1] == 0){
            System.out.println("НЕ ПЕРЕСЕКАЮТСЯ");
        }else {
            System.out.println("ПЕРЕСЕКАЮТСЯ");
        }
    }
}
