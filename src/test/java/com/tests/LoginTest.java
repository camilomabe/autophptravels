package com.tests;

import com.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;


    ClaseData data = new ClaseData();
    LoginPage categoria = new LoginPage(driver);


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(data.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws Exception {
        System.out.println("Login test N° 4");
        categoria = new LoginPage(driver);
        categoria.Login(data.strCorreo, data.strPass);

    }

    @Test
    public void LoginPhptravels() throws IOException, InterruptedException {
        System.out.println("Login test N° 5");
        categoria = new LoginPage(driver);
        categoria.setCorreo(data.strCorreo);
        categoria.setPassword(data.strPass);
        categoria.setCheckRemember();
        categoria.setLogin();
        Thread.sleep(2000);
        categoria.getScreen("Screen Login");
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
