package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {

    @Test
    public void verifyThatTheTextBoxDisplaysValidInputThatUserHasEntered() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnTextBox();
        String expected = getTextBoxPage().inputtedDataView("Darko Nikolic",
                "darko@mail.com", "Some Street 1", "Novi Sad 123");
        Assert.assertEquals(getTextBoxPage().displayActualInfo(), expected);

    }

}
