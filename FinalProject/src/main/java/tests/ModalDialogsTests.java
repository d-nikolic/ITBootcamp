package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsTests extends BaseTest {

    @Test(priority = 1)
    public void verifyThatSmallModalDialogBtnWorks() {
        getHomePage().clickOnAlertsFramesWindows();
        getAlertsWindowsPage().clickOnModalDialogs();
        getModalDialogsPage().clickOnSmallModal();
        //is modal window displayed
        Assert.assertTrue(getModalDialogsPage().isModalWindowDisplayed());
        //asserting title
        Assert.assertEquals(getModalDialogsPage().getSmallModalTitle(), "Small Modal");
        //asserting text
        Assert.assertEquals(getModalDialogsPage().getSmallModalText(), "This is a small modal. " +
                "It has very less content");
        getModalDialogsPage().clickOnSmallModalCloseBtn();
    }

    @Test(priority = 2)
    public void verifyThatLargeModalDialogBtnWorks() {
        getHomePage().clickOnAlertsFramesWindows();
        getAlertsWindowsPage().clickOnModalDialogs();
        getModalDialogsPage().clickOnLargeModal();
        //is modal window displayed
        Assert.assertTrue(getModalDialogsPage().isModalWindowDisplayed());
        //asserting title
        Assert.assertEquals(getModalDialogsPage().getLargeModalTitle(), "Large Modal");
        //asserting text
        Assert.assertEquals(getModalDialogsPage().getSmallModalText(), "Lorem Ipsum is simply dummy text " +
                "of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                "text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                "make a type specimen book. It has survived not only five centuries, but also the leap into " +
                "electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s " +
                "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        getModalDialogsPage().clickOnLargeModalCloseBtn();
    }
}
