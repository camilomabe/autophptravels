package com.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class LoginPage {

    WebDriver driver;

    By txtUsuario = By.name("email");
    By txtPassword = By.name("password");
    By checkRemember = By.name("remember");
    By btnLogin = By.xpath("//*[@class='btn btn-primary btn-block ladda-button fadeIn animated btn-lg']");

    String nombre;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCorreo(String strNombre) {
        driver.findElement(txtUsuario).sendKeys(strNombre);

    }

    public void setPassword(String strPassword) {
        driver.findElement(txtPassword).sendKeys(strPassword);
    }

    public void setCheckRemember() {
        driver.findElement(checkRemember).click();
    }

    public void setLogin() {
        driver.findElement(btnLogin).click();
    }

    public void Login(String strNombre, String strPassword) throws Exception {
        this.setCorreo(strNombre);
        this.setPassword(strPassword);
        this.setCheckRemember();
        this.setLogin();
        Thread.sleep(3000);
        this.getScreen("Screen Login");
    }

    public void getScreen(String nombre) throws IOException {
        String pathImg = "src/main/resources/screen/";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File fichero = new File(pathImg + nombre + ".png");
        if (fichero.exists()) {
            fichero.delete();
        }
        FileUtils.copyFile(scrFile, new File(pathImg + nombre + ".png"));
    }
}
