package com.qaprosoft.carina.demo.gui.pages.rozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RozetkaCareersPage extends AbstractPage {

    @FindBy(xpath = "//select[@class=\"select-css select-css--medium ng-star-inserted\"]")
    private List<ExtendedWebElement> filterSelectMenuList;

    @FindBy(xpath = "//div[@class=\"filter-vacancies__checkbox ng-star-inserted\"]//input")
    private ExtendedWebElement remoteJobCheckbox;

    public RozetkaCareersPage(WebDriver driver) {
        super(driver);
    }

    public Select getDirectionsSelectMenu(){
        return new Select(filterSelectMenuList.get(0).getElement());
    }

    public ExtendedWebElement getRemoteJobCheckbox() {
        return remoteJobCheckbox;
    }

    public String readSalaryData(){
        String dataProperty = filterSelectMenuList.get(0).getElement().getDomProperty("__data__");
        return dataProperty.substring(dataProperty.indexOf('=') + 1, dataProperty.lastIndexOf(','));
    }
}
