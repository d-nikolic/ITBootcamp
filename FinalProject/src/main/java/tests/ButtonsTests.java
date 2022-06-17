package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTest {



    @Test(priority = 1)
    public void verifyThatClickMeBtnWorks() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnButtons();
        getButtonsPage().clickOnClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getClickMeButtonMsg()).
                getText().equals("You have done a dynamic click"));
    }

    @Test(priority = 2)
    public void verifyThatRightClickMeBtnWorks() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnButtons();
        getButtonsPage().clickOnRightClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getRightClickMeMsg()).
                getText().equals("You have done a right click"));
    }

    @Test(priority = 3)
    public void verifyThatDoubleClickMeBtnWorks() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnButtons();
        getButtonsPage().doubleClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getDoubleClickMeMsg()).
                getText().equals("You have done a double click"));
    }
}
