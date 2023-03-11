package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ReviewsPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewsPageTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Mychael")
    public void testReviewItems(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        ReviewsPage reviewPage = homePage.getHeaderMenu().openReviewsPage();

        reviewPage.getReviewItemList().forEach(e-> Assert.assertTrue(e.isElementPresent()));

    }
}
