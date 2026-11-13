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

    // Nhập số thực rồi kiểm tra SAU khi ép sang float: số quá lớn thành vô cực thì nhập lại
    static float nhapFloat(Scanner sc, String nhan) {
        while (true) {
            float v = (float) NhapLieu.soThuc(sc, nhan);
            if (Float.isFinite(v)) return v;
            System.out.println("  Gia tri vuot pham vi float, nhap lai!");
        }
    }

    public void nhap(Scanner sc) {
        x = nhapFloat(sc, "Nhap x: ");
        y = nhapFloat(sc, "Nhap y: ");
    }

    public void xuat() {
        System.out.println("(" + x + ", " + y + ")");
    }

    // Di chuyển điểm: x = x + x', y = y + y'
    // Nếu tọa độ mới vượt phạm vi float thì không di chuyển và trả về false
    public boolean diChuyen(float dx, float dy) {
        float xMoi = x + dx;
        float yMoi = y + dy;
        if (!Float.isFinite(xMoi) || !Float.isFinite(yMoi)) return false;
        x = xMoi;
        y = yMoi;
        return true;
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

        System.out.println("Nhap x' va y' de di chuyen A:");
        float dx = Diem.nhapFloat(sc, "  x' = ");
        float dy = Diem.nhapFloat(sc, "  y' = ");
        if (a.diChuyen(dx, dy)) {
            System.out.print("A sau khi di chuyen: ");
            a.xuat();
        } else {
            System.out.println("Toa do moi vuot pham vi float, A giu nguyen.");
        }

        sc.close();
    }
}