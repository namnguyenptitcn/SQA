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
public class Nhanvien {
    private int id;
    private String ten;
    private String sdt;
    private String email;
    private String diaChi;
    private String vaiTro;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Nhanvien() {
    }

    public Nhanvien(int id, String ten, String sdt, String email, String diaChi, String vaiTro, String ngayTao) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "Nhanvien{" + "id=" + id + ", ten=" + ten + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + ", vaiTro=" + vaiTro + ", ngayTao=" + ngayTao + '}';
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
        final Nhanvien other = (Nhanvien) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ten, other.ten)) {
            return false;
        }
        if (!Objects.equals(this.sdt, other.sdt)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.diaChi, other.diaChi)) {
            return false;
        }
        if (!Objects.equals(this.vaiTro, other.vaiTro)) {
            return false;
        }
        if (!Objects.equals(this.ngayTao, other.ngayTao)) {
            return false;
        }
        return true;
    }
    
}
