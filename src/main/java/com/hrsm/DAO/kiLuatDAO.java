/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.kiLuat;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class kiLuatDAO extends HRSMDAO<kiLuat, String> {

    @Override
    public void insert(kiLuat entity) {
        String sql = "INSERT INTO KILUAT VALUES(?,?,?,?)";
        XJDBC.update(sql, entity.getMaNV(), entity.getLoaiViPham(), entity.getHinhThuc(), entity.getMoTa());
    }

    @Override
    public void update(kiLuat entity) {
        String sql = "UPDATE KILUAT SET LOAIVIPHAM = ?, HINHTHUC_KL = ?, MOTA = ? WHERE MANV = ?";
        XJDBC.update(sql, entity.getLoaiViPham(), entity.getHinhThuc(), entity.getMoTa(), entity.getMaNV());
    }

    @Override
    public void delete(kiLuat entity) {
        String sql = "DELETE FROM KILUAT WHERE MANV = ?";
        XJDBC.update(sql, entity);
    }

    @Override
    public List<kiLuat> selectAll() {
        String sql = "SELECT STT,NV.maNV,NV.hoTen,loaiViPham,hinhThuc_KL, moTa"
                + " FROM KILUAT KL "
                + " LEFT JOIN NHANVIEN NV ON NV.maNV = KL.maNV";
        return this.selectBySql(sql);
    }

    @Override
    public kiLuat selectById(String key) {
        String sql = "SELECT STT,NV.maNV as maNV,NV.hoTen as hoTen,loaiViPham,hinhThuc_KL, moTa"
                + " FROM KILUAT KL LEFT JOIN NHANVIEN NV ON NV.maNV = KL.maNV"
                + " WHERE NV.MANV = ?";
        List<kiLuat> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }
    public kiLuat selectBySTT(int key) {
        String sql = "SELECT STT,NV.maNV as maNV,NV.hoTen as hoTen,loaiViPham,hinhThuc_KL, moTa"
                + " FROM KILUAT KL LEFT JOIN NHANVIEN NV ON NV.maNV = KL.maNV"
                + " WHERE STT = ?";
        List<kiLuat> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<kiLuat> selectBySql(String sql, Object... args) {
        List<kiLuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    kiLuat entity = new kiLuat();
                    entity.setSTT(rs.getInt("STT"));
                    entity.setMaNV(rs.getString("maNV"));
                    entity.setHoTen(rs.getString("hoTen"));
                    entity.setLoaiViPham(rs.getString("loaiViPham"));
                    entity.setHinhThuc(rs.getString("hinhThuc_KL"));
                    entity.setMoTa(rs.getString("moTa"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void delete(String entity) {
        String sql = "DELETE FROM KILUAT WHERE MANV = ?";
        XJDBC.update(sql, entity);
    }

}
