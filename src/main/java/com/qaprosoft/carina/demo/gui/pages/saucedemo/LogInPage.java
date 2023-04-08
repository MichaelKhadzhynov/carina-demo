package com.qaprosoft.carina.demo.gui.pages.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    private ExtendedWebElement loginButton;

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(userNameField);
    }

    public LogInPage typeUserName(String userName){
        userNameField.type(userName);
        return this;
    }

    public LogInPage typePassword(String password){
        passwordField.type(password);
        return this;
    }

    public InventoryPage clickLoginButton(){
        loginButton.click();
        return new InventoryPage(driver);
    }

    public InventoryPage logIn(String username, String password){
        typeUserName(username);
        typePassword(password);
        return clickLoginButton();
    }

}
