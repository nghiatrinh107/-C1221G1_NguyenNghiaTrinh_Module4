<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
</head>
<body>
<center>
    <h2>TỜ KHAI Y TẾ</h2>
    <h3>TÀI LIỆU QUAN TRỌNG</h3>
</center>
    <h4 style="color: red">Khuyến cáo:</h4>
<form:form action="" method="post" modelAttribute="toKhai">
    <div>
        <span>Họ tên (ghi chữ IN HOA)<span style="color: red">(*)</span></span> <br>
        <form:input type="text" path="ten"/>
    </div>
    <div>
        <ul>
            <li>
                <span>Năm sinh<span style="color: red">(*)</span></span> <br>
                <form:input type="date" name="date" path="ngaySinh" />
            </li>
            <li>
                <span>Giới tính<span style="color: red">(*)</span></span> <br>
                <form:select  path="gioiTinh">
                    <form:option value="none">--Chọn--</form:option>
                    <form:option value="nam">Nam</form:option>
                    <form:option value="nữ">Nữ</form:option>
                </form:select>
            </li>
            <li>
                <span>Quốc Tịch<span style="color: red">(*)</span></span> <br>
                <form:select  path="quocTich">
                    <form:option value="none">--Chọn--</form:option>
                    <form:option value="việt nam">Việt Nam</form:option>
                    <form:option value="khác">Khác</form:option>
                </form:select>
            </li>
        </ul>
    </div>
    <div>
        <span>Số hộ chiếu hoặc số cmnd hoặc giấy thông hành hợp pháp khác<span style="color: red">(*)</span></span>
        <form:input type="number" path="cmnd"/>
    </div>
    <div>
        <span>Thông tin đi lại<span style="color: red">(*)</span></span>
        <div>
            <form:radiobutton path="diLai"/><label>Tàu bay</label>

            <form:radiobutton path="diLai"/><label>Tàu Thuyền</label>

            <form:radiobutton path="diLai"/><label>Ô tô</label>

            <form:radiobutton path="diLai"/><label>Khác</label>
        </div>
    </div>
    <div>
        <div>
            <span>Sô hiệu phương tiện</span> <br>
            <form:input type="text"  placeholder="abc-123" path="bsx" />
        </div>
        <div>
            <span>Số ghế</span> <br>
            <form:input type="number"  path="soGhe" />
        </div>
    </div>
    <div>
        <div>
            <span>Ngày khởi hành</span> <br>
            <form:input type="date"  path="ngayKhoiHang"/>
        </div><div>
        <span>Ngày kkết thúc</span> <br>
        <form:input type="date"  path="ngayKetThuc"/>
    </div>
    </div>
    <input type="submit" value="Gửi tờ khai">
</form:form>

</body>
</html>
