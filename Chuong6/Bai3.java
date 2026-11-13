package Chuong6;

import java.util.Arrays;
import java.util.Scanner;

// Bài 3: Quản lý cán bộ (CongNhan, KySu, NhanVien kế thừa CanBo) và danh sách DSCB
class CanBo {
    private String ma;
    private String hoTen;
    private int tuoi;
    private String diaChi;

    public CanBo() {
        ma = "";
        hoTen = "";
        tuoi = 18;
        diaChi = "";
    }

    public CanBo(String ma, String hoTen, int tuoi, String diaChi) {
        this.ma = ma;
        this.hoTen = hoTen;
        setTuoi(tuoi);
        this.diaChi = diaChi;
    }

    // Hàm thiết lập sao chép
    public CanBo(CanBo khac) {
        this(khac.ma, khac.hoTen, khac.tuoi, khac.diaChi);
    }

    // Tạo bản sao đúng lớp con (đa hình); DSCB chỉ lưu bản sao
    public CanBo saoChep() {
        return new CanBo(this);
    }

    public String getMa() { return ma; }
    public void setMa(String ma) { this.ma = ma; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public int getTuoi() { return tuoi; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi > 0 ? tuoi : 18; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public void nhap(Scanner sc) {
        ma = NhapLieu.chuoiKhacRong(sc, "  Ma: ");
        nhapThongTin(sc);
    }

    // Nhập mọi thông tin trừ mã (dùng khi sửa cán bộ theo mã)
    public void nhapThongTin(Scanner sc) {
        hoTen = NhapLieu.chuoiKhacRong(sc, "  Ho ten: ");
        tuoi = NhapLieu.soNguyen(sc, "  Tuoi: ", 1, Integer.MAX_VALUE);
        diaChi = NhapLieu.chuoi(sc, "  Dia chi: ");
    }

    public void xuat() {
        System.out.printf("%-10s %-6s %-22s %-4d %-20s", loai(), ma, hoTen, tuoi, diaChi);
    }

    public String loai() { return "Can bo"; }
}

class CongNhan extends CanBo {
    private int bac;   // 1 đến 10

    public CongNhan() {
        super();
        bac = 1;
    }

    public CongNhan(String ma, String hoTen, int tuoi, String diaChi, int bac) {
        super(ma, hoTen, tuoi, diaChi);
        setBac(bac);
    }

    public CongNhan(CongNhan khac) {
        super(khac);
        bac = khac.bac;
    }

    @Override
    public CanBo saoChep() { return new CongNhan(this); }

    public int getBac() { return bac; }
    public void setBac(int bac) { this.bac = (bac >= 1 && bac <= 10) ? bac : 1; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        bac = NhapLieu.soNguyen(sc, "  Bac (1-10): ", 1, 10);
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" Bac: " + bac);
    }

    @Override
    public String loai() { return "Cong nhan"; }
}

class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu() {
        super();
        nganhDaoTao = "";
    }

    public KySu(String ma, String hoTen, int tuoi, String diaChi, String nganhDaoTao) {
        super(ma, hoTen, tuoi, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu(KySu khac) {
        super(khac);
        nganhDaoTao = khac.nganhDaoTao;
    }

    @Override
    public CanBo saoChep() { return new KySu(this); }

    public String getNganhDaoTao() { return nganhDaoTao; }
    public void setNganhDaoTao(String nganhDaoTao) { this.nganhDaoTao = nganhDaoTao; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        nganhDaoTao = NhapLieu.chuoi(sc, "  Nganh dao tao: ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" Nganh: " + nganhDaoTao);
    }

    @Override
    public String loai() { return "Ky su"; }
}

class NhanVien extends CanBo {
    private String congViec;

    public NhanVien() {
        super();
        congViec = "";
    }

    public NhanVien(String ma, String hoTen, int tuoi, String diaChi, String congViec) {
        super(ma, hoTen, tuoi, diaChi);
        this.congViec = congViec;
    }

    public NhanVien(NhanVien khac) {
        super(khac);
        congViec = khac.congViec;
    }

    @Override
    public CanBo saoChep() { return new NhanVien(this); }

    public String getCongViec() { return congViec; }
    public void setCongViec(String congViec) { this.congViec = congViec; }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        congViec = NhapLieu.chuoi(sc, "  Cong viec: ");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println(" Cong viec: " + congViec);
    }

    @Override
    public String loai() { return "Nhan vien"; }
}

class DSCB {
    private CanBo[] ds;
    private int n;

    public DSCB() {
        ds = new CanBo[0];
        n = 0;
    }

    public int getN() { return n; }

    private int viTri(String ma) {
        if (ma == null) return -1;
        for (int i = 0; i < n; i++) {
            if (ds[i].getMa().equalsIgnoreCase(ma.trim())) return i;
        }
        return -1;
    }

    // Thêm mới: hỏi loại cán bộ rồi nhập theo đúng lớp con
    public void themMoi(Scanner sc) {
        int loai;
        loai = NhapLieu.soNguyen(sc, "Loai (1 = cong nhan, 2 = ky su, 3 = nhan vien): ", 1, 3);

        CanBo cb;
        if (loai == 1) cb = new CongNhan();
        else if (loai == 2) cb = new KySu();
        else cb = new NhanVien();

        cb.nhap(sc);
        System.out.println(them(cb) ? "Da them." : "Ma da ton tai, khong them.");
    }

    // Mọi cách thêm đều đi qua hàm này nên mã cán bộ luôn duy nhất.
    // Danh sách lưu BẢN SAO: bên gọi sửa đối tượng gốc sau đó (vd setMa) không ảnh hưởng danh sách.
    public boolean them(CanBo cb) {
        if (cb == null || cb.getMa() == null || cb.getMa().trim().isEmpty()
                || viTri(cb.getMa()) >= 0) return false;
        ds = Arrays.copyOf(ds, n + 1);
        CanBo banSao = cb.saoChep();
        banSao.setMa(banSao.getMa().trim());   // chuẩn hoá mã giống lúc tìm kiếm
        ds[n] = banSao;
        n++;
        return true;
    }

    // Đổi mã do danh sách quản lý: mã mới không được rỗng, null hoặc trùng cán bộ khác
    public boolean doiMa(String maCu, String maMoi) {
        int i = viTri(maCu);
        if (i < 0 || maMoi == null || maMoi.trim().isEmpty()) return false;
        int j = viTri(maMoi);
        if (j >= 0 && j != i) return false;
        ds[i].setMa(maMoi.trim());
        return true;
    }

    public boolean sua(String ma, Scanner sc) {
        int i = viTri(ma);
        if (i < 0) return false;
        System.out.println("Nhap thong tin moi cho " + ds[i].getMa() + ":");
        ds[i].nhapThongTin(sc);   // đa hình: nhập đúng thuộc tính riêng của lớp con
        return true;
    }

    public boolean xoa(String ma) {
        int i = viTri(ma);
        if (i < 0) return false;
        for (int j = i; j < n - 1; j++) {
            ds[j] = ds[j + 1];
        }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        return true;
    }

    // Có thể có nhiều cán bộ trùng họ tên nên in hết các kết quả
    public int timTheoHoTen(String hoTen) {
        int dem = 0;
        if (hoTen == null) return 0;
        for (int i = 0; i < n; i++) {
            if (ds[i].getHoTen().equalsIgnoreCase(hoTen.trim())) {
                ds[i].xuat();
                dem++;
            }
        }
        return dem;
    }

    public void hienThi() {
        if (n == 0) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DSCB ds = new DSCB();
        ds.them(new CongNhan("CN01", "Tran Van Binh", 35, "Quan 8", 5));
        ds.them(new KySu("KS01", "Le Thi Hoa", 29, "Thu Duc", "Co khi"));
        ds.them(new NhanVien("NV01", "Pham Minh Chau", 26, "Quan 1", "Ke toan"));

        int chon;
        do {
            System.out.println("\n===== QUAN LY CAN BO =====");
            System.out.println("1. Them moi can bo");
            System.out.println("2. Sua can bo theo ma");
            System.out.println("3. Xoa can bo theo ma");
            System.out.println("4. Tim kiem theo ho ten");
            System.out.println("5. Hien thi danh sach");
            System.out.println("0. Thoat");
            chon = NhapLieu.soNguyen(sc, "Chon: ", 0, 5);

            switch (chon) {
                case 1:
                    ds.themMoi(sc);
                    break;
                case 2: {
                    String ma = NhapLieu.chuoi(sc, "Ma can sua: ");
                    System.out.println(ds.sua(ma, sc) ? "Da sua." : "Khong tim thay ma.");
                    break;
                }
                case 3: {
                    String ma = NhapLieu.chuoi(sc, "Ma can xoa: ");
                    System.out.println(ds.xoa(ma) ? "Da xoa." : "Khong tim thay ma.");
                    break;
                }
                case 4: {
                    String ten = NhapLieu.chuoi(sc, "Ho ten can tim: ");
                    if (ds.timTheoHoTen(ten) == 0) System.out.println("Khong tim thay.");
                    break;
                }
                case 5:
                    ds.hienThi();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (chon != 0);

        sc.close();
    }
}
