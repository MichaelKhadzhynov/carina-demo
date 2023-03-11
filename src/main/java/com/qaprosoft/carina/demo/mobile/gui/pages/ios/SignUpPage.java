package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignUpPageBase.class)
public class SignUpPage extends SignUpPageBase {

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Create account - GSMArena.com\"`]/XCUIElementTypeOther[7]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    @ClassChain
    private ExtendedWebElement nickNameField;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Create account - GSMArena.com\"`]/XCUIElementTypeOther[7]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    @ClassChain
    private ExtendedWebElement emailField;

    @FindBy(xpath = "value == \"Your password\"")
    @Predicate
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "**/XCUIElementTypeSwitch[`value == \"0\"`][1]")
    @ClassChain
    private ExtendedWebElement personalDataCheckbox;

    @FindBy(xpath = "**/XCUIElementTypeSwitch[`value == \"0\"`][2]")
    @ClassChain
    private ExtendedWebElement ageCheckbox;

    @FindBy(xpath = "label == \"Submit\"")
    @Predicate
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "")
    private ExtendedWebElement registrationSuccessMassage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public SignUpPageBase typeNickName(String nickname) {
        nickNameField.type(nickname);
        return this;
    }

    @Override
    public SignUpPageBase typeEmail(String email) {
        emailField.type(email);
        return this;
    }

    @Override
    public SignUpPageBase typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    @Override
    public SignUpPageBase clickPersonalDataCheckbox() {
        personalDataCheckbox.click();
        return this;
    }

    @Override
    public SignUpPageBase clickAgeCheckbox() {
        ageCheckbox.click();
        return this;
    }

    @Override
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Override
    public ExtendedWebElement getRegistrationSuccessMassage() {
        return registrationSuccessMassage;
    }


}
