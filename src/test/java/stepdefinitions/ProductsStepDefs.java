package stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pages.Products_Page;
import utils.factory.DriverFactory;

import static org.junit.Assert.assertTrue;

public class ProductsStepDefs {

    Page page = DriverFactory.getPage();
    Products_Page productsPage = new Products_Page(page);

    @Then("Ana sayfa başarılı şekilde görüntülenir")
    public void ana_sayfa_basarili_sekilde_goruntulenir() {
        assertTrue("Ana sayfa görünür değil", productsPage.isHomePageVisible());
    }

    @And("Kullanıcı 'Products' butonuna tıklar")
    public void kullanici_products_butonuna_tiklar() {
        productsPage.clickProducts();
    }

    @Then("Kullanıcı ALL PRODUCTS sayfasına yönlendirildiğini doğrular")
    public void kullanici_all_products_sayfasina_yonlendirildigini_dogrular() {
        assertTrue("All Products sayfası görünmüyor", productsPage.isAllProductsPageVisible());
    }

    @And("Ürün listesi görünür")
    public void urun_listesi_gorunur() {
        assertTrue("Ürün listesi görünür değil", productsPage.isProductsListVisible());
    }

    @When("İlk ürünün 'View Product' bağlantısına tıklar")
    public void ilk_urunun_view_product_baglantisina_tiklar() {
        productsPage.viewFirstProduct();
    }

    @Then("Kullanıcı ürün detay sayfasına gider")
    public void kullanici_urun_detay_sayfasina_gider() {
        assertTrue("Ürün detay sayfası görünmüyor", productsPage.isProductDetailPageVisible());
    }

    @And("Ürün detayları görünür: ürün adı, kategori, fiyat, stok durumu, durum, marka")
    public void urun_detaylari_gorunur() {
        assertTrue("Ürün detayları eksik", productsPage.areProductDetailsVisible());
    }
}


