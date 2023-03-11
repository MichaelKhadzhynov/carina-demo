package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.YouTubeTab;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YTSubscribingDialogWindow extends AbstractUIObject {

    @FindBy(xpath = "//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--text yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m ']")
    private ExtendedWebElement cancelButton;

    public YTSubscribingDialogWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public YouTubeTab clickCancelButton(){
        cancelButton.click();
        return new YouTubeTab(driver);
    }

}
