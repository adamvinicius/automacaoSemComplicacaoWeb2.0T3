package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.pages.EditAccountPage;
import br.com.chronosAcademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class EditAccountSteps {
    MyAccountPage myAccountPage;
    EditAccountPage editAccountPage;
    Map<String, String> mapDados;

    @Dado("que esteja na pagina de alteracao de conta")
    public void queEstejaNaPaginaDeAlteracaoDeConta() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
        myAccountPage.clickLinkEdit();
    }
    @Quando("altero os valores dos seguintes campos")
    public void alteroOsValoresDosSeguintesCampos(Map<String, String> map) {
        mapDados = map;
        editAccountPage = new EditAccountPage();
        editAccountPage.setFirstName(map.get("firstName"));
        editAccountPage.setLastName(map.get("lastName"));
    }
    @Quando("for realizado o clique em salvar")
    public void forRealizadoOCliqueEmSalvar() {
        editAccountPage.clickBtnSave();
    }
    @Entao("a alteracao foi exibida na pagina myAccount")
    public void aAlteracaoFoiExibidaNaPaginaMyAccount() {
        String nome = mapDados.get("firstName") + " " + mapDados.get("lastName");
        Assert.assertEquals(nome, myAccountPage.getTextUsuario());
    }
}
