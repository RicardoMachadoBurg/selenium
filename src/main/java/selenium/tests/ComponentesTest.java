package selenium.tests;

import org.junit.Test;
import selenium.core.BaseTest;
import selenium.pages.TestesComponentesPage;

public class ComponentesTest extends BaseTest {

    TestesComponentesPage testesComponentesPage = new TestesComponentesPage();


    @Test
    public void Test1(){
        testesComponentesPage.acessarTelaInicial();
        testesComponentesPage.escreverNome();
        testesComponentesPage.escreverSobrenome();
        testesComponentesPage.escreverPrompt();
        //testesComponentesPage.abrirPoupop();
        System.out.println("finalizou test1");
    }

    @Test
    public void Test2(){
        testesComponentesPage.acessarTelaInicial();
        testesComponentesPage.escreverTextArea();
        System.out.println("finalizou test2");
    }
}
