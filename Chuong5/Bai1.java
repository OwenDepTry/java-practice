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

    public HinhTron(double banKinh) {
        this.banKinh = banKinh > 0 ? banKinh : 1;
    }

    public double getBanKinh() { return banKinh; }
    public void setBanKinh(double banKinh) { if (banKinh > 0) this.banKinh = banKinh; }

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
        do {
            System.out.print("  Ban kinh: ");
            banKinh = Double.parseDouble(sc.nextLine().trim());
            if (banKinh <= 0) System.out.println("  Ban kinh phai > 0, nhap lai!");
        } while (banKinh <= 0);
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
        this.dai = dai > 0 ? dai : 1;
        this.rong = rong > 0 ? rong : 1;
    }

    public double getDai() { return dai; }
    public void setDai(double dai) { if (dai > 0) this.dai = dai; }
    public double getRong() { return rong; }
    public void setRong(double rong) { if (rong > 0) this.rong = rong; }

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
        do {
            System.out.print("  Chieu dai: ");
            dai = Double.parseDouble(sc.nextLine().trim());
            System.out.print("  Chieu rong: ");
            rong = Double.parseDouble(sc.nextLine().trim());
            if (dai <= 0 || rong <= 0) System.out.println("  Kich thuoc phai > 0, nhap lai!");
        } while (dai <= 0 || rong <= 0);
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

        System.out.print("So hinh can nhap: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        // Mảng kiểu lớp cha chứa đối tượng của nhiều lớp con
        HinhHoc[] ds = new HinhHoc[Math.max(n, 0)];

        for (int i = 0; i < ds.length; i++) {
            int loai;
            do {
                System.out.print("Hinh thu " + (i + 1) + " (1 = tron, 2 = chu nhat): ");
                loai = Integer.parseInt(sc.nextLine().trim());
            } while (loai != 1 && loai != 2);

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
