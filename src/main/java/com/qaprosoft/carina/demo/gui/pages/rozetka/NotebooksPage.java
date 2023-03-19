package com.qaprosoft.carina.demo.gui.pages.rozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.rozetka.componentsRozetka.CatalogGridCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotebooksPage extends AbstractPage {

    @FindBy(xpath = "//ul[@class='checkbox-filter']//a[@data-id='ASUS']")
    private ExtendedWebElement checkboxASUS;


    @FindBy(xpath = "//ul[@class=\'catalog-grid ng-star-inserted\']//li[@class=\'catalog-grid__cell catalog-grid__cell_type_slim ng-star-inserted\']")
    private List<CatalogGridCell> catalogGrid;

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    public NotebooksPage clickCheckboxASUS() {
        checkboxASUS.click();
        return this;
    }

    public List<CatalogGridCell> getCatalogGrid() {
        return catalogGrid;
    }


}
