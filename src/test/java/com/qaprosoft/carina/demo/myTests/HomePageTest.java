package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.LogInMenu;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.Keys.ENTER;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class HomePageTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testFooterMenuButtons() {
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");

        List<ExtendedWebElement> footerMenuElements = homePage.getFooterMenuElements();

        footerMenuElements.forEach(e -> Assert.assertTrue(e.isPresent(), " Element is not present"));
        footerMenuElements.forEach(e -> Assert.assertTrue(e.isClickable(), " Element is not clickable"));

        Assert.assertTrue(homePage.openFooterLinks());

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P2)
    public void testHeaderMenuButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        List<ExtendedWebElement> headerMenuElements = homePage.getHeaderMenuElements();

        headerMenuElements.forEach(e -> Assert.assertTrue(e.isPresent(), " Element is not present"));

        Assert.assertTrue(homePage.openHeaderLinks());
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P3)
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getSignUpPage();

        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.fillingFields();

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P4)
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getLogInMenu();

        LogInMenu logInMenu = new LogInMenu(getDriver());
        logInMenu.LogIn();

    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P5)
    public void testHoverBrandButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getBrandHover();
    }

}

/**
 * Тест кейс 1.
 * open Home Page.
 * scroll down to the footer menu
 * check if all buttons on the menu present.
 * click on each button and check if we go to the next Page
 * <p>
 * Тест кейс 2
 * open Home Page.
 * check all buttons on Header menu - if present
 * click on each button and check if we go to the next Page
 * <p>
 * Тест кейс 3
 * open Home Page.
 * click on the button “Sing up”
 * check if all elements on the SingUp Page present
 * fill in all info to create new account
 * click Submit button
 * <p>
 * Тест кейс 4
 * open Home Page.
 * click on the button “Log in”
 * Check all elements on the LogIn Modal - if elements present
 * fill in login and password
 * click button Log in
 * check if was opened next page
 */