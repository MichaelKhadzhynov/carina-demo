package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.YTSubscribingDialogWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YouTubeTab extends AbstractPage {

    @FindBy(xpath = "//div[@id='main'][@class='style-scope yt-confirm-dialog-renderer']")
    private YTSubscribingDialogWindow subscribingDialogWindow;

    @FindBy(xpath = "//div[@id='contents']//button[@class='ytp-play-button ytp-button']")
    private ExtendedWebElement playButton;

    @FindBy(xpath = "//div[@id='subscribe-button']//ytd-button-renderer//button")
    private ExtendedWebElement subscribingButton;

    public YouTubeTab(WebDriver driver) {
        super(driver);
    }

    public YouTubeTab pauseMainVideo(){
        playButton.click();
        return this;
    }

    public YTSubscribingDialogWindow getSubscribingDialogWindow() {
        return subscribingDialogWindow;
    }

    public ExtendedWebElement getSubscribingButton() {
        return subscribingButton;
    }

    public void closeYouTubePage(){
        driver.close();
    }


}
