package com.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BlogPostPage {

    WebDriver driver;
    LoginPage sc = new LoginPage(driver);
    private HTMLInputElement upload;

    public BlogPostPage(WebDriver driver) {
        this.driver = driver;
    }

    By txtTitle = By.name("title");
    By txtPermaLinck = By.name("slug");
    By clickLinckWeb = By.xpath("//a[@id='cke_59']/span");
    By txtUrlWeb = By.id("cke_573_textInput");
    By clickBtbOkUrlWeb = By.id("cke_720_label");
    By cbxStatus = By.name("status");
    By cbxCategory = By.name("category");
    By cbxRelatedPost = By.id("s2id_autogen2");
    By clickThumbnail = By.id("image_default");
    By txtKeywords = By.name("keywords");
    By txtMetadesc = By.name("metadesc");
    By btnSubmit = By.xpath("//button[@type='submit']");

    By btnViewWebSide = By.xpath("//div[@id='nav']/ul/a/button");


    public void sendTitle(String strTitle) {
        System.out.println("Ingresar Post Title " + txtTitle);
        driver.findElement(txtTitle).sendKeys(strTitle);
    }

    public void clickPermaLinck() throws InterruptedException {
        System.out.println("Click en Permalink " + txtPermaLinck);
        driver.findElement(txtPermaLinck).click();
        Thread.sleep(6000);
    }

    public void clickBtnLinckWeb() {
        System.out.println("Clic en el icono Link " + clickLinckWeb);
        driver.findElement(clickLinckWeb).click();
    }

    public void sendUrlWeb(String strUrlWeb) {
        System.out.println("Ingresar URL " + txtUrlWeb);
        driver.findElement(txtUrlWeb).sendKeys(strUrlWeb);
    }

    public void clickOkUrlWeb() {
        System.out.println("hacer clic en el boton OK " + clickBtbOkUrlWeb);
        driver.findElement(clickBtbOkUrlWeb).click();
    }

    public void selectStatus(String strStatusEnable) {
        System.out.println("Seleccionar Status " + cbxStatus);
        Select status = new Select(driver.findElement(cbxStatus));
        status.selectByVisibleText(strStatusEnable);
    }

    public void cbxSelectCategory(String strNombreCategoria) {
        System.out.println("Seleccionar Category " + cbxCategory);
        Select category = new Select(driver.findElement(cbxCategory));
        category.selectByVisibleText(strNombreCategoria);
    }

    public void cbxSelectRelatedPost(String strRelatedPost) {
        System.out.println("Seleccionar Related Posts " + cbxRelatedPost);
        driver.findElement(cbxRelatedPost).sendKeys(strRelatedPost);
        driver.findElement(cbxRelatedPost).sendKeys(Keys.ENTER);
        driver.findElement(cbxRelatedPost).sendKeys(Keys.TAB);
    }

    public void sendClickThumbnail(String strPathImg) throws InterruptedException {
        System.out.println("Cargar imagen Thumbnail " + clickThumbnail);
        File file = new File(strPathImg);  //"src/main/resources/img/img.jpg");
        String filePath = file.getAbsolutePath();
        driver.findElement(clickThumbnail).sendKeys(filePath);
        Thread.sleep(4000);
    }

    public void sendKeywords(String strKeywords) {
        System.out.println("Ingresar Keywords" + txtKeywords);
        driver.findElement(txtKeywords).sendKeys(strKeywords);
    }

    public void sendMetadesc(String strMetadesc) {
        System.out.println("Ingresar Description " + txtMetadesc);
        driver.findElement(txtMetadesc).sendKeys(strMetadesc);
    }

    public void clickBtnSubmit() {
        System.out.println("Hacer click en el boton SUBMIT " + btnSubmit);
        driver.findElement(btnSubmit).click();
    }

    public void CreatePost(String strTitle, String strUrlWeb, String strStatusEnable, String strNombreCategoria, String strRelatedPost, String strPathImg, String strKeywords, String strMetadesc) throws InterruptedException, IOException {
        this.sendTitle(strTitle);
        this.clickPermaLinck();
        this.clickBtnLinckWeb();
        this.sendUrlWeb(strUrlWeb);
        this.clickOkUrlWeb();
        this.selectStatus(strStatusEnable);
        this.cbxSelectCategory(strNombreCategoria);
        this.cbxSelectRelatedPost(strRelatedPost);
        this.sendClickThumbnail(strPathImg);
        this.sendKeywords(strKeywords);
        this.sendMetadesc(strMetadesc);
        sc.getScreen("Csreen " + strMetadesc);
        this.clickBtnSubmit();
        Thread.sleep(4000);
    }


    public void ConsultarBlogCreado(String strTitle) throws InterruptedException {
        By elementos = By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr");
        int filas = driver.findElements(elementos).size();
        for (int i = 1; i <= filas; i++) {
            By lblNombreCategoria = By.xpath("//*[@id='content']/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[" + i + "]/td[4]/a");
            String cate = driver.findElement(lblNombreCategoria).getText();
            System.out.println("Consultar blog creado: " + lblNombreCategoria);
            if (cate.contains(strTitle)) {
                System.out.println("Blog encontrado en la posicion: " + i + " " + strTitle);
                driver.findElement(lblNombreCategoria).click();
                Thread.sleep(4000);
                break;
            } else {
                System.out.println("Blog no encontrado: " + strTitle);
            }
        }

    }


    public void clickViewWebSide() {
        System.out.println("clickViewWebSide Hacer click en el boton VIEW WEBSITE ");
        driver.findElement(btnViewWebSide).click();
    }

    public void cambiaWindow() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("cambiaWindow Cambiar de ventana chrome");
        String oldTab = driver.getWindowHandle();
        int win = 0;
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(win));
    }


    public void buscarClickBlog(String strTitle) throws InterruptedException {
        System.out.println("buscarClickBlog Buscar el brog y hacer scroll " + strTitle);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,500)");

        By getTextoBlog = By.xpath("//*[contains(text(), '" + strTitle + "')]");
        System.out.println("Hacer clic en el blog " + getTextoBlog);
        String nombreBlog = driver.findElement(getTextoBlog).getText();
        if (nombreBlog.contains(strTitle)) {
            System.out.println("Blog consultado exitosamente: " + strTitle);
            Assert.assertEquals(strTitle, driver.findElement(getTextoBlog).getText());
            driver.findElement(getTextoBlog).click();
            Thread.sleep(4000);
        } else {
            System.out.println("Blog no encontrado: " + nombreBlog);
        }
    }

    public void clickPostWeb(String strTitle) throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,500)");
        By btnViewWebSide = By.xpath("//*[contains(text(), '" + strTitle + "')]");
        System.out.println("clickPostWeb " + btnViewWebSide);
        driver.findElement(btnViewWebSide).click();
    }

}



