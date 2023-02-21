package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = \"uname\"]")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//fieldset[@id=\"udata-f\"]//input[@id=\"email\"]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//form[@id= \"frmOpin\"]//input[@id=\"upass\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//fieldset//input[@id=\"iagree1\"]")
    private ExtendedWebElement personalDataCheckbox;

    @FindBy(xpath="//fieldset//input[@id=\"iagree2\"]")
    private ExtendedWebElement ageCheckbox;

    @FindBy(xpath = "//div[@id=\"ucsubmit-f\"]//input[@id=\"nick-submit\"]")
    private ExtendedWebElement submitButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void fillingFields(){
        submitButton.scrollTo();

        if(userNameField.isPresent()){
            userNameField.type("UserName12378665432");
        }

        if(emailField.isPresent()) {
            emailField.type("ewruhwe@uhu.com");
        }

        if (passwordField.isPresent()){
            passwordField.type("3456898542345");
        }

        if(personalDataCheckbox.isPresent()){
            personalDataCheckbox.clickByJs();
        }

        if(ageCheckbox.isPresent()){
            ageCheckbox.clickByJs();
        }

        if(submitButton.isClickable()){
            submitButton.click();
        }
    }
}
