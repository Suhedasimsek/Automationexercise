@login
Feature: Giriş Sayfası işlemleri

  Scenario: Kullanıcının geçerli bilgilerle giriş yapması
    Given Kullanıcı giriş sayfasına gider
    And Kullanıcı Login linkine tıklar
    When Kullanıcı email "username" ve şifre "password" bilgileriyle giriş yapar
    Then Kullanıcı Logged in as bilgisinde "Suheda" adını görür

