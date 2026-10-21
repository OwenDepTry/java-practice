package chuong1b;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap mot ky tu: ");
        String chuoi = sc.nextLine();

        if (chuoi.length() != 1) {
            System.out.println("Vui long chi nhap mot ky tu.");
        } else {
            char kyTu = chuoi.charAt(0);

            if ((kyTu >= 'a' && kyTu <= 'z')
                    || (kyTu >= 'A' && kyTu <= 'Z')) {

                char chuThuong = Character.toLowerCase(kyTu);

                if (chuThuong == 'a' || chuThuong == 'e'
                        || chuThuong == 'i' || chuThuong == 'o'
                        || chuThuong == 'u') {
                    System.out.println(kyTu + " la nguyen am.");
                } else {
                    System.out.println(kyTu + " la phu am.");
                }
            } else {
                System.out.println(
                        kyTu + " khong phai ky tu chu tieng Anh.");
            }
        }

        sc.close();
    }
}