/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import Entity.chamCong;
import com.hrsm.DAO.HRSMDAO;
import com.hrsm.Utils.XJDBC;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class chamCongDAO extends HRSMDAO<chamCong, String> {

    @Override
    public void insert(chamCong entity) {
        String sql = "INSERT INTO ChamCong VALUES (?, ?, ?, ?)";
        XJDBC.update(sql,
                entity.getManv(),
                entity.getNgaychamcong(),
                entity.getThoigianlam(),
                entity.getGiotangca());
    }

    @Override
    public void update(chamCong entity) {
    }

    @Override
    public chamCong selectById(String id) {
        String sql = "SELECT C.MANV,NV.hoTen,C.NGAY_cc,C.THOIGIANLAM,C.GIOTANGCA\n"
                + "FROM CHAMCONG C\n"
                + "LEFT JOIN NHANVIEN NV ON NV.maNV = C.MANV"
                + " WHERE C.maNV = ?";
        List<chamCong> list = this.selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<chamCong> selectAll() {
        String sql = "SELECT C.MANV,NV.hoTen,C.NGAY_cc,C.THOIGIANLAM,C.GIOTANGCA\n"
                + "FROM CHAMCONG C\n"
                + "LEFT JOIN NHANVIEN NV ON NV.maNV = C.MANV";
        return this.selectBySql(sql);
    }

    public List<chamCong> selectByMaNV(String id) {
        String sql = "SELECT C.MANV,NV.hoTen,C.NGAY_cc,C.THOIGIANLAM,C.GIOTANGCA\n"
                + "FROM CHAMCONG C\n"
                + "LEFT JOIN NHANVIEN NV ON NV.maNV = C.MANV"
                + " WHERE C.maNV = ?";
        return this.selectBySql(sql, id);
    }

    @Override
    protected List<chamCong> selectBySql(String sql, Object... args) {
        List<chamCong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    chamCong entity = new chamCong();
                    entity.setTennv(rs.getString("hoTen"));
                    entity.setManv(rs.getString("Manv"));
                    entity.setNgaychamcong(rs.getDate("ngay_cc"));
                    entity.setThoigianlam(rs.getInt("thoigianlam"));
                    entity.setGiotangca(rs.getInt("giotangca"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public void delete(chamCong entity) {
    }

}
