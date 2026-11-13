package Chuong5;

import java.util.Scanner;

// Luyện tập: lớp trừu tượng HinhHoc, hai lớp con HinhTron và HinhChuNhat
abstract class HinhHoc {
    public abstract double tinhDienTich();
    public abstract double tinhChuVi();
    public abstract void nhap(Scanner sc);
    public abstract void xuat();
}

class HinhTron extends HinhHoc {
    private double banKinh;

    public HinhTron() {
        banKinh = 1;
    }

    // Bán kính không hợp lệ (<= 0, NaN, quá lớn) thì dùng mặc định 1
    public HinhTron(double banKinh) {
        this.banKinh = NhapLieu.kichThuocHopLe(banKinh) ? banKinh : 1;
    }

    public double getBanKinh() { return banKinh; }
    public void setBanKinh(double banKinh) { if (NhapLieu.kichThuocHopLe(banKinh)) this.banKinh = banKinh; }

    @Override
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    @Override
    public void nhap(Scanner sc) {
        banKinh = NhapLieu.soDuong(sc, "  Ban kinh: ");
    }

    @Override
    public void xuat() {
        System.out.printf("Hinh tron r = %.2f: S = %.2f, P = %.2f%n",
                banKinh, tinhDienTich(), tinhChuVi());
    }
}

class HinhChuNhat extends HinhHoc {
    private double dai;
    private double rong;

    public HinhChuNhat() {
        dai = 1;
        rong = 1;
    }

    public HinhChuNhat(double dai, double rong) {
        this.dai = NhapLieu.kichThuocHopLe(dai) ? dai : 1;
        this.rong = NhapLieu.kichThuocHopLe(rong) ? rong : 1;
    }

    public double getDai() { return dai; }
    public void setDai(double dai) { if (NhapLieu.kichThuocHopLe(dai)) this.dai = dai; }
    public double getRong() { return rong; }
    public void setRong(double rong) { if (NhapLieu.kichThuocHopLe(rong)) this.rong = rong; }

    @Override
    public double tinhDienTich() {
        return dai * rong;
    }

    @Override
    public double tinhChuVi() {
        return 2 * (dai + rong);
    }

    @Override
    public void nhap(Scanner sc) {
        dai = NhapLieu.soDuong(sc, "  Chieu dai: ");
        rong = NhapLieu.soDuong(sc, "  Chieu rong: ");
    }

    @Override
    public void xuat() {
        System.out.printf("Hinh chu nhat %.2f x %.2f: S = %.2f, P = %.2f%n",
                dai, rong, tinhDienTich(), tinhChuVi());
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = NhapLieu.soNguyen(sc, "So hinh can nhap: ", 0, 1000);

        // Mảng kiểu lớp cha chứa đối tượng của nhiều lớp con
        HinhHoc[] ds = new HinhHoc[n];

        for (int i = 0; i < ds.length; i++) {
            int loai;
            loai = NhapLieu.soNguyen(sc, "Hinh thu " + (i + 1) + " (1 = tron, 2 = chu nhat): ", 1, 2);

            ds[i] = (loai == 1) ? new HinhTron() : new HinhChuNhat();
            ds[i].nhap(sc);   // đa hình: gọi nhap() của đúng lớp con
        }

        System.out.println("\n--- Danh sach hinh ---");
        double tongDienTich = 0;
        HinhHoc lonNhat = null;

        for (HinhHoc h : ds) {
            h.xuat();           // đa hình: gọi xuat() của đúng lớp con
            tongDienTich += h.tinhDienTich();
            if (lonNhat == null || h.tinhDienTich() > lonNhat.tinhDienTich()) {
                lonNhat = h;
            }
        }

        System.out.printf("Tong dien tich: %.2f%n", tongDienTich);
        if (lonNhat != null) {
            System.out.print("Hinh co dien tich lon nhat: ");
            lonNhat.xuat();
        }

        sc.close();
    }
}
