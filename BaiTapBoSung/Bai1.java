package BaiTapBoSung;

import java.util.Scanner;

// Bài 1: Cây phân cấp phương tiện giao thông
//
//              Vehicle (reg_num, brand)
//             /          |           \
//   PassengerVehicle   Truck       Motorbike
//     (max_pass)     (max_load)     (type)
//      /     \
//    Car     Bus (number)
//
// Car và Bus được gom vào nhóm "xe chở khách" (PassengerVehicle).
abstract class Vehicle {
    protected String reg_num;   // số đăng ký xe
    protected String brand;     // hãng

    public Vehicle() {
        reg_num = "";
        brand = "";
    }

    public Vehicle(String reg_num, String brand) {
        this.reg_num = reg_num;
        this.brand = brand;
    }

    public String getRegNum() { return reg_num; }
    public String getBrand() { return brand; }

    public void input(Scanner sc) {
        System.out.print("  So dang ky: ");
        reg_num = sc.nextLine().trim();
        System.out.print("  Hang: ");
        brand = sc.nextLine().trim();
    }

    public void print() {
        System.out.printf("%-10s %-12s %-10s", loai(), reg_num, brand);
    }

    public abstract String loai();

    protected static int docSoKhongAm(Scanner sc, String nhan) {
        int x;
        do {
            System.out.print("  " + nhan + ": ");
            x = Integer.parseInt(sc.nextLine().trim());
            if (x < 0) System.out.println("  Gia tri phai >= 0, nhap lai!");
        } while (x < 0);
        return x;
    }
}

abstract class PassengerVehicle extends Vehicle {
    protected int max_pass;     // số hành khách tối đa

    public PassengerVehicle() {
        super();
        max_pass = 0;
    }

    public PassengerVehicle(String reg_num, String brand, int max_pass) {
        super(reg_num, brand);
        this.max_pass = max_pass;
    }

    public int getMaxPass() { return max_pass; }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        max_pass = docSoKhongAm(sc, "So hanh khach toi da");
    }

    @Override
    public void print() {
        super.print();
        System.out.print(" Khach toi da: " + max_pass);
    }
}

class Car extends PassengerVehicle {
    public Car() {
        super();
    }

    public Car(String reg_num, String brand, int max_pass) {
        super(reg_num, brand, max_pass);
    }

    @Override
    public void print() {
        super.print();
        System.out.println();
    }

    @Override
    public String loai() { return "Xe con"; }
}

class Bus extends PassengerVehicle {
    private int number;         // mã số tuyến

    public Bus() {
        super();
        number = 0;
    }

    public Bus(String reg_num, String brand, int max_pass, int number) {
        super(reg_num, brand, max_pass);
        this.number = number;
    }

    public int getNumber() { return number; }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        number = docSoKhongAm(sc, "Ma so tuyen");
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" | Tuyen so: " + number);
    }

    @Override
    public String loai() { return "Xe buyt"; }
}

class Truck extends Vehicle {
    private int max_load;       // số kg hàng hóa tối đa

    public Truck() {
        super();
        max_load = 0;
    }

    public Truck(String reg_num, String brand, int max_load) {
        super(reg_num, brand);
        this.max_load = max_load;
    }

    public int getMaxLoad() { return max_load; }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        max_load = docSoKhongAm(sc, "Tai trong toi da (kg)");
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" Tai trong: " + max_load + " kg");
    }

    @Override
    public String loai() { return "Xe tai"; }
}

class Motorbike extends Vehicle {
    private int type;           // loại xe

    public Motorbike() {
        super();
        type = 0;
    }

    public Motorbike(String reg_num, String brand, int type) {
        super(reg_num, brand);
        this.type = type;
    }

    public int getType() { return type; }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        type = docSoKhongAm(sc, "Loai xe (so)");
    }

    @Override
    public void print() {
        super.print();
        System.out.println(" Loai: " + type);
    }

    @Override
    public String loai() { return "Xe may"; }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("So phuong tien can nhap: ");
        int n = Math.max(0, Integer.parseInt(sc.nextLine().trim()));
        Vehicle[] ds = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            int loai;
            do {
                System.out.print("Phuong tien " + (i + 1)
                        + " (1 = xe con, 2 = xe buyt, 3 = xe tai, 4 = xe may): ");
                loai = Integer.parseInt(sc.nextLine().trim());
            } while (loai < 1 || loai > 4);

            switch (loai) {
                case 1: ds[i] = new Car(); break;
                case 2: ds[i] = new Bus(); break;
                case 3: ds[i] = new Truck(); break;
                default: ds[i] = new Motorbike();
            }
            ds[i].input(sc);   // đa hình
        }

        System.out.println("\n--- Danh sach phuong tien ---");
        int tongCho = 0;
        for (Vehicle v : ds) {
            v.print();         // đa hình
            // Xử lý riêng nhóm xe chở khách nhưng vẫn duyệt chung một mảng
            if (v instanceof PassengerVehicle) {
                tongCho += ((PassengerVehicle) v).getMaxPass();
            }
        }
        System.out.println("Tong so cho cua cac xe cho khach: " + tongCho);

        sc.close();
    }
}
