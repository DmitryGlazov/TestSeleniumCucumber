package tests.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.DriverFactory;
import pageObjects.ProductPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ProductPageSteps {

    WebDriver driver;
    WebDriverWait wait;

    ProductPage productPage;

    public ProductPageSteps() {
        this.driver = DriverFactory.getWebDriver();

        productPage = new ProductPage(this.driver);
        wait = new WebDriverWait(this.driver, 5);
    }

    @Given("Open product page")
    public void openProductPage() {
        productPage.get();
    }

    @When("Choose color")
    public void chooseColor() {
        productPage.selectColor("Black");
    }

    @When("Choose size")
    public void chooseSize() {
        wait.until(ExpectedConditions.elementToBeClickable(productPage.getSizesSelect()));
        productPage.selectSize("T-Shirt - M (US$19.99)");
    }

    @When("Click add to cart button")
    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(productPage.getSizesSelect()));
        productPage.addToCart();
    }

}
