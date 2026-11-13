package Chuong3;

import java.util.Scanner;

// Bài 4: Lớp SINHVIEN
class SinhVien {
    private String maSV;
    private String hoTen;
    private String lop;
    private float diem1;
    private float diem2;
    private float diem3;

    public SinhVien() {
        maSV = "";
        hoTen = "";
        lop = "";
        diem1 = diem2 = diem3 = 0;
    }

    public SinhVien(String maSV, String hoTen, String lop,
                    float diem1, float diem2, float diem3) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        // Điểm không hợp lệ thì giữ giá trị 0 ban đầu
        setDiem1(diem1);
        setDiem2(diem2);
        setDiem3(diem3);
    }

    // get / set
    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }
    // Setter trả về false và GIỮ điểm cũ nếu điểm nằm ngoài [0, 10]
    public float getDiem1() { return diem1; }
    public boolean setDiem1(float d) {
        if (!hopLe(d)) return false;
        diem1 = d;
        return true;
    }
    public float getDiem2() { return diem2; }
    public boolean setDiem2(float d) {
        if (!hopLe(d)) return false;
        diem2 = d;
        return true;
    }
    public float getDiem3() { return diem3; }
    public boolean setDiem3(float d) {
        if (!hopLe(d)) return false;
        diem3 = d;
        return true;
    }

    private static boolean hopLe(float d) {
        return d >= 0 && d <= 10;
    }

    private float nhapDiem(Scanner sc, String ten) {
        return (float) NhapLieu.soThuc(sc, "Nhap " + ten + " (0-10): ", 0, 10);
    }

    public void nhap(Scanner sc) {
        maSV = NhapLieu.chuoiKhacRong(sc, "Nhap ma SV: ");
        hoTen = NhapLieu.chuoiKhacRong(sc, "Nhap ho ten: ");
        lop = NhapLieu.chuoi(sc, "Nhap lop: ");
        diem1 = nhapDiem(sc, "diem mon 1");
        diem2 = nhapDiem(sc, "diem mon 2");
        diem3 = nhapDiem(sc, "diem mon 3");
    }

    public float tinhDTB() {
        return (diem1 + diem2 + diem3) / 3;
    }

    public String xepLoai() {
        float dtb = tinhDTB();
        if (dtb >= 8) return "Gioi";
        if (dtb >= 6.5) return "Kha";
        if (dtb >= 5) return "Trung binh";
        return "Yeu";
    }

    public void xuat() {
        System.out.println("Ma SV: " + maSV + " | Ho ten: " + hoTen + " | Lop: " + lop);
        System.out.println("  Diem: " + diem1 + ", " + diem2 + ", " + diem3);
        System.out.printf("  DTB = %.2f - Xep loai: %s%n", tinhDTB(), xepLoai());
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinhVien sv1 = new SinhVien();
        sv1.nhap(sc);
        sv1.xuat();

        SinhVien sv2 = new SinhVien("SV002", "Tran Thi B", "CNTT1", 7, 8.5f, 6);
        sv2.xuat();

        // Điểm 11 không hợp lệ: setter báo false và giữ điểm cũ
        if (!sv2.setDiem1(11)) {
            System.out.println("Diem 11 khong hop le, giu diem mon 1 = " + sv2.getDiem1());
        }

        sc.close();
    }
}
