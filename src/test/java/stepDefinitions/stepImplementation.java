package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import pageObjects.FinalPage;
import pageObjects.ProductCardsPage;
import pageObjects.ShippingDetailsPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class stepImplementation  extends BaseTest {
    ProductCardsPage productsPage;
    CheckOutPage checkOutPage;
    ShippingDetailsPage shippingPage;
    FinalPage finalPage;
    List<String> itemsToBeAdded;
    @Given("I landed on the Ecommerce Page and logged in using username and password")
    public void iLandedOnTheEcommercePageAndLoggedInUsingUsernameAndPassword() throws IOException {
            LaunchApplication();

    }
    @When("I add the prodcuts from the productList to Cart")
    public void i_add_the_prodcuts_from_the_product_list_to_cart() {
        productsPage  = new ProductCardsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        shippingPage= new ShippingDetailsPage(driver);
        finalPage= new FinalPage(driver);
        //Below are the Items to be added.....
       itemsToBeAdded = new ArrayList<>(List.of("ZARA COAT 3","ADIDAS ORIGINAL"));
        //Adding items in above list to Cart using the custom built method
        productsPage.clickOnAddToCartForSpecficItems(itemsToBeAdded);
        //Clikcing on teh CART button to land on Checkout page
        productsPage.CLickOnCart();


    }
    @When("Checkout productList and submit the order")
    public void checkout_product_list_and_submit_the_order() {
// Validating that the added items are available on the CheckoutPage using the below custom built method
        checkOutPage.validateAddedItemsonCheckOutPage(itemsToBeAdded);
        // CLicking on the CHECKOUT button to land on Shipping Page
        checkOutPage.clickOnCheckoutButton();
    }
    @Then("verify confirmation message is displayed in the Confirmation Page")
    public void verify_confirmation_message_is_displayed_in_the_confirmation_page() throws InterruptedException {
//Adding Country as INDIA on shipping page using the below custom built methods
        shippingPage.sendDetailstoCountryDropDown("IND");
        String CountryToBeSelected="India";
        shippingPage.selectDesiredOptionsFromDropDown(CountryToBeSelected);
        shippingPage.clickOnPlaceOrderButton();
        // Order success validation using below custom built method
        finalPage.validateOrderSuccessMessage("Thankyou for the Order.");
        driver.close();


    }

}
