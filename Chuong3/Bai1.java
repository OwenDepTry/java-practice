package Chuong3;

import java.util.Scanner;

// Bài 1: Lớp DIEM
class Diem {
    private float x;
    private float y;

    // Hàm thiết lập không tham số
    public Diem() {
        x = 0;
        y = 0;
    }

    // Hàm thiết lập có tham số
    public Diem(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // get / set
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap x: ");
        x = sc.nextFloat();
        System.out.print("Nhap y: ");
        y = sc.nextFloat();
    }

    public void xuat() {
        System.out.println("(" + x + ", " + y + ")");
    }

    // Di chuyển điểm: x = x + x', y = y + y'
    public void diChuyen(float dx, float dy) {
        x = x + dx;
        y = y + dy;
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Diem a = new Diem();          // không tham số
        Diem b = new Diem(3, 4);      // có tham số

        System.out.println("Nhap diem A:");
        a.nhap(sc);
        System.out.print("Diem A: ");
        a.xuat();
        System.out.print("Diem B: ");
        b.xuat();

        System.out.print("Nhap x' va y' de di chuyen A: ");
        float dx = sc.nextFloat();
        float dy = sc.nextFloat();
        a.diChuyen(dx, dy);
        System.out.print("A sau khi di chuyen: ");
        a.xuat();

        sc.close();
    }
}