package com.tests;

import com.pages.BlogCategoriesPage;
import com.pages.BlogPostPage;
import com.pages.LoginPage;
import com.pages.MenuPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BlogPostTest {

    WebDriver driver;

    ClaseData data = new ClaseData();
    BlogCategoriesPage cat = new BlogCategoriesPage(driver);
    MenuPage menu = new MenuPage(driver);
    LoginPage login = new LoginPage(driver);
    BlogPostPage post = new BlogPostPage(driver);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(data.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void CreatPostCrearCategoriaParacrearPost() {
        try {
            System.out.println("Crear una categoria y luego crear un post con la categoria Test N° 2");
            login = new LoginPage(driver);
            menu = new MenuPage(driver);
            cat = new BlogCategoriesPage(driver);
            post = new BlogPostPage(driver);

            login.Login(data.strCorreo, data.strPass);

            menu.clickMenuBlog();
            login.getScreen("Screen clickMenuBlog");
            menu.clickMenuBlogCategories();
            login.getScreen("Screen clickBtnAdd Categoria");
            menu.clickBtnAdd();
            cat.CrearCategoriaNueva(data.strNombreCategoria, data.strStatusEnable, data.strVietnamese, data.strRussian, data.strArabic, data.strFarsi, data.strTurkish, data.strFrench, data.strSpanish, data.strGerman);

            login.getScreen("Screen CrearCategoriaNueva");
            menu.clickMenuBlog();
            menu.clickMenuBlogPost();
            login.getScreen("Screen clickBtnAdd Post");
            menu.clickBtnAdd();
            post.CreatePost(data.strTitle, data.strUrlWeb, data.strStatusEnable, data.strNombreCategoria, data.strRelatedPost, data.strPathImg, data.strKeywords, data.strMetadesc);

            login.getScreen("Screen Posst");
            menu.clickMenuBlog();
            menu.clickMenuBlogPost();
            login.getScreen("Screen ConsultarBlogCreado");
            post.ConsultarBlogCreado(data.strTitle);
            post.clickViewWebSide();
            post.cambiaWindow();
            post.buscarClickBlog(data.strTitle);
            login.getScreen("Screen buscarClickBlog");
            post.clickPostWeb(data.strTitle);

        } catch (Exception ex) {
            System.out.println("Error en: " + ex.getMessage() + "\nTambien en: " + ex.getStackTrace());
        }


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
