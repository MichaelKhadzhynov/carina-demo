package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpPageTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P3)
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't open");

        SignUpPage signUpPage = homePage.getHeaderMenu().openSignUpPage();

        signUpPage.signUp("Wqtwqrrq",
                "testEmail3213rwety25t231@test.com",
                "1234567876543");

        Assert.assertTrue(signUpPage.getRegistrationSuccessMassage().isPresent());
        Assert.assertEquals(signUpPage.getRegistrationSuccessMassage().getText(), "Your account was created. ");
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P4)
    @XlsDataSourceParameters(path = "xls/userSignUpData.xlsx", sheet = "data", dsArgs = "nickName, email, password")
    public void testSignUpDataProvider(String nickname, String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't open");

        SignUpPage signUpPage = homePage.getHeaderMenu().openSignUpPage();

        signUpPage.signUp(nickname, email, password);
        Assert.assertEquals(signUpPage.getRegistrationSuccessMassage().getText(), "Your account was created. ");
    }

}
