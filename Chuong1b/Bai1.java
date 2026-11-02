package chuong1b;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nguyen N: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println(n + " la so am.");
        } else if (n == 0) {
            System.out.println("N bang zero.");
        } else {
            System.out.println(n + " la so duong.");
        }

        sc.close();
    }
}