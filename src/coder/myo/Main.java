package coder.myo;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte MONTHS_IN_YEARS = 12;
        byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal: ");
        int principal = scanner.nextInt();

        System.out.println("Annual Interest Rate: " );
        float annualInterset = scanner.nextFloat();
        float monthlyInterset = annualInterset / PERCENT / MONTHS_IN_YEARS;

        System.out.println("Period (Year)");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEARS;

        double mortgage = principal * (monthlyInterset * Math.pow(1 + monthlyInterset, numberOfPayments))
                / (Math.pow(1 + monthlyInterset, numberOfPayments) - 1);

        String mortgageFomatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage :"+ mortgageFomatted);


    }
}
