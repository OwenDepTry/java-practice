package Chuong3;

import java.util.Scanner;

// Bài 2: Lớp HINHCHUNHAT
class HinhChuNhat {
    private float dai;
    private float rong;

    // Hình mặc định 1 x 1 để luôn có kích thước hợp lệ
    public HinhChuNhat() {
        dai = 1;
        rong = 1;
    }

    // Kích thước không hợp lệ (<= 0) thì giữ giá trị mặc định 1
    public HinhChuNhat(float dai, float rong) {
        this();
        setDai(dai);
        setRong(rong);
    }

    private static boolean hopLe(float d) {
        return d > 0 && Float.isFinite(d);
    }

    public float getDai() { return dai; }
    public float getRong() { return rong; }

    // Trả về false và giữ giá trị cũ nếu kích thước không hợp lệ
    public boolean setDai(float dai) {
        if (!hopLe(dai)) return false;
        this.dai = dai;
        return true;
    }

    public boolean setRong(float rong) {
        if (!hopLe(rong)) return false;
        this.rong = rong;
        return true;
    }

    public void nhap(Scanner sc) {
        dai = (float) NhapLieu.soDuong(sc, "Nhap chieu dai: ");
        rong = (float) NhapLieu.soDuong(sc, "Nhap chieu rong: ");
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

        // Kích thước âm bị từ chối, hình giữ kích thước hợp lệ
        HinhChuNhat hcn3 = new HinhChuNhat(-5, 3);
        hcn3.xuat();

        sc.close();
    }
}
