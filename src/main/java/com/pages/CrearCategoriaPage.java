package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CrearCategoriaPage {

    WebDriver driver;

    By nemuBlog = By.xpath("//i[@class='w30 fa fa-columns']");
    By menuBlogCategories = By.xpath("//a[@href='https://www.phptravels.net/admin/blog/category']");
    By btnAdd = By.xpath("//*[contains(text(),' Add')]");
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

    By btnAddCategory = By.name("//button[@class='btn btn-primary' and contains(text(),'Add')] ");

    public CrearCategoriaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenuBlog() {
        driver.findElement(nemuBlog).click();
    }

    public void clickBlogCategories() throws InterruptedException {
        driver.findElement(menuBlogCategories).click();
        Thread.sleep(7000);
    }

    public void clickBtnAdd() {
        driver.findElement(btnAdd).click();
    }

    public void selectStatus(String strStatus) {
        Select status = new Select(driver.findElement(cbxStatus));
        status.selectByVisibleText(strStatus);
    }

    public void sedNombreCategoria(String strSombreCategory) {
        driver.findElement(txtName).sendKeys(strSombreCategory);
    }

    public void CrearCategotia(String strCategoria, String strStatus) throws InterruptedException {
        this.clickMenuBlog();
        this.clickBlogCategories();
        this.clickBtnAdd();
        this.sedNombreCategoria(strCategoria);
        this.selectStatus(strStatus);
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


    public void IdiomasCategoria(String strVietnamese, String strRussian, String strArabic, String strFarsi, String strTurkish, String strFrench, String strSpanish, String strGerman) {
        this.sedVietnamese(strVietnamese);
        this.sedRussian(strRussian);
        this.sedArabic(strArabic);
        this.sedFarsi(strFarsi);
        this.sedTurkish(strTurkish);
        this.sedFrench(strFrench);
        this.sedSpanish(strSpanish);
        this.sedGerman(strGerman);
        this.sedAddCategory();
    }

}
