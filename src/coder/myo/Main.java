package coder.myo;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int)readNumber("Principal ($1K - 1M):  ", 1000, 1000000);
        float annualInterset = (float)readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Year)", 1 , 30);

        double mortgage = calculateMortgage(principal, annualInterset, years);

        String mortgageFomatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage :"+ mortgageFomatted);
    }

    private static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max) {
                break;
            }
            System.out.println("Enter value between "+ min+" and " + max +" .");
        }
        return value;
    }

    private static double calculateMortgage(int principal, float annualInterset, byte years){
        byte MONTHS_IN_YEARS = 12;
        byte PERCENT = 100;
        short numberOfPayments = (short)(years * MONTHS_IN_YEARS);
        float monthlyInterset = annualInterset / PERCENT / MONTHS_IN_YEARS;


        return principal * (monthlyInterset * Math.pow(1 + monthlyInterset, numberOfPayments))
                / (Math.pow(1 + monthlyInterset, numberOfPayments) - 1);
    }
}
