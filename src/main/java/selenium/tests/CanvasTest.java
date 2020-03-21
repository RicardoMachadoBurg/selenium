package selenium.tests;

import org.junit.Test;
import selenium.core.BaseTest;
import selenium.pages.CanvasPage;

public class CanvasTest extends BaseTest {


    CanvasPage canvasPage = new CanvasPage();

    @Test
    public void Test1Canvas(){
        canvasPage.acessarTelaInicial();
        canvasPage.clica01();

    }

}
