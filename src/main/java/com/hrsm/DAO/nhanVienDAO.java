/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.nhanVien;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class nhanVienDAO extends HRSMDAO<nhanVien, String> {

    @Override
    public void insert(nhanVien model) {
        String sql = "INSERT INTO NHANVIEN VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        XJDBC.update(sql,
                model.getMaNV(),
                model.getHoTen(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getCMND(),
                model.getEmail(),
                model.getDiaChi(),
                model.getSoDT(),
                model.getChucVu(), 
                model.getLoaiHinh_LV(), 
                model.getQuocTich(), 
                model.getTrangThai(), 
                model.getMaPB(), 
                model.getHinhAnh(), 
                model.getNgayLV());
    }

    @Override
    public void update(nhanVien model) {
        String sql = "UPDATE NHANVIEN SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, CMND = ?, EMAIL = ?, DIACHI = ?, SODT = ?, CHUCVU = ?, LOAIHINH_LV = ?, QUOCTICH = ?, TRANGTHAI = ?, MAPB = ?, HINH = ?, NGAYBDLV = ? WHERE MANV = ?";
        XJDBC.update(sql, 
                model.getHoTen(), 
                model.getGioiTinh(), 
                model.getNgaySinh(), 
                model.getCMND(), 
                model.getEmail(), 
                model.getDiaChi(), 
                model.getSoDT(), 
                model.getChucVu(), 
                model.getLoaiHinh_LV(), 
                model.getQuocTich(), 
                model.getTrangThai(), 
                model.getMaPB(), 
                model.getHinhAnh(), 
                model.getNgayLV(), 
                model.getMaNV());
    }

    @Override
    public void delete(nhanVien maNV) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
        XJDBC.update(sql, maNV);
    }

    @Override
    public List<nhanVien> selectAll() {
        String sql = "SELECT * FROM NHANVIEN;";
        return this.selectBySql(sql);
    }

    @Override
    public nhanVien selectById(String key) {
        String sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";
        List<nhanVien> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    protected List<nhanVien> selectBySql(String sql, Object... args) {
        List<nhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    nhanVien entity = new nhanVien();
                    entity.setMaNV(rs.getString("MANV"));
                    entity.setHoTen(rs.getString("HOTEN"));
                    entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                    entity.setNgaySinh(rs.getDate("NGAYSINH"));
                    entity.setCMND(rs.getString("CMND"));
                    entity.setEmail(rs.getString("EMAIL"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setSoDT(rs.getString("SODT"));
                    entity.setChucVu(rs.getBoolean("CHUCVU"));
                    entity.setLoaiHinh_LV(rs.getString("LOAIHINH_LV"));
                    entity.setQuocTich(rs.getString("QUOCTICH"));
                    entity.setTrangThai(rs.getString("TRANGTHAI"));
                    entity.setMaPB(rs.getString("MAPB"));
                    entity.setHinhAnh(rs.getString("HINH"));
                    entity.setNgayLV(rs.getDate("NGAYBDLV"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(String maNV) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
        XJDBC.update(sql, maNV);
    }

    public nhanVien selectByID(String b) {
        String sql = "SELECT maNV,hoTen,tenPB,gioiTinh,ngaySinh,cmnd,email,diaChi,SoDT,chucVu,loaiHinh_LV,quocTich,trangThai,Hinh "
                + "FROM nhanvien NV  "
                + "LEFT JOIN PHONGBAN PB ON PB.maPB = NV.maPB "
                + "WHERE manv= ?";
        List<nhanVien> list = this.selectBySqls(sql, b);
        return !list.isEmpty() ? list.get(0) : null;
    }

    protected List<nhanVien> selectBySqls(String sql, Object... args) {
        List<nhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    nhanVien entity = new nhanVien();
                    entity.setMaNV(rs.getString("MANV"));
                    entity.setHoTen(rs.getString("HOTEN"));
                    entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                    entity.setNgaySinh(rs.getDate("NGAYSINH"));
                    entity.setCMND(rs.getString("CMND"));
                    entity.setEmail(rs.getString("EMAIL"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setSoDT(rs.getString("SODT"));
                    entity.setChucVu(rs.getBoolean("CHUCVU"));
                    entity.setLoaiHinh_LV(rs.getString("LOAIHINH_LV"));
                    entity.setQuocTich(rs.getString("QUOCTICH"));
                    entity.setTrangThai(rs.getString("TRANGTHAI"));
                    entity.setTenPB(rs.getString("TENPB"));
                    entity.setHinhAnh(rs.getString("HINH"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> selectStatus() {
        String sql = "select distinct trangthai from nhanvien";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getString("trangThai"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
