package Chuong3;

import java.util.Scanner;

// Bài 2: Lớp HINHCHUNHAT
class HinhChuNhat {
    private float dai;
    private float rong;

    public HinhChuNhat() {
        dai = 0;
        rong = 0;
    }

    public HinhChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public float getDai() { return dai; }
    public void setDai(float dai) { this.dai = dai; }
    public float getRong() { return rong; }
    public void setRong(float rong) { this.rong = rong; }

    public void nhap(Scanner sc) {
        do {
            System.out.print("Nhap chieu dai: ");
            dai = sc.nextFloat();
            System.out.print("Nhap chieu rong: ");
            rong = sc.nextFloat();
            if (dai <= 0 || rong <= 0)
                System.out.println("Kich thuoc phai > 0, nhap lai!");
        } while (dai <= 0 || rong <= 0);
    }

    public float tinhDienTich() {
        return dai * rong;
    }

    public float tinhChuVi() {
        return (dai + rong) * 2;
    }

    public void xuat() {
        System.out.println("Hinh chu nhat: dai = " + dai + ", rong = " + rong);
        System.out.println("  Dien tich = " + tinhDienTich());
        System.out.println("  Chu vi    = " + tinhChuVi());
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HinhChuNhat hcn1 = new HinhChuNhat();
        hcn1.nhap(sc);
        hcn1.xuat();

        HinhChuNhat hcn2 = new HinhChuNhat(5, 3);
        hcn2.xuat();
    }
}
