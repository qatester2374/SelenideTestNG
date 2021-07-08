package com.selenide.testng.jr;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    SelenideElement damenTab = $(byXpath("//li/a/span[contains(text(), 'Damen')]"));
    SelenideElement searchInput = $(byId("simple-header-search"));
    SelenideElement numberOfSearchElements = $(byClassName("gkk-pop-pagination__details"));
    ElementsCollection searchResultItems = $$("#search-result-items li.gkk-search-results__item");
    SelenideElement wishList = $(byId("IDTA_wishlist"));
    SelenideElement wishListIndicator = $(byId("wishlist-indicator"));
//    SelenideElement pagination = $(byClassName("gkk-pop-pagination__nav-pages-item-link"));
    SelenideElement lastPage = $(byClassName("gkk-pop-pagination__nav-icon--relative-left"));
    SelenideElement lastPageNumbers = $(byClassName("gkk-pop-pagination__nav-pages"));
    ElementsCollection lastPageNumbersElements = $$("ul .gkk-pop-pagination__nav-pages-item");

    // registration
    SelenideElement name = $(byId("jform_name"));
    SelenideElement username = $(byId("jform_username"));
    SelenideElement password = $(byId("jform_password1"));
    SelenideElement confirmPassword = $(byId("jform_password2"));
    SelenideElement email = $(byId("jform_email1"));
    SelenideElement confirmEmail = $(byId("jform_email2"));
    SelenideElement registerSubmit = $(byXpath("//button[contains(text(), 'Register')]"));

    // login
    SelenideElement usernameLogin = $(byId("username"));
    SelenideElement passwordLogin = $(byId("password"));
    SelenideElement loginSubmit = $(byXpath("//button[contains(text(), 'Log in')]"));

    // upload
    SelenideElement galleryViewForImage = $(byXpath("//h3[contains(text(), 'Gallery View for Images')]"));
    SelenideElement fineUploaderGalleryArea = $(byId("fine-uploader-gallery"));
    SelenideElement inputUpload = $(byXpath("//*[@id=\"fine-uploader-gallery\"]/div/div[3]/input"));

    SelenideElement manualTriggerUploads = $(byXpath("//h3[contains(text(), 'Manually Trigger Uploads')]"));
    SelenideElement selectFiles = $(byXpath("//*[@id=\"fine-uploader-manual-trigger\"]/div/div[3]/div/input"));
    SelenideElement triggerUpload = $(byId("trigger-upload"));

    public SelenideElement searchElementContainsText(String str) {
        SelenideElement element = $(byXpath("//img[contains(@alt,'" + str + "')]"));
        return element;
    }

    @BeforeTest
    static void beforeTest() {
//        Configuration.browser = "Firefox";
//        open("https://www.galeria.de/");
    }

    @Test
    void todoMvc() throws InterruptedException {
        open("https://www.galeria.de/");
        damenTab.hover();
        $(withText("Aktuelle Empfehlungen")).shouldBe(Condition.visible);
        Thread.sleep(3000);

        searchInput.sendKeys("Citizen");
        searchInput.pressEnter();
        System.out.println(searchResultItems.size());
//        searchElementContainsText("CA0690-88L").click();
//        wishList.click();
//        wishListIndicator.shouldHave(text("1"));
//        Assertions.assertEquals(1, Integer.valueOf(wishListIndicator.getText()));
//        System.out.println(numberOfSearchElements.getText());

        String[] elements = numberOfSearchElements.getText().split(" ");
        System.out.println(elements.length);
        System.out.println(elements[elements.length - 1]);
        Assert.assertTrue(Integer.valueOf(elements[elements.length - 1]) > 0);

        lastPage.click();
        Thread.sleep(3000);

        System.out.println(lastPageNumbersElements.size());

        zoom(2.0);
        Thread.sleep(1000);
        zoom(0.1);
        Thread.sleep(1000);
        zoom(1.0);
        Thread.sleep(1000);
    }

    @Test
    void register() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/registration-form");
        name.sendKeys("Joca");
        username.sendKeys("joca");
        password.sendKeys("12345");
        confirmPassword.sendKeys("1234");
        email.sendKeys("hilimi6347@herrain.com");
        confirmEmail.sendKeys("hilimi6347@herrain.com");
        registerSubmit.click();
        Thread.sleep(3000);
    }

    @Test
    void login() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/login-page");
        usernameLogin.sendKeys("joca");
        passwordLogin.sendKeys("12345");
        loginSubmit.click();
        Thread.sleep(3000);
    }

    @Test
    void uploadImage1() throws InterruptedException {
        open("https://fineuploader.com/demos.html");
//        fineUploaderGalleryArea.scrollIntoView(true);
        galleryViewForImage.scrollTo();
        inputUpload.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        Thread.sleep(3000);
    }

    @Test
    void uploadImage2() throws InterruptedException {
        open("https://fineuploader.com/demos.html");
        galleryViewForImage.scrollTo();
        inputUpload.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        Thread.sleep(1000);
        manualTriggerUploads.scrollTo();
        selectFiles.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        triggerUpload.click();
        Thread.sleep(1000);
    }

}
