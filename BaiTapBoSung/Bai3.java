package BaiTapBoSung;

import java.util.Scanner;

// Bài 3: Chợ OOP-Market. Cài đặt theo sơ đồ lớp trong đề:
//   Cho  ◆—— 1..*  Sap (abstract)  <|——  SapThucPham, SapQuanAo, SapTrangSuc
// Đề dùng kiểu int cho tiền; ở đây dùng long vì 40.000.000 x diện tích dễ vượt giới hạn int.
abstract class Sap {
    private static final long DONGIA = 40_000_000L;   // đồng / m2 / năm
    // Giới hạn tiền nhập vào (1 triệu tỷ đồng) để phép nhân thuế và tổng tiền không tràn long
    protected static final long TIEN_TOI_DA = 1_000_000_000_000_000L;
    private static final int DIEN_TICH_TOI_DA = 1_000_000;
    private int soThuTu;
    private int dienTich;       // m2
    protected long doanhThu;    // đồng

    public Sap() {
        soThuTu = 0;
        dienTich = 0;
        doanhThu = 0;
    }

    public Sap(int soThuTu, int dienTich, long doanhThu) {
        this.soThuTu = soThuTu;
        this.dienTich = Math.max(0, Math.min(dienTich, DIEN_TICH_TOI_DA));
        this.doanhThu = Math.max(0, Math.min(doanhThu, TIEN_TOI_DA));
    }

    public int getSoThuTu() { return soThuTu; }
    public int getDienTich() { return dienTich; }
    public long getDoanhThu() { return doanhThu; }

    protected abstract long tinhThueDoanhThu();

    // Chỉ sạp thực phẩm có tiền dịch vụ đông lạnh
    protected long tinhTienDichVu() {
        return 0;
    }

    private long tinhTienThueSap() {
        return DONGIA * dienTich;
    }

    public long tinhTienPhaiDong() {
        return tinhTienThueSap() + tinhThueDoanhThu() + tinhTienDichVu();
    }

    public void nhap(Scanner sc) {
        soThuTu = NhapLieu.soNguyen(sc, "  So thu tu sap: ");
        dienTich = NhapLieu.soNguyen(sc, "  Dien tich (m2): ", 1, DIEN_TICH_TOI_DA);
        doanhThu = NhapLieu.soLong(sc, "  Doanh thu (dong): ", 0, TIEN_TOI_DA);
    }

    public abstract String loai();

    public void xuat() {
        System.out.printf("Sap %-3d %-12s %3d m2  DT: %,15d  Thue sap: %,13d  Thue DT: %,12d"
                        + "  DV: %,11d  Phai dong: %,15d%n",
                soThuTu, loai(), dienTich, doanhThu, tinhTienThueSap(),
                tinhThueDoanhThu(), tinhTienDichVu(), tinhTienPhaiDong());
    }
}

class SapThucPham extends Sap {
    private long tienDichVu;    // tiền dịch vụ đông lạnh

    public SapThucPham() {
        super();
        tienDichVu = 0;
    }

    public SapThucPham(int soThuTu, int dienTich, long doanhThu, long tienDichVu) {
        super(soThuTu, dienTich, doanhThu);
        this.tienDichVu = Math.max(0, Math.min(tienDichVu, TIEN_TOI_DA));
    }

    @Override
    protected long tinhThueDoanhThu() {
        return doanhThu * 5 / 100;
    }

    @Override
    protected long tinhTienDichVu() {
        return tienDichVu;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        tienDichVu = NhapLieu.soLong(sc, "  Tien dich vu dong lanh (dong): ", 0, TIEN_TOI_DA);
    }

    @Override
    public String loai() { return "Thuc pham"; }
}

class SapQuanAo extends Sap {
    public SapQuanAo() {
        super();
    }

    public SapQuanAo(int soThuTu, int dienTich, long doanhThu) {
        super(soThuTu, dienTich, doanhThu);
    }

    @Override
    protected long tinhThueDoanhThu() {
        return doanhThu * 10 / 100;
    }

    @Override
    public String loai() { return "Quan ao"; }
}

class SapTrangSuc extends Sap {
    private static final long MOC = 100_000_000L;

    public SapTrangSuc() {
        super();
    }

    public SapTrangSuc(int soThuTu, int dienTich, long doanhThu) {
        super(soThuTu, dienTich, doanhThu);
    }

    // Thuế lũy tiến: phần dưới 100 triệu chịu 20%, phần từ 100 triệu trở lên chịu 30%
    @Override
    protected long tinhThueDoanhThu() {
        if (doanhThu < MOC) {
            return doanhThu * 20 / 100;
        }
        return MOC * 20 / 100 + (doanhThu - MOC) * 30 / 100;
    }

    @Override
    public String loai() { return "Trang suc"; }
}

class Cho {
    private Sap[] dsSap = new Sap[0];

    public void nhap(Scanner sc) {
        int n;
        n = NhapLieu.soNguyen(sc, "So sap duoc thue (1-1000): ", 1, 1000);

        dsSap = new Sap[n];
        for (int i = 0; i < n; i++) {
            int loai;
            loai = NhapLieu.soNguyen(sc, "Sap " + (i + 1) + " (1 = thuc pham, 2 = quan ao, 3 = trang suc): ", 1, 3);

            if (loai == 1) dsSap[i] = new SapThucPham();
            else if (loai == 2) dsSap[i] = new SapQuanAo();
            else dsSap[i] = new SapTrangSuc();
            dsSap[i].nhap(sc);
        }
    }

    public void xuat() {
        for (Sap s : dsSap) {
            s.xuat();
        }
    }

    public long tinhTongSoTien() {
        long tong = 0;
        for (Sap s : dsSap) {
            tong += s.tinhTienPhaiDong();   // đa hình
        }
        return tong;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cho cho = new Cho();
        cho.nhap(sc);                                   // câu a

        System.out.println("\n--- Danh sach sap ---");
        cho.xuat();
        System.out.printf("Tong so tien cac sap phai dong: %,d dong%n",
                cho.tinhTongSoTien());                  // câu b

        sc.close();
    }
}
