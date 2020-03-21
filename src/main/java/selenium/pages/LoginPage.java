package selenium.pages;

import selenium.core.BasePage;
import selenium.core.DriverFactory;

public class LoginPage extends BasePage {
    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("http://srbarriga.herokuapp.com");
    }

    public void setEmail(String email) {
        write("email", email);
    }

    public void setSenha(String senha) {
        write("senha", senha);
    }

    public void entrar(){
        clickButtonByTetxt("Entrar");
    }

    public void logar(String email, String senha) {
        setEmail(email);
        setSenha(senha);
        entrar();
    }

    public void resetar(){
        clicarLink("reset");
    }
}
