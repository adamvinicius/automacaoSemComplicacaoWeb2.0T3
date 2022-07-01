package br.com.chronosAcademy.pages;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.maps.EditAccountMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {
    EditAccountMap editAccountMap;

    public EditAccountPage() {
        editAccountMap = new EditAccountMap();
        PageFactory.initElements(Driver.getDriver(), editAccountMap);
    }

    public void setFirstName(String firstName){
        Driver.visibilityOf(editAccountMap.inpFirstName);
        editAccountMap.inpFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        editAccountMap.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSave(){
        Driver.aguardaOptions(new Select(editAccountMap.slcCountry));
        editAccountMap.btnSave.click();
    }
}
