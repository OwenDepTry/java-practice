# Java Practice

Kho lưu trữ các bài tập luyện lập trình Java của **Phan Tiến Đạt**, được tổ chức theo từng chương và chủ đề.

Mục tiêu là rèn luyện kỹ năng giải bài toán, củng cố cách sử dụng Java và duy trì quá trình thực hành thông qua mã nguồn có thể biên dịch, chạy và kiểm tra độc lập.

## Công nghệ sử dụng

- **Ngôn ngữ:** Java
- **Môi trường phát triển:** Visual Studio Code
- **Quản lý phiên bản:** Git và GitHub

## Nội dung hiện có

| Phần | Nội dung |
|---|---|
| [Chương 1A](./chuong1a/) | Nhập xuất dữ liệu, phép toán số học, tính chu vi và diện tích |
| [Chương 1B](./chuong1b/) | Câu lệnh điều kiện, vòng lặp, kiểm tra số nguyên tố và tính tổng |

### Chương 1A — Nhập xuất và tính toán

| Bài | Yêu cầu |
|---|---|
| [Bài 1](./chuong1a/Bai1.java) | Tính tổng, hiệu, tích và thương của hai số nguyên |
| [Bài 2](./chuong1a/Bai2.java) | Tính chu vi và diện tích hình chữ nhật |
| [Bài 3](./chuong1a/Bai3.java) | Tính chu vi và diện tích hình tròn |

📄 [Đề bài Chương 1A](./chuong1a/Chuong01a.pdf)

### Chương 1B — Điều kiện và vòng lặp

| Bài | Yêu cầu |
|---|---|
| [Bài 1](./chuong1b/Bai1.java) | Kiểm tra số nguyên là số âm, số 0 hay số dương |
| [Bài 2](./chuong1b/Bai2.java) | Tìm số nhỏ nhất trong ba số nguyên |
| [Bài 3](./chuong1b/Bai3.java) | Kiểm tra số nguyên tố |
| [Bài 4](./chuong1b/Bai4.java) | Liệt kê, tính tổng các nhóm số và tìm N số nguyên tố đầu tiên |

📄 [Đề bài Chương 1B](./chuong1b/Chuong01b.pdf)

## Cách chạy

### 1. Chuẩn bị

Cài đặt **JDK** và kiểm tra bằng Terminal:

```bash
java -version
javac -version
```

### 2. Clone repository

```bash
git clone https://github.com/OwenDepTry/java-practice.git
cd java-practice
```

### 3. Biên dịch và chạy

Thực hiện các lệnh từ thư mục gốc `java-practice`.

Ví dụ, chạy Bài 1 của Chương 1A:

```bash
javac chuong1a/Bai1.java
java chuong1a.Bai1
```

Chạy Bài 4 của Chương 1B:

```bash
javac chuong1b/Bai4.java
java chuong1b.Bai4
```

Thay tên chương và tên lớp tương ứng để chạy các bài khác.

> Tên file phải trùng với tên lớp `public`, có phân biệt chữ hoa và chữ thường. Khai báo `package` phải phù hợp với thư mục chứa mã nguồn.

## Quy ước tổ chức

- Mỗi chương được lưu trong một thư mục riêng.
- Mỗi bài tập được triển khai trong một file Java riêng.
- Tên lớp sử dụng dạng `Bai1`, `Bai2`, `Bai3`, …
- Đề bài PDF được đặt cùng thư mục với lời giải.
- Các bài tập sẽ được bổ sung và chỉnh sửa trong quá trình luyện tập.

## Tác giả

**Phan Tiến Đạt**  
Sinh viên ngành Công nghệ thông tin — Trường Đại học Sài Gòn  
GitHub: [@OwenDepTry](https://github.com/OwenDepTry)
