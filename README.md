# Java Practice

> Luyện giải bài tập Java và thực hành lập trình hướng đối tượng.

Repository lưu lại quá trình học Java của **Phan Tiến Đạt**: từ nhập xuất, điều kiện, vòng lặp, mảng và chuỗi đến lớp, đối tượng, kế thừa và đa hình. Mỗi chương có một thư mục riêng gồm đề bài (PDF) và các bài giải có thể chạy độc lập.

## Mục lục

| Chương | Chủ đề | Bài giải | Tài liệu |
|---|---|:---:|---|
| [Chương 1A](./Chuong1a/) | Nhập xuất và tính toán | 3 | [Chuong01a.pdf](./Chuong1a/Chuong01a.pdf) |
| [Chương 1B](./Chuong1b/) | Điều kiện, vòng lặp, mảng và chuỗi | 10 | [Chuong01b.pdf](./Chuong1b/Chuong01b.pdf) |
| [Chương 2](./Chuong2/) | Tổng quan lập trình hướng đối tượng | — | [Chuong2_OOP.pdf](./Chuong2/Chuong2_OOP.pdf) |
| [Chương 3](./Chuong3/) | Lớp và đối tượng | 4 | [Chuong03_LopVaDoiTuong.pdf](./Chuong3/Chuong03_LopVaDoiTuong.pdf) |
| [Chương 4](./Chuong4/) | Kế thừa | — | [Chuong04_KeThua.pdf](./Chuong4/Chuong04_KeThua.pdf) |
| [Chương 5](./Chuong5/) | Tính đa hình | — | [Chuong05_TinhDaHinh.pdf](./Chuong5/Chuong05_TinhDaHinh.pdf) |

`—`: chương mới có tài liệu, bài giải sẽ được bổ sung trong quá trình học.

## Chi tiết bài giải

### Chương 1A · Nhập xuất và tính toán

| Bài | Nội dung |
|---|---|
| [Bài 1](./Chuong1a/Bai1.java) | Nhập hai số nguyên, tính tổng, hiệu, tích và thương |
| [Bài 2](./Chuong1a/Bai2.java) | Tính chu vi và diện tích hình chữ nhật |
| [Bài 3](./Chuong1a/Bai3.java) | Tính chu vi và diện tích hình tròn |

### Chương 1B · Điều kiện, vòng lặp, mảng và chuỗi

| Bài | Nội dung |
|---|---|
| [Bài 1](./Chuong1b/Bai1.java) | Phân loại số nguyên: âm, bằng 0 hoặc dương |
| [Bài 2](./Chuong1b/Bai2.java) | Tìm số nhỏ nhất trong ba số nguyên |
| [Bài 3](./Chuong1b/Bai3.java) | Kiểm tra số nguyên tố |
| [Bài 4](./Chuong1b/Bai4.java) | Liệt kê và tính tổng các nhóm số; xuất N số nguyên tố đầu tiên |
| [Bài 5](./Chuong1b/Bai5.java) | Kiểm tra năm nhuận |
| [Bài 6](./Chuong1b/Bai6.java) | Phân loại ký tự: nguyên âm, phụ âm hoặc không phải chữ cái tiếng Anh |
| [Bài 7](./Chuong1b/Bai7.java) | Chuyển số tháng sang tên tháng tiếng Anh |
| [Bài 8](./Chuong1b/Bai8.java) | In tam giác dấu sao theo chiều cao nhập vào |
| [Bài 9](./Chuong1b/Bai9.java) | Nhập, xuất, lọc, tính tổng, thêm, xoá và tìm kiếm phần tử trong mảng |
| [Bài 10](./Chuong1b/Bai10.java) | Tính độ dài chuỗi, chuẩn hoá khoảng trắng, đếm từ và trích xuất chuỗi con |

### Chương 3 · Lớp và đối tượng

Mỗi lớp có thuộc tính `private`, getter/setter, hàm thiết lập có và không có tham số, cùng các phương thức nhập/xuất.

| Bài | Lớp | Nội dung |
|---|---|---|
| [Bài 1](./Chuong3/Bai1.java) | `Diem` | Toạ độ x, y; di chuyển điểm theo (x', y') |
| [Bài 2](./Chuong3/Bai2.java) | `HinhChuNhat` | Chiều dài, chiều rộng; tính diện tích và chu vi |
| [Bài 3](./Chuong3/Bai3.java) | `HinhTron` | Bán kính; tính diện tích và chu vi |
| [Bài 4](./Chuong3/Bai4.java) | `SinhVien` | Mã SV, họ tên, lớp, điểm 3 môn; tính điểm trung bình và xếp loại |

## Cấu trúc thư mục

```text
java-practice/
├── Chuong1a/      # package Chuong1a — Bai1.java … Bai3.java
├── Chuong1b/      # package Chuong1b — Bai1.java … Bai10.java
├── Chuong2/       # tài liệu PDF
├── Chuong3/       # package Chuong3  — Bai1.java … Bai4.java
├── Chuong4/       # tài liệu PDF
├── Chuong5/       # tài liệu PDF
└── README.md
```

## Hướng dẫn chạy

### Yêu cầu

- **JDK** (Java Development Kit) để biên dịch và chạy chương trình.
- **Visual Studio Code** với **Extension Pack for Java** (tuỳ chọn).
- Chỉ dùng thư viện chuẩn của Java, không cần cài thêm gì.

Kiểm tra JDK đã sẵn sàng:

```bash
java -version
javac -version
```

Nếu Terminal không nhận lệnh, kiểm tra lại việc cài JDK và biến môi trường `PATH`.

### Lấy mã nguồn

```bash
git clone https://github.com/OwenDepTry/java-practice.git
cd java-practice
```

### Biên dịch và chạy bằng Terminal

Luôn chạy lệnh từ thư mục gốc `java-practice`. Cú pháp chung:

```bash
javac -encoding UTF-8 <ThuMuc>/<TenBai>.java
java <ThuMuc>.<TenBai>
```

Ví dụ:

```bash
# Chương 1A – Bài 1
javac -encoding UTF-8 Chuong1a/Bai1.java
java Chuong1a.Bai1

# Chương 3 – Bài 4 (lớp SinhVien)
javac -encoding UTF-8 Chuong3/Bai4.java
java Chuong3.Bai4
```

Khi chương trình yêu cầu dữ liệu, nhập trực tiếp trong Terminal.

### Chạy bằng VS Code

1. Mở thư mục `java-practice` trong VS Code.
2. Cài **Extension Pack for Java** nếu chưa có.
3. Mở file bài tập cần chạy.
4. Bấm **Run** phía trên hàm `main`, sau đó nhập dữ liệu trong Terminal.

## Quy ước

- Mỗi chương là một thư mục `ChuongX` và cũng là một `package` cùng tên, ví dụ `package Chuong3;`.
- Mỗi bài nằm trong file `BaiN.java` với lớp `public class BaiN` chứa hàm `main`, để đối chiếu nhanh với đề bài.
- Ở các chương hướng đối tượng, lớp chính của đề (như `Diem`, `SinhVien`) được khai báo trong cùng file, lớp `BaiN` dùng để chạy thử.
- Tên file phải trùng tên lớp `public`, kể cả chữ hoa và chữ thường.

## Tác giả

**Phan Tiến Đạt**<br>
Sinh viên Công nghệ thông tin · Trường Đại học Sài Gòn<br>
GitHub: [@OwenDepTry](https://github.com/OwenDepTry)
