package Chuong6;

import java.util.Arrays;
import java.util.Scanner;

// Bài 1: Chương trình quản lý sinh viên (lớp SinhVien, lớp danh sách DSSV, menu QuanLyDSSV)
class SinhVien {
    private String maSV;
    private String hoTen;
    private String sdt;

    // Hàm thiết lập không tham số
    public SinhVien() {
        maSV = "";
        hoTen = "";
        sdt = "";
    }

    // Hàm thiết lập 3 tham số
    public SinhVien(String maSV, String hoTen, String sdt) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    // Hàm thiết lập sao chép
    public SinhVien(SinhVien khac) {
        this(khac.maSV, khac.hoTen, khac.sdt);
    }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public void nhap(Scanner sc) {
        System.out.print("  Ma SV: ");
        maSV = sc.nextLine().trim();
        nhapThongTin(sc);
    }

    // Nhập họ tên và SĐT (dùng chung cho nhap và sua)
    public void nhapThongTin(Scanner sc) {
        System.out.print("  Ho ten: ");
        hoTen = sc.nextLine().trim();
        System.out.print("  So dien thoai: ");
        sdt = sc.nextLine().trim();
    }

    public void xuat() {
        System.out.printf("%-10s %-25s %-12s%n", maSV, hoTen, sdt);
    }
}

class DSSV {
    private SinhVien[] dssv;
    private int n;

    public DSSV() {
        n = 0;
        dssv = new SinhVien[0];
    }

    public DSSV(int n, SinhVien[] ds) {
        this.n = Math.max(0, Math.min(n, ds.length));
        dssv = new SinhVien[this.n];
        for (int i = 0; i < this.n; i++) {
            dssv[i] = new SinhVien(ds[i]);
        }
    }

    public int getN() { return n; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap so luong sinh vien: ");
        n = Math.max(0, Integer.parseInt(sc.nextLine().trim()));
        dssv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien thu " + (i + 1) + ":");
            dssv[i] = new SinhVien();
            dssv[i].nhap(sc);
        }
    }

    public void xuat() {
        if (n == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.printf("%-10s %-25s %-12s%n", "Ma SV", "Ho ten", "SDT");
        for (int i = 0; i < n; i++) {
            dssv[i].xuat();
        }
    }

    // Hàm chồng: them() nhập từ bàn phím, them(SinhVien) thêm đối tượng có sẵn
    public void them(Scanner sc) {
        SinhVien sv = new SinhVien();
        sv.nhap(sc);
        if (timkiem(sv.getMaSV()) != null) {
            System.out.println("Ma SV da ton tai, khong them.");
            return;
        }
        them(sv);
        System.out.println("Da them.");
    }

    public void them(SinhVien x) {
        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = new SinhVien(x);   // gọi hàm thiết lập sao chép
        n++;
    }

    public void xoa(Scanner sc) {
        System.out.print("Nhap ma SV can xoa: ");
        String ma = sc.nextLine().trim();
        System.out.println(xoa(ma) ? "Da xoa." : "Khong tim thay ma " + ma);
    }

    public boolean xoa(String ma) {
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMaSV().equalsIgnoreCase(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dssv[j] = dssv[j + 1];
                }
                dssv = Arrays.copyOf(dssv, n - 1);
                n--;
                return true;
            }
        }
        return false;
    }

    public SinhVien timkiem(String ma) {
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMaSV().equalsIgnoreCase(ma)) {
                return dssv[i];
            }
        }
        return null;
    }

    public void sua(Scanner sc) {
        System.out.print("Nhap ma SV can sua: ");
        String ma = sc.nextLine().trim();
        if (!sua(ma, sc)) System.out.println("Khong tim thay ma " + ma);
    }

    public boolean sua(String ma, Scanner sc) {
        SinhVien sv = timkiem(ma);
        if (sv == null) return false;
        System.out.println("Nhap thong tin moi cho " + sv.getMaSV() + ":");
        sv.nhapThongTin(sc);
        System.out.println("Da sua.");
        return true;
    }

    // Thống kê: số sinh viên và số sinh viên chưa có số điện thoại hợp lệ (10 chữ số)
    public void thongKe() {
        int sdtHopLe = 0;
        for (int i = 0; i < n; i++) {
            if (dssv[i].getSdt().matches("0\\d{9}")) sdtHopLe++;
        }
        System.out.println("Tong so sinh vien: " + n);
        System.out.println("SDT hop le (10 so, bat dau bang 0): " + sdtHopLe);
        System.out.println("SDT chua hop le: " + (n - sdtHopLe));
    }
}

class QuanLyDSSV {
    private final Scanner sc;
    private final DSSV ds = new DSSV();

    public QuanLyDSSV(Scanner sc) {
        this.sc = sc;
    }

    public void menu() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY SINH VIEN =====");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Sua thong tin sinh vien");
            System.out.println("5. Tim kiem theo ma");
            System.out.println("6. Thong ke");
            System.out.println("7. Thoat");
            System.out.print("Chon: ");
            chon = docLuaChon();

            switch (chon) {
                case 1:
                    ds.xuat();
                    break;
                case 2:
                    ds.them(sc);
                    break;
                case 3:
                    ds.xoa(sc);
                    break;
                case 4:
                    ds.sua(sc);
                    break;
                case 5:
                    System.out.print("Nhap ma SV can tim: ");
                    SinhVien sv = ds.timkiem(sc.nextLine().trim());
                    if (sv == null) System.out.println("Khong tim thay.");
                    else sv.xuat();
                    break;
                case 6:
                    ds.thongKe();
                    break;
                case 7:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 7);
    }

    private int docLuaChon() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuanLyDSSV ql = new QuanLyDSSV(sc);
        ql.menu();

        sc.close();
    }
}
