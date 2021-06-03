/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selenium;

import DAO.NhanvienDAO;
import Model.Nhanvien;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author NamNguyen
 */
public class AutomaticEmployeeTest {
     private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--star-maximized");
        System.setProperty("webdriver.chrome.driver", "D:\\Download\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/Shop/Employee");
        
    }

    @Test
    public void testCreateEmployee() throws InterruptedException{
        WebElement btnAddForm = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div/div[1]/div/button"));
        btnAddForm.click();
        NhanvienDAO instance1 = new NhanvienDAO();
        List<Nhanvien> resultBefore = instance1.getAllNhanvien();
        WebElement textTenNV = driver.findElement(By.name("txtTen"));
        textTenNV.sendKeys("Nam Nguyen");
        WebElement textSdt = driver.findElement(By.name("txtSDT"));
        textSdt.sendKeys("0987893023");
        WebElement textEmail = driver.findElement(By.name("txtEmail"));
        textEmail.sendKeys("Namnguyenptitcn@gmail.com");
        WebElement textDiaChi = driver.findElement(By.name("txtDiachi"));
        textDiaChi.sendKeys("Ha Noi");
        WebElement textVaiTro = driver.findElement(By.name("txtVaitro"));
        textVaiTro.sendKeys("Manager");
        WebElement btnAdd = driver.findElement(By.xpath("//*[@id=\"modal-add\"]/div/div/form/div[2]/button[2]"));
        btnAdd.click();
        NhanvienDAO instance2 = new NhanvienDAO();
        List<Nhanvien> resultAfter = instance2.getAllNhanvien();
        assertEquals(resultBefore.size() + 1, resultAfter.size());
        Thread.sleep(2000);
        driver.close();

    }
    @Test
    public void testEditEmployee() throws InterruptedException{
        WebElement btnEditForm = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[8]/button[1]"));
        btnEditForm.click();
        
        WebElement textTenNV = driver.findElement(By.name("txtTenS"));
        textTenNV.clear();
        String key = "Nam Nguyen";
        textTenNV.sendKeys(key);
        WebElement btnEdit = driver.findElement(By.xpath("//*[@id=\"modal-edit\"]/div/div/form/div[2]/button[2]"));
        btnEdit.click();
        NhanvienDAO instance1 = new NhanvienDAO();
        Nhanvien nv =  instance1.findById(100);
        assertEquals(nv.getTen(), key);
        
        Thread.sleep(2000);
        driver.close();

    }
    @Test
    public void testDeleteEmployee() {
        NhanvienDAO instance1 = new NhanvienDAO();
        List<Nhanvien> resultBefore = instance1.getAllNhanvien();
        WebElement btnDelete = driver.findElements(By.name("xoaNV")).get(1);
        btnDelete.click();
        NhanvienDAO instance2 = new NhanvienDAO();
        List<Nhanvien> resultAfter = instance2.getAllNhanvien();
        assertEquals(resultBefore.size() - 1, resultAfter.size());

    }

}
