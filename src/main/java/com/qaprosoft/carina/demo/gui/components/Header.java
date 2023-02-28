package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.enums.HeaderMenuElements;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//header//button")
    private ExtendedWebElement ToggleNavigationButton;

    @FindBy(xpath = "//ul[@id='menu']")
    private ExtendedWebElement headerMenu;

    @FindBy(xpath = "//header//ul[@id='menu']//a")
    private List<ExtendedWebElement> headerMenuButtons;

    @FindBy(xpath = "//a[@href='register.php3']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//a[@id='login-active']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//span[@id='login-popup2']")
    private LogInMenu logInMenu;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public Header clickToggleNavigationButton(){
        ToggleNavigationButton.click();
        return this;
    }

    public Header getMenu(){
        if(!headerMenu.isElementPresent()) {
            clickToggleNavigationButton();
        }
        return this;
    }

    public HomePage openHomePage() {
        headerMenuButtons.get(HeaderMenuElements.HOME.getHeaderElement()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        headerMenuButtons.get(HeaderMenuElements.NEWS.getHeaderElement()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        headerMenuButtons.get(HeaderMenuElements.REVIEWS.getHeaderElement()).click();
        return new ReviewsPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        headerMenuButtons.get(HeaderMenuElements.PHONE_FINDER.getHeaderElement()).click();
        return new PhoneFinderPage(driver);
    }

    public CoveragePage openCoveragePage() {
        headerMenuButtons.get(HeaderMenuElements.COVERAGE.getHeaderElement()).click();
        return new CoveragePage(driver);
    }

    public ContactUsPage openContactUsPage() {
        headerMenuButtons.get(HeaderMenuElements.CONTACT_US.getHeaderElement()).click();
        return new ContactUsPage(driver);
    }

    public List<ExtendedWebElement> getHeaderMenuButtons() {
        return headerMenuButtons;
    }

    public ExtendedWebElement getHeaderMenuButton(HeaderMenuElements element) {
        return headerMenuButtons.get(element.getHeaderElement());
    }

    public Header clickSignUpButton(){
        signUpButton.click();
        return this;
    }

    public SignUpPage openSignUpPage(){
        clickSignUpButton();
        return  new SignUpPage(driver);
    }

    public LogInMenu openLogInMenu(){
        logInButton.click();
        return logInMenu;
    }

}
