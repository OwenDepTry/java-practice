package Chuong3;

import java.util.Scanner;

// Bài 3: Lớp HINHTRON
class HinhTron {
    private double banKinh;

    public HinhTron() {
        banKinh = 0;
    }

    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
    }

    public double getBanKinh() { return banKinh; }
    public void setBanKinh(double banKinh) { this.banKinh = banKinh; }

    public void nhap(Scanner sc) {
        do {
            System.out.print("Nhap ban kinh: ");
            banKinh = sc.nextDouble();
            if (banKinh <= 0)
                System.out.println("Ban kinh phai > 0, nhap lai!");
        } while (banKinh <= 0);
    }

    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    public void xuat() {
        System.out.println("Hinh tron: ban kinh = " + banKinh);
        System.out.printf("  Dien tich = %.2f%n", tinhDienTich());
        System.out.printf("  Chu vi    = %.2f%n", tinhChuVi());
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HinhTron ht1 = new HinhTron();
        ht1.nhap(sc);
        ht1.xuat();

        HinhTron ht2 = new HinhTron(2.5);
        ht2.xuat();

        sc.close();
    }
}
