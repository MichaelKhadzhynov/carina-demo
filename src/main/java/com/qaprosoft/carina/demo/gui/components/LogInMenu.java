package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LogInPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.slf4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogInMenu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//form[@action='login.php3']//input[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = ".//form[@action='login.php3']//input[@id='upass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = ".//form[@action='login.php3']//input[@id='nick-submit']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = ".//span[@id='login-popup2']//a[@class='forgot']")
    private ExtendedWebElement forgotPasswordButton;


    public LogInMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogInMenu typeEmailField(String email){
        emailField.type(email);
        return this;
    }

    public LogInMenu typePassWord(String password){
        passwordField.type(password);
        return this;
    }

    public LogInMenu clickLogInButton(){
        logInButton.click();
        return this;
    }

    public LogInMenu clickForgotPassword(){
        forgotPasswordButton.click();
        return this;
    }

    public LogInPage logIn(String email, String password){
        typeEmailField(email);
        typePassWord(password);
        clickLogInButton();
        return new LogInPage(driver);
    }



}
