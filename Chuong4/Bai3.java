package Chuong4;

import java.util.Scanner;

// Bài 3: Lớp TamGiac gồm 3 đỉnh, dùng lại lớp Diem của Bài 2 (Diem.java)
class TamGiac {
    private Diem a;
    private Diem b;
    private Diem c;

    public TamGiac() {
        a = new Diem();
        b = new Diem();
        c = new Diem();
    }

    public TamGiac(Diem a, Diem b, Diem c) {
        this.a = new Diem(a);
        this.b = new Diem(b);
        this.c = new Diem(c);
    }

    public Diem getA() { return a; }
    public void setA(Diem a) { this.a = new Diem(a); }
    public Diem getB() { return b; }
    public void setB(Diem b) { this.b = new Diem(b); }
    public Diem getC() { return c; }
    public void setC(Diem c) { this.c = new Diem(c); }

    // Ba điểm tạo thành tam giác khi không thẳng hàng:
    // (xB - xA)(yC - yA) != (yB - yA)(xC - xA)
    // Hiệu tọa độ được tính bằng long (không tràn); mỗi tích có thể vượt long
    // nên so sánh chính xác trên 128 bit bằng Math.multiplyHigh (phần cao) và phép nhân thường (phần thấp).
    public boolean hopLe() {
        long ux = (long) b.getX() - a.getX();
        long uy = (long) b.getY() - a.getY();
        long vx = (long) c.getX() - a.getX();
        long vy = (long) c.getY() - a.getY();
        boolean bangNhau = Math.multiplyHigh(ux, vy) == Math.multiplyHigh(uy, vx)
                && ux * vy == uy * vx;
        return !bangNhau;
    }

    public void nhap(Scanner sc) {
        do {
            System.out.println("Dinh A:");
            a.nhap(sc);
            System.out.println("Dinh B:");
            b.nhap(sc);
            System.out.println("Dinh C:");
            c.nhap(sc);
            if (!hopLe()) System.out.println("Ba diem thang hang, nhap lai!");
        } while (!hopLe());
    }

    public void xuat() {
        System.out.print("Tam giac A");
        a.xuat();
        System.out.print(" B");
        b.xuat();
        System.out.print(" C");
        c.xuat();
        System.out.println();
    }

    public double tinhChuVi() {
        return a.khoangCach(b) + b.khoangCach(c) + c.khoangCach(a);
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TamGiac t1 = new TamGiac(new Diem(0, 0), new Diem(3, 0), new Diem(0, 4));
        t1.xuat();
        System.out.printf("Chu vi: %.2f%n", t1.tinhChuVi());

        System.out.println("\n--- Nhap tam giac moi ---");
        TamGiac t2 = new TamGiac();
        t2.nhap(sc);
        t2.xuat();
        System.out.printf("Chu vi: %.2f%n", t2.tinhChuVi());

        sc.close();
    }
}
