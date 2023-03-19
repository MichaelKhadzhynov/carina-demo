package com.qaprosoft.carina.demo.myTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class SearchFieldListTest implements IAbstractTest {

    private static final String SAMSUNG_A54 = "Galaxy A54";
    private static final String APPLE_IPHONE = "iPhone 14 Pro Max";
    private static final String SONY_X5 = "Xperia 5 IV";

    @Test
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testSearchFieldListTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        BrandModelsPage brandModelsPageSamsung = homePage.selectBrand("samsung");
        brandModelsPageSamsung.selectModel(SAMSUNG_A54);

        homePage.open();

        BrandModelsPage brandModelsPageApple = homePage.selectBrand("apple");
        brandModelsPageApple.selectModel(APPLE_IPHONE);

        homePage.open();

        BrandModelsPage brandModelsPageSony = homePage.selectBrand("sony");
        brandModelsPageSony.selectModel(SONY_X5);

        homePage.open();

        List<ExtendedWebElement> searchListElements = homePage.getHeaderMenu()
                .getSearchList();

        Assert.assertEquals("Samsung " + SAMSUNG_A54, searchListElements.get(2).getText());
        Assert.assertEquals("Apple " + APPLE_IPHONE, searchListElements.get(1).getText());
        Assert.assertEquals("Sony " + SONY_X5, searchListElements.get(0).getText());

    }

}
