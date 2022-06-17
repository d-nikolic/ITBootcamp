package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTests extends BaseTest {

    @Test
    public void verifyThatAddingAUserWithAValidDataIsSuccessful() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnWebTables();
        String enteredData = getWebTablesPage().fillingOutTheUserFormModal("Darko", "Nikolic",
                "darko@mail.com", "33", "50000", "QA");
        String displayedDataViaSearchBox = getWebTablesPage().searchingForAddedUser("darko@mail.com");
        Assert.assertEquals(enteredData, displayedDataViaSearchBox);

    }

}
