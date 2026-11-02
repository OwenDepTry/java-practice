package chuong1b;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap nam: ");
        int nam = sc.nextInt();

        if (nam <= 0) {
            System.out.println("Nam phai lon hon 0.");
        } else if (nam % 400 == 0
                || (nam % 4 == 0 && nam % 100 != 0)) {
            System.out.println(nam + " la nam nhuan.");
        } else {
            System.out.println(nam + " khong phai nam nhuan.");
        }

        sc.close();
    }
}