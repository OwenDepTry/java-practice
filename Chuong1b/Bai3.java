package chuong1b;

import java.util.Scanner;

public class Bai3 {
    public static boolean prime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so tu nhien N: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("N phai la so tu nhien.");
        } else if (prime(n)) {
            System.out.println(n + " la so nguyen to.");
        } else {
            System.out.println(n + " khong phai so nguyen to.");
        }

        sc.close();
    }
}