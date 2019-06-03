package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(linkText = "Remove")
    private WebElement removeItemLink;

    @FindBy(xpath = "//div[contains(text(), \"Your cart is empty\")]")
    private WebElement emptyCartMessage;

    @FindBy(xpath = "//select[@name=\"listing-quantity\"]")
    private List<WebElement> quantitySelects;

    @FindBy(xpath = "//th[contains(text(), \"Total\")]/following-sibling::td//span[@class='currency-value']")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmptyCartMessage() {
        return this.emptyCartMessage;
    }

    public WebElement getRemoveItemLink() {
        return this.removeItemLink;
    }

    public WebElement getQuantitySelect() {
        return this.quantitySelects.get(1);
    }

    public WebElement getTotalPrice() {
        return this.totalPrice;
    }

    public void removeItemFromCart() {
        removeItemLink.click();
    }

    public void selectQuantity(String value) {
        Select quantitySelect = new Select(this.quantitySelects.get(1));
        quantitySelect.selectByValue(value);
    }
}
