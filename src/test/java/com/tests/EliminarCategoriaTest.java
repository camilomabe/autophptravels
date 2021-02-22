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


public class EliminarCategoriaTest {

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
    public void EliminatedCategories() throws Exception {
        System.out.println("Eliminar categoria test N° 6");
        login = new LoginPage(driver);
        menu = new MenuPage(driver);
        cat = new BlogCategoriesPage(driver);
        login.Login(data.strCorreo, data.strPass);
        menu.clickMenuBlog();
        menu.clickMenuBlogCategories();
        cat.EliminarCategoria(data.strNombreCategoria);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
