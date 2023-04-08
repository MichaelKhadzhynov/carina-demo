package com.qaprosoft.carina.demo.gui.pages.saucedemo;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.InventoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"inventory_item\"]")
    private List<InventoryItem> inventoryItemList;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

    }

    public Integer getInventoryItemCount(){
        return inventoryItemList.size();
    }

}
