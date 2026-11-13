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
        System.out.print("  Ma: ");
        ma = sc.nextLine().trim();
        System.out.print("  Ten: ");
        ten = sc.nextLine().trim();
        do {
            System.out.print("  So luong co: ");
            soLuong = Integer.parseInt(sc.nextLine().trim());
        } while (soLuong < 0);
        do {
            System.out.print("  Don gia ban: ");
            donGia = Double.parseDouble(sc.nextLine().trim());
        } while (donGia < 0);
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
        soTrang = 0;
    }

    public Tap(String ma, String ten, int soLuong, double donGia, int soTrang) {
        super(ma, ten, soLuong, donGia);
        this.soTrang = soTrang;
    }

    public int getSoTrang() { return soTrang; }
    public void setSoTrang(int soTrang) { this.soTrang = soTrang; }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("  So trang: ");
        soTrang = Integer.parseInt(sc.nextLine().trim());
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
        System.out.print("  Mau muc: ");
        mauMuc = sc.nextLine().trim();
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
        do {
            System.out.print("Them (1 = tap, 2 = but): ");
            loai = Integer.parseInt(sc.nextLine().trim());
        } while (loai != 1 && loai != 2);

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

        System.out.print("So van phong pham muon them: ");
        int k = Integer.parseInt(sc.nextLine().trim());
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
