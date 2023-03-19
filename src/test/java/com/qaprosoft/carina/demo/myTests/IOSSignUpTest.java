package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.SaucePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.ios.SignUpPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

public class IOSSignUpTest implements IAbstractTest, IMobileUtils {
    @Test
    public void safariTest() {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.openURL("https://m.gsmarena.com/register.php3");
        signUpPage.typeEmail("fuewirfh@test.com");
        signUpPage.typeNickName("nickName3782384");
        signUpPage.typePassword("g34827tfgh");
        signUpPage.clickAgeCheckbox();
        signUpPage.clickPersonalDataCheckbox();
        signUpPage.clickSubmitButton();
    }
}
