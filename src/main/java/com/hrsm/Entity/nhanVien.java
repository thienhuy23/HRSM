/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.Entity;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class nhanVien {

    private String maNV;
    private String hoTen;
    private String CMND;
    private String email;
    private String diaChi;
    private String soDT;
    private String loaiHinh_LV;
    private String quocTich;
    private String trangThai;
    private String hinhAnh;
    private String maPB;
    private String tenPB;
    private Boolean gioiTinh;
    private Boolean chucVu;
    private Date ngaySinh;
    private Date ngayLV;

    @Override
    public String toString() {
        return loaiHinh_LV;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayLV() {
        return ngayLV;
    }

    public void setNgayLV(Date ngayLV) {
        this.ngayLV = ngayLV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getLoaiHinh_LV() {
        return loaiHinh_LV;
    }

    public void setLoaiHinh_LV(String loaiHinh_LV) {
        this.loaiHinh_LV = loaiHinh_LV;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Boolean getChucVu() {
        return chucVu;
    }

    public void setChucVu(Boolean chucVu) {
        this.chucVu = chucVu;
    }

}
