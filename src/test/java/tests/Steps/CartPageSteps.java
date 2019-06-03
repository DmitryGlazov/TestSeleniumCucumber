package tests.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import tests.DriverFactory;

public class CartPageSteps {

    WebDriver driver;
    WebDriverWait wait;

    CartPage cartPage;

    public CartPageSteps() {
        this.driver = DriverFactory.getWebDriver();

        cartPage = new CartPage(this.driver);
        wait = new WebDriverWait(this.driver, 5);
    }

    @When("Remove item from cart")
    public void removeItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.getRemoveItemLink()));
        cartPage.removeItemFromCart();
    }

    @When("Increase item quantity")
    public void increaseItemQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(cartPage.getQuantitySelect()));
        cartPage.selectQuantity("2");
    }

    @Then("See increased price")
    public void seeIncreasedPrice() {
        wait.until(ExpectedConditions.textToBePresentInElement(cartPage.getTotalPrice(), "50.27"));
    }

    @Then("See empty cart message")
    public void seeEmptyCartMessage() {
        wait.until(ExpectedConditions.visibilityOf(cartPage.getEmptyCartMessage()));
    }

}
