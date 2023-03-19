package com.qaprosoft.carina.demo.gui.pages.rozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.support.FindBy;

public class ComputersNotebooksPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='tile-cats']//a[@title='Ноутбуки']")
    private ExtendedWebElement notebooksButton;

    public ComputersNotebooksPage(WebDriver driver) {
        super(driver);
    }

    public NotebooksPage openNotebooksPage(){
        notebooksButton.click();
        return new NotebooksPage(driver);
    }
}
