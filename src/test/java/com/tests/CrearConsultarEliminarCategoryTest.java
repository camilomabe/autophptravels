package com.tests;

import com.pages.BlogCategoriesPage;
import com.pages.LoginPage;
import com.pages.MenuPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CrearConsultarEliminarCategoryTest extends ClaseData {

    WebDriver driver;

    ClaseData data = new ClaseData();
    BlogCategoriesPage cat = new BlogCategoriesPage(driver);
    MenuPage menu = new MenuPage(driver);
    LoginPage login = new LoginPage(driver);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(data.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void CrearCategoria() throws Exception {
        System.out.println("Crear categoria test N° 3");
        login = new LoginPage(driver);
        menu = new MenuPage(driver);
        cat = new BlogCategoriesPage(driver);

        login.Login(data.strCorreo, data.strPass);
        menu.clickMenuBlog();
        login.getScreen("Screen clickMenuBlog");
        menu.clickMenuBlogCategories();
        login.getScreen("Screen clickBtnAdd Categoria");
        menu.clickBtnAdd();
        cat.CrearCategoriaNueva(data.strNombreCategoria, data.strStatusEnable, data.strVietnamese, data.strRussian, data.strArabic, data.strFarsi, data.strTurkish, data.strFrench, data.strSpanish, data.strGerman);
        login.getScreen("Screen CrearCategoriaNueva");
        menu.clickMenuBlog();
        menu.clickMenuBlogCategories();
        cat.ConsultarCategotiaCreada(data.strNombreCategoria);
        login.getScreen("Categoria creada " + data.strNombreCategoria);
        menu.clickMenuBlog();
        menu.clickMenuBlogCategories();
        cat.EliminarCategoria(data.strNombreCategoria);
        login.getScreen("Categoria Eliminada " + data.strNombreCategoria);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
