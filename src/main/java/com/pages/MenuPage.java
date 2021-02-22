package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    By nemuBlog = By.xpath("//i[@class='w30 fa fa-columns']");

    public void clickMenuBlog() {
        driver.findElement(nemuBlog).click();
    }

    By menuBlogCategories = By.xpath("//a[@href='https://www.phptravels.net/admin/blog/category']");

    public void clickMenuBlogCategories() throws InterruptedException {
        driver.findElement(menuBlogCategories).click();
        Thread.sleep(5000);
    }

    By menuBlogPost = By.xpath("//a[@href='https://www.phptravels.net/admin/blog']");

    public void clickMenuBlogPost() throws InterruptedException {
        driver.findElement(menuBlogPost).click();
        Thread.sleep(5000);
    }

    By btnAdd = By.xpath("//*[contains(text(),' Add')]");

    public void clickBtnAdd() {
        driver.findElement(btnAdd).click();

    }
}
