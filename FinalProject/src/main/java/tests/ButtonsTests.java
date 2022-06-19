package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnButtons();
    }


    @Test(priority = 1)
    public void verifyThatClickMeBtnWorks() {
        getButtonsPage().clickOnClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getClickMeButtonMsg()).
                getText().equals("You have done a dynamic click"));
    }

    @Test(priority = 2)
    public void verifyThatRightClickMeBtnWorks() {
        getButtonsPage().clickOnRightClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getRightClickMeMsg()).
                getText().equals("You have done a right click"));
    }

    @Test(priority = 3)
    public void verifyThatDoubleClickMeBtnWorks() {
        getButtonsPage().doubleClickMe();
        Assert.assertTrue(getDriver().findElement(getButtonsPage().getDoubleClickMeMsg()).
                getText().equals("You have done a double click"));
    }
}
