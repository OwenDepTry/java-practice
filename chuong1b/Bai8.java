package chuong1b;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chieu cao tam giac: ");
        int h = sc.nextInt();

        if (h <= 0) {
            System.out.println("Chieu cao phai lon hon 0.");
        } else {
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }

                System.out.println();
            }
        }

        sc.close();
    }
}