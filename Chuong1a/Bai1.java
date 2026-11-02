package chuong1a;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nguyen a: ");
        int a = sc.nextInt();

        System.out.print("Nhap so nguyen b: ");
        int b = sc.nextInt();

        System.out.println("Tong: " + (a + b));
        System.out.println("Hieu: " + (a - b));
        System.out.println("Tich: " + (a * b));

        if (b != 0) {
            System.out.println("Thuong: " + ((double) a / b));
        } else {
            System.out.println("Khong the chia cho 0.");
        }

        sc.close();
    }
}