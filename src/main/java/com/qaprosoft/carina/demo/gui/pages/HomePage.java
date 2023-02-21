/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;


    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBys({@FindBy(xpath = "//p[contains(@class, 'pad')]"), @FindBy(xpath = ".//*[contains(@class, 'pad-single')]")})
    private ExtendedWebElement phoneFinderButton;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(xpath = "//div[@class = \"footer-inner\"]//a[@href]")
    private List<ExtendedWebElement> footerMenuElements;

    @FindBy(xpath = "//header[@id=\"header\"]//a")
    private List<ExtendedWebElement> headerMenuElements;

    @FindBy(xpath = "//a[@href=\"register.php3\"]")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//a[@id=\"login-active\"]")
    private ExtendedWebElement logInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public void getBrandHover(){
        brandLinks.forEach(ExtendedWebElement::hover);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }

    public ExtendedWebElement getPhoneFinderButton() {
        return phoneFinderButton;
    }

    //Methods for footer menu testing
    public List<ExtendedWebElement> getFooterMenuElements() {
        footerMenuElements.forEach(ExtendedWebElement::scrollTo);
        return footerMenuElements;
    }

    public boolean openFooterLinks() {
        List<String> elementLinks = new ArrayList<>();
        List<String> currentLinks = new ArrayList<>();

        footerMenuElements.forEach(e -> elementLinks.add(e.getAttribute("href")));
        elementLinks.forEach(e -> {
            driver.get(e);
            currentLinks.add(driver.getCurrentUrl());
        });

        for (String eln : elementLinks) {
            for (String cln : currentLinks) {
                if (eln.equals(cln)) {
                    LOGGER.info("Links are equals");
                    return true;
                }
            }
        }
        return false;
    }

    //Methods for header menu testing
    public List<ExtendedWebElement> getHeaderMenuElements() {
        return headerMenuElements;
    }

    public boolean openHeaderLinks() {
        List<String> elementLinks = new ArrayList<>();
        List<String> currentLinks = new ArrayList<>();

        headerMenuElements.forEach(e -> elementLinks.add(e.getAttribute("href")));
        elementLinks.forEach(e -> {
            driver.get(e);
            currentLinks.add(driver.getCurrentUrl());
        });

        for (String eln : elementLinks) {
            for (String cln : currentLinks) {
                if (eln.equals(cln)) {
                    LOGGER.info("Links are equals");
                    return true;
                }
            }
        }
        return false;
    }

    //Methods for sign up testing
    public void getSignUpPage() {
        if (signUpButton.isClickable()) {
            signUpButton.click();
        }
    }

    //Method for log in testing
    public void getLogInMenu() {
        if (logInButton.isPresent() && logInButton.isClickable()) {
            logInButton.click();
        }
    }

}
