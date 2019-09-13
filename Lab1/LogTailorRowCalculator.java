package com.company;

public class LogTailorRowCalculator {
    public double x;
    public double eps;

    public double calculate() {
        double sum = 1000;
        double answer = 0;
        int i = 1;
        while (Math.abs(sum) > eps) {
            sum = 0;
            sum = Math.pow(x, i);
            sum /= -i;
            answer += sum;
            i++;
        }
        return answer;
    }
}
