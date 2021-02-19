package com.tests;

import com.pages.LoginCrarCategoriaPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginCrarCategoriaTest {
    WebDriver driver;
    LoginCrarCategoriaPage categoria = new LoginCrarCategoriaPage(driver);

    String url = "https://www.phptravels.net/admin";
    String strCorreo = "admin@phptravels.com";
    String strPass = "demoadmin";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Login() {
        categoria = new LoginCrarCategoriaPage(driver);
        categoria.Login(strCorreo, strPass);
        driver.quit();
    }

    @Test
    public void LoginPhptravels() throws Exception {
        categoria = new LoginCrarCategoriaPage(driver);
        categoria.setCorreo(strCorreo);
        categoria.setPassword(strPass);
        categoria.setCheckRemember();
        categoria.setLogin();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
