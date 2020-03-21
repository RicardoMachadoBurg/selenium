package selenium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import static selenium.core.DriverFactory.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    @Rule
    public TestName testName = new TestName();

    //private LoginPage page = new LoginPage();

    @Before
    public void initialize(){

       /* page.acessarTelaInicial();

        page.setEmail("wagner@costa");
        page.setSenha("123456");
        page.entrar();*/
    }

    @After
    public void finish() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File file = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if(Properties.CLOSE_BROWSER) {
            killDriver();
        }
    }
}
