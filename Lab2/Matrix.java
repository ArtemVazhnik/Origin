package com.company;

import java.util.Random;

public class Matrix
{
    public int matrixSize;
    int[][] matrix;

    public Matrix(int size)
    {
        matrixSize = size;
        matrix = new int[matrixSize][matrixSize];
        Random rand = new Random();
        for (int i = 0; i < matrixSize; i++)
        {
            for (int j = 0; j < matrixSize; j++)
            {
                matrix[i][j] = 4 * rand.nextInt(matrixSize) - 2 * matrixSize + 1;
            }
        }
    }

    public int findMaxSumAbsString()
    {
        int answer = -1;
        for (int i = 0; i < matrixSize; i++)
        {
            int sum = findSumOfStringElements(i);
            if (answer < sum)
            {
                answer = findSumOfStringElements(i);
            }
        }
        return answer;
    }

    private int findSumOfStringElements(int stringPosition)
    {
        int sum = 0;
        for (int i = 0; i < matrixSize; i++)
        {
            sum += Math.abs(matrix[stringPosition][i]);
        }
        return sum;
    }

    public void show()
    {
        for (int i = 0; i < matrixSize; i++)
        {
            for (int j = 0; j < matrixSize; j++)
            {
                //System.out.printf("%.d ", matrix[i][j]);
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
