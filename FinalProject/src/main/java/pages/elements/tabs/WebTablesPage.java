package pages.elements.tabs;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import java.util.List;


@Data
public class WebTablesPage extends BasePage {

    public WebTablesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By addButtonLocator = By.id("addNewRecordButton");

    private By userFormLocator = By.id("userForm");

    private By firstNameLocator = By.id("firstName");
    private By lastNameLocator = By.id("lastName");
    private By emailLocator = By.id("userEmail");
    private By ageLocator = By.id("age");
    private By salaryLocator = By.id("salary");

    private By departmentLocator = By.id("department");

    private By submitButtonLocator = By.id("submit");

    private By searchBoxLocator = By.id("searchBox");


    public void clickOnAddButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addButtonLocator));
        WebElement addButton = getDriver().findElement(addButtonLocator);
        addButton.click();
    }

    public void inputDataIntoFormField(By locator, String data) {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement locatedField = getDriver().findElement(locator);
        locatedField.click();
        locatedField.sendKeys(data);
    }

    //this method is returning the inputted data
    public String fillingOutTheUserFormModal(String firstName, String lastName, String email,
                                             String age, String salary, String department) {

        clickOnAddButton();

        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(userFormLocator));
        inputDataIntoFormField(firstNameLocator, firstName);
        inputDataIntoFormField(lastNameLocator, lastName);
        inputDataIntoFormField(emailLocator, email);
        inputDataIntoFormField(ageLocator, age);
        inputDataIntoFormField(salaryLocator, salary);
        inputDataIntoFormField(departmentLocator, department);
        getDriverWait().until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        getDriver().findElement(submitButtonLocator).click();

        return firstName + lastName + age + email + salary + department;
    }

    //searching by email which should be unique
    //this method is returning existing user via email
    public String searchingForAddedUser(String email) {
        getDriverWait().until(ExpectedConditions.presenceOfElementLocated(searchBoxLocator));
        inputDataIntoFormField(searchBoxLocator, email);
        By recordLocator = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div");
        List<WebElement> record = getDriver().findElements(recordLocator);
        String returnedData = "";
        for(WebElement cell : record) {
            //getting the text in form of "name\nlastname\nage"... so replaceAll() is needed
            returnedData += cell.getText().replaceAll("\n", "");
        }

        return returnedData;

    }

}
