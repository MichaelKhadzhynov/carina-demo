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
package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.demo.gui.enums.FooterMenuElements;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class FooterMenu extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='footer']//div[@id='footmenu']//a")
    private List<ExtendedWebElement> footerMenuButtons;


    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        footerMenuButtons.get(FooterMenuElements.HOME.getFooterElement()).click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        footerMenuButtons.get(FooterMenuElements.COMPARE.getFooterElement()).click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        footerMenuButtons.get(FooterMenuElements.NEWS.getFooterElement()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        footerMenuButtons.get(FooterMenuElements.REVIEWS.getFooterElement()).click();
        return new ReviewsPage(driver);
    }

    public ToolsPage openToolsPage() {
        footerMenuButtons.get(FooterMenuElements.TOOLS.getFooterElement()).click();
        return new ToolsPage(driver);
    }

    public CoveragePage openCoveragePage() {
        footerMenuButtons.get(FooterMenuElements.COVERAGE.getFooterElement()).click();
        return new CoveragePage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        footerMenuButtons.get(FooterMenuElements.GLOSSARY.getFooterElement()).click();
        return new GlossaryPage(driver);
    }

    public ContactUsPage openContactUsPage() {
        footerMenuButtons.get(FooterMenuElements.CONTACT_US.getFooterElement()).click();
        return new ContactUsPage(driver);
    }

    public List<ExtendedWebElement> getFooterMenuButtons() {
        return footerMenuButtons;
    }

    public ExtendedWebElement getFooterMenuElement(FooterMenuElements elements) {
        return footerMenuButtons.get(elements.getFooterElement());
    }




}
