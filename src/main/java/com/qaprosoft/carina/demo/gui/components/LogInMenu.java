package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LogInMenu extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@action=\"login.php3\"]//input[@id=\"email\"]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//form[@action=\"login.php3\"]//input[@id=\"upass\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//form[@action=\"login.php3\"]//input[@id=\"nick-submit\"]")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//span[@id=\"login-popup2\"]//a[@class=\"forgot\"]")
    private ExtendedWebElement forgotPasswordButton;


    public LogInMenu(WebDriver driver) {
        super(driver);
    }

    public void LogIn() {

        if(forgotPasswordButton.isPresent() && forgotPasswordButton.isClickable()){
            LOGGER.info("'Forgot password' button is present");
        } else {
            throw new NoSuchElementException("'Forgot password' button is not present");
        }

        if (emailField.isPresent()) {
            LOGGER.info("Email field is present");
            emailField.type("Test902348@test.com");
        } else {
            throw new NoSuchElementException("Email field is not present");
        }


        if (passwordField.isPresent()) {
            LOGGER.info("Password field is present");
            passwordField.type("1456765432");
        } else {
            throw new NoSuchElementException("Password field is not present");
        }

        if (logInButton.isPresent() && logInButton.isClickable()) {
            LOGGER.info("Log in button field is present");
            logInButton.click();
        } else {
            throw new NoSuchElementException("Log in button is not present");
        }

    }
}
