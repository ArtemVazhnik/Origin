package com.company;

import java.util.Scanner;

public class ConsultTest {

    public static void main(String[] args) {

        LogTailorRowCalculator Test = new LogTailorRowCalculator();

        System.out.println("Введите порядок погрешности: ");
        Scanner in = new Scanner(System.in);
        int power = in.nextInt();
        Test.eps = Math.pow(10, -power);
        System.out.println("Введите x ");
        Test.x = in.nextDouble();

        double answer = Test.calculate();


        System.out.printf("мой логарифм %.3f \n", answer);
        double log = Math.log(1 - Test.x);
        System.out.printf("дефолтный логарифм %.3f \n", log);
    }
}
