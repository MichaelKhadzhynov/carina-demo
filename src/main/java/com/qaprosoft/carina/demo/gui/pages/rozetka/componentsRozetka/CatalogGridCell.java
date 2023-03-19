package com.qaprosoft.carina.demo.gui.pages.rozetka.componentsRozetka;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogGridCell extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class='goods-tile__title']")
    private ExtendedWebElement goodsTitle;

    public CatalogGridCell(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getGoodsTitle() {
        return goodsTitle;
    }
}
