package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PreferencesPage extends AbstractPage {

    @FindBy(xpath = "label == 'General' AND name == 'General'")
    @Predicate
    private ExtendedWebElement generalButton;
    
    public PreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void clickGeneralBtn() {
        generalButton.click();
    }

}
