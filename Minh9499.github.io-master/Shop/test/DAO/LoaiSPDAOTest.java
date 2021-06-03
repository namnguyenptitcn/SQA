/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.LoaiSP;
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
public class LoaiSPDAOTest {
    
    public LoaiSPDAOTest() {
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
        rb.RollBackLoaiSP();
    }
    @Test
   
    public void testGetAllLoaiSP() {
        System.out.println("getAllLoaiSP");
        LoaiSPDAO instance = new LoaiSPDAO();
        int expResult = 4;
        List<LoaiSP> result = instance.getAllLoaiSP();
        assertEquals(expResult, result.size());       
    }

    @Test
    public void testAddLoaiSPThanhCong() {
        System.out.println("addLoaiSP");
        String ten = "laptop";
        String ghichu = "maytinhxachtay";
        String ngaytao = "2021-06-06";
        LoaiSPDAO instance = new LoaiSPDAO();
        String result = instance.addLoaiSP(ten, ghichu, ngaytao);
        LoaiSP lastCategory = instance.findByIdMAX();
        LoaiSP newCategory = new LoaiSP(lastCategory.getId(),ten, ghichu, ngaytao);
        String expResult = "Them moi thanh cong";
        assertTrue(result.equals(expResult)&&lastCategory.equals(newCategory));
    }
    @Test
    public void testAddLoaiSPThatBai() {
        System.out.println("addLoaiSP");
        String ten = "laptop";
        String ghichu = "maytinhxachtay";
        String ngaytao = "a";
        LoaiSPDAO instance = new LoaiSPDAO();
        String result = instance.addLoaiSP(ten, ghichu, ngaytao);
        LoaiSP lastCategory = instance.findByIdMAX();
        LoaiSP newCategory = new LoaiSP(lastCategory.getId(),ten, ghichu, ngaytao);
        String expResult = "Them moi that bai";
        assertTrue(result.equals(expResult));
    }  
    @Test
    public void testDeleteLoaiSPThanhCong() {
        System.out.println("deleteLoaiSP");
        String uid = "4";
        LoaiSPDAO instance = new LoaiSPDAO();
        String expResult = "Xoa thanh cong";
        String result = instance.deleteLoaiSP(uid);
        assertEquals(expResult, result);
    }
     @Test
    public void testDeleteLoaiSPThatBai() {
        System.out.println("deleteLoaiSP");
        String uid = "13";
        LoaiSPDAO instance = new LoaiSPDAO();
        String expResult = "Xoa that bai";
        String result = instance.deleteLoaiSP(uid);
        assertEquals(expResult, result);
    }

    @Test
    public void testEditLoaiSPThanhCong() {
        System.out.println("editLoaiSP");
        String ten = "MINH";
        String ghichu = "123123123";
        String ngaytao = "2021-02-02";
        int id = 3;
        LoaiSPDAO instance = new LoaiSPDAO();
        String expResult = "Sua thanh cong";
        String result = instance.editLoaiSP(ten, ghichu, ngaytao, id);
        LoaiSP lastCategory = instance.findById(id);
        LoaiSP newCategory = new LoaiSP(lastCategory.getId(),ten, ghichu, ngaytao);
        assertTrue(result.equals(expResult)&&lastCategory.equals(newCategory));
    }
    @Test
    public void testEditLoaiSPThatBai1() {
        System.out.println("editLoaiSP");
        String ten = "MINH";
        String ghichu = "123123123";
        String ngaytao = "2021-02-02";
        int id = 19;
        LoaiSPDAO instance = new LoaiSPDAO();
        String expResult = "Sua that bai";
        String result = instance.editLoaiSP(ten, ghichu, ngaytao, id);
        assertTrue(result.equals(expResult));
    }
    @Test
    public void testEditLoaiSPThatBai2() {
        System.out.println("editLoaiSP");
        String ten = "MINH";
        String ghichu = "123123123";
        String ngaytao = "a";
        int id = 3;
        LoaiSPDAO instance = new LoaiSPDAO();
        String expResult = "Sua that bai";
        String result = instance.editLoaiSP(ten, ghichu, ngaytao, id);
        assertTrue(result.equals(expResult));
    }

    @Test
    public void testFindByIdDung() {
        System.out.println("findById");
        int id = 1;
        LoaiSPDAO instance = new LoaiSPDAO();
        LoaiSP expResult = new LoaiSP(id,"Tủ Lạnh","Tủ lạnh siêu nóng","2021-04-04");
        LoaiSP result = instance.findById(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindByIdSai() {
        System.out.println("findById");
        int id = 0;
        LoaiSPDAO instance = new LoaiSPDAO();
        LoaiSP expResult = new LoaiSP();
        LoaiSP result = instance.findById(id);
        assertEquals(expResult, result);
    }  
    
}
