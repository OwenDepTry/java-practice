package Chuong4;

import java.util.Scanner;

// Bài 1: Lớp NoiSinh, lớp Nguoi (có nơi sinh) và lớp SinhVien kế thừa Nguoi
class NoiSinh {
    private String phuong;
    private String quan;
    private String tinhThanh;

    public NoiSinh() {
        phuong = "";
        quan = "";
        tinhThanh = "";
    }

    public NoiSinh(String phuong, String quan, String tinhThanh) {
        this.phuong = phuong;
        this.quan = quan;
        this.tinhThanh = tinhThanh;
    }

    // Hàm thiết lập sao chép
    public NoiSinh(NoiSinh khac) {
        this(khac.phuong, khac.quan, khac.tinhThanh);
    }

    public String getPhuong() { return phuong; }
    public void setPhuong(String phuong) { this.phuong = phuong; }
    public String getQuan() { return quan; }
    public void setQuan(String quan) { this.quan = quan; }
    public String getTinhThanh() { return tinhThanh; }
    public void setTinhThanh(String tinhThanh) { this.tinhThanh = tinhThanh; }

    public void nhap(Scanner sc) {
        phuong = NhapLieu.chuoi(sc, "  Phuong: ");
        quan = NhapLieu.chuoi(sc, "  Quan: ");
        tinhThanh = NhapLieu.chuoi(sc, "  Tinh/thanh: ");
    }

    public void xuat() {
        System.out.print(phuong + ", " + quan + ", " + tinhThanh);
    }
}

class Nguoi {
    // Số định danh có thể bắt đầu bằng 0 và dài 12 chữ số nên dùng String
    private String soDinhDanh;
    private String hoTen;
    private int namSinh;
    private String diaChi;
    private NoiSinh noiSinh;   // Nguoi "có một" NoiSinh (has-a)

    public Nguoi() {
        soDinhDanh = "";
        hoTen = "";
        namSinh = 2000;
        diaChi = "";
        noiSinh = new NoiSinh();
    }

    public Nguoi(String soDinhDanh, String hoTen, int namSinh,
                 String diaChi, NoiSinh noiSinh) {
        this.soDinhDanh = soDinhDanh;
        this.hoTen = hoTen;
        setNamSinh(namSinh);
        this.diaChi = diaChi;
        this.noiSinh = new NoiSinh(noiSinh);
    }

    public String getSoDinhDanh() { return soDinhDanh; }
    public void setSoDinhDanh(String soDinhDanh) { this.soDinhDanh = soDinhDanh; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public int getNamSinh() { return namSinh; }
    public void setNamSinh(int namSinh) { this.namSinh = namSinh > 0 ? namSinh : 2000; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public NoiSinh getNoiSinh() { return noiSinh; }
    public void setNoiSinh(NoiSinh noiSinh) { this.noiSinh = new NoiSinh(noiSinh); }

    public void nhap(Scanner sc) {
        soDinhDanh = NhapLieu.chuoi(sc, "So dinh danh: ");
        hoTen = NhapLieu.chuoi(sc, "Ho ten: ");
        namSinh = NhapLieu.soNguyen(sc, "Nam sinh: ", 1, Integer.MAX_VALUE);
        diaChi = NhapLieu.chuoi(sc, "Dia chi: ");
        System.out.println("Noi sinh:");
        noiSinh.nhap(sc);
    }

    public void xuat() {
        System.out.println("So dinh danh: " + soDinhDanh + " | Ho ten: " + hoTen
                + " | Nam sinh: " + namSinh);
        System.out.println("  Dia chi: " + diaChi);
        System.out.print("  Noi sinh: ");
        noiSinh.xuat();
        System.out.println();
    }
}

class SinhVien extends Nguoi {
    private int maSV;
    private String lop;

    public SinhVien() {
        super();
        maSV = 0;
        lop = "";
    }

    public SinhVien(String soDinhDanh, String hoTen, int namSinh, String diaChi,
                    NoiSinh noiSinh, int maSV, String lop) {
        super(soDinhDanh, hoTen, namSinh, diaChi, noiSinh);
        this.maSV = maSV;
        this.lop = lop;
    }

    public int getMaSV() { return maSV; }
    public void setMaSV(int maSV) { this.maSV = maSV; }
    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);   // nhập phần thông tin của Nguoi
        maSV = NhapLieu.soNguyen(sc, "Ma SV (so nguyen): ");
        lop = NhapLieu.chuoi(sc, "Lop: ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("  Ma SV: " + maSV + " | Lop: " + lop);
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NoiSinh ns = new NoiSinh("Phuong 3", "Quan 5", "TP. Ho Chi Minh");
        SinhVien sv1 = new SinhVien("079205001234", "Nguyen Van A", 2005,
                "273 An Duong Vuong", ns, 241001, "DCT1241");
        System.out.println("--- Sinh vien tao bang ham thiet lap ---");
        sv1.xuat();

        System.out.println("\n--- Nhap sinh vien moi ---");
        SinhVien sv2 = new SinhVien();
        sv2.nhap(sc);
        System.out.println("\n--- Thong tin vua nhap ---");
        sv2.xuat();

        // Nguoi tham chiếu tới SinhVien: xuat() của SinhVien được gọi
        Nguoi n = sv2;
        System.out.println("\n--- Goi xuat() qua bien kieu Nguoi ---");
        n.xuat();

        sc.close();
    }
}
