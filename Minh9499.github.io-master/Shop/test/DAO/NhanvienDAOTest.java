/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Nhanvien;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author ASUS
 */
public class NhanvienDAOTest {
    
    public NhanvienDAOTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
        RollBackDB rb = new RollBackDB();
        rb.RollBackNhanVien();
    }

    @Test
    public void testGetAllNhanvien() {
        System.out.println("getAllNhanvien");
        NhanvienDAO instance = new NhanvienDAO();
        int expResult = 4;
        List<Nhanvien> result = instance.getAllNhanvien();
        assertEquals(expResult, result.size());
        
    }

    @Test
    public void testAddNhanvienThanhCong() {
        System.out.println("addNhanvien");
        String ten = "minh";
        String sdt = "0969341099";
        String email = "nqm0904@gmail.com";
        String diachi = "Ha Noi";
        String vaitro = "Stu";
        String ngaytao = "2021-09-09";
        NhanvienDAO instance = new NhanvienDAO();
        String result = instance.addNhanvien(ten, sdt, email, diachi, vaitro, ngaytao);
        Nhanvien lastEmployee = instance.findByIdMAX();
        Nhanvien newEmployee = new Nhanvien(lastEmployee.getId(),ten, sdt, email, diachi, vaitro, ngaytao);
        String expResult = "Them moi thanh cong";
        assertTrue(result.equals(expResult)&&lastEmployee.equals(newEmployee));
    }
    @Test
    public void testAddNhanvienThatBai() {
        System.out.println("addNhanvien");
        String ten = "minh";
        String sdt = "0969341099";
        String email = "nqm0904@gmail.com";
        String diachi = "Ha Noi";
        String vaitro = "Stu";
        String ngaytao = "a";
        NhanvienDAO instance = new NhanvienDAO();
        String result = instance.addNhanvien(ten, sdt, email, diachi, vaitro, ngaytao);
        Nhanvien lastEmployee = instance.findByIdMAX();
        Nhanvien newEmployee = new Nhanvien(lastEmployee.getId(),ten, sdt, email, diachi, vaitro, ngaytao);
        String expResult = "Them moi that bai";
        assertTrue(result.equals(expResult));
    }

    @Test
    public void testDeleteNhanvienThanhCong() {
        System.out.println("deleteNhanvien");
        int uid = 3;
        NhanvienDAO instance = new NhanvienDAO();
        String expResult = "Xoa thanh cong";
        String result = instance.deleteNhanvien(uid);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteNhanvienThatBai() {
        System.out.println("deleteNhanvien");
        int uid = 0;
        NhanvienDAO instance = new NhanvienDAO();
        String expResult = "Xoa that bai";
        String result = instance.deleteNhanvien(uid);
        assertEquals(expResult, result);
      
    }

    @Test
    public void testEditNhanvienThanhCong() {
        System.out.println("editNhanvien");
        String ten = "MINH";
        String sdt = "123123123";
        String email = "qsdqdwq";
        String diachi = "qweqwe";
        String vaitro = "wqeqwe";
        String ngaytao = "2021-02-02";
        int id = 4;
        NhanvienDAO instance = new NhanvienDAO();
        String expResult = "Sua thanh cong";
        String result = instance.editNhanvien(ten, sdt, email, diachi, vaitro, ngaytao, id);
         Nhanvien lastEmployee = instance.findById(id);
        Nhanvien newEmployee = new Nhanvien(lastEmployee.getId(),ten, sdt, email, diachi, vaitro, ngaytao);
        assertTrue(result.equals(expResult)&&lastEmployee.equals(newEmployee));
       
    }
    @Test
    public void testEditNhanvienThatBai1() {
        System.out.println("editNhanvien");
       String ten = "MINH";
        String sdt = "123123123";
        String email = "qsdqdwq";
        String diachi = "qweqwe";
        String vaitro = "wqeqwe";
        String ngaytao = "2021-02-02";
        int id = 0;
        NhanvienDAO instance = new NhanvienDAO();
        String expResult = "Sua that bai";
        String result = instance.editNhanvien(ten, sdt, email, diachi, vaitro, ngaytao, id);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testEditNhanvienThatBai2() {
        System.out.println("editNhanvien");
        String ten = "MINH";
        String sdt = "123123123";
        String email = "qsdqdwq";
        String diachi = "qweqwe";
        String vaitro = "wqeqwe";
        String ngaytao = "a";
        int id = 4;
        NhanvienDAO instance = new NhanvienDAO();
        String expResult = "Sua that bai";
        String result = instance.editNhanvien(ten, sdt, email, diachi, vaitro, ngaytao, id);
        assertEquals(expResult, result);
       
    }

    @Test
    public void testFindByIdDung() {
        System.out.println("findById");
        int id = 1;
        NhanvienDAO instance = new NhanvienDAO();
        Nhanvien expResult = new Nhanvien(id,"Minh","0969341099","nqm0904@gmail.com","Hà Nội","Stu","2021-01-04");
        Nhanvien result = instance.findById(id);
        assertEquals(expResult, result);
    }
        @Test
    public void testFindByIdSai() {
        System.out.println("findById");
        int id = 0;
        NhanvienDAO instance = new NhanvienDAO();
        Nhanvien expResult = new Nhanvien();
        Nhanvien result = instance.findById(id);
        assertEquals(expResult, result);
    }  
    
}
