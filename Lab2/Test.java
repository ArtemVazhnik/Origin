package com.company;

import java.util.Scanner;
//import java.util.Random;
//import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println("Введите размерность матрицы: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Matrix MyMatrix = new Matrix(n);

        MyMatrix.show();
        int answer = MyMatrix.findMaxSumAbsString();

        System.out.println(answer);
    }
}
