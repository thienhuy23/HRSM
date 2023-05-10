/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.Entity;

/**
 *
 * @author lenovo
 */
public class kiLuat {

    private Integer STT;
    private String maNV;
    private String hoTen;
    private String loaiViPham;
    private String hinhThuc;
    private String moTa;

    @Override
    public String toString() {
        return this.hinhThuc;
    }

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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLoaiViPham() {
        return loaiViPham;
    }

    public void setLoaiViPham(String loaiViPham) {
        this.loaiViPham = loaiViPham;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
