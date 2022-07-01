package br.com.chronosAcademy.steps;

import br.com.chronosAcademy.pages.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class MyAccountSteps {
    MyAccountPage myAccountPage;

    @Dado("que esteja na pagina myAccount")
    public void queEstejaNaPaginaMyAccount() {
        myAccountPage = new MyAccountPage();
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
    }
    @Quando("for efetuado a acao do clique delete e em yes")
    public void forEfetuadoAAcaoDoCliqueDeleteEEmYes() {
        myAccountPage.clickBtnDelete();
        myAccountPage.clickBtnYes();
    }
    @Entao("o usuario deve ser deletado")
    public void oUsuarioDeveSerDeletado() {
        Assert.assertEquals("Account deleted successfully", myAccountPage.getTextDelete());
    }
}
