package br.com.chronosAcademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountMap {

    @FindBy(name = "first_nameAccountDetails")
    public WebElement inpFirstName;
    @FindBy(name = "last_nameAccountDetails")
    public WebElement inpLastName;
    @FindBy(css = "#save_btnundefined")
    public WebElement btnSave;
}
