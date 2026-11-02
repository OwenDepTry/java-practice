package chuong1b;

import java.util.Scanner;

public class Bai9 {
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void xuatMang(int[] a) {
        for (int phanTu : a) {
            System.out.print(phanTu + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu N: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("N phai >= 0.");
            sc.close();
            return;
        }

        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        // a. Xuat cac phan tu va tinh tong
        long tong = 0;

        System.out.print("\na. Cac phan tu: ");
        xuatMang(a);

        for (int phanTu : a) {
            tong += phanTu;
        }

        System.out.println("Tong: " + tong);

        // b. Xuat cac phan tu chan va tinh tong
        long tongChan = 0;

        System.out.print("\nb. Cac phan tu chan: ");

        for (int phanTu : a) {
            if (phanTu % 2 == 0) {
                System.out.print(phanTu + " ");
                tongChan += phanTu;
            }
        }

        System.out.println("\nTong cac phan tu chan: " + tongChan);

        // c. Xuat cac phan tu le va tinh tong
        long tongLe = 0;

        System.out.print("\nc. Cac phan tu le: ");

        for (int phanTu : a) {
            if (phanTu % 2 != 0) {
                System.out.print(phanTu + " ");
                tongLe += phanTu;
            }
        }

        System.out.println("\nTong cac phan tu le: " + tongLe);

        // d. Xuat cac phan tu nguyen to va tinh tong
        long tongNguyenTo = 0;

        System.out.print("\nd. Cac phan tu nguyen to: ");

        for (int phanTu : a) {
            if (laSoNguyenTo(phanTu)) {
                System.out.print(phanTu + " ");
                tongNguyenTo += phanTu;
            }
        }

        System.out.println(
                "\nTong cac phan tu nguyen to: " + tongNguyenTo);

        // e. Them mot phan tu vao cuoi mang
        System.out.print("\ne. Nhap phan tu can them: ");
        int giaTriMoi = sc.nextInt();

        int[] mangMoi = new int[a.length + 1];

        for (int i = 0; i < a.length; i++) {
            mangMoi[i] = a[i];
        }

        mangMoi[mangMoi.length - 1] = giaTriMoi;
        a = mangMoi;

        System.out.print("Mang sau khi them: ");
        xuatMang(a);

        // f. Xoa phan tu thu k, vi tri tinh tu 1
        System.out.print("\nf. Nhap vi tri k can xoa (1-"
                + a.length + "): ");
        int k = sc.nextInt();

        if (k < 1 || k > a.length) {
            System.out.println("Vi tri khong hop le. Mang giu nguyen.");
        } else {
            int[] mangSauXoa = new int[a.length - 1];
            int j = 0;

            for (int i = 0; i < a.length; i++) {
                if (i != k - 1) {
                    mangSauXoa[j] = a[i];
                    j++;
                }
            }

            a = mangSauXoa;

            System.out.print("Mang sau khi xoa: ");
            xuatMang(a);
        }

        // g. Tim tat ca vi tri cua x
        System.out.print("\ng. Nhap so x can tim: ");
        int x = sc.nextInt();

        boolean timThay = false;

        System.out.print("Cac vi tri cua " + x + ": ");

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                System.out.print((i + 1) + " ");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.print("Khong co trong mang.");
        }

        System.out.println();

        sc.close();
    }
}