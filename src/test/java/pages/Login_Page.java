package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.WebActions;

public class Login_Page {
    // Locators for automationexercise.com flow
    private final Locator signupLoginLink;
    private final Locator loginHeader;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator loggedInAsInfo;

    public Login_Page(Page page) {
        // Header -> Signup / Login
        this.signupLoginLink = page.locator("header .shop-menu a[href='/login']");
        this.loginHeader = page.locator("h2:has-text('Login to your account')");
        this.emailInput = page.locator("input[data-qa='login-email']");
        this.passwordInput = page.locator("input[data-qa='login-password']");
        this.loginButton = page.locator("button[data-qa='login-button']");
        this.loggedInAsInfo = page.locator("header .shop-menu a:has(i.fa-user):has-text('Logged in as')");
    }

    
    public void clickSignupLoginLink() {
        WebActions.waitUntilElementDisplayed(signupLoginLink, 1);
        signupLoginLink.scrollIntoViewIfNeeded();
        signupLoginLink.click();
        WebActions.waitUntilElementDisplayed(loginHeader, 1);
    }

    public void login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        loginButton.click();
    }

    public boolean isLoggedInAsVisible() {
        return WebActions.waitUntilElementDisplayed(loggedInAsInfo, 10);
    }

    public String getLoggedInUserName() {
        return loggedInAsInfo.locator("b").innerText().trim();
    }
}
