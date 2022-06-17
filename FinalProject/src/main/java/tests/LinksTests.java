package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTests extends BaseTest {

    @Test
    public void verifyThatHomeLinkWorks() {
        getHomePage().clickOnElements();
        getElementsPage().clickOnLinks();
        String originalHandle = getLinksPage().getOriginalHandle();
        System.out.println(originalHandle);
        String homeLinkURL = getLinksPage().getHomeLinkURL();
        System.out.println(homeLinkURL);
        String currentHandle = getLinksPage().getCurrentHandle();
        System.out.println(currentHandle);
        Assert.assertFalse(originalHandle.equals(currentHandle));
        Assert.assertEquals(homeLinkURL, getDriver().getCurrentUrl());
    }
}
