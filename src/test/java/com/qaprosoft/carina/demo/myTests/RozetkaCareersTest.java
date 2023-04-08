package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.rozetka.RozetkaCareersPage;
import com.qaprosoft.carina.demo.gui.pages.rozetka.RozetkaHomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaCareersTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testRemoteJobCheckbox(){
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(getDriver());
        rozetkaHomePage.open();

        RozetkaCareersPage rozetkaCareersPage = rozetkaHomePage.openRozetkaCareersPage();

        Assert.assertTrue(rozetkaCareersPage.getRemoteJobCheckbox().getElement().isEnabled());

        rozetkaCareersPage.getDirectionsSelectMenu().selectByIndex(1);

        Assert.assertFalse(rozetkaCareersPage.getRemoteJobCheckbox().getElement().isEnabled());

        rozetkaCareersPage.getDirectionsSelectMenu().selectByIndex(2);

        Assert.assertTrue(rozetkaCareersPage.getRemoteJobCheckbox().getElement().isEnabled());

    }
}
