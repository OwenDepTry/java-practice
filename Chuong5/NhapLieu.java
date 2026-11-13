package Chuong5;

import java.util.Scanner;

// Các hàm nhập dữ liệu an toàn dùng chung cho các bài trong chương:
// nhập sai kiểu (chữ thay vì số), NaN, vô cực hoặc ngoài khoảng cho phép thì yêu cầu nhập lại
// thay vì làm chương trình dừng với NumberFormatException.
public class NhapLieu {
    // Kích thước hình học tối đa: đủ lớn cho mọi bài tập, đồng thời bảo đảm
    // diện tích (bình phương kích thước) vẫn là số hữu hạn trong kiểu double.
    public static final double KICH_THUOC_TOI_DA = 1e100;

    private NhapLieu() { }

    // Kích thước hợp lệ: 0 < d <= KICH_THUOC_TOI_DA (NaN tự động bị loại)
    public static boolean kichThuocHopLe(double d) {
        return d > 0 && d <= KICH_THUOC_TOI_DA;
    }

    public static String chuoi(Scanner sc, String nhan) {
        System.out.print(nhan);
        return sc.nextLine().trim();
    }

    // Chuỗi không được để trống
    public static String chuoiKhacRong(Scanner sc, String nhan) {
        String s;
        do {
            s = chuoi(sc, nhan);
            if (s.isEmpty()) System.out.println("  Khong duoc de trong, nhap lai!");
        } while (s.isEmpty());
        return s;
    }

    public static int soNguyen(Scanner sc, String nhan) {
        return soNguyen(sc, nhan, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Số nguyên trong đoạn [min, max]
    public static int soNguyen(Scanner sc, String nhan, int min, int max) {
        while (true) {
            String s = chuoi(sc, nhan);
            try {
                int x = Integer.parseInt(s);
                if (x >= min && x <= max) return x;
                System.out.println("  Gia tri phai trong khoang [" + min + ", " + max + "], nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("  \"" + s + "\" khong phai so nguyen hop le, nhap lai!");
            }
        }
    }

    // Số nguyên lớn (long) không nhỏ hơn min
    public static long soLong(Scanner sc, String nhan, long min) {
        return soLong(sc, nhan, min, Long.MAX_VALUE);
    }

    // Số nguyên lớn (long) trong đoạn [min, max]
    public static long soLong(Scanner sc, String nhan, long min, long max) {
        while (true) {
            String s = chuoi(sc, nhan);
            try {
                long x = Long.parseLong(s);
                if (x >= min && x <= max) return x;
                System.out.println("  Gia tri phai trong khoang [" + min + ", " + max + "], nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("  \"" + s + "\" khong phai so nguyen hop le, nhap lai!");
            }
        }
    }

    public static double soThuc(Scanner sc, String nhan) {
        while (true) {
            String s = chuoi(sc, nhan);
            try {
                double x = Double.parseDouble(s);
                if (Double.isFinite(x)) return x;   // loại NaN và Infinity
                System.out.println("  Gia tri phai la so huu han, nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("  \"" + s + "\" khong phai so thuc hop le, nhap lai!");
            }
        }
    }

    // Kích thước hình học: 0 < x <= KICH_THUOC_TOI_DA
    public static double soDuong(Scanner sc, String nhan) {
        while (true) {
            double x = soThuc(sc, nhan);
            if (kichThuocHopLe(x)) return x;
            System.out.println("  Gia tri phai > 0 va <= " + KICH_THUOC_TOI_DA + ", nhap lai!");
        }
    }

    // Số thực trong đoạn [min, max], dùng cho điểm số
    public static double soThuc(Scanner sc, String nhan, double min, double max) {
        while (true) {
            double x = soThuc(sc, nhan);
            if (x >= min && x <= max) return x;
            System.out.println("  Gia tri phai trong khoang [" + min + ", " + max + "], nhap lai!");
        }
    }
}
