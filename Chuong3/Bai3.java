package Chuong3;

import java.util.Scanner;

// Bài 3: Lớp HINHTRON
class HinhTron {
    private double banKinh;

    // Hình tròn mặc định bán kính 1
    public HinhTron() {
        banKinh = 1;
    }

    // Bán kính không hợp lệ (<= 0) thì giữ giá trị mặc định 1
    public HinhTron(double banKinh) {
        this();
        setBanKinh(banKinh);
    }

    public double getBanKinh() { return banKinh; }

    // Trả về false và giữ giá trị cũ nếu bán kính không hợp lệ
    public boolean setBanKinh(double banKinh) {
        if (!(banKinh > 0 && Double.isFinite(banKinh))) return false;
        this.banKinh = banKinh;
        return true;
    }

    public void nhap(Scanner sc) {
        banKinh = NhapLieu.soDuong(sc, "Nhap ban kinh: ");
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

        // Bán kính âm bị từ chối, hình giữ bán kính hợp lệ
        HinhTron ht3 = new HinhTron(-2);
        ht3.xuat();

        sc.close();
    }
}
