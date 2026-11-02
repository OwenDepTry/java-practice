package chuong1b;

import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi s: ");
        String s = sc.nextLine();

        // a. Do dai chuoi ban dau
        System.out.println("\na. Do dai cua s: " + s.length());

        // b. Xoa khoang trang thua
        s = s.trim().replaceAll("\\s+", " ");

        System.out.println("\nb. Chuoi sau khi xoa khoang trang thua: "
                + s);

        // c. Dem tu va xuat moi tu tren mot dong
        System.out.println("\nc. Dem va liet ke cac tu:");

        if (s.isEmpty()) {
            System.out.println("So tu: 0");
        } else {
            String[] cacTu = s.split(" ");

            System.out.println("So tu: " + cacTu.length);

            for (String tu : cacTu) {
                System.out.println(tu);
            }
        }

        // d. Lay k ky tu ben trai va ben phai
        System.out.print("\nd. Nhap so ky tu k: ");
        int k = sc.nextInt();

        if (k < 0 || k > s.length()) {
            System.out.println(
                    "k phai nam trong khoang 0 den " + s.length() + ".");
        } else {
            String benTrai = s.substring(0, k);
            String benPhai = s.substring(s.length() - k);

            System.out.println(k + " ky tu ben trai: " + benTrai);
            System.out.println(k + " ky tu ben phai: " + benPhai);
        }

        // e. Lay n ky tu ke tu vi tri k, vi tri tinh tu 1
        System.out.print("\ne. Nhap vi tri bat dau k (tinh tu 1): ");
        int viTri = sc.nextInt();

        System.out.print("Nhap so ky tu n can lay: ");
        int n = sc.nextInt();

        // Cho phep vi tri ngay sau cuoi chuoi neu n = 0
        if (viTri < 1 || (long) viTri > (long) s.length() + 1) {
            System.out.println("Vi tri bat dau khong hop le.");
        } else {
            int batDau = viTri - 1;

            if (n < 0 || n > s.length() - batDau) {
                System.out.println("So ky tu can lay khong hop le.");
            } else {
                String ketQua = s.substring(batDau, batDau + n);
                System.out.println("Chuoi ket qua: " + ketQua);
            }
        }

        sc.close();
    }
}