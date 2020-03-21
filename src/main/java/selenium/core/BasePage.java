package selenium.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import static selenium.core.DriverFactory.*;
public class BasePage {
    /********* TextField e TextArea ************/



    public void write(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void write(String id_campo, String texto){
        write(By.id(id_campo), texto);
    }

    public String getFieldValue(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void clickRadio(By by) {
        getDriver().findElement(by).click();
    }

    public void clickRadio(String id) {
        clickRadio(By.id(id));
    }

    public boolean isRadioMarked(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clickCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckMarked(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selectCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselectCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String getValueCombo(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> getValuesCombo(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int getQuantityComboOptions(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verifyOptionCombo(String id, String opcao){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    public void selectComboPrime(String radical, String value) {
        clickRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
        clickRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+value+"']"));
    }

    /********* Button ************/

    public void clickButton(By by) {
        getDriver().findElement(by).click();
    }
    public void clickButton(String id) {
        clickButton(By.id(id));
    }

    public void clickButtonByTetxt(String text){
        clickButton(By.xpath("//Button[.='"+text+"']"));
    }

    public String getValueElement(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /********* Link ************/

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********* Textos ************/

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return getText(By.id(id));
    }

    /********* Alerts ************/

    public String alertGetText(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String alertGetTextAndAccept(){
        Alert alert = getDriver().switchTo().alert();
        String value = alert.getText();
        alert.accept();
        return value;

    }

    public String alertGetTextAndDeny(){
        Alert alert = getDriver().switchTo().alert();
        String value = alert.getText();
        alert.dismiss();
        return value;

    }

    public void alertWrite(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames and Windows ************/

    public void enterFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void leaveFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void changeWindow(String id) {
        getDriver().switchTo().window(id);
    }

    /************** JS *********************/

    public Object executeJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    /************** Table *********************/

    public WebElement getCell(String columnSearch, String value, String columnButton, String idTable){
        //procurar coluna do registro
        WebElement table = getDriver().findElement(By.xpath("//*[@id='"+idTable+"']"));
        int idColumn = getColumnIndex(columnSearch, table);

        //encontrar a linha do registro
        int idLinha = getIndexLine(value, table, idColumn);

        //procurar coluna do Button
        int idColumnButton = getColumnIndex(columnButton, table);

        //clicar no Button da celula encontrada
        WebElement cell = table.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColumnButton+"]"));
        return cell;
    }

    public void clickButtonTable(String colunaBusca, String value, String colunaButton, String idTable){
        WebElement cell = getCell(colunaBusca, value, colunaButton, idTable);
        cell.findElement(By.xpath(".//input")).click();

    }

    protected int getIndexLine(String value, WebElement table, int idColumn) {
        List<WebElement> lines = table.findElements(By.xpath("./tbody/tr/td["+idColumn+"]"));
        int idLine = -1;
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).getText().equals(value)) {
                idLine = i+1;
                break;
            }
        }
        return idLine;
    }

    protected int getColumnIndex(String column, WebElement table) {
        List<WebElement> columns = table.findElements(By.xpath(".//th"));
        int idColumn = -1;
        for(int i = 0; i < columns.size(); i++) {
            if(columns.get(i).getText().equals(column)) {
                idColumn = i+1;
                break;
            }
        }
        return idColumn;
    }


}
