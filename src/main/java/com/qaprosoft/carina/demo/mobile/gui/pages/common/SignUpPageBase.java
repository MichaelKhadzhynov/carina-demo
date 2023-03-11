package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SignUpPageBase extends AbstractPage {


    public SignUpPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract SignUpPageBase typeNickName(String nickname);

    public abstract SignUpPageBase typeEmail(String email);

    public abstract SignUpPageBase typePassword(String password);

    public abstract SignUpPageBase clickPersonalDataCheckbox();

    public abstract SignUpPageBase clickAgeCheckbox();

    public abstract void clickSubmitButton();

    public abstract ExtendedWebElement getRegistrationSuccessMassage();


}
