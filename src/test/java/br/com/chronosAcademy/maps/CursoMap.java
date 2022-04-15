package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursoMap {
    @FindBy(css = "div.text-center > div.large-h1")
    public WebElement txtTitulo;
}
