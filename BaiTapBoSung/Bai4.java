package BaiTapBoSung;

import java.util.Scanner;

// Bài 4: Quản lý ca sĩ công ty XYZ và tính lương
//   CaSi (abstract)  <|——  CaSiChuaNoiTieng, CaSiNoiTieng (+ soGameshow)
//   CongTyXYZ  ◇—— 0..*  CaSi
abstract class CaSi {
    private String hoTen;
    private int soNamLamViec;
    private int soDiaBan;

    public CaSi() {
        hoTen = "";
        soNamLamViec = 0;
        soDiaBan = 0;
    }

    public CaSi(String hoTen, int soNamLamViec, int soDiaBan) {
        this.hoTen = hoTen;
        this.soNamLamViec = Math.max(0, soNamLamViec);
        this.soDiaBan = Math.max(0, soDiaBan);
    }

    public String getHoTen() { return hoTen; }
    public int getSoNamLamViec() { return soNamLamViec; }
    public int getSoDiaBan() { return soDiaBan; }

    public abstract long tinhLuong();

    public abstract String loai();

    protected static int docSoKhongAm(Scanner sc, String nhan) {
        return NhapLieu.soNguyen(sc, "  " + nhan + ": ", 0, Integer.MAX_VALUE);
    }

    public void nhap(Scanner sc) {
        hoTen = NhapLieu.chuoi(sc, "  Ho ten: ");
        soNamLamViec = docSoKhongAm(sc, "So nam lam viec");
        soDiaBan = docSoKhongAm(sc, "So dia da ban");
    }

    public void xuat() {
        System.out.printf("%-18s %-22s Nam: %-3d Dia: %-8d", loai(), hoTen, soNamLamViec, soDiaBan);
    }
}

class CaSiChuaNoiTieng extends CaSi {
    public CaSiChuaNoiTieng() {
        super();
    }

    public CaSiChuaNoiTieng(String hoTen, int soNamLamViec, int soDiaBan) {
        super(hoTen, soNamLamViec, soDiaBan);
    }

    // Lương = 3.000.000 + 500.000 x số năm + 1.000 x số đĩa
    @Override
    public long tinhLuong() {
        return 3_000_000L + 500_000L * getSoNamLamViec() + 1_000L * getSoDiaBan();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-13s Luong: %,d%n", "", tinhLuong());
    }

    @Override
    public String loai() { return "Chua noi tieng"; }
}

class CaSiNoiTieng extends CaSi {
    private int soGameshow;

    public CaSiNoiTieng() {
        super();
        soGameshow = 0;
    }

    public CaSiNoiTieng(String hoTen, int soNamLamViec, int soDiaBan, int soGameshow) {
        super(hoTen, soNamLamViec, soDiaBan);
        this.soGameshow = Math.max(0, soGameshow);
    }

    public int getSoGameshow() { return soGameshow; }

    // Lương = 5.000.000 + 500.000 x số năm + 1.200 x số đĩa + 500.000 x số gameshow
    @Override
    public long tinhLuong() {
        return 5_000_000L + 500_000L * getSoNamLamViec() + 1_200L * getSoDiaBan()
                + 500_000L * soGameshow;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        soGameshow = docSoKhongAm(sc, "So gameshow tham gia");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("Gameshow: %-3d Luong: %,d%n", soGameshow, tinhLuong());
    }

    @Override
    public String loai() { return "Noi tieng"; }
}

class CongTyXYZ {
    private CaSi[] dsCaSi = new CaSi[0];

    // Câu a: nhập danh sách ca sĩ, lưu trong mảng
    public void nhap(Scanner sc) {
        int n;
        n = NhapLieu.soNguyen(sc, "So ca si: ", 0, Integer.MAX_VALUE);

        dsCaSi = new CaSi[n];
        for (int i = 0; i < n; i++) {
            int loai;
            loai = NhapLieu.soNguyen(sc, "Ca si " + (i + 1) + " (1 = chua noi tieng, 2 = noi tieng): ", 1, 2);

            dsCaSi[i] = (loai == 1) ? new CaSiChuaNoiTieng() : new CaSiNoiTieng();
            dsCaSi[i].nhap(sc);
        }
    }

    public void xuat() {
        for (CaSi cs : dsCaSi) {
            cs.xuat();
        }
    }

    // Câu b: trả về một ca sĩ có lương cao nhất (null nếu danh sách rỗng)
    public CaSi timLuongCaoNhat() {
        CaSi max = null;
        for (CaSi cs : dsCaSi) {
            if (max == null || cs.tinhLuong() > max.tinhLuong()) {
                max = cs;
            }
        }
        return max;
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CongTyXYZ cty = new CongTyXYZ();
        cty.nhap(sc);

        System.out.println("\n--- Danh sach ca si ---");
        cty.xuat();

        CaSi max = cty.timLuongCaoNhat();
        if (max == null) {
            System.out.println("Danh sach rong.");
        } else {
            System.out.print("Ca si co luong cao nhat: ");
            max.xuat();
        }

        sc.close();
    }
}
