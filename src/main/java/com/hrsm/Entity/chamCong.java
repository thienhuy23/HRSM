/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class chamCong {

    public String tennv;
    public String manv;
    public Date ngaychamcong;
    public int thoigianlam;
    public int giotangca;

    public chamCong() {
    }

    public chamCong(String tennv, String manv, Date ngaychamcong, int thoigianlam, int giotangca) {
        this.tennv = tennv;
        this.manv = manv;
        this.ngaychamcong = ngaychamcong;
        this.thoigianlam = thoigianlam;
        this.giotangca = giotangca;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public Date getNgaychamcong() {
        return ngaychamcong;
    }

    public void setNgaychamcong(Date ngaychamcong) {
        this.ngaychamcong = ngaychamcong;
    }

    public int getThoigianlam() {
        return thoigianlam;
    }

    public void setThoigianlam(int thoigianlam) {
        this.thoigianlam = thoigianlam;
    }

    public int getGiotangca() {
        return giotangca;
    }

    public void setGiotangca(int giotangca) {
        this.giotangca = giotangca;
    }

   
}
