/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selenium;

import DAO.LoaiSPDAO;
import Model.LoaiSP;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;

/**
 *
 * @author NamNguyen
 */
public class AutomaticKindCategoryTest {

    private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--star-maximized");
        System.setProperty("webdriver.chrome.driver", "D:\\Download\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:8080/Shop/category");
    }

    @Test
    public void testCreateKindCategory() throws InterruptedException{
        WebElement btnAddForm = driver.findElement(By.name("btnAdd"));
        btnAddForm.click();
        LoaiSPDAO instance1 = new LoaiSPDAO();
        List<LoaiSP> resultBefore = instance1.getAllLoaiSP();
        WebElement textTenlmh = driver.findElement(By.name("txtTenlmh"));
        textTenlmh.sendKeys("Dieu hoa");
        WebElement textGhiChu = driver.findElement(By.name("txtGhichu"));
        textGhiChu.sendKeys("1 chieu");
        WebElement btnAdd = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/button[2]"));
        btnAdd.click();
        LoaiSPDAO instance2 = new LoaiSPDAO();
        List<LoaiSP> resultAfter = instance2.getAllLoaiSP();
        assertEquals(resultBefore.size() + 1, resultAfter.size());
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.close();

    }
    @Test
    public void testEditKindCategory() throws InterruptedException{
        WebElement btnEditForm = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/button[1]"));
        btnEditForm.click();
        driver.navigate().refresh();
        
        WebElement textTenlmh = driver.findElement(By.name("txtTenlmhS"));
        textTenlmh.clear();
        String key = "May Giat";
        textTenlmh.sendKeys(key);
        WebElement btnEdit = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[2]/button[2]"));
        btnEdit.click();
        LoaiSPDAO instance1 = new LoaiSPDAO();
        LoaiSP lsp =  instance1.findById(125);
        assertEquals(lsp.getTen(), key);
        
        Thread.sleep(2000);
        driver.close();

    }
    @Test
    public void testDeleteKindCategory() {
        LoaiSPDAO instance1 = new LoaiSPDAO();
        List<LoaiSP> resultBefore = instance1.getAllLoaiSP();
        WebElement btnDelete = driver.findElements(By.name("xoaCate")).get(1);
        btnDelete.click();
        LoaiSPDAO instance2 = new LoaiSPDAO();
        List<LoaiSP> resultAfter = instance2.getAllLoaiSP();
        driver.navigate().refresh();
        assertEquals(resultBefore.size() - 1, resultAfter.size());

    }

}
