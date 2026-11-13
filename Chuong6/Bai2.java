package Chuong6;

import java.util.Arrays;
import java.util.Scanner;

// Bài 2: Văn phòng phẩm (Tap, But kế thừa VanPhongPham) và danh sách văn phòng phẩm
abstract class VanPhongPham {
    private String ma;
    private String ten;
    private int soLuong;
    private double donGia;

    public VanPhongPham() {
        ma = "";
        ten = "";
        soLuong = 0;
        donGia = 0;
    }

    public VanPhongPham(String ma, String ten, int soLuong, double donGia) {
        this.ma = ma;
        this.ten = ten;
        setSoLuong(soLuong);
        setDonGia(donGia);
    }

    public String getMa() { return ma; }
    public void setMa(String ma) { this.ma = ma; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = Math.max(0, soLuong); }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = Math.max(0, donGia); }

    public void nhap(Scanner sc) {
        ma = NhapLieu.chuoiKhacRong(sc, "  Ma: ");
        ten = NhapLieu.chuoi(sc, "  Ten: ");
        soLuong = NhapLieu.soNguyen(sc, "  So luong co: ", 0, Integer.MAX_VALUE);
        donGia = NhapLieu.soThuc(sc, "  Don gia ban: ", 0, Double.MAX_VALUE);
    }

    // Lớp con gọi super.xuat() rồi in thêm thuộc tính riêng
    public void xuat() {
        System.out.printf("%-6s %-20s SL: %-5d Gia: %,.0f", ma, ten, soLuong, donGia);
    }

    public abstract String loai();
}

class Tap extends VanPhongPham {
    private int soTrang;

    public Tap() {
        super();
        soTrang = 1;
    }

    // Số trang phải > 0; giá trị không hợp lệ thì dùng mặc định 1
    public Tap(String ma, String ten, int soLuong, double donGia, int soTrang) {
        super(ma, ten, soLuong, donGia);
        this.soTrang = 1;
        setSoTrang(soTrang);
    }

    public int getSoTrang() { return soTrang; }

    // Trả về false và giữ giá trị cũ nếu số trang <= 0
    public boolean setSoTrang(int soTrang) {
        if (soTrang <= 0) return false;
        this.soTrang = soTrang;
        return true;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        soTrang = NhapLieu.soNguyen(sc, "  So trang (> 0): ", 1, Integer.MAX_VALUE);
    }

    @Override
    public void xuat() {
        System.out.print("[" + loai() + "] ");
        super.xuat();
        System.out.println(" | So trang: " + soTrang);
    }

    @Override
    public String loai() { return "Tap"; }
}

class But extends VanPhongPham {
    private String mauMuc;

    public But() {
        super();
        mauMuc = "";
    }

    public But(String ma, String ten, int soLuong, double donGia, String mauMuc) {
        super(ma, ten, soLuong, donGia);
        this.mauMuc = mauMuc;
    }

    public String getMauMuc() { return mauMuc; }
    public void setMauMuc(String mauMuc) { this.mauMuc = mauMuc; }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        mauMuc = NhapLieu.chuoi(sc, "  Mau muc: ");
    }

    @Override
    public void xuat() {
        System.out.print("[" + loai() + "] ");
        super.xuat();
        System.out.println(" | Mau muc: " + mauMuc);
    }

    @Override
    public String loai() { return "But"; }
}

class DanhSachVPP {
    private VanPhongPham[] ds;
    private int n;

    public DanhSachVPP() {
        ds = new VanPhongPham[0];
        n = 0;
    }

    public int getN() { return n; }

    public void xuat() {
        if (n == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (int i = 0; i < n; i++) {
            ds[i].xuat();   // đa hình: Tap.xuat() hoặc But.xuat()
        }
    }

    // Cho người dùng chọn loại rồi nhập: biến kiểu VanPhongPham trỏ tới Tap hoặc But
    public void them(Scanner sc) {
        int loai;
        loai = NhapLieu.soNguyen(sc, "Them (1 = tap, 2 = but): ", 1, 2);

        VanPhongPham vp = (loai == 1) ? new Tap() : new But();
        vp.nhap(sc);        // đa hình: Tap.nhap() hoặc But.nhap()
        them(vp);
    }

    public void them(VanPhongPham vp) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = vp;
        n++;
    }

    public double tongGiaTriTonKho() {
        double tong = 0;
        for (int i = 0; i < n; i++) {
            tong += ds[i].getSoLuong() * ds[i].getDonGia();
        }
        return tong;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DanhSachVPP ds = new DanhSachVPP();
        ds.them(new Tap("T01", "Tap Campus 96 trang", 50, 12000, 96));
        ds.them(new But("B01", "But bi Thien Long", 100, 5000, "Xanh"));

        int k = NhapLieu.soNguyen(sc, "So van phong pham muon them: ");
        for (int i = 0; i < k; i++) {
            System.out.println("Van phong pham thu " + (i + 1) + ":");
            ds.them(sc);
        }

        System.out.println("\n--- Danh sach van phong pham ---");
        ds.xuat();
        System.out.printf("Tong gia tri ton kho: %,.0f dong%n", ds.tongGiaTriTonKho());

        sc.close();
    }
}
