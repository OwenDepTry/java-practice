package chuong1a;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chieu dai: ");
        double chieuDai = sc.nextDouble();

        System.out.print("Nhap chieu rong: ");
        double chieuRong = sc.nextDouble();

        if (chieuDai > 0 && chieuRong > 0) {
            double chuVi = 2 * (chieuDai + chieuRong);
            double dienTich = chieuDai * chieuRong;

            System.out.println("Chu vi: " + chuVi);
            System.out.println("Dien tich: " + dienTich);
        } else {
            System.out.println("Chieu dai va chieu rong phai lon hon 0.");
        }

        sc.close();
    }
}