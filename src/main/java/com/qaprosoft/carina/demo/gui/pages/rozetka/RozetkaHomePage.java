package com.qaprosoft.carina.demo.gui.pages.rozetka;

import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


//15:21
public class RozetkaHomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='menu-wrapper menu-wrapper_state_static ng-star-inserted']//ul//li")
    private List<ExtendedWebElement> menuCategories;

    @FindBy(xpath = "//div[@class=\"ng-tns-c115-3 side-links ng-star-inserted\"]//li")
    private List<ExtendedWebElement> mainSidebarButtonList;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    public ComputersNotebooksPage openComputersNotebooksPage() {
        menuCategories.get(0).click();
    return new ComputersNotebooksPage(driver);
    }

    public RozetkaCareersPage openRozetkaCareersPage(){
        mainSidebarButtonList.get(2).click();
        return new RozetkaCareersPage(driver);
    }
}
