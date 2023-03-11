package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.Header;
import com.qaprosoft.carina.demo.gui.components.LogInMenu;
import com.qaprosoft.carina.demo.gui.enums.FooterMenuElements;
import com.qaprosoft.carina.demo.gui.enums.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LogInPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class HomePageTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testFooterMenuButtons() {
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't not opened");

        FooterMenu footerMenu = homePage.getFooterMenu();

        footerMenu.getFooterMenuButtons().forEach(e -> Assert.assertTrue(e.isPresent(), "element not present"));

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.NEWS).getAttribute("href"),
                footerMenu.openNewsPage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.REVIEWS).getAttribute("href"),
                footerMenu.openReviewsPage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.TOOLS).getAttribute("href"),
                footerMenu.openToolsPage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.COMPARE).getAttribute("href"),
                footerMenu.openComparePage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.CONTACT_US).getAttribute("href"),
                footerMenu.openContactUsPage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.COVERAGE).getAttribute("href"),
                footerMenu.openCoveragePage().getCurrentUrl());

        Assert.assertEquals(footerMenu.getFooterMenuElement(FooterMenuElements.GLOSSARY).getAttribute("href"),
                footerMenu.openGlossaryPage().getCurrentUrl());
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P2)
    public void testHeaderMenuButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Header header = homePage.getHeaderMenu();

        Assert.assertTrue(header.isUIObjectPresent(2), "Header menu not present");

        header.getHeaderMenuButtons().forEach(e -> Assert.assertTrue(e.isPresent(), "element not present"));

        Assert.assertEquals(header.openNewsPage().getCurrentUrl(),
                header.getHeaderMenuButton(HeaderMenuElements.NEWS).getAttribute("href"));
        Assert.assertEquals(header.openContactUsPage().getCurrentUrl(),
                header.getHeaderMenuButton(HeaderMenuElements.CONTACT_US).getAttribute("href"));
        Assert.assertEquals(header.openReviewsPage().getCurrentUrl(),
                header.getHeaderMenuButton(HeaderMenuElements.REVIEWS).getAttribute("href"));
        Assert.assertEquals(header.openCoveragePage().getCurrentUrl(),
                header.getHeaderMenuButton(HeaderMenuElements.COVERAGE).getAttribute("href"));
        Assert.assertEquals(header.openPhoneFinderPage().getCurrentUrl(),
                header.getHeaderMenuButton(HeaderMenuElements.PHONE_FINDER).getAttribute("href"));
    }


    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P3)
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LogInMenu logInMenu = homePage.getHeaderMenu().openLogInMenu();

        LogInPage loInPage = logInMenu.logIn("rtyui@test.com", "356789098");

        Assert.assertEquals(loInPage.getTitle(), "Login - GSMArena.com");

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P4)
    public void testHoverBrandButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.getBrandLinks().forEach(e -> {
            e.hover();
            Assert.assertEquals(e.getElement().getCssValue("background-color"), "rgb(213, 0, 0)");
            LOGGER.info("Element " + e.getText() + " hover testing success");
        });
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P5)
    public void testLogInErrorMassage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LogInMenu logInMenu = homePage.getHeaderMenu().openLogInMenu();

        logInMenu.logIn("", "");
        Assert.assertEquals("Заполните это поле", logInMenu.getEmailField().getElement()
                        .getDomProperty("validationMessage")
                /*getAttribute("validationMessage")*/);
    }

    @Test(dataProvider = "userData")
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P6)
    public void testLogInDataProvider(String email, String password){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LogInMenu logInMenu = homePage.getHeaderMenu().openLogInMenu();

        LogInPage loInPage = logInMenu.logIn(email, password);

        Assert.assertEquals(loInPage.getTitle(), "Login - GSMArena.com");
    }

    @DataProvider()
    public Object[][] userData(){
        return new Object[][]{
                {"efwef@test.com", "32425355"},
                {"egergef@test.com", "142345"},
                {"grtwgf@test.com", "32543534"}
        };
    }


}
