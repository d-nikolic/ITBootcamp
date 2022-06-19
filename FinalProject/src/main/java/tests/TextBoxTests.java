package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnTextBox();
    }

    @Test
    public void verifyThatTheTextBoxDisplaysValidInputThatUserHasEntered() {
        String expected = getTextBoxPage().inputtedDataView("Darko Nikolic",
                "darko@mail.com", "Some Street 1", "Novi Sad 123");
        Assert.assertEquals(getTextBoxPage().displayActualInfo(), expected);

    }

}
