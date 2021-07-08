package com.selenide.testng.jr;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Register {
    SelenideElement meineGaleria = $(byXpath("//*[@id=\"header\"]/div[2]/section[2]/ul/li[1]/div"));
    SelenideElement registerLink = $(byXpath("//a[contains(text(), 'Starten Sie hier.')]"));
    SelenideElement anrede = $(byId("dwfrm_profile_customer_salutation"));
    ElementsCollection optionsAnrede = $$(byXpath("//*[@id='dwfrm_profile_customer_salutation']/option"));

    @BeforeMethod
    void openSite() {
        open("https://www.galeria.de/");
    }

    @Test
    void openRegisterWindow() throws InterruptedException {
        meineGaleria.hover();
        Thread.sleep(1000);
        registerLink.click();
        Thread.sleep(1000);
        anrede.click();
//        anrede.selectOption("Herr");
        for (SelenideElement option : optionsAnrede) {
            System.out.println(option.getText());
            if (option.getText().contains("Herr")) {
                option.click();
                break;
            }
        }
        anrede.click();
        Thread.sleep(3000);
    }
}
