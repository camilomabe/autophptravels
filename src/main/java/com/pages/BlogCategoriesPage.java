package com.pages;



import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class BlogCategoriesPage {

    WebDriver driver;
    LoginPage sc = new LoginPage(driver);

    By txtName = By.name("name");
    By cbxStatus = By.name("status");
    By txtVietnamese = By.name("translated[vi][name]");
    By txtRussian = By.name("translated[ru][name]");
    By txtArabic = By.name("translated[ar][name]");
    By txtFarsi = By.name("translated[fa][name]");
    By txtTurkish = By.name("translated[tr][name]");
    By txtFrench = By.name("translated[fr][name]");
    By txtSpanish = By.name("translated[es][name]");
    By txtGerman = By.name("translated[de][name]");
    By btnAddCategory = By.xpath("//button[@type='submit']");
    By elementos = By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr");

    public BlogCategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectStatus(String strStatus) {
        Select status = new Select(driver.findElement(cbxStatus));
        status.selectByVisibleText(strStatus);
    }

    public void sedNombreCategoria(String strSombreCategory) {
        driver.findElement(txtName).sendKeys(strSombreCategory);
    }

    public void sedVietnamese(String strVietnamese) {
        driver.findElement(txtVietnamese).sendKeys(strVietnamese);
    }

    public void sedRussian(String strRussian) {
        driver.findElement(txtRussian).sendKeys(strRussian);
    }

    public void sedArabic(String strArabic) {
        driver.findElement(txtArabic).sendKeys(strArabic);
    }

    public void sedFarsi(String strFarsi) {
        driver.findElement(txtFarsi).sendKeys(strFarsi);
    }

    public void sedTurkish(String strTurkish) {
        driver.findElement(txtTurkish).sendKeys(strTurkish);
    }

    public void sedFrench(String strFrench) {
        driver.findElement(txtFrench).sendKeys(strFrench);
    }

    public void sedSpanish(String strSpanish) {
        driver.findElement(txtSpanish).sendKeys(strSpanish);
    }

    public void sedGerman(String strGerman) {
        driver.findElement(txtGerman).sendKeys(strGerman);
    }

    public void sedAddCategory() {
        driver.findElement(btnAddCategory).click();
    }

    public void CrearCategoriaNueva(String strNombreCategoria, String strStatusEnable, String strVietnamese, String strRussian, String strArabic, String strFarsi, String strTurkish, String strFrench, String strSpanish, String strGerman) throws InterruptedException, IOException {
        sc = new LoginPage(driver);
        this.sedNombreCategoria(strNombreCategoria);
        this.selectStatus(strStatusEnable);
        this.sedVietnamese(strVietnamese);
        this.sedRussian(strRussian);
        this.sedArabic(strArabic);
        this.sedFarsi(strFarsi);
        this.sedTurkish(strTurkish);
        this.sedFrench(strFrench);
        this.sedSpanish(strSpanish);
        this.sedGerman(strGerman);
        sc.getScreen("Traducciones de la categoria");
        Thread.sleep(3000);
        this.sedAddCategory();
        System.out.println("¡Categoria creada exitosamente! " + strNombreCategoria);
        Thread.sleep(4000);
    }

    public void EliminarCategoria(String strNombreCategoria) throws InterruptedException {
        this.EliminarCategoriaPorNombre(strNombreCategoria);
    }

    public void EliminarCategoriaPorNombre(String strNombreCategoria) throws InterruptedException {
        int filas = driver.findElements(elementos).size();
        for (int i = 1; i < filas; i++) {
            By lblNombreCategoria = By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[" + i + "]/td[3]");
            By eliminarCategoria = By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[" + i + "]/td[6]/span/a[2]");
            String cate = driver.findElement(lblNombreCategoria).getText();
            if (cate.contains(strNombreCategoria)) {
                driver.findElement(lblNombreCategoria).click();
                Thread.sleep(2000);
                driver.findElement(eliminarCategoria).click();
                Thread.sleep(2000);

                Alert alert = driver.switchTo().alert();
                String alertMessage = driver.switchTo().alert().getText();
                alert.accept();
                Thread.sleep(5000);
                System.out.println("Categotia eliminada: " + strNombreCategoria);
                break;
            } else {
                System.out.println("Categotia no encontrada: " + strNombreCategoria);
                Assert.fail();
            }
        }

    }

    public void ConsultarCategotiaCreada(String strNombreCategoria) throws InterruptedException {

        int filas = driver.findElements(elementos).size();
        for (int i = 1; i <= filas; i++) {
            By lblNombreCategoria = By.xpath("//*[@id='content']/div[2]/div[2]/div[2]/div/div[1]/div[2]/table/tbody/tr[" + i + "]/td[3]");
            String cate = driver.findElement(lblNombreCategoria).getText();
            if (cate.contains(strNombreCategoria)) {
                driver.findElement(lblNombreCategoria).click();

                System.out.println("Categotia encontrada: " + strNombreCategoria);
                Assert.assertEquals(strNombreCategoria, driver.findElement(lblNombreCategoria).getText());
                break;
            } else {
                System.out.println("Categotia no encontrada: " + strNombreCategoria);

            }
        }
        Thread.sleep(4000);
    }
}
