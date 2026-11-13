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
        maSV = NhapLieu.chuoiKhacRong(sc, "  Ma SV: ");
        nhapThongTin(sc);
    }

    // Nhập họ tên và SĐT (dùng chung cho nhap và sua)
    public void nhapThongTin(Scanner sc) {
        hoTen = NhapLieu.chuoiKhacRong(sc, "  Ho ten: ");
        sdt = NhapLieu.chuoi(sc, "  So dien thoai: ");
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

    // Sao chép n sinh viên đầu của mảng ds; sinh viên trùng mã bị bỏ qua
    public DSSV(int n, SinhVien[] ds) {
        this();
        int soLuong = Math.max(0, Math.min(n, ds.length));
        for (int i = 0; i < soLuong; i++) {
            if (ds[i] != null) them(ds[i]);
        }
    }

    public int getN() { return n; }

    public void nhap(Scanner sc) {
        int soLuong = NhapLieu.soNguyen(sc, "Nhap so luong sinh vien: ", 0, 1000);
        n = 0;
        dssv = new SinhVien[0];
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Sinh vien thu " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.nhap(sc);
            while (!them(sv)) {   // mã đã có trong danh sách
                System.out.println("  Ma SV da ton tai, nhap lai ma!");
                sv.setMaSV(NhapLieu.chuoiKhacRong(sc, "  Ma SV: "));
            }
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

    // Hàm chồng: them(Scanner) nhập từ bàn phím, them(SinhVien) thêm đối tượng có sẵn
    public void them(Scanner sc) {
        SinhVien sv = new SinhVien();
        sv.nhap(sc);
        System.out.println(them(sv) ? "Da them." : "Ma SV da ton tai, khong them.");
    }

    // Mọi cách thêm đều đi qua hàm này nên mã SV luôn duy nhất
    public boolean them(SinhVien x) {
        if (x == null || x.getMaSV() == null || x.getMaSV().trim().isEmpty() || viTri(x.getMaSV()) >= 0) return false;
        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = new SinhVien(x);   // gọi hàm thiết lập sao chép
        n++;
        return true;
    }

    public void xoa(Scanner sc) {
        String ma = NhapLieu.chuoi(sc, "Nhap ma SV can xoa: ");
        System.out.println(xoa(ma) ? "Da xoa." : "Khong tim thay ma " + ma);
    }

    public boolean xoa(String ma) {
        int i = viTri(ma);
        if (i < 0) return false;
        for (int j = i; j < n - 1; j++) {
            dssv[j] = dssv[j + 1];
        }
        dssv = Arrays.copyOf(dssv, n - 1);
        n--;
        return true;
    }

    private int viTri(String ma) {
        if (ma == null) return -1;
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMaSV().equalsIgnoreCase(ma.trim())) return i;
        }
        return -1;
    }

    // Trả về BẢN SAO: bên ngoài sửa bản sao (kể cả setMaSV) không làm đổi dữ liệu trong danh sách.
    // Muốn sửa thì gọi sua(...) hoặc doiMa(...) của DSSV.
    public SinhVien timkiem(String ma) {
        int i = viTri(ma);
        return i < 0 ? null : new SinhVien(dssv[i]);
    }

    // Đổi mã do danh sách quản lý: mã mới không được rỗng, null hoặc trùng sinh viên khác
    public boolean doiMa(String maCu, String maMoi) {
        int i = viTri(maCu);
        if (i < 0 || maMoi == null || maMoi.trim().isEmpty()) return false;
        int j = viTri(maMoi);
        if (j >= 0 && j != i) return false;
        dssv[i].setMaSV(maMoi.trim());
        return true;
    }

    public void sua(Scanner sc) {
        String ma = NhapLieu.chuoi(sc, "Nhap ma SV can sua: ");
        if (!sua(ma, sc)) System.out.println("Khong tim thay ma " + ma);
    }

    public boolean sua(String ma, Scanner sc) {
        int i = viTri(ma);
        if (i < 0) return false;
        SinhVien sv = dssv[i];   // sửa trực tiếp đối tượng trong danh sách (không đổi mã)
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
            chon = NhapLieu.soNguyen(sc, "Chon: ", 1, 7);

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
                    SinhVien sv = ds.timkiem(NhapLieu.chuoi(sc, "Nhap ma SV can tim: "));
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

}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuanLyDSSV ql = new QuanLyDSSV(sc);
        ql.menu();

        sc.close();
    }
}
