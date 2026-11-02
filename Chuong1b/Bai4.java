package chuong1b;

import java.util.Scanner;

public class Bai4 {
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
            sc.close();
            return;
        }

        // Cau a: Cac so tu nhien <= N va tong
        long sumA = 0;

        System.out.print("a. Cac so tu nhien <= N: ");

        for (long i = 0; i <= n; i++) {
            System.out.print(i + " ");
            sumA += i;
        }

        System.out.println("\nTong: " + sumA);

        // Cau b: Cac so tu nhien chan <= N va tong
        long sumB = 0;

        System.out.print("\nb. Cac so tu nhien chan <= N: ");

        for (long i = 0; i <= n; i += 2) {
            System.out.print(i + " ");
            sumB += i;
        }

        System.out.println("\nTong: " + sumB);

        // Cau c: Cac so tu nhien le <= N va tong
        long sumC = 0;

        System.out.print("\nc. Cac so tu nhien le <= N: ");

        for (long i = 1; i <= n; i += 2) {
            System.out.print(i + " ");
            sumC += i;
        }

        System.out.println("\nTong: " + sumC);

        // Cau d: Cac so nguyen to <= N va tong
        long sumD = 0;

        System.out.print("\nd. Cac so nguyen to <= N: ");

        for (long i = 2; i <= n; i++) {
            if (prime((int) i)) {
                System.out.print(i + " ");
                sumD += i;
            }
        }

        System.out.println("\nTong: " + sumD);

        // Cau e: N so nguyen to dau tien
        int count = 0;
        long num = 2;

        System.out.print("\ne. " + n + " so nguyen to dau tien: ");

        while (count < n && num <= Integer.MAX_VALUE) {
            if (prime((int) num)) {
                System.out.print(num + " ");
                count++;
            }

            num++;
        }

        System.out.println();

        if (count < n) {
            System.out.println("Da vuot pham vi so nguyen int.");
        }

        sc.close();
    }
}