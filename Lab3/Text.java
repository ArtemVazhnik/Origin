package com.company;
import java.util.Scanner;

public class Text {
    public void CutFirstKWords(int k)
    {
        Scanner in = new Scanner(System.in);
        String S = new String();
        boolean key = true;

        while (key)
        {
            S = in.nextLine();
            if (S.isEmpty())
            {
                key = false;
            }
            else
            {
                String[] words = S.split(" ");
                int c = words.length;
                if (c > k)

                {
                    for(int j = k; j < c; j++)
                    {
                        System.out.print(words[j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                else
                {
                    System.out.println();
                }
            }

        }
    }
}
