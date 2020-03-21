package selenium.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.core.BasePage;
import selenium.core.DriverFactory;

import java.util.concurrent.TimeUnit;

public class CanvasPage extends BasePage {

    public CanvasPage(){
        DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 1000));
    }
    public void acessarTelaInicial(){
       // DriverFactory.getDriver().get("https://andrew.wang-hoyer.com/experiments/cloth/");
        //DriverFactory.getDriver().get("https://diveintohtml5.com.br/canvas.html");
        DriverFactory.getDriver().get("http://gyu.que.jp/jscloth/");
    }


    public void clica01(){
        ///html[1]/body[1]/div[2]/div[1]/canvas[1]
        //executeJS("var evt = $.Event('click', { pageX: " + 100 +", pageY: " + (155) + " } );" +"$('#diagramCanvas').trigger(evt);");
        //executeJS("var evt = $.Event('click', { pageX: " + 100 +", pageY: " + (155) + " } );" +"$('#b').trigger(evt);");
        //WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        executeJS("var evt = $.Event('click', { pageX: " + 100 +", pageY: " + (50) + " } );" +"$('#cv').trigger(evt);");
    }

}
