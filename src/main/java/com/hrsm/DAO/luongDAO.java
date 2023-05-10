/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import com.hrsm.Entity.luong;
import com.hrsm.Utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class luongDAO extends HRSMDAO<luong, String> {

    @Override
    public void insert(luong entity) {
        String sql = "INSERT INTO LUONGTHUONG VALUES(?,?,?,?,?,?,?,?,?)";
        XJDBC.update(sql, entity.getThoiGianTinh(),
                entity.getSoNgayNghi(),
                entity.getSoNgayTangCa(),
                entity.getTrachNhiem(),
                entity.getThuong(),
                entity.getKhautru(),
                entity.getLuongCoBan(),
                entity.getTrangThai(),
                entity.getMaNV());
    }

    @Override
    public void update(luong entity) {
        String sql = "UPDATE LUONGTHUONG SET SONGAYNGHI = ?, SONGAYTANGCA = ?, TRACHNHIEM = ?, TIENTHUONG = ?, KHAUTRU = ?, LUONGCOBAN = ?, TRANGTHAI = ? WHERE MANV = ? AND THOIGIANTINH = ?";
        XJDBC.update(sql,entity.getSoNgayNghi(),
                entity.getSoNgayTangCa(),
                entity.getTrachNhiem(),
                entity.getThuong(),
                entity.getKhautru(),
                entity.getLuongCoBan(),
                entity.getTrangThai(),
                entity.getMaNV(),
                entity.getThoiGianTinh());
    }

    @Override
    public void delete(luong entity) {
    }

    @Override
    public List<luong> selectAll() {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong\n"
                + "FROM LUONGTHUONG LT \n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV \n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai";
        return this.selectBySql(sql);
    }

    @Override
    public luong selectById(String key) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong\n"
                + "FROM LUONGTHUONG LT \n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV \n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE NV.MANV = ?"
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai";
        List<luong> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    public luong selectByIds(int key) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong\n"
                + "FROM LUONGTHUONG LT \n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV \n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE LT.STT = ?"
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai";
        List<luong> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<luong> selectBySql(String sql, Object... args) {
        List<luong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    luong entity = new luong();
                    entity.setSTT(rs.getInt("STT"));
                    entity.setThoiGianTinh(rs.getDate("THOIGIANTINH"));
                    entity.setSoNgayLam(rs.getInt("SONGAYLAM"));
                    entity.setSoNgayNghi(rs.getInt("SONGAYNGHI"));
                    entity.setSoNgayTangCa(rs.getInt("SONGAYTANGCA"));
                    entity.setLoaiViPham(rs.getString("LOAIVIPHAM"));
                    entity.setTrachNhiem(rs.getInt("TRACHNHIEM"));
                    entity.setThuong(rs.getInt("tienThuong"));
                    entity.setKhautru(rs.getDouble("khauTru"));
                    entity.setLuongCoBan(rs.getDouble("luongCoBan"));
                    entity.setTrangThai(rs.getBoolean("trangThai"));
                    entity.setTong(rs.getDouble("tongLuong"));
                    entity.setMaNV(rs.getString("maNV"));
                    entity.setTenNV(rs.getString("hoTen"));
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

    public List<luong> selectByKeyword(String keyword) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong\n"
                + "FROM LUONGTHUONG LT \n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV \n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE NV.HOTEN LIKE ? "
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai"
                + " ORDER BY STT ASC";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<luong> selectByComponents(String a, int keyword) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong\n"
                + "FROM LUONGTHUONG LT \n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV \n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE NV.HOTEN LIKE ? and YEAR(THOIGIANTINH) = ? "
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai "
                + "ORDER BY STT ASC";
        return this.selectBySql(sql, "%" + a + "%", keyword);
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT YEAR(thoigiantinh) FROM LUONGTHUONG";
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
        String sql = "SELECT DISTINCT IIF(trangThai = 1,N'Đã xử lí',N'Đang xử lí') as trangThai FROM LUONGTHUONG";
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

    public List<luong> selectByComponents(String maNV, String progress) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,IIF(LT.trangThai = 1,N'Đã xử lí',N'Đang xử lí') as trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong \n"
                + "FROM LUONGTHUONG LT\n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV\n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE NV.maNV = ? and IIF(LT.trangThai = 1,N'Đã xử lí',N'Đang xử lí') = ? \n"
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai\n"
                + "ORDER BY LT.STT ASC";
        return this.selectBySql(sql, maNV, progress);
    }

    public luong selectBySTT(Integer key) {
        String sql = "SELECT LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,COUNT(C.ngay_cc) AS soNgayLam,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,IIF(LT.trangThai = 1,N'Đã xử lí',N'Đang xử lí') as trangThai,sum(soNgayTangCa + tienThuong + soNgayNghi - khauTru + luongCoBan + trachNhiem) + COUNT(C.NGAY_CC) as tongLuong \n"
                + "FROM LUONGTHUONG LT\n"
                + "LEFT JOIN NHANVIEN NV ON NV.MANV = LT.MANV\n"
                + "LEFT JOIN CHAMCONG C ON C.manv = NV.maNV\n"
                + "LEFT JOIN KILUAT KL ON KL.maNV = NV.maNV\n"
                + "WHERE LT.STT = ? \n"
                + "GROUP BY LT.STT,NV.maNV,NV.hoTen,thoiGianTinh,soNgayNghi,soNgayTangCa,KL.loaiViPham,trachNhiem,tienThuong,khauTru,luongCoBan,LT.trangThai\n"
                + "ORDER BY LT.STT ASC";
        List<luong> list = this.selectBySql(sql, key);
        return !list.isEmpty() ? list.get(0) : null;
    }
}
