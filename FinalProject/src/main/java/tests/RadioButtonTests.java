package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnRadioButton();
    }


    @Test(priority = 1)
    public void verifyThatImpressiveButtonWorks() {

        getRadioButtonPage().clickOnImpressiveBtn();
        Assert.assertFalse(getRadioButtonPage().isYesBtnSelected());
        Assert.assertEquals(getRadioButtonPage().valueOfImpressiveButton(), getRadioButtonPage().valueOfDisplayedMsg());
    }

    @Test(priority = 2)
    public void verifyThatYesButtonWorks() {
        getRadioButtonPage().clickOnYesBtn();
        Assert.assertFalse(getRadioButtonPage().isImpressiveBtnSelected());
        Assert.assertEquals(getRadioButtonPage().valueOfYesButton(), getRadioButtonPage().valueOfDisplayedMsg());
    }

}
