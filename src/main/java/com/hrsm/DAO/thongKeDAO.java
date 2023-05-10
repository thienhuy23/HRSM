/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class thongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList();
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getStaffInformation(String status) {
        String sql = "{CaLL SP_getInformationStaff (?)}";
        String[] cols = {"maNV", "hoTen", "TrangThai", "tenPB", "tenDA"};
        return this.getListOfArray(sql, cols, status);
    }

    public List<Object[]> getStaffSalary(String status, int year) {
        String sql = "{CALL SP_getInformationSalary (?,?)}";
        String[] cols = {"thoiGianTinh","maNV", "hoTen", "luongCoBan", "chucVu", "TrangThai","tongLuong"};
        return this.getListOfArray(sql, cols,status,year);
    }
    
    public List<Object[]> getStaffProject(String progress, int year) {
        String sql = "{CALL SP_getInformationProject (?,?)}";
        String[] cols = {"maDA", "TenDA", "ngayBatDau", "ngayKetThuc", "moTa","tienDo"};
        return this.getListOfArray(sql, cols,progress,year);
    }
}
