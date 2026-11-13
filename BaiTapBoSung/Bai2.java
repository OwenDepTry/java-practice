package BaiTapBoSung;

import java.util.Scanner;

// Bài 2: Shape, Circle, Square, giao diện Resizable, ResizableCircle, ResizableSquare
// Sơ đồ vẽ nét đứt từ Circle/Square tới Shape (quan hệ hiện thực) nên Shape là interface.
interface Shape {
    double getPerimeter();
    double getArea();
}

interface Resizable {
    void resize(int percent);
}

class Circle implements Shape {
    protected double radius = 1.0;

    public Circle(double radius) {
        if (radius > 0) this.radius = radius;
    }

    public double getRadius() { return radius; }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius = %.2f, P = %.2f, S = %.2f]",
                radius, getPerimeter(), getArea());
    }
}

class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    // percent = 100: giữ nguyên, 50: nhỏ đi một nửa, 150: lớn gấp rưỡi
    @Override
    public void resize(int percent) {
        if (percent <= 0) {
            System.out.println("percent phai > 0.");
            return;
        }
        radius = radius * percent / 100.0;
        System.out.printf("Sau khi resize %d%%: chu vi = %.2f, dien tich = %.2f%n",
                percent, getPerimeter(), getArea());
    }
}

class Square implements Shape {
    protected double side = 1.0;

    public Square(double side) {
        if (side > 0) this.side = side;
    }

    public double getSide() { return side; }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return String.format("Square[side = %.2f, P = %.2f, S = %.2f]",
                side, getPerimeter(), getArea());
    }
}

class ResizableSquare extends Square implements Resizable {
    public ResizableSquare(double side) {
        super(side);
    }

    @Override
    public void resize(int percent) {
        if (percent <= 0) {
            System.out.println("percent phai > 0.");
            return;
        }
        side = side * percent / 100.0;
        System.out.printf("Sau khi resize %d%%: chu vi = %.2f, dien tich = %.2f%n",
                percent, getPerimeter(), getArea());
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Câu 1 và 3: Circle, Square qua biến kiểu Shape
        Shape[] hinh = { new Circle(2), new Square(3) };
        for (Shape s : hinh) {
            System.out.println(s);
        }

        // Câu 2 và 3: ResizableCircle, ResizableSquare
        System.out.println();
        ResizableCircle rc = new ResizableCircle(NhapLieu.soDuong(sc, "Nhap ban kinh hinh tron: "));
        ResizableSquare rs = new ResizableSquare(NhapLieu.soDuong(sc, "Nhap canh hinh vuong: "));
        System.out.println(rc);
        System.out.println(rs);

        int percent = NhapLieu.soNguyen(sc, "Nhap percent (> 0): ", 1, 10000);

        Resizable[] coTheDoi = { rc, rs };
        for (Resizable r : coTheDoi) {
            r.resize(percent);
        }

        sc.close();
    }
}
