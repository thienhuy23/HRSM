/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.nguoiDung;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class nguoiDungDAO extends HRSMDAO<nguoiDung, String> {

    @Override
    public void insert(nguoiDung model) {
        String sql = "INSERT INTO NGUOIDUNG VALUES(?,?,?)";
        XJDBC.update(sql, model.getTaiKhoan(), model.getMatKhau(), model.getVaiTro());
    }

    @Override
    public void update(nguoiDung model) {
        String sql = "UPDATE NGUOIDUNG SET passwords = ? WHERE username = ?";
        XJDBC.update(sql, model.getMatKhau(),model.getTaiKhoan());
    }

    @Override
    public void delete(nguoiDung maNV) {
        String sql = "DELETE FROM NGUOIDUNG WHERE username = ?";
        XJDBC.update(sql, maNV);
    }

    @Override
    public List<nguoiDung> selectAll() {
        String sql = "SELECT HOTEN, USERNAME, PASSWORDS, VAITRO"
                + " FROM NGUOIDUNG ND LEFT JOIN NHANVIEN NV ON ND.USERNAME = NV.MANV";
        return this.selectBySql(sql);
    }

    @Override
    public nguoiDung selectById(String USERNAME) {
        String sql = "SELECT HOTEN, USERNAME, PASSWORDS, VAITRO"
                + " FROM NGUOIDUNG ND LEFT JOIN NHANVIEN NV ON ND.USERNAME = NV.MANV"
                + " WHERE USERNAME = ?";
        List<nguoiDung> list = this.selectBySql(sql, USERNAME);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<nguoiDung> selectBySql(String sql, Object... args) {
        List<nguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    nguoiDung entity = new nguoiDung();
                    entity.setHoTen(rs.getString("hoTen"));
                    entity.setTaiKhoan(rs.getString("Username"));
                    entity.setMatKhau(rs.getString("Passwords"));
                    entity.setVaiTro(rs.getBoolean("vaiTro"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.toString();
        }
        return list;
    }

    public void delete(String manv) {
        String sql = "DELETE FROM NGUOIDUNG WHERE USERNAME = ?";
        XJDBC.update(sql, manv);
    }
}
