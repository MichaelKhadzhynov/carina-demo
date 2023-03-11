package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.YTSubscribingDialogWindow;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.YouTubeTab;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YouTubeTabTest implements IAbstractTest {

    private static final String SUBSCRIBING_BUTTON_COLOR_WHITE = "rgb(241, 241, 241)";

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testYouTubeSubscribingDialogWindow(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't open");

        YouTubeTab youTubeTab = homePage.getHeaderMenu().openYouTubeTab();

        YTSubscribingDialogWindow dialogWindow = youTubeTab.getSubscribingDialogWindow();
        Assert.assertTrue(dialogWindow.isUIObjectPresent(10), "Dialog subscribing window wasn't present");

        dialogWindow.clickCancelButton();

        Assert.assertEquals(youTubeTab.getSubscribingButton().getElement().getCssValue
                ("background-color"), SUBSCRIBING_BUTTON_COLOR_WHITE);

        youTubeTab.closeYouTubePage();

    }
}
