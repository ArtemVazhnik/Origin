package com.company;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        System.out.println("Введите k: ");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.nextLine();

        Text T = new Text();
        T.CutFirstKWords(k);
    }
}
