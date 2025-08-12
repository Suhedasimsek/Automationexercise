package stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pages.Login_Page;
import utils.WebActions;
import utils.factory.DriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    Page page = DriverFactory.getPage();
    Login_Page loginPage = new Login_Page(page);

    @Given("Kullanıcı giriş sayfasına gider")
    public void kullanici_giris_sayfasina_gider() {
        String url = WebActions.getProperty("baseUrl");
        page.navigate(url, new Page.NavigateOptions().setTimeout(60000));
    }

    @When("Kullanıcı Login linkine tıklar")
    public void kullanici_signup_login_linkine_tiklar() {
        loginPage.clickSignupLoginLink();
    }

    @When("Kullanıcı email {string} ve şifre {string} bilgileriyle giriş yapar")
    public void kullanici_email_ve_sifre_bilgileriyle_giris_yapar(String usernameKey, String passwordKey) {
        String email = WebActions.getProperty(usernameKey);
        String password = WebActions.getProperty(passwordKey);
        loginPage.login(email, password);
    }


    @Then("Kullanıcı Logged in as bilgisinde {string} adını görür")
    public void kullanici_logged_in_as_bilgisinde_adini_gorur(String expectedName) {
        assertTrue("Login başarısız", loginPage.isLoggedInAsVisible());
        String actualUser = loginPage.getLoggedInUserName();
        System.out.println("Logged in as: " + actualUser);
        assertTrue("Beklenen kullanıcı adı görünmedi: " + expectedName,
                actualUser != null && actualUser.contains(expectedName));
    }
}
