# Java Practice

**Luyện giải bài tập Java và thực hành lập trình hướng đối tượng.**

Repository lưu lại quá trình thực hành Java của **Phan Tiến Đạt**, từ các bài toán với điều kiện, vòng lặp, mảng và chuỗi đến các nội dung về lớp và đối tượng. Mã nguồn và tài liệu được tổ chức theo từng chương để thuận tiện theo dõi, chạy thử và ôn tập.

## Nội dung

| Phần | Chủ đề | Hiện có |
|---|---|---|
| [Chương 1A](./chuong1a/) | Nhập xuất và tính toán | 3 bài giải Java và đề bài PDF |
| [Chương 1B](./chuong1b/) | Điều kiện, vòng lặp, mảng và chuỗi | 10 bài giải Java và đề bài PDF |
| [Chương 2](./Chuong2/) | Lập trình hướng đối tượng | Tài liệu PDF |
| [Chương 3](./Chuong3/) | Lớp và đối tượng | Tài liệu PDF |

### Chương 1A · Nhập xuất và tính toán

| Bài | Nội dung |
|---|---|
| [Bài 1](./chuong1a/Bai1.java) | Nhập hai số nguyên, tính tổng, hiệu, tích và thương |
| [Bài 2](./chuong1a/Bai2.java) | Tính chu vi và diện tích hình chữ nhật |
| [Bài 3](./chuong1a/Bai3.java) | Tính chu vi và diện tích hình tròn |

📄 [Xem đề bài Chương 1A](./chuong1a/Chuong01a.pdf)

### Chương 1B · Điều kiện, vòng lặp, mảng và chuỗi

| Bài | Nội dung |
|---|---|
| [Bài 1](./chuong1b/Bai1.java) | Phân loại số nguyên: âm, bằng 0 hoặc dương |
| [Bài 2](./chuong1b/Bai2.java) | Tìm số nhỏ nhất trong ba số nguyên |
| [Bài 3](./chuong1b/Bai3.java) | Kiểm tra số nguyên tố |
| [Bài 4](./chuong1b/Bai4.java) | Liệt kê và tính tổng các nhóm số; xuất N số nguyên tố đầu tiên |
| [Bài 5](./chuong1b/Bai5.java) | Kiểm tra năm nhuận |
| [Bài 6](./chuong1b/Bai6.java) | Phân loại ký tự: nguyên âm, phụ âm hoặc không phải chữ tiếng Anh |
| [Bài 7](./chuong1b/Bai7.java) | Chuyển số tháng sang tên tháng tiếng Anh |
| [Bài 8](./chuong1b/Bai8.java) | In tam giác dấu sao theo chiều cao nhập vào |
| [Bài 9](./chuong1b/Bai9.java) | Nhập, xuất, lọc, tính tổng, thêm, xoá và tìm kiếm phần tử trong mảng |
| [Bài 10](./chuong1b/Bai10.java) | Tính độ dài chuỗi, chuẩn hoá khoảng trắng, đếm từ và trích xuất chuỗi con |

📄 [Xem đề bài Chương 1B](./chuong1b/Chuong01b.pdf)

### Chương 2 và Chương 3 · Lập trình hướng đối tượng

Hai chương hiện có tài liệu PDF; mã nguồn thực hành sẽ được bổ sung trong quá trình học.

- [Chương 2: Lập trình hướng đối tượng](./Chuong2/Chuong2_OOP.pdf)
- [Chương 3: Lớp và đối tượng](./Chuong3/Chuong03_LopVaDoiTuong.pdf)

## Môi trường sử dụng

- **Java Development Kit (JDK)** để biên dịch và chạy chương trình.
- **Visual Studio Code** để viết và quản lý mã nguồn.
- **Git và GitHub** để theo dõi thay đổi.

Các bài tập hiện tại sử dụng thư viện chuẩn Java, không cần cài thêm thư viện ngoài.

## Hướng dẫn chạy

### 1. Kiểm tra JDK

Mở Terminal và chạy:

```bash
java -version
javac -version
```

Cả hai lệnh cần hiển thị phiên bản. Nếu Terminal chưa nhận lệnh, hãy kiểm tra việc cài đặt JDK và cấu hình `PATH`.

### 2. Lấy mã nguồn

```bash
git clone https://github.com/OwenDepTry/java-practice.git
cd java-practice
```

### 3. Biên dịch và thực thi

Chạy các lệnh từ thư mục gốc `java-practice`.

**Ví dụ: Bài 1, Chương 1A**

```bash
javac -encoding UTF-8 chuong1a/Bai1.java
java chuong1a.Bai1
```

**Ví dụ: Bài 9, Chương 1B**

```bash
javac -encoding UTF-8 chuong1b/Bai9.java
java chuong1b.Bai9
```

Thay tên thư mục và tên lớp tương ứng để chạy bài khác. Khi chương trình yêu cầu dữ liệu, nhập trực tiếp trong Terminal.

### Chạy bằng VS Code

1. Mở thư mục `java-practice` trong VS Code.
2. Cài **Extension Pack for Java** nếu chưa có môi trường hỗ trợ Java.
3. Mở file bài tập cần chạy và lưu các thay đổi.
4. Chọn **Run** phía trên hàm `main`, sau đó nhập dữ liệu trong Terminal.

> Tên file phải trùng với tên lớp `public`, kể cả chữ hoa và chữ thường. Ví dụ: lớp `Bai9` được lưu trong `Bai9.java`. Các file thuộc thư mục `chuong1b` sử dụng khai báo `package chuong1b;`.

## Quy ước tổ chức

- Mỗi chương có một thư mục riêng; tài liệu PDF được đặt trong thư mục tương ứng.
- Mỗi bài giải nằm trong một file Java và có hàm `main` để chạy độc lập.
- Tên lớp theo dạng `Bai1`, `Bai2`, … để đối chiếu với đề bài.
- Mã nguồn tiếp tục được bổ sung và chỉnh sửa trong quá trình thực hành.

## Tác giả

**Phan Tiến Đạt**  
Sinh viên Công nghệ thông tin · Trường Đại học Sài Gòn  
GitHub: [@OwenDepTry](https://github.com/OwenDepTry)
