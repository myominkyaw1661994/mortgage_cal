package coder.myo;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte MONTHS_IN_YEARS = 12;
        byte PERCENT = 100;
        int principal;
        float monthlyInterset;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Principal ($1K - 1M):  ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal < 1000000){
                break;
            }else {
                System.out.println("Enter a number Between 1,000 and 1,000,000");
            }
        }

        while (true) {
            System.out.println("Annual Interest Rate: ");
            float annualInterset = scanner.nextFloat();
            if(annualInterset >= 1 && annualInterset <= 30){
                monthlyInterset = annualInterset / PERCENT / MONTHS_IN_YEARS;
                break;
            }else {
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            }
        }



        System.out.println("Period (Year)");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEARS;

        double mortgage = principal * (monthlyInterset * Math.pow(1 + monthlyInterset, numberOfPayments))
                / (Math.pow(1 + monthlyInterset, numberOfPayments) - 1);

        String mortgageFomatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage :"+ mortgageFomatted);


    }
}
