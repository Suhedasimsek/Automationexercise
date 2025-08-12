package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.WebActions;

public class Products_Page {

    private final Locator productsLink;
    private final Locator homeLink;
    private final Locator allProductsHeader;
    private final Locator productsListItemsFirst;
    private final Locator firstViewProductLink;

    private final Locator productInformation;
    private final Locator productName;
    private final Locator categoryInfo;
    private final Locator priceInfo;
    private final Locator availabilityInfo;
    private final Locator conditionInfo;
    private final Locator brandInfo;

    public Products_Page(Page page) {
        this.productsLink = page.locator("header .shop-menu a[href='/products']");
        this.homeLink = page.locator("header .shop-menu a[href='/' ]:has-text('Home')");
        this.allProductsHeader = page.locator("h2.title:has-text('All Products')");
        this.productsListItemsFirst = page.locator(".features_items .product-image-wrapper").first();
        this.firstViewProductLink = page.locator(".features_items a:has-text('View Product')").first();

        this.productInformation = page.locator(".product-information");
        this.productName = productInformation.locator("h2");
        this.categoryInfo = productInformation.locator("p:has-text('Category')");
        // On detail page price is inside nested span under .product-information
        this.priceInfo = productInformation.locator("span > span:has-text('Rs.')");
        this.availabilityInfo = productInformation.locator("p:has-text('Availability:')");
        this.conditionInfo = productInformation.locator("p:has-text('Condition:')");
        this.brandInfo = productInformation.locator("p:has-text('Brand:')");
    }

    public boolean isHomePageVisible() {
        return WebActions.waitUntilElementDisplayed(homeLink, 10);
    }

    public void clickProducts() {
        WebActions.waitUntilElementDisplayed(productsLink, 10);
        productsLink.scrollIntoViewIfNeeded();
        productsLink.click();
    }

    public boolean isAllProductsPageVisible() {
        // Either header visible or products list visible
        return WebActions.waitUntilElementDisplayed(allProductsHeader, 10) ||
                WebActions.waitUntilElementDisplayed(productsListItemsFirst, 10);
    }

    public boolean isProductsListVisible() {
        return WebActions.waitUntilElementDisplayed(productsListItemsFirst, 10);
    }

    public void viewFirstProduct() {
        WebActions.waitUntilElementDisplayed(firstViewProductLink, 10);
        firstViewProductLink.scrollIntoViewIfNeeded();
        firstViewProductLink.click();
    }

    public boolean isProductDetailPageVisible() {
        return WebActions.waitUntilElementDisplayed(productInformation, 10);
    }

    public boolean areProductDetailsVisible() {
        boolean nameVisible = WebActions.waitUntilElementDisplayed(productName, 10);
        boolean categoryVisible = WebActions.waitUntilElementDisplayed(categoryInfo, 10);
        boolean priceVisible = WebActions.waitUntilElementDisplayed(priceInfo, 10);
        boolean availabilityVisible = WebActions.waitUntilElementDisplayed(availabilityInfo, 10);
        boolean conditionVisible = WebActions.waitUntilElementDisplayed(conditionInfo, 10);
        boolean brandVisible = WebActions.waitUntilElementDisplayed(brandInfo, 10);
        return nameVisible && categoryVisible && priceVisible && availabilityVisible && conditionVisible && brandVisible;
    }
}


