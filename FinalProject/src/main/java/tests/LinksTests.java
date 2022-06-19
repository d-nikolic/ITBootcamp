package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends BaseTest {

    @BeforeMethod
    public void setUp() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnLinks();
    }

    @Test
    public void verifyThatHomeLinkWorks() {
        String originalHandle = getLinksPage().getOriginalHandle();
        String homeLinkURL = getLinksPage().getHomeLinkURL();
        String currentHandle = getLinksPage().getCurrentHandle();
        Assert.assertFalse(originalHandle.equals(currentHandle));
        Assert.assertEquals(homeLinkURL, getDriver().getCurrentUrl());
    }

}
