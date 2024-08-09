DROP TABLE Student;
CREATE TABLE student(
    id INT AUTO_INCREMENT primary key,
    name nvarchar(50) not null,
    age int not null,
    street nvarchar(200),
    district nvarchar(100),
    major nvarchar(50) not null,
    phone varchar(25) not null,
    gpa double not null
);

INSERT INTO student (name, age, street, district, major, phone, gpa)
VALUES 
('Nguyễn Thị Lan', 20, '123 Đường Trần Duy Hưng', 'Quận Cầu Giấy', 'Công nghệ thông tin', '0912345678', 0.8),
('Phạm Văn Hùng', 21, '456 Đường Kim Mã', 'Quận Ba Đình', 'Kinh tế', '0987654321', 0.9),
('Lê Thị Hòa', 22, '789 Đường Phạm Văn Đồng', 'Quận Bắc Từ Liêm', 'Quản trị kinh doanh', '0901234567', 1.5),
('Vũ Văn Nam', 19, '12 Đường Nguyễn Trãi', 'Quận Thanh Xuân', 'Kế toán', '0934567890', 1.8),
('Hoàng Thị Hà', 20, '34 Đường Nguyễn Chí Thanh', 'Quận Đống Đa', 'Y dược', '0910987654', 1.9),
('Ngô Văn Bình', 21, '56 Đường Láng Hạ', 'Quận Ba Đình', 'Marketing', '0976543210', 2.3),
('Trần Thị Mai', 22, '78 Đường Lê Đức Thọ', 'Quận Nam Từ Liêm', 'Ngôn ngữ Anh', '0908765432', 2.7),
('Đỗ Văn Khánh', 19, '90 Đường Giảng Võ', 'Quận Ba Đình', 'Tài chính', '0923456789', 2.9),
('Bùi Thị Liên', 20, '123 Đường Xã Đàn', 'Quận Đống Đa', 'Luật', '0912345670', 3.2),
('Nguyễn Văn Sơn', 21, '456 Đường Hoàng Quốc Việt', 'Quận Cầu Giấy', 'Báo chí', '0987654322', 3.6);


