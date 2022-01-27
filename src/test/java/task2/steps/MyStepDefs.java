package task2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import task2.page.MainPage;

public class MyStepDefs {
    private MainPage mainPage = new MainPage(task2.steps.Auxillary.driver);

    @Given("^I press (?:button|on) '([^\"]*)'$")
    public void i_press_on(String string) {
        mainPage.clickButton(string);
    }

    @Then("I can see on page {string}")
    public void iCanSeeOnPageMyFirstTestMessage(String string) {
        mainPage.checkElementDisplayed(string, true);
    }

    @Given("I Login by {string} with pwd {string}")
    public void iLoginByWithPwd(String arg0, String arg1) {
        mainPage.clickButton("login");
        mainPage.setFieldValue("username", arg0);
        mainPage.setFieldValue("password", arg1);
        mainPage.clickButton("login_button");
    }

    @And("I type {string} in {string}")
    public void iTypeIn(String arg0, String arg1) {
        mainPage.setFieldValue(arg1, arg0);


    }
}
