package com.tests;

import com.pages.CrearCategoriaPage;
import com.pages.LoginCrarCategoriaPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CrearCategoriaTest {
    WebDriver driver;
    LoginCrarCategoriaPage login = new LoginCrarCategoriaPage(driver);
    CrearCategoriaPage cat = new CrearCategoriaPage(driver);

    String url = "https://www.phptravels.net/admin";
    String strCorreo = "admin@phptravels.com";
    String strPass = "demoadmin";
    String strNombreCategoria = "World around travel";
    String strStatusEnable = "Enable";
    String strStatusDisable = "Disable";

    String strVietnamese = "Du lịch vòng quanh thế giới";
    String strRussian = "Мир вокруг путешествия";
    String strArabic = "عالم حول السفر";
    String strFarsi = "Wrâld om reizgjen";
    String strTurkish = "Seyahat çevresinde dünya";
    String strFrench = "Monde autour du voyage";
    String strSpanish = "Viajes alrededor del mundo";
    String strGerman = "Welt rund ums Reisen";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void Login() {
        login = new LoginCrarCategoriaPage(driver);
        login.Login(strCorreo, strPass);
    }


    public void LoginPhptravels() throws Exception {
        login = new LoginCrarCategoriaPage(driver);
        this.Login();

    }

    @Test
    public void CreatCategoria() throws Exception {
        cat = new CrearCategoriaPage(driver);
        this.Login();
        cat.CrearCategotia(strNombreCategoria, strStatusEnable);
        cat.IdiomasCategoria(strVietnamese, strRussian, strArabic, strFarsi, strTurkish, strFrench, strSpanish, strGerman);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

}
