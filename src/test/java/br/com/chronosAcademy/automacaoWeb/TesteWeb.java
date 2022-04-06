package br.com.chronosAcademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class TesteWeb {

    ChromeDriver driver;

    @Before
    public void inicializaTeste(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chronosacademy.com.br");
    }

    @Test
    public void primeiroTeste(){
        //section[2]/div[3]/div/div/div/div/div[1]/div/h4

        String xpathTitulo = "//section[2]//h4";

        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        assertEquals("Porque Tempo É Conhecimento", titulo);
    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }


}
