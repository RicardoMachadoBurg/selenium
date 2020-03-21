package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import selenium.core.BasePage;
import selenium.core.DriverFactory;

public class TestesComponentesPage extends BasePage {


    public TestesComponentesPage(){
        DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 765));
    }
    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("http://wcaquino.me/selenium/componentes.html");
    }

    public void escreverSobrenome(){
        write(By.xpath("//input[@name='elementosForm:sobrenome']"),"Burg Machado");
    }

    public void escreverNome(){
        write(By.xpath("//input[@name='elementosForm:nome']"),"Ricardo");
    }

    public void escreverPrompt(){
        clickButton(By.xpath("//input[@value='Prompt']"));
        alertWrite("120");
        alertGetTextAndAccept();
        alertGetTextAndAccept();
    }

    public void abrirPoupop(){
        clickButton(By.xpath("//input[@value='Abrir Popup']"));

    }

    public void escreverTextArea(){
        write(By.xpath("//textarea[contains(@name,'elementosForm:sugestoes')]"),"conteudo escrito na text area");
    }


}
