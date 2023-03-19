package com.qaprosoft.carina.demo.myTests;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.rozetka.NotebooksPage;
import com.qaprosoft.carina.demo.gui.pages.rozetka.RozetkaHomePage;
import com.qaprosoft.carina.demo.gui.pages.rozetka.componentsRozetka.CatalogGridCell;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class NotebooksFilterTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @Priority(Priority.P1)
    public void testAsusFilter() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(getDriver());
        rozetkaHomePage.open();

        NotebooksPage notebooksPage = rozetkaHomePage.openComputersNotebooksPage().openNotebooksPage();

        notebooksPage.clickCheckboxASUS();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<CatalogGridCell> catalogGridCell = notebooksPage.getCatalogGrid();

        catalogGridCell.forEach(e->Assert.assertTrue(e.isUIObjectPresent(), "UI object is not present"));

        List<String> titleList = catalogGridCell.stream()
                .map(e -> e.getGoodsTitle().getText().toLowerCase()).collect(Collectors.toList());

        titleList.forEach(e -> {
            Assert.assertTrue(e.contains("asus"));
            LOGGER.info("passed");
        });
    }

}
