/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.duAn;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class duAnDAO extends HRSMDAO<duAn, String> {

    @Override
    public void insert(duAn model) {
        String sql = "INSERT INTO DUAN VALUES(?,?,?,?,?,?,?)";
        XJDBC.update(sql, model.getMaDA(), model.getTenDA(), model.getNgayBatDau(), model.getNgayKetThuc(), model.getTienDo(), model.getMoTa(), model.getMaPB());
    }

    @Override
    public void update(duAn model) {
        String sql = "UPDATE DUAN SET TENDA = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, TIENDO = ?, MOTA = ?, MAPB = ? WHERE MADA = ?";
        XJDBC.update(sql, model.getTenDA(), model.getNgayBatDau(), model.getNgayKetThuc(), model.getTienDo(), model.getMoTa(), model.getMaPB(), model.getMaDA());
    }

    @Override
    public void delete(duAn model) {
        String sql = "DELETE FROM DUAN WHERE MADA = ?";
        XJDBC.update(sql, model);
    }

    @Override
    public List<duAn> selectAll() {
        String sql = "SELECT maDA,tenDA,ngayBatDau,ngayKetThuc,tienDo,moTa,maPB FROM duan ";
        return this.selectBySql(sql);
    }

    @Override
    public duAn selectById(String key) {
        String sql = "SELECT maDA,tenDA,ngayBatDau,ngayKetThuc,tienDo,moTa,maPB from duan WHERE maDA = ?";
        List<duAn> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<duAn> selectBySql(String sql, Object... args) {
        List<duAn> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    duAn entity = new duAn();
                    entity.setMaDA(rs.getString("maDA"));
                    entity.setTenDA(rs.getString("tenDA"));
                    entity.setNgayBatDau(rs.getDate("ngayBatDau"));
                    entity.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                    entity.setTienDo(rs.getString("tienDo"));
                    entity.setMoTa(rs.getString("moTa"));
                    entity.setMaPB(rs.getString("maPB"));
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

    public void delete(String maDA) {
        String sql = "DELETE FROM DUAN WHERE MADA = ?";
        XJDBC.update(sql, maDA);
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT YEAR(ngayBatDau) FROM DUAN";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<String> selectProgress() {
        String sql = "SELECT DISTINCT TIENDO FROM DUAN";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql);
            while (rs.next()) {
                list.add(rs.getString("tienDo"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<duAn> selectByComponents(String maNV, String progress, int year) {
        String sql = "SELECT PB.tenPB, DA.tenDA, DA.ngayBatDau, DA.ngayKetThuc, DA.tienDo \n"
                + "FROM DUAN DA \n"
                + "LEFT JOIN PHONGBAN PB ON PB.maPB = DA.maPB \n"
                + "LEFT JOIN NHANVIEN NV ON NV.maPB = PB.maPB \n"
                + "WHERE NV.maNV = ? AND TIENDO = ? AND YEAR(ngayBatDau) = ?";
        return this.selectBySqls(sql, maNV, progress, year);
    }

    protected List<duAn> selectBySqls(String sql, Object... args) {
        List<duAn> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    duAn entity = new duAn();
                    entity.setTenPB(rs.getString("tenPB"));
                    entity.setTenDA(rs.getString("tenDA"));
                    entity.setNgayBatDau(rs.getDate("ngayBatDau"));
                    entity.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                    entity.setTienDo(rs.getString("tienDo"));
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
}
