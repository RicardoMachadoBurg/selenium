package selenium.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import selenium.core.DriverFactory;
import selenium.pages.TestesComponentesPage;
import selenium.tests.CanvasTest;
import selenium.tests.ComponentesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //ComponentesTest.class
        CanvasTest.class
})
public class MainSuite {
    //private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset(){
        //page.acessarTelaInicial();

        //page.setEmail("wagner@costa");
        //page.setSenha("123456");
        //page.entrar();

        //page.resetar();

        DriverFactory.killDriver();
    }
}
