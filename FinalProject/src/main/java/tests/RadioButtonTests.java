package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {

    @Test(priority = 1)
    public void verifyThatImpressiveButtonWorks() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnRadioButton();
        getRadioButtonPage().clickOnImpressiveBtn();
        Assert.assertFalse(getRadioButtonPage().isYesBtnSelected());
        Assert.assertEquals(getRadioButtonPage().valueOfImpressiveButton(), getRadioButtonPage().valueOfDisplayedMsg());
    }

    @Test(priority = 2)
    public void verifyThatYesButtonWorks() {
        //if you are running test suite then use this code
        getDriver().navigate().refresh();
        /*
        getHomePage().clickOnElements();
        getElementsPage().clickOnRadioButton();
         */
        //if you are running only this test - comment out refresh call and uncomment 2 commented lines
        getRadioButtonPage().clickOnYesBtn();
        Assert.assertFalse(getRadioButtonPage().isImpressiveBtnSelected());
        Assert.assertEquals(getRadioButtonPage().valueOfYesButton(), getRadioButtonPage().valueOfDisplayedMsg());
    }

}
