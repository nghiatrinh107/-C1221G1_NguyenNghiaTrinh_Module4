package com.codegym.model;

public class ToKhaiYTe {
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private String quocTich;
    private String cmnd;
    private String diLai;
    private String bsx;
    private String soGhe;
    private String ngayKhoiHang;
    private String ngayKetThuc;

    public ToKhaiYTe() {
    }

    public ToKhaiYTe(String ten, String ngaySinh, String gioiTinh, String quocTich, String cmnd, String diLai, String bsx, String soGhe, String ngayKhoiHang, String ngayKetThuc) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.diLai = diLai;
        this.bsx = bsx;
        this.soGhe = soGhe;
        this.ngayKhoiHang = ngayKhoiHang;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiLai() {
        return diLai;
    }

    public void setDiLai(String diLai) {
        this.diLai = diLai;
    }

    public String getBsx() {
        return bsx;
    }

    public void setBsx(String bsx) {
        this.bsx = bsx;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHang() {
        return ngayKhoiHang;
    }

    public void setNgayKhoiHang(String ngayKhoiHang) {
        this.ngayKhoiHang = ngayKhoiHang;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
