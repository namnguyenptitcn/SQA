/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class LoaiSP {
    private int id;
    private String ten;
    private String ghiChu;
    private String ngayTao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LoaiSP() {
    }

    public LoaiSP(int id, String ten, String ghiChu, String ngayTao) {
        this.id = id;
        this.ten = ten;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "LoaiSP{" + "id=" + id + ", ten=" + ten + ", ghiChu=" + ghiChu + ", ngayTao=" + ngayTao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiSP other = (LoaiSP) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ten, other.ten)) {
            return false;
        }
        if (!Objects.equals(this.ghiChu, other.ghiChu)) {
            return false;
        }
        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
            return false;
        }
        return true;
    }
    
}
