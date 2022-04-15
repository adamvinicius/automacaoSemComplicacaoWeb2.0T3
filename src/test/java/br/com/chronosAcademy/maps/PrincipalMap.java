package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrincipalMap {
    @FindBy(xpath = "//section[2]//h4")
    public WebElement txtTitulo;
    @FindBy(xpath = "//section[2]/div[3]//a")
    public WebElement btnTitulo;
}
