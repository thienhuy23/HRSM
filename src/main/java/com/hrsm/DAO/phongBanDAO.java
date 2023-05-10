/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.phongBan;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class phongBanDAO extends HRSMDAO<phongBan, String>{

    @Override
    public void insert(phongBan entity) {
        String sql = "INSERT INTO PHONGBAN VALUES (?,?,?)";
        XJDBC.update(sql, entity.getMaPB(), entity.getTenPB(), entity.getMoTa());
    }

    @Override
    public void update(phongBan entity) {
        String sql = "UPDATE PHONGBAN SET TENPB = ?, MOTA = ? WHERE MAPB = ?";
        XJDBC.update(sql, entity.getTenPB(), entity.getMoTa(), entity.getMaPB());
    }

    @Override
    public void delete(phongBan entity) {
        String sql = "DELETE FROM PHONGBAN WHERE MAPB = ?";
        XJDBC.update(sql, entity);
    }

    @Override
    public List<phongBan> selectAll() {
        String sql = "SELECT maPB, tenPB, moTa FROM PHONGBAN";
        return this.selectBySql(sql);
    }
    
    @Override
    public phongBan selectById(String key) {
        String sql = "SELECT * FROM PHONGBAN WHERE MAPB = ?";
        List<phongBan> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<phongBan> selectBySql(String sql, Object... args) {
        List<phongBan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    phongBan entity = new phongBan();
                    entity.setMaPB(rs.getString("maPB"));
                    entity.setTenPB(rs.getString("tenPB"));
                    entity.setMoTa(rs.getString("moTa"));
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
    
    public void delete(String entity) {
        String sql = "DELETE FROM PHONGBAN WHERE MAPB = ?";
        XJDBC.update(sql, entity);
    }
    public List<phongBan> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM PHONGBAN WHERE TENPB LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    
    public List<String> selectRoom() {
        String sql = "SELECT DISTINCT MaPB FROM PHONGBAN";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
