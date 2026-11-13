package Chuong4;

import java.util.Scanner;

// Lớp Diem dùng chung cho Bài 2 (DiemMau kế thừa Diem) và Bài 3 (TamGiac gồm 3 Diem)
public class Diem {
    protected int x;
    protected int y;

    public Diem() {
        x = 0;
        y = 0;
    }

    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Diem(Diem khac) {
        this(khac.x, khac.y);
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public void nhap(Scanner sc) {
        x = NhapLieu.soNguyen(sc, "  x = ");
        y = NhapLieu.soNguyen(sc, "  y = ");
    }

    public void xuat() {
        System.out.print("(" + x + ", " + y + ")");
    }

    // Khoảng cách từ điểm này tới điểm khác
    public double khoangCach(Diem khac) {
        // Ép sang double trước khi trừ để không tràn số int với tọa độ lớn
        double dx = (double) khac.x - x;
        double dy = (double) khac.y - y;
        return Math.hypot(dx, dy);
    }
}
