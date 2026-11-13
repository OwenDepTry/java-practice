package Chuong4;

import java.util.Scanner;

// Bài 2: Lớp DiemMau kế thừa Diem và lớp DoanThang gồm 2 DiemMau
// Lớp Diem nằm ở Diem.java vì được dùng chung cho Bài 2 và Bài 3
class DiemMau extends Diem {
    private int mau;

    public DiemMau() {
        super();
        mau = 0;
    }

    public DiemMau(int x, int y, int mau) {
        super(x, y);
        this.mau = mau;
    }

    public DiemMau(DiemMau khac) {
        this(khac.x, khac.y, khac.mau);
    }

    public int getMau() { return mau; }
    public void setMau(int mau) { this.mau = mau; }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        mau = NhapLieu.soNguyen(sc, "  Mau (so nguyen) = ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.print(" mau " + mau);
    }
}

class DoanThang {
    private DiemMau diem1;
    private DiemMau diem2;

    public DoanThang() {
        diem1 = new DiemMau();
        diem2 = new DiemMau();
    }

    public DoanThang(DiemMau diem1, DiemMau diem2) {
        this.diem1 = new DiemMau(diem1);
        this.diem2 = new DiemMau(diem2);
    }

    public DiemMau getDiem1() { return diem1; }
    public void setDiem1(DiemMau diem1) { this.diem1 = new DiemMau(diem1); }
    public DiemMau getDiem2() { return diem2; }
    public void setDiem2(DiemMau diem2) { this.diem2 = new DiemMau(diem2); }

    public void nhap(Scanner sc) {
        System.out.println("Diem mau 1:");
        diem1.nhap(sc);
        System.out.println("Diem mau 2:");
        diem2.nhap(sc);
    }

    public void xuat() {
        System.out.print("Doan thang tu ");
        diem1.xuat();
        System.out.print(" den ");
        diem2.xuat();
        System.out.println();
    }

    public double tinhKhoangCach() {
        return diem1.khoangCach(diem2);
    }

    public boolean cungMau() {
        return diem1.getMau() == diem2.getMau();
    }

    public void inKetQuaCungMau() {
        if (cungMau()) {
            System.out.println("Hai diem cua doan thang CUNG mau.");
        } else {
            System.out.println("Hai diem cua doan thang KHAC mau.");
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoanThang ab = new DoanThang(new DiemMau(0, 0, 1), new DiemMau(3, 4, 1));
        ab.xuat();
        System.out.printf("Khoang cach: %.2f%n", ab.tinhKhoangCach());
        ab.inKetQuaCungMau();

        System.out.println("\n--- Nhap doan thang moi ---");
        DoanThang cd = new DoanThang();
        cd.nhap(sc);
        cd.xuat();
        System.out.printf("Khoang cach: %.2f%n", cd.tinhKhoangCach());
        cd.inKetQuaCungMau();

        sc.close();
    }
}
