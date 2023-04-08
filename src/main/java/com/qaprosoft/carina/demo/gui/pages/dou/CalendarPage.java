package com.qaprosoft.carina.demo.gui.pages.dou;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='txtDate']")
    private ExtendedWebElement calendarField;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCalendarField() {
        return calendarField;
    }

    public CalendarPage typeCalendarDate(String day, String month, String year){
        calendarField.getElement().sendKeys(day + Keys.ARROW_RIGHT + month + Keys.ARROW_RIGHT + year);
        return this;
    }

    public String getValueAsDate(){
        return calendarField.getElement().getDomProperty("valueAsDate").toLowerCase();
    }
}
