package com.qaprosoft.carina.demo.myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.dou.CalendarPage;

public class CalendarTest implements IAbstractTest {

    @Test()
    public void testCalendar(){
        CalendarPage calendarPage = new CalendarPage(getDriver());
        calendarPage.open();

        Assert.assertTrue(calendarPage.isPageOpened(), "Page wasn't opened");

        Assert.assertTrue(calendarPage.getCalendarField().isElementPresent(), "Element wasn't present ");

        calendarPage.typeCalendarDate("17","05", "2023");

        Assert.assertEquals(calendarPage.getValueAsDate(), "2023-05-17t00:00:00.000z");
    }
}
