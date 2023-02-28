package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = \"uname\"]")
    private ExtendedWebElement nickNameField;

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

    @FindBy(xpath = "//div[@class ='normal-text res-success']/h3")
    private ExtendedWebElement registrationSuccessMassage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    public SignUpPage typeNickName(String nickname){
        nickNameField.type(nickname);
        return this;
    }

    public SignUpPage typeEmail(String email){
        emailField.type(email);
        return this;
    }

    public SignUpPage typePassword(String password){
        passwordField.type(password);
        return this;
    }

    public SignUpPage clickPersonalDataCheckbox(){
        personalDataCheckbox.clickByJs();
        return this;
    }

    public SignUpPage clickAgeCheckbox(){
        ageCheckbox.clickByJs();
        return this;
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public ExtendedWebElement getRegistrationSuccessMassage() {
        return registrationSuccessMassage;
    }

    public SignUpPage signUp(String nickname, String email, String password){
        typeNickName(nickname);
        typeEmail(email);
        typePassword(password);
        clickPersonalDataCheckbox();
        clickAgeCheckbox();
        clickSubmitButton();
        return this;
    }
}
