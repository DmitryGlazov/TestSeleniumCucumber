package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends PageObject {

    private final String productPage = "https://www.etsy.com/listing/696659280/fathor-like-a-dad-just-way-mightier-see";

    @FindBy(id = "inventory-variation-select-1")
    private WebElement colorsSelect;

    @FindBy(id = "inventory-variation-select-0")
    private WebElement sizesSelect;

    @FindBy(xpath = "//form[@class=\"add-to-cart-form\"]")
    private WebElement addToCartForm;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSizesSelect() {
        return this.sizesSelect;
    }

    public void get() {
        driver.navigate().to(this.productPage);
    }

    public void selectColor(String color) {
        Select colorsSelect = new Select(this.colorsSelect);
        colorsSelect.selectByVisibleText(color);
    }

    public void selectSize(String size) {
        Select sizesSelect = new Select(this.sizesSelect);
        sizesSelect.selectByVisibleText(size);
    }

    public void addToCart() {
        addToCartForm.submit();
    }

}
