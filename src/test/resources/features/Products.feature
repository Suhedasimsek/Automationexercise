@products
Feature: Tüm Ürünler ve ürün detay sayfasını doğrulama

  Background:
    Given Kullanıcı giriş sayfasına gider
    And Kullanıcı Login linkine tıklar
    When Kullanıcı email "username" ve şifre "password" bilgileriyle giriş yapar
    Then Kullanıcı Logged in as bilgisinde "Suheda" adını görür

  Scenario: Tüm Ürünler ve ürün detay sayfası doğrulaması
    Then Ana sayfa başarılı şekilde görüntülenir
    And Kullanıcı 'Products' butonuna tıklar
    Then Kullanıcı ALL PRODUCTS sayfasına yönlendirildiğini doğrular
    And Ürün listesi görünür
    When İlk ürünün 'View Product' bağlantısına tıklar
    Then Kullanıcı ürün detay sayfasına gider
    And Ürün detayları görünür: ürün adı, kategori, fiyat, stok durumu, durum, marka


