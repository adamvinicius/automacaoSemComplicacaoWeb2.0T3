package br.com.chronosAcademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrincipalPage {
    WebDriver driver;

    public PrincipalPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitulo() {
        String xpathTitulo = "//section[2]//h4";

        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        return titulo;
    }

    public void clickBotao() {
        String xpathBotao = "//section[2]/div[3]//a";

        WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));
        btnTitulo.click();
    }

}
