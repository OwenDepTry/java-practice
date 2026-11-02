package chuong1a;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ban kinh: ");
        double banKinh = sc.nextDouble();

        if (banKinh > 0) {
            double chuVi = 2 * Math.PI * banKinh;
            double dienTich = Math.PI * banKinh * banKinh;

            System.out.println("Chu vi: " + chuVi);
            System.out.println("Dien tich: " + dienTich);
        } else {
            System.out.println("Ban kinh phai lon hon 0.");
        }

        sc.close();
    }
}