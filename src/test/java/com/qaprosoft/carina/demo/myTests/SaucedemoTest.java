package com.qaprosoft.carina.demo.myTests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.saucedemo.InventoryPage;
import com.qaprosoft.carina.demo.gui.pages.saucedemo.LogInPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testInventoryPresent(){

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();

        Assert.assertTrue(logInPage.isPageOpened(), "Page wasn't opened");

        InventoryPage inventoryPage = logInPage.logIn("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.getInventoryItemCount() >= 1, "Non match element wasn't present");

    }
}
