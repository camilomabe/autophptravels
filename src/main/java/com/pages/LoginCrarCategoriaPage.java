package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCrarCategoriaPage {

    WebDriver driver;

    By txtUsuario = By.name("email");
    By txtPassword = By.name("password");
    By checkRemember = By.name("remember");
    By btnLogin = By.xpath("//*[@class='btn btn-primary btn-block ladda-button fadeIn animated btn-lg']");


    public LoginCrarCategoriaPage(WebDriver driver) {
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

    public void Login(String user, String pass) {
        this.setCorreo(user);
        this.setPassword(pass);
        this.setCheckRemember();
        this.setLogin();
    }


}
