/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDB;
import Model.Nhanvien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhanvienDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Nhanvien> getAllNhanvien(){
        List<Nhanvien> list= new ArrayList<>();
        String query = "SELECT *  FROM nhan_vien";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Nhanvien(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (Exception e) {
        }

        return list;
    }
     public String addNhanvien(String ten , String sdt, String email , String diachi  , String vaitro , String ngaytao){
        String query = "INSERT INTO nhan_vien(ten,sdt,email,dia_chi,vai_tro,ngay_tao) VALUES(?,?,?,?,?,?);";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setString(3, email);
            ps.setString(4, diachi);
            ps.setString(5, vaitro);
            ps.setString(6, ngaytao);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Them moi thanh cong";
            }else{
                return "Them moi that bai";
            }
        } catch (Exception e) {
            return "Them moi that bai";
        }
    }
    public String deleteNhanvien(int uid){
        String query = "DELETE FROM nhan_vien WHERE id = ?;";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Xoa thanh cong";
            }else{
                return "Xoa that bai";
            }

        } catch (Exception e) {
            return "Xoa that bai";
        }
    }
    public String editNhanvien(String ten , String sdt, String email , String diachi  , String vaitro , String ngaytao,int id){
        String query ="UPDATE [QL_CHANG].[dbo].[nhan_vien] SET ten =?,sdt=?,email=?,dia_chi=?,vai_tro=?,ngay_tao=? WHERE id=?;";
        try {
           
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setString(3, email);
            ps.setString(4, diachi);
            ps.setString(5, vaitro);
            ps.setString(6, ngaytao);
            ps.setInt(7, id);
            int count = ps.executeUpdate();
            if(count > 0){
                return "Sua thanh cong";
            }else{
                return "Sua that bai";
            }

        } catch (Exception e) {
            return "Sua that bai";
        }
    }
    public Nhanvien findById(int id){
        Nhanvien u = new Nhanvien();
        String query = "SELECT * FROM nhan_vien WHERE id = ?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new Nhanvien(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (Exception e) {
        }
        return u;
    }
    public Nhanvien findByIdMAX(){
        Nhanvien u = new Nhanvien();
        String query = "SELECT * FROM nhan_vien WHERE id = (SELECT  MAX(id) From nhan_vien)";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new Nhanvien(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        } catch (Exception e) {
        }
        return u;
    }
}
