package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedAnnotations;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewsPage  extends AbstractPage {

    @FindBy(xpath = "//div[@class='review-item clearfix']")
    private List<ExtendedWebElement> reviewItemList;

    public ReviewsPage(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getReviewItemList() {
        return reviewItemList;
    }
}
