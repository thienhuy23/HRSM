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
public class luong {
    private Integer STT;
    private String maNV;
    private String loaiViPham;
    private String tenNV;
    private Date thoiGianTinh;
    private Integer soNgayLam;
    private Integer soNgayNghi;
    private Integer soNgayTangCa;
    private Integer trachNhiem;
    private Integer thuong;
    private Double khautru;
    private Double tong;
    private Double luongCoBan;
    private Boolean trangThai;

    public Integer getSTT() {
        return STT;
    }

    public void setSTT(Integer STT) {
        this.STT = STT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiViPham() {
        return loaiViPham;
    }

    public void setLoaiViPham(String loaiViPham) {
        this.loaiViPham = loaiViPham;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getThoiGianTinh() {
        return thoiGianTinh;
    }

    public void setThoiGianTinh(Date thoiGianTinh) {
        this.thoiGianTinh = thoiGianTinh;
    }

    public Integer getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(Integer soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public Integer getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(Integer soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public Integer getSoNgayTangCa() {
        return soNgayTangCa;
    }

    public void setSoNgayTangCa(Integer soNgayTangCa) {
        this.soNgayTangCa = soNgayTangCa;
    }

    public Integer getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(Integer trachNhiem) {
        this.trachNhiem = trachNhiem;
    }

    public Integer getThuong() {
        return thuong;
    }

    public void setThuong(Integer thuong) {
        this.thuong = thuong;
    }

    public Double getKhautru() {
        return khautru;
    }

    public void setKhautru(Double khautru) {
        this.khautru = khautru;
    }

    public Double getTong() {
        return tong;
    }

    public void setTong(Double tong) {
        this.tong = tong;
    }

    public Double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(Double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
    @Override
    public String toString(){
        if(trangThai==true){
            return "Đã xử lí";
        } else {
            return "Đang xử lí";
        }
    }
}
