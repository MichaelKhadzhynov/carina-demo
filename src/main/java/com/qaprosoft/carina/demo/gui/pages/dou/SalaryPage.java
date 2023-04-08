package com.qaprosoft.carina.demo.gui.pages.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SalaryPage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"bar\"]")
    private List<ExtendedWebElement> barsList;

    @FindBy(xpath = "//div[@id='respondents']//span")
    private ExtendedWebElement respondents;

    @FindBy(xpath = "//div[@id='button-filters']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//div[@id=\"dws-fl-experience\"]//*[@class='handle left']")
    private ExtendedWebElement handleLeft;

    @FindBy(xpath = "//div[@id=\"dws-fl-experience\"]//*[@class='tick']")
    private List<ExtendedWebElement> ticksList;


    public SalaryPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getBarsList() {
        return barsList;
    }

    public List<Long> getBarsValuesList(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<Long> elementKeysList = new ArrayList<>();

        for(int i=0; i<20; i++){
            elementKeysList.add((Long) jsExecutor.executeScript("return arguments[0].__data__.value;",
                    barsList.get(i).getElement()));
        }
        return elementKeysList;
    }

    public List<String> getBarsKeysList(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<String> elementKeysList = new ArrayList<>();

        for(int i=0; i<20; i++){
            elementKeysList.add((String) jsExecutor.executeScript("return arguments[0].__data__.key;",
                    barsList.get(i).getElement()));
        }
        return elementKeysList;
    }

    public List<String> getBarsKeysList1(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<String> elementKeysList = new ArrayList<>();

        barsList.forEach(e->elementKeysList.add((String) jsExecutor
                .executeScript("return arguments[0].__data__.key;",
                e.getElement())));
        return elementKeysList;
    }

    public ExtendedWebElement getRespondents() {
        return respondents;
    }

    public SalaryPage clickFilterButton(){
        filterButton.click();
        return this;
    }

    public ExtendedWebElement getHandleLeft() {
        return handleLeft;
    }

    public List<ExtendedWebElement> getTicksList() {
        return ticksList;
    }

    public SalaryPage moveToTicket(WebElement element){
        Actions action = new Actions(driver);
        action.clickAndHold(handleLeft.getElement()).moveToElement(element);
        action.perform();
        return this;
    }
}
