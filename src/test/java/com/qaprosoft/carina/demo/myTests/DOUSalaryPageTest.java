package com.qaprosoft.carina.demo.myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.dou.SalaryPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class DOUSalaryPageTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P1)
    public void testSalaryStatistic(){
        SalaryPage salaryPage = new SalaryPage(getDriver());
        salaryPage.open();

        salaryPage.getBarsKeysList().forEach(System.out::println);
        salaryPage.getBarsValuesList().forEach(System.out::println);
    }

    @Test()
    @MethodOwner(owner = "Khadzhynov Michael")
    @TestPriority(Priority.P2)
    public void testExperienceSlider(){
        SalaryPage salaryPage = new SalaryPage(getDriver());
        salaryPage.open();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(salaryPage.isPageOpened(), "Page wasn't opened");
        softAssert.assertAll();

        salaryPage.clickFilterButton();
        Assert.assertTrue(salaryPage.getHandleLeft().isElementPresent());

        salaryPage.getTicksList().forEach(e->{
            int countBefore = Integer.parseInt(salaryPage.getRespondents().getText());
            salaryPage.moveToTicket(e.getElement());
            int countAfter = Integer.parseInt(salaryPage.getRespondents().getText());
            Assert.assertTrue(countAfter <= countBefore, "");
        });
    }
}
