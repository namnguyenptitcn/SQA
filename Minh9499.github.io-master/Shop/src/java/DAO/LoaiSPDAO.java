/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDB;
import Model.LoaiSP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LoaiSPDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<LoaiSP> getAllLoaiSP(){
        List<LoaiSP> list= new ArrayList<>();
        String query = "SELECT * FROM loai_sp";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new LoaiSP(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)
                ));
            }
            System.out.println(list);
        } catch (Exception e) {
        }

        return list;
    }
    public String addLoaiSP(String ten , String ghichu, String ngaytao){
        String query = "INSERT INTO loai_sp(ten_loai, ghi_chu, ngay_tao) VALUES(?,?,?);";
        try {
            if (ten.trim()=="") return "Ten khong duoc de trong";
            if (ghichu.trim()=="") return "SDT khong duoc de trong";
            if (ngaytao.trim()=="") return "Ngay tao khong duoc de trong";
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, ghichu);
            ps.setString(3, ngaytao);
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
    public String deleteLoaiSP(String uid){
        String query = "DELETE FROM loai_sp WHERE id = ?;";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uid);
            int count=ps.executeUpdate();
            if(count > 0){
                return "Xoa thanh cong";
            }else{
                return "Xoa that bai";
            }

        } catch (Exception e) {
            return "Xoa that bai";
        }
    }
    public String editLoaiSP(String ten , String ghichu, String ngaytao,int id){
        String query ="UPDATE loai_sp SET ten_loai =?,ghi_chu=?,ngay_tao=? WHERE id=?;";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, ghichu);
            ps.setString(3, ngaytao);
            ps.setInt(4, id);
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
    public LoaiSP findById(int id){
        LoaiSP u = new LoaiSP();
        String query = "SELECT * FROM loai_sp WHERE id = ?";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new LoaiSP(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
        }
        return u;
    }
    public LoaiSP findByIdMAX(){
        LoaiSP u = new LoaiSP();
        String query = "SELECT * FROM loai_sp WHERE id = (SELECT  MAX(id) From loai_sp)";
        try {
            conn = new ConnectDB().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                u = (new LoaiSP(rs.getInt(1),
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4)
                ));
            }
        } catch (Exception e) {
        }
        return u;
    }
}
